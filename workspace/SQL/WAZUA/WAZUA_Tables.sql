
/*
		+ 추가사항:	
					+MOV_GENRE 도 참조형태 변경.
					+WAZLEVEL 참조형태 변경 (인덱스를 거치도록).
					+오타수정 REGEDATE, REGDATE -> REG_DATE
					+timestamp 용 트리거 추가(기존 트리거 수정)
					+공지사항(+이벤트) 테이블 추가.
					+시청목록 테이블 추가.
					+소유상품 테이블 추가.
					+상품목록 테이블 추가.
					회원등급 테이블 참조형태 약간 수정.
					영화 태그(장르) 테이블 추가. +영화 테이블의 장르 열 삭제(일단 코멘트 처리).
					영화와 태그의 매핑 테이블 추가.
					영화 감독 및 배우 (영화관련 인물들의)테이블 추가. (MOVGUYS) .---감독 및 배우들의 이미지 파일 을 매핑 하기위해 필요.
					영화관련 인물들과 영화들의 매핑 테이블 추가. (MOVGUYS_MAPPING)
					MEMBER->ACCOUNT  MEM_ -> ACC_
					외래키 지정위치 변경 (가독성).
					MOVIE 테이블에 총 평가 점수와 평가 수 추가.
					평점 관리용 테이블 추가 (영화에 댓글은 여러번 쓸 수 있으므로 구현과 관리의 용이성을 위해 따로 두기로 했음.).
					MOVIE :  -> 무결성 유지하기 위한 트리거 추가(평점 등록/변경시 MOVIE 테이블의 정보 또한 변경).
			todo.
				인덱스 추가 고려 --별로 중요하지 않음
				외래키 on delete 옵션 설정 고려 --별로 중요하지 않음
				각종 REG_DATE 같은 TIMESTAMP 들에 TRIGGER 를 만들기 --편의성
				
TABLE LIST:	WAZLEVEL
			ACCOUNT
			MOVGUYS
			MOVIE
			MOVGUYS_MAPPING
			MOV_GENRE
			MOVGENRE_MAP
			WAZPOINT
			COMMENTS
			REPORT
			MOVIE_IMG
			WISH_LIST
			INQUIRE
			TRAILERS
			MVSCORE
			PRODUCTS
			POSSESION
			WATCHEDLIST
			ANNOUNCE
			
SequenceList:
			WAZLEVEL_SEQ
			ACCOUNT_SEQ
			MOVGUYS_SEQ
			MOVIE_SEQ
			MOV_GENRE_SEQ
			WAZPOINT_SEQ
			COMMENTS_SEQ
			REPORT_SEQ
			INQUIRE_SEQ
			TRAILERS_SEQ
			PRODUCTS_SEQ
			POSSESION_SEQ
			
TriggerList:
			WAZLEVEL_IDX_TRG
			ACCOUNT_IDX_TRG
			MOVGUYS_IDX_TRG
			MOVIE_IDX_TRG
			MOVGENRE_IDX_TRG
			WAZPOINT_IDX_TRG
			COMMENTS_IDX_TRG
			COMM_COUNT_MGR
			REPORT_SEQ
			INQUIRE_SEQ
			TRAILERS_IDX_TRG
			MVSCORE_MANAGER
			PRODUCTS_IDX_TRG
			PRODUCTS_MV_MGR
			POSSESION_IDX_TRG
			WATCHEDLIST_TIME_TRG
			ANNOUNCE_TIME_TRG

*/
-------------------------------------------Clear ALL-----------------------------------------------------------------------

drop trigger ANNOUNCE_TIME_TRG;
drop table ANNOUNCE cascade constraints;
drop trigger WATCHEDLIST_TIME_TRG;
drop table WATCHEDLIST cascade constraints;
drop trigger POSSESION_IDX_TRG;
drop sequence POSSESION_SEQ;
drop table POSSESION cascade constraints;
drop trigger PRODUCTS_MV_MGR;
drop trigger PRODUCTS_IDX_TRG;
drop sequence PRODUCTS_SEQ;
drop table PRODUCTS cascade constraints;
drop trigger MVSCORE_MANAGER;
drop table MVSCORE cascade constraints;
drop trigger TRAILERS_IDX_TRG;
drop sequence TRAILERS_SEQ;
drop table TRAILERS cascade constraints;
drop trigger INQUIRE_IDX_TRG;
drop sequence INQUIRE_SEQ;
drop table INQUIRE cascade constraints;
drop table WISH_LIST cascade constraints;
drop table MOVIE_IMG cascade constraints;
drop trigger REPORT_IDX_TRG;
drop sequence REPORT_SEQ;
drop table REPORT cascade constraints;
drop trigger COMM_COUNT_MGR;
drop trigger COMMENTS_IDX_TRG;
drop sequence COMMENTS_SEQ;
drop table COMMENTS cascade constraints;
drop trigger WAZPOINT_IDX_TRG;
drop sequence WAZPOINT_SEQ;
drop table WAZPOINT cascade constraints;
drop table MOVGENRE_MAP cascade constraints;
drop trigger MOVGENRE_IDX_TRG;
drop sequence MOV_GENRE_SEQ;
drop table MOV_GENRE cascade constraints;
drop table MOVGUYS_MAPPING cascade constraints;
drop trigger MOVIE_IDX_TRG;
drop sequence MOVIE_SEQ;
drop table MOVIE cascade constraints;
drop trigger MOVGUYS_IDX_TRG;
drop sequence MOVGUYS_SEQ;
drop table MOVGUYS cascade constraints;
drop trigger ACCOUNT_IDX_TRG;
drop sequence ACCOUNT_SEQ;
drop table ACCOUNT cascade constraints;
drop sequence WAZLEVEL_SEQ;
drop trigger WAZLEVEL_IDX_TRG;
drop table WAZLEVEL cascade constraints;

------------------------------------------------------------------------------------------------------------------

ALTER SESSION SET PLSCOPE_SETTINGS = 'IDENTIFIERS:NONE';

------------------------------------------------------------------------------------------------------------------


create table WAZLEVEL
(
	IDX			number(3,0)
	,LEVEL_NAME	char(25)
	,constraint WAZLEVEL_PK primary key (IDX)
);

create sequence WAZLEVEL_SEQ start with 1 increment by 1;

create or replace trigger WAZLEVEL_IDX_TRG
	before insert on WAZLEVEL
	for each row
	when (NEW.IDX is null)
begin
	select WAZLEVEL_SEQ.nextval into :NEW.IDX from DUAL;
end;
/

comment on table WAZLEVEL is '회원등급 테이블';

comment on column WAZLEVEL.IDX is '인덱스 + 주 키';

comment on column WAZLEVEL.LEVEL_NAME is '레벨명';


--drop sequence WAZLEVEL_SEQ;
--drop trigger WAZLEVEL_IDX_TRG;
--drop table WAZLEVEL cascade constraints;
------------------------------------------------------------------------------------------------------------------
create table ACCOUNT (
	IDX			number(9,0)
	,EMAIL		varchar2(50)	not null
	,PW   		varchar2(50) 	not null
	,NAME		varchar2(50)	not null
	,BIRTH		date 			not null
	,WAZLV_IDX	number(3,0)
	,REG_DATE	timestamp		not null
	,LEFT_DATE	timestamp
	,DEL_FLAG	varchar2(100)	default 'N'
	,IMG		varchar2(255)	default '-'
	,constraint ACCOUNT_PK primary key ( IDX )
	,constraint ACCOUNT_LEV_FK foreign key (WAZLV_IDX) references WAZLEVEL (IDX)
);
------DEL_FLAG 탈퇴일자와 기능 중복
------IMG 프로필 이미지를 DBMS를 사용해 처리할 것이 아니라면 필요 없음 -- 더 진행하여 기능들이 수정하기 어려워지기 전에 분명히 해야 할 부분(이미지의 처리)! 게다가 관리자 페이지의 구현과 직결되어있음

create sequence ACCOUNT_SEQ start with 1 increment by 1; 

create or replace trigger ACCOUNT_IDX_TRG
	before insert on ACCOUNT
	for each row
begin
	if :NEW.IDX is null 
		then select ACCOUNT_SEQ.nextval into :NEW.IDX from DUAL;
	end if;
	if :NEW.REG_DATE is null
		then :NEW.REG_DATE := SYSDATE;
	end if;
end;
/

--	trigger test
--	insert into ACCOUNT (EMAIL, PW, NAME, BIRTH) values ('Email@aa.com','pw','name',TO_DATE('2018/04/01 00:01:23', 'yyyy/mm/dd hh24:mi:ss'));

comment on table ACCOUNT is '회원테이블';

comment on column ACCOUNT.IDX is '회원번호';

comment on column ACCOUNT.EMAIL is '이메일';

comment on column ACCOUNT.PW is '비밀번호';

comment on column ACCOUNT.NAME is '이름';

comment on column ACCOUNT.BIRTH is '생년월일';

comment on column ACCOUNT.WAZLV_IDX is '회원등급 - 참조';

comment on column ACCOUNT.REG_DATE is '가입일자';

comment on column ACCOUNT.LEFT_DATE is '탈퇴일자';

comment on column ACCOUNT.DEL_FLAG is '삭제플래그';

comment on column ACCOUNT.IMG is '프로필이미지';


--drop trigger ACCOUNT_IDX_TRG;
--drop sequence ACCOUNT_SEQ;
--drop table ACCOUNT cascade constraints;
------------------------------------------------------------------------------------------------------------


create table MOVGUYS (
	IDX			number(7,0)
	,NAME		varchar2(50) not null
	,constraint MOVGUY_PK primary key (IDX)
);

create sequence MOVGUYS_SEQ start with 1 increment by 1;

create or replace trigger MOVGUYS_IDX_TRG
	before insert on MOVGUYS
	for each row 
	when (NEW.IDX is null)
begin 
	select MOVGUYS_SEQ.nextval into :NEW.IDX from DUAL;
end;
/

comment on table MOVGUYS is '영화 감독 및 배우 등등';

comment on column MOVGUYS.IDX is '식별번호';

comment on column MOVGUYS.NAME is '이름';


--drop trigger MOVGUYS_IDX_TRG;
--drop sequence MOVGUYS_SEQ;
--drop table MOVGUYS cascade constraints;
------------------------------------------------------------------------------------------------------------

create table MOVIE
(
	IDX				number(8,0)
	,KORTITLE		varchar2(500)	not null
	,ENGTITLE		varchar2(500)	not null
	,COUNTRY		varchar2(100)	not null
	,RELEASEDATE	date			not null
	,RATING			varchar2(50)	not null
	,PLAYTIME		varchar2(50)	not null
--	,GENRE			varchar2(100)	not null
	,VIEWCOUNT		number(9,0)		default 0
	,OUTLINE		clob			default ''
	,TICKETSOLD		number(8,0)		default 0
	,PRICE			number(7,0)		default 0
	,TOT_SCORE		binary_double	default 0
	,SCORE_COUNT	number(9,0)		default 0
	,COMM_COUNT 	number(7)		default 0
	,constraint MOVIE_PK primary key (IDX)
);

create sequence MOVIE_SEQ start with 1 increment by 1;

create or replace trigger MOVIE_IDX_TRG	
	before insert on MOVIE 
	for each row 
	when (NEW.IDX is null)
begin 
	select MOVIE_SEQ.nextval into :NEW.IDX from DUAL;
end;
/

comment on table MOVIE is '영화 테이블';

comment on column MOVIE.IDX is '영화번호';

comment on column MOVIE.KORTITLE is '영화제목(한글)';

comment on column MOVIE.ENGTITLE is '원제';

comment on column MOVIE.COUNTRY is '제작국가';

comment on column MOVIE.RELEASEDATE is '개봉일자';

comment on column MOVIE.RATING is '연령등급';

comment on column MOVIE.PLAYTIME is '영화의 길이';

--comment on column MOVIE.GENRE is '장르';

comment on column MOVIE.VIEWCOUNT is '시청(평가)수';

comment on column MOVIE.OUTLINE is '줄거리';

comment on column MOVIE.TICKETSOLD is '관람객수';

comment on column MOVIE.PRICE is '가격';

comment on column MOVIE.TOT_SCORE is '총점';

comment on column MOVIE.SCORE_COUNT is '총 평가 갯수';

comment on column MOVIE.COMM_COUNT is '총 코멘트 수';


--drop trigger MOVIE_IDX_TRG;
--drop sequence MOVIE_SEQ;
--drop table MOVIE cascade constraints;
------------------------------------------------------------------------------------------------------------

create table MOVGUYS_MAPPING
(
	MOV_IDX				number(8,0)
	,MOVGUYS_IDX		number(7,0) 	not null
	,ROLE				varchar2(50)	not null
	,CHARACTER			varchar2(50)	default ''
	,constraint MOVMAP_PK primary key(MOV_IDX,MOVGUYS_IDX)
	,constraint FK_MOVMAP_MOVIE foreign key (MOV_IDX) references MOVIE (IDX)
	,constraint FK_MOVMAP_MOVGUYS foreign key (MOVGUYS_IDX) references MOVGUYS (IDX)
);

comment on table MOVGUYS_MAPPING is '영화관련 인물들 테이블';

comment on column MOVGUYS_MAPPING.MOV_IDX is '영화 식별 코드 - 외래키 + 복합 주 키';

comment on column MOVGUYS_MAPPING.MOVGUYS_IDX is '인물 식별 코드 - 외래키 + 복합 주 키';

comment on column MOVGUYS_MAPPING.ROLE is '역할, 감독이냐 배우냐 등등';

comment on column MOVGUYS_MAPPING.CHARACTER is '배역';


--drop table MOVGUYS_MAPPING cascade constraints;
------------------------------------------------------------------------------------------------------------

create table MOV_GENRE
(	
	IDX			number(3,0)
	,GENRE		char(30)		not null
	,constraint MOVGENRE_PK primary key (IDX)
);
--태그의 개념을 장르와 분리하려면 비슷한 테이블을 추가.
create sequence MOV_GENRE_SEQ start with 1 increment by 1;

create or replace trigger MOVGENRE_IDX_TRG
	before insert on MOV_GENRE 
	for each row 
	when (NEW.IDX is null)
begin 
	select MOV_GENRE_SEQ.nextval into :NEW.IDX from DUAL;
end;
/

comment on table MOV_GENRE is '영화 장르(태그) 테이블';

comment on column MOV_GENRE.IDX is '인덱스 + 주 키';

comment on column MOV_GENRE.GENRE is '영화 장르(태그)';


--drop trigger MOVGENRE_IDX_TRG;
--drop sequence MOV_GENRE_SEQ;
--drop table MOV_GENRE cascade constraints;
------------------------------------------------------------------------------------------------------------

create table MOVGENRE_MAP
(
	MOV_IDX				number(8,0)
	,GENRE_IDX			number(3,0)
	,constraint MOVGENREMAP_PK primary key (MOV_IDX,GENRE_IDX)
	,constraint FK_MOVGENREMAP_MOVIE foreign key (MOV_IDX) references MOVIE (IDX)
	,constraint FK_MOVGENREMAP_GENRE foreign key (GENRE_IDX) references MOV_GENRE (IDX)
);

comment on table MOVGENRE_MAP is '영화-장르(태그) 매핑 테이블';

comment on column MOVGENRE_MAP.MOV_IDX is '영화 식별 코드 - 외래키';

comment on column MOVGENRE_MAP.GENRE_IDX is '장르 키 - 외래키';

--drop table MOVGENRE_MAP;
------------------------------------------------------------------------------------------------------------

create table WAZPOINT
(
	IDX				number(11,0)
	,ACC_IDX		number(9,0)			not null
	,INIT_POINTS	number(8,0)			not null
	,LEFT_POINTS	number(8,0)			not null
	,GIVEN_FOR		varchar2(200)		not null
	,GIVEN_DATE		timestamp			not null
	,EXP_DATE		timestamp			not null
	,constraint WAZPOINT_PK primary key(IDX)
	,constraint FK_WAZPOINT_ACC_IDX_ACCOUNT foreign key (ACC_IDX) references ACCOUNT (IDX)
);

create sequence WAZPOINT_SEQ start with 1 increment by 1;

create or replace trigger WAZPOINT_IDX_TRG
	before insert on WAZPOINT
	for each row
begin
	if :NEW.IDX is null
		then select WAZPOINT_SEQ.nextval into :NEW.IDX from DUAL;
	end if;
	if :NEW.GIVEN_DATE is null
		then :NEW.GIVEN_DATE := SYSDATE;
	end if;
end;
/

comment on table WAZPOINT is '보유포인트 테이블';

comment on column WAZPOINT.IDX is '식별번호';

comment on column WAZPOINT.ACC_IDX is '회원번호(참조키)';

comment on column WAZPOINT.INIT_POINTS is '해당 묶음의 초기 포인트';

comment on column WAZPOINT.LEFT_POINTS is '해당 묶음의 잔여 포인트';

comment on column WAZPOINT.GIVEN_FOR is '부여사유';

comment on column WAZPOINT.GIVEN_DATE is '부여일자';

comment on column WAZPOINT.EXP_DATE is '만료일자';


--drop trigger WAZPOINT_IDX_TRG;
--drop sequence WAZPOINT_SEQ;
--drop table WAZPOINT cascade constraints;
----------------------------------------------------------------------------

create table COMMENTS
(
	IDX				number(12,0)
	,ACC_IDX		number(9,0)			not null
	,MOVIE_IDX		number(8,0)			not null
	,REG_DATE		timestamp			not null
	,CONTENTS		clob				not null
	,ISBLIND		varchar2(100)
	,constraint COMMENT_PK primary key (IDX)
	,constraint FK_COMMENT_ACC_IDX_ACCOUNT foreign key (ACC_IDX) references ACCOUNT (IDX)
	,constraint FK_COMMENT_MOVIE_IDX_MOVIE foreign key (MOVIE_IDX) references MOVIE (IDX)
);

create sequence COMMENTS_SEQ start with 1 increment by 1;

create or replace trigger COMMENTS_IDX_TRG
	before insert on COMMENTS
	for each row
begin
	if :NEW.IDX is null
		then select COMMENTS_SEQ.nextval into :NEW.IDX from DUAL;
	end if;
	if :NEW.REG_DATE is null
		then :NEW.REG_DATE := SYSDATE;
	end if;
end;
/

create or replace trigger COMM_COUNT_MGR
after
	insert
	or delete
	on COMMENTS
	for each row
begin
	case
		when inserting then
			update MOVIE set
				COMM_COUNT = COMM_COUNT + 1
			where IDX = :NEW.MOVIE_IDX;
		when deleting then
			update MOVIE set
				COMM_COUNT = COMM_COUNT-1
			where IDX = :OLD.MOVIE_IDX;
	end case;
end;
/



comment on table COMMENTS is '코멘트 테이블';

comment on column COMMENTS.IDX is '코멘트식별번호';

comment on column COMMENTS.ACC_IDX is '회원번호(참조키)';

comment on column COMMENTS.MOVIE_IDX is '영화번호(참조키)';

comment on column COMMENTS.REG_DATE is '등록일자';

comment on column COMMENTS.CONTENTS is '코멘트내용';

comment on column COMMENTS.ISBLIND is '블라인드';

--drop trigger COMM_COUNT_MGR;
--drop trigger COMMENTS_IDX_TRG;
--drop sequence COMMENTS_SEQ;
--drop table COMMENTS cascade constraints;
----------------------------------------------------------------------------

create table REPORT
(
	IDX				number(12,0)
	,ACC_IDX		number(9,0)			not null
	,COMM_IDX		number(12,0)		not null
	,REPORT_DATE	timestamp			not null
	,DEALT			varchar2(200)		not null
	,constraint REPORT_PK primary key (IDX)
	,constraint FK_REPORT_ACC_IDX_ACCOUNT foreign key (ACC_IDX) references ACCOUNT (IDX)
	,constraint FK_REPORT_COMM_IDX_COMMENT_T foreign key (COMM_IDX) references COMMENTS (IDX)
);
-- 신고가 들어오면 == 바로 신고 테이블에 올라온다 ? NULL 허용 필요 : 아니라면 신고가 들어오는 것들을 모아 볼 테이블이 따로 필요하다;

create sequence REPORT_SEQ start with 1 increment by 1;

create or replace trigger REPORT_IDX_TRG
	before insert on REPORT 
	for each row
begin 
	if :NEW.IDX is null
		then select REPORT_SEQ.nextval into :NEW.IDX from DUAL;
	end if;
	if :NEW.REPORT_DATE is null
		then :NEW.REPORT_DATE := SYSDATE;
	end if;
end;
/

comment on table REPORT is '신고접수 테이블';

comment on column REPORT.IDX is '신고식별번호';

comment on column REPORT.ACC_IDX is '회원번호(참조키)';

comment on column REPORT.COMM_IDX is '코멘트번호(참조키)';

comment on column REPORT.REPORT_DATE is '신고일자';

comment on column REPORT.DEALT is '조치내용';


--drop trigger REPORT_IDX_TRG;
--drop sequence REPORT_SEQ;
--drop table REPORT cascade constraints;
-------------------------------------------------------------------------------------------------------

--이미지 매핑을 DBMS에서 한다면 필요.(종류 및 갯수에 제한을 받게 됨) 이미 이미지를 저장해야할 위치가 정해진 상태에서 꼭 필요하지는 않음.
create table MOVIE_IMG
(
	MOVIE_IDX		number(8,0)
	,POSTER			varchar2(255)	not null
	,THUM			varchar2(255)	not null
	,SC1			varchar2(255)	not null
	,SC2			varchar2(255)	not null
	,SC3			varchar2(255)	default '-'
	,SC4			varchar2(255)	default '-'
	,SC5			varchar2(255)	default '-'
	,constraint MOVIE_IMG_PK primary key (MOVIE_IDX)
	,constraint FK_MOVIE_IMG_MOVIE_IDX_MOVI foreign key (MOVIE_IDX) references MOVIE (IDX)
);

comment on table MOVIE_IMG is '영화이미지 테이블';

comment on column MOVIE_IMG.MOVIE_IDX is '영화번호(참조키)';

comment on column MOVIE_IMG.POSTER is '포스터';

comment on column MOVIE_IMG.THUM is '썸네일';

comment on column MOVIE_IMG.SC1 is '스틸컷1';

comment on column MOVIE_IMG.SC2 is '스틸컷2';

comment on column MOVIE_IMG.SC3 is '스틸컷3';

comment on column MOVIE_IMG.SC4 is '스틸컷4';

comment on column MOVIE_IMG.SC5 is '스틸컷5';

--drop table MOVIE_IMG cascade constraints;
-----------------------------------------------------------------------------

create table WISH_LIST
(
	ACC_IDX		number(9,0)
	,MOVIE_IDX	number(8,0)				not null
	,FLAG		varchar2(200)			not null
	,constraint WISH_LIST_PK primary key (ACC_IDX, MOVIE_IDX)
	,constraint FK_WISHLIST_ACCIDX_ACCOUNT foreign key (ACC_IDX) references ACCOUNT (IDX)
	,constraint FK_WISHLIST_MOVIEIDX_MOVI foreign key (MOVIE_IDX) references MOVIE (IDX)
);

comment on table WISH_LIST is '찜목록 테이블';

comment on column WISH_LIST.ACC_IDX is '회원번호(참조키)';

comment on column WISH_LIST.MOVIE_IDX is '영화번호(참조키)';

comment on column WISH_LIST.FLAG is'플래그';
----------------- 어디에 쓰는 플래그?

--drop table WISH_LIST cascade constraints;
-----------------------------------------------------------------------------

create table INQUIRE
(
	IDX			number(9,0)
	,ACC_IDX	number(9,0)		not null
	,CONTENTS	clob			not null
	,RESPONSE	clob			null
	,REG_DATE	timestamp		not null
	,RES_DATE	timestamp		null
	,constraint INQUIRE_PK primary key (IDX)
	,constraint FK_INQUIRE_ACC_IDX_ACCOUNT_ID foreign key (ACC_IDX) references ACCOUNT (IDX)
);

create sequence INQUIRE_SEQ start with 1 increment by 1;

create or replace trigger INQUIRE_IDX_TRG
	before insert on INQUIRE
	for each row
begin
	if :NEW.IDX is null 
		then select INQUIRE_SEQ.nextval into :NEW.IDX from DUAL;
	end if;
	if :NEW.REG_DATE is null
		then :NEW.REG_DATE := SYSDATE;
	end if;
end;
/

comment on table INQUIRE is '문의내역';

comment on column INQUIRE.IDX is '문의번호';

comment on column INQUIRE.ACC_IDX is '회원번호(참조키)';

comment on column INQUIRE.CONTENTS is '문의내용';

comment on column INQUIRE.RESPONSE is '답변내용';

comment on column INQUIRE.REG_DATE is '문의일자';

comment on column INQUIRE.RES_DATE is '답변일자';


--drop trigger INQUIRE_IDX_TRG;
--drop sequence INQUIRE_SEQ;
--drop table INQUIRE cascade constraints;
-----------------------------------------------------------------------------

create table TRAILERS
(
	IDX				number(9,0)
	,MOVIE_IDX		number(8,0)		not null
	,TRAILER_FILE	varchar2(200)	not null
	,TRAILER_TITLE	varchar2(200)	not null
	,constraint TRAILERS_PK primary key (IDX)
	,constraint FK_TRAILERS_MOVIE_IDX_MOVIE foreign key (MOVIE_IDX) references MOVIE (IDX)
);
--트레일러 영상을 어떻게 송출할 것인가에 따라 필요 없을 수 있음. 

create sequence TRAILERS_SEQ start with 1 increment by 1;

create or replace trigger TRAILERS_IDX_TRG
	before insert on TRAILERS
	for each row
	when (NEW.IDX is null)
begin
	select TRAILERS_SEQ.nextval into :NEW.IDX from DUAL;
end;
/

comment on table TRAILERS is '트레일러(영상) 테이블';

comment on column TRAILERS.IDX is '영상식별번호';

comment on column TRAILERS.MOVIE_IDX is '영화번호(참조키)';

comment on column TRAILERS.TRAILER_FILE is '파일이름';

comment on column TRAILERS.TRAILER_TITLE is '영상제목';

--drop trigger TRAILERS_IDX_TRG;
--drop sequence TRAILERS_SEQ;
--drop table TRAILERS cascade constraints;
-----------------------------------------------------------------------------

create table MVSCORE
(
	ACC_IDX			number(9,0)	
	,MOVIE_IDX		number(8,0)			not null
	,SCORE			binary_double		not null
	,constraint MVSCORE_PK primary key (ACC_IDX, MOVIE_IDX)
	,constraint FK_MVSCORE_ACCIDX_ACCOUNT_IDX foreign key (ACC_IDX) references ACCOUNT (IDX)
	,constraint FK_MVSCORE_MOVIDX_MOVIE_IDX foreign key (MOVIE_IDX)  references MOVIE (IDX)
);
--평점은 1자리 정수 + 1자리 소수
create or replace trigger MVSCORE_MANAGER
	before
		insert
		or update of SCORE
		or delete
	on MVSCORE
	for each row
begin
	case
		when inserting then
			update MOVIE set
				TOT_SCORE = TOT_SCORE + :NEW.SCORE
				,SCORE_COUNT = SCORE_COUNT + 1
			where IDX = :NEW.MOVIE_IDX;
		when updating('SCORE') then
			update MOVIE set 
				TOT_SCORE = TOT_SCORE + :NEW.SCORE - :OLD.SCORE
			where IDX = :NEW.MOVIE_IDX;
		when deleting then
			update MOVIE set
				TOT_SCORE = TOT_SCORE - :OLD.SCORE
				,SCORE_COUNT = SCORE_COUNT -1
			where IDX = :OLD.MOVIE_IDX;
	end case;
end;
/

comment on table MVSCORE is '영화 평점 테이블';

comment on column MVSCORE.ACC_IDX is '계정식별 번호 - 참조키 + 복합 주 키';

comment on column MVSCORE.MOVIE_IDX is '영화식별 번호 - 참조키 + 복합 주 키';

comment on column MVSCORE.SCORE is '점수';


/*
-----------------------------------trigger test-------------------------------------

insert into MOVIE (KORTITLE, TITLE, DIRECTOR, ACTOR, COUNTRY, RELEASEDATE, RATING, PLAYTIME, GENRE, VIEWCOUNT, OUTLINE, TICKETSOLD, PRICE, TOT_SCORE, SCORE_COUNT)
	values ('영화제목', 'MOV TITLE', 'DIRECTOR', 'ACTOR', 'COUNTRY', TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), '연령등급', '영화의 길이', 'GENRE', 300, '줄거리줄거리줄거리줄거리줄거리줄거리', 100, 200, 500, 100);

insert into ACCOUNT (EMAIL,PW,NAME,BIRTH,REG_DATE)
	values('email@email.com','pwpwpw','이름이름이름',to_DATE('0001/01/01','yyyy/mm/dd'),to_date('1010/10/10','yyyy/mm/dd'));

insert into MVSCORE (MOVIE_IDX, ACC_IDX, SCORE) values(1,1,500);

update MVSCORE set SCORE = 20 where MOVIE_IDX=1;

delete MVSCORE where ACC_IDX=1 and MOVIE_IDX = 1;

select * from MVSCORE;
select * from MOVIE;
select * from ACCOUNT;
*/


--drop trigger MVSCORE_MANAGER;
--drop table MVSCORE cascade constraints;
-----------------------------------------------------------------------------

create table PRODUCTS
(
	IDX				number(8,0)
	,MOV_IDX		number(8,0)
	,DURATION		timestamp
	,PRICE			number(7,0)			not null
	,constraint PRODUCTS_PK primary key (IDX)
	,constraint FK_PRODUCTS_MOVIDX_MOVI foreign key (MOV_IDX) references MOVIE (IDX)
);

create sequence PRODUCTS_SEQ start with 1 increment by 1;

create or replace trigger PRODUCTS_IDX_TRG
	before insert on PRODUCTS
	for each row
	when (NEW.IDX is null)
begin 
	select PRODUCTS_SEQ.nextval into :NEW.IDX from DUAL;
end;
/

create or replace trigger PRODUCTS_MV_MGR
	after insert on MOVIE
	for each row
begin
	insert into PRODUCTS (MOV_IDX,PRICE) values (:NEW.IDX, :NEW.PRICE);
end;
/

comment on table PRODUCTS is '상품 테이블 (월결제와 개별 구매를 같이 관리)';

comment on column PRODUCTS.IDX is '상품번호(식별) +주 키';

comment on column PRODUCTS.MOV_IDX is '영화번호(개별구매영화) +외래키, 월결제시 null, 혹시 나중에 개별영화를 기간을 두고 구매 가능하게 할 때에도 사용 가능';

comment on column PRODUCTS.DURATION is '유효기간, 일단 월결제 용';

comment on column PRODUCTS.PRICE is '가격';

--drop trigger PRODUCTS_MV_MGR;
--drop trigger PRODUCTS_IDX_TRG;
--drop sequence PRODUCTS_SEQ;
--drop table PRODUCTS cascade constraints;
-----------------------------------------------------------------------------

create table POSSESION
(
	IDX				number(10,0)
	,ACC_IDX		number(9,0)
	,PRODUCTS_IDX	number(8,0)
	,REG_DATE		timestamp
	,EXPDATE		timestamp
	,isused			timestamp
	,constraint POSSESION_PK primary key (IDX)
	,constraint FK_POSSACCIDX_ACCIDX_ACC foreign key (ACC_IDX) references ACCOUNT (IDX)
	,constraint FK_POSSPRODUCT_PRODUCT foreign key (PRODUCTS_IDX) references PRODUCTS (IDX)
);

create sequence POSSESION_SEQ start with 1 increment by 1;

create or replace trigger POSSESION_IDX_TRG
	before insert on POSSESION
	for each row
begin
	if :NEW.IDX is null 
		then select POSSESION_SEQ.nextval into :NEW.IDX from DUAL;
	end if;
	if :NEW.REG_DATE is null
		then :NEW.REG_DATE := SYSDATE;
	end if;
end;
/

comment on table POSSESION is '상품 소유 테이블';

comment on column POSSESION.IDX is '인덱스 +주 키';

comment on column POSSESION.ACC_IDX is '계정번호 + 외래키';

comment on column POSSESION.PRODUCTS_IDX is '상품번호 + 외래키';

comment on column POSSESION.REG_DATE is '등록일자 - 트리거로 관리';

comment on column POSSESION.EXPDATE is '기간이 있는 제품의 경우 만료일 등록';

comment on column POSSESION.isused is '사용여부 처음 이 상품이 사용된 시간 기록';

--drop trigger POSSESION_IDX_TRG;
--drop sequence POSSESION_SEQ;
--drop table POSSESION cascade constraints;
-----------------------------------------------------------------------------

create table WATCHEDLIST
(
	TIMEWHEN		timestamp		not null
	,ACC_IDX		number(9,0)		not null
	,MOVIE_IDX		number(8,0)		not null
	,constraint WATCHEDLIST_PK primary key (TIMEWHEN, ACC_IDX)
	,constraint FK_WATCHLIST_ACCIDX foreign key (ACC_IDX) references ACCOUNT (IDX)
	,constraint FK_WATCHLIST_MOVIDX foreign key (MOVIE_IDX) references MOVIE (IDX)
);
--마지막 시청시각만 기록한다면 WISH LIST 와 합치는 것도 가능하지만 너무 관리가 지저분해 져서 그냥 분리

create or replace trigger WATCHEDLIST_TIME_TRG
	before insert on WATCHEDLIST
	for each row
	when (NEW.TIMEWHEN is null)
begin
	:NEW.TIMEWHEN := SYSDATE;
end;
/

comment on table WATCHEDLIST is '시청목록 (마지막 시청시각만 기록)';

comment on column WATCHEDLIST.TIMEWHEN is '마지막으로 본 시간 기록 + 복합 주 키';

comment on column WATCHEDLIST.ACC_IDX is '계정 + 복합 주 키 +외래키 ';

comment on column WATCHEDLIST.MOVIE_IDX is '계정 +외래키';

--drop trigger WATCHEDLIST_TIME_TRG;
--drop table WATCHEDLIST cascade constraints;
-----------------------------------------------------------------------------

create table ANNOUNCE
(
	REG_DATE 		timestamp
	,ISEVENT		number(1,0)			not null
	,TITLE			varchar2(200)		default ''
	,ACC_IDX		number(9,0)			not null
	,VIEWCOUNT		number(11,0)		default 0
	,CONTENTS		clob				default ''
	,constraint ANNOUNCE_PK primary key (REG_DATE,ACC_IDX)
	,constraint FK_ANNOUNCE_ACCIDX	foreign key (ACC_IDX) references ACCOUNT (IDX)
);
--만일 관리자 계정을 ACCOUNT 테이블이 아닌 다른 테이블에서 관리하게 된다면 수정해야함!!!!
create or replace trigger ANNOUNCE_TIME_TRG
	before insert on ANNOUNCE
	for each row
	when (NEW.REG_DATE is null)
begin
	:NEW.REG_DATE := SYSDATE;
end;
/

comment on table ANNOUNCE is '공지사항 계시판';

comment on column ANNOUNCE.ISEVENT is '공지사항과 이벤트 구분 0=공지사항 1=이벤트';

comment on column ANNOUNCE.REG_DATE is '등록시간 +복합 주 키';

comment on column ANNOUNCE.TITLE is '제목';

comment on column ANNOUNCE.ACC_IDX is '등록한 계정 +복합 주 키 + 외래키 (관리자 계정도 ACCOUNT 테이블에 있다고 일단 가정함';

comment on column ANNOUNCE.VIEWCOUNT is '조회수';

comment on column ANNOUNCE.CONTENTS is '내용';


--drop trigger ANNOUNCE_TIME_TRG;
--drop table ANNOUNCE cascade constraints;
-----------------------------------------------------------------------------



-----------------------------------------------------------------------------
disc;