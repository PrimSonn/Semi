
/*

TABLE LIST:	MEMBER
			MOVIE
			WAZPOINT
			WAZLEVEL
			COMMENTS
			REPORT
			MOVIE_IMG
			WISH_LIST
			INQUIRE
			TRAILERS

*/
-------------------------------------------Clear ALL-----------------------------------------------------------------------
--
--drop trigger TRAILERS_IDX_TRG;
--drop sequence TRAILERS_SEQ;
--drop table TRAILERS cascade constraints;
--drop trigger INQUIRE_IDX_TRG;
--drop sequence INQUIRE_SEQ;
--drop table INQUIRE cascade constraints;
--drop table WISH_LIST cascade constraints;
--drop table MOVIE_IMG cascade constraints;
--drop trigger REPORT_IDX_TRG;
--drop sequence REPORT_SEQ;
--drop table REPORT cascade constraints;
--drop trigger COMMENTS_IDX_TRG;
--drop sequence COMMENTS_SEQ;
--drop table COMMENTS cascade constraints;
--drop table WAZLEVEL cascade constraints;
--drop trigger WAZPOINT_IDX_TRG;
--drop sequence WAZPOINT_SEQ;
--drop table WAZPOINT cascade constraints;
--drop trigger MOVIE_IDX_TRG;
--drop sequence MOVIE_SEQ;
--drop table MOVIE cascade constraints;
--drop trigger MEMBER_IDX_TRG;
--drop sequence MEMBER_SEQ;
--drop table MEMBER cascade constraints;

------------------------------------------------------------------------------------------------------------------

ALTER SESSION SET PLSCOPE_SETTINGS = 'IDENTIFIERS:NONE';

create table MEMBER (
    IDX			int not null,
    EMAIL		varchar2(50) not null,
    PW   		varchar2(50) not null,
    NAME		varchar2(50) not null,
    BIRTH		date not null,
    REG_DATE	date not null,
    LEFT_DATE	date default null,
    DEL_FLAG		varchar2(100) default 'N',------탈퇴일자와 기능 중복
    IMG			varchar2(255) default '-',------프로필 이미지를 DBMS를 사용해 처리할 것이 아니라면 필요 없음
    constraint MEMBER_PK primary key ( IDX )
);

create sequence MEMBER_SEQ start with 1 increment by 1; 

/
create or replace trigger MEMBER_IDX_TRG
	before insert on MEMBER
    referencing
        new as new
    for each row
    WHEN (new.IDX IS NULL)
begin
    select
        MEMBER_SEQ.nextval
    into
        :new.IDX
    from
        DUAL;
end;
/

comment on table MEMBER is '회원테이블';

comment on column MEMBER.IDX is '회원번호';

comment on column MEMBER.EMAIL is '이메일';

comment on column MEMBER.PW is '비밀번호';

comment on column MEMBER.NAME is '이름';

comment on column MEMBER.BIRTH is '생년월일';

comment on column MEMBER.REG_DATE is '가입일자';

comment on column MEMBER.LEFT_DATE is '탈퇴일자';

comment on column MEMBER.DEL_FLAG is '삭제플래그';

comment on column MEMBER.IMG is '프로필이미지';------프로필 이미지를 DBMS를 사용해 처리할 것이 아니라면 필요 없음#2


--drop trigger MEMBER_IDX_TRG;
--drop sequence MEMBER_SEQ;
--drop table MEMBER cascade constraints;
------------------------------------------------------------------------------

create table MOVIE
(
    IDX				int               not null, 
    KORTITLE		varchar2(500)     not null, 
    TITLE			varchar2(500)     not null, 
    DIRECTOR		varchar2(200)     not null, 
    ACTOR			varchar2(1000)    not null, 
    COUNTRY			varchar2(100)     not null, 
    RELEASEDATE		date              not null, 
    RATING			varchar2(50)      not null, 
    PLAYTIME		varchar2(50)      not null, -- 시간을 처리할 때는 다른 데이터 타입도 가능 할 듯?
    GERNE			varchar2(100)     not null, 
    VIEWCOUNT		int               default 0, 
    OUTLINE			clob              not null, 
    TICKETSOLD		int               default 0, 
    PRICE			int               default 0, 
    constraint MOVIE_PK primary key (IDX)
);

create sequence MOVIE_SEQ start with 1 increment by 1;

/
create or replace trigger MOVIE_IDX_TRG	
    before insert on MOVIE 
    referencing new as new
    for each row 
    WHEN (new.IDX IS NULL)
begin 
    select MOVIE_SEQ.nextval
    into:new.IDX
    from DUAL;
end;
/

comment on table MOVIE is '영화 테이블';

comment on column MOVIE.IDX is '영화번호';

comment on column MOVIE.KORTITLE is '영화제목(한글)';

comment on column MOVIE.TITLE is '원제';

comment on column MOVIE.DIRECTOR is '감독';

comment on column MOVIE.ACTOR is '배우';

comment on column MOVIE.COUNTRY is '제작국가';

comment on column MOVIE.RELEASEDATE is '개봉일자';

comment on column MOVIE.RATING is '연령등급';

comment on column MOVIE.PLAYTIME is '플레이타임';

comment on column MOVIE.GERNE is '장르';

comment on column MOVIE.VIEWCOUNT is '시청(평가)수';

comment on column MOVIE.OUTLINE is '줄거리';

comment on column MOVIE.TICKETSOLD is '관람객수';

comment on column MOVIE.PRICE is '가격';


--drop trigger MOVIE_IDX_TRG;
--drop sequence MOVIE_SEQ;
--drop table MOVIE cascade constraints;
----------------------------------------------------------------------------

create table WAZPOINT
(
    IDX			int              not null, 
    MEM_IDX		int              not null, 
    INIT_POINTS	int              not null,
	LEFT_POINTS	int              not null,	
    GIVEN_FOR	varchar2(200)    not null, 
    GIVEN_DATE	date             not null, 
    EXP_DATE	date             not null, 
    constraint WAZPOINT_PK primary key (IDX)
);

create sequence WAZPOINT_SEQ start with 1 increment by 1;

/
create or replace trigger WAZPOINT_IDX_TRG
	before insert on WAZPOINT 
	referencing new as new
    for each row 
begin 
    select WAZPOINT_SEQ.nextval
    into:new.IDX
    from DUAL;
end;
/

comment on table WAZPOINT is '보유포인트 테이블';

comment on column WAZPOINT.IDX is '식별번호';

comment on column WAZPOINT.MEM_IDX is '회원번호(참조키)';

comment on column WAZPOINT.INIT_POINTS is '해당 묶음의 초기 포인트';

comment on column WAZPOINT.LEFT_POINTS is '해당 묶음의 잔여 포인트';

comment on column WAZPOINT.GIVEN_FOR is '부여사유';

comment on column WAZPOINT.GIVEN_DATE is '부여일자';

comment on column WAZPOINT.EXP_DATE is '만료일자';

alter table WAZPOINT add constraint FK_WAZPOINT_MEM_IDX_MEMBER foreign key (MEM_IDX) references MEMBER (IDX);


--drop trigger WAZPOINT_IDX_TRG;
--drop sequence WAZPOINT_SEQ;
--drop table WAZPOINT cascade constraints;
----------------------------------------------------------------------------

create table WAZLEVEL
(
    MEM_IDX			int              not null, 
    LEV_NAME		varchar2(100)    not null, 
    constraint WAZLEVEL_PK primary key (MEM_IDX)
);

comment on table WAZLEVEL is '회원등급 테이블';

comment on column WAZLEVEL.MEM_IDX is '회원번호(참초키)';

comment on column WAZLEVEL.LEV_NAME is '회원등급';

alter table WAZLEVEL add constraint FK_WAZLEVEL_MEM_IDX_MEMBER_ID foreign key (MEM_IDX) references MEMBER (IDX);


--drop table WAZLEVEL cascade constraints;
----------------------------------------------------------------------------

create table COMMENTS
(
    IDX				int              not null, 
    MEM_IDX			int              not null, 
    MOVIE_IDX		int              not null, 
    REG_DATE		date             not null, 
    CONTENTS		clob             not null, 
    ISBLIND			varchar2(100)    , 
    constraint COMMENT_PK primary key (IDX)
);

create sequence COMMENTS_SEQ start with 1 increment by 1;

/
create or replace trigger COMMENTS_IDX_TRG
before insert on COMMENTS
referencing new as new for each row 
begin 
    select COMMENTS_SEQ.nextval
    into:new.IDX
    from DUAL;
end;
/

comment on table COMMENTS is '코멘트 테이블';

comment on column COMMENTS.IDX is '코멘트식별번호';

comment on column COMMENTS.MEM_IDX is '회원번호(참초키)';

comment on column COMMENTS.MOVIE_IDX is '영화번호(참조키)';

comment on column COMMENTS.REG_DATE is '등록일자';

comment on column COMMENTS.CONTENTS is '코멘트내용';

comment on column COMMENTS.ISBLIND is '블라인드';

alter table COMMENTS add constraint FK_COMMENT_MEM_IDX_MEMBER foreign key (MEM_IDX) references MEMBER (IDX);

alter table COMMENTS add constraint FK_COMMENT_MOVIE_IDX_MOVIE foreign key (MOVIE_IDX) references MOVIE (IDX);


--drop trigger COMMENTS_IDX_TRG;
--drop sequence COMMENTS_SEQ;
--drop table COMMENTS cascade constraints;
----------------------------------------------------------------------------

create table REPORT
(
    IDX					int              not null, 
    MEM_IDX				int              not null, 
    COMM_IDX			int              not null, 
    REPORT_DATE			date             not null, 
    DEALT				varchar2(200)    not null,-- 신고가 들어오면 == 바로 신고 테이블에 올라온다 ? NULL 필요 : 신고가 들어오는 것들을 모아 볼 테이블이 따로 필요하다;
    constraint REPORT_PK primary key (IDX)
);

create sequence REPORT_SEQ start with 1 increment by 1;

/
create or replace trigger REPORT_IDX_TRG
	before insert on REPORT 
	referencing new as new for each row 
begin 
    select REPORT_SEQ.nextval
    into:new.IDX
    from DUAL;
end;
/

comment on table REPORT is '신고접수 테이블';

comment on column REPORT.IDX is '신고식별번호';

comment on column REPORT.MEM_IDX is '회원번호(참초키)';

comment on column REPORT.COMM_IDX is '코멘트번호(참조키)';

comment on column REPORT.REPORT_DATE is '신고일자';

comment on column REPORT.DEALT is '조치내용';

alter table REPORT add constraint FK_REPORT_MEM_IDX_MEMBER foreign key (MEM_IDX) references MEMBER (IDX);

alter table REPORT add constraint FK_REPORT_COMM_IDX_COMMENT_T foreign key (COMM_IDX) references COMMENTS (IDX);


--drop trigger REPORT_IDX_TRG;
--drop sequence REPORT_SEQ;
--drop table REPORT cascade constraints;
-----------------------------------------------------------------------------

create table MOVIE_IMG--이미지 매핑을 DBMS에서 한다면 필요.(종류 및 갯수에 제한을 받게 됨) 이미 이미지를 저장해야할 위치가 정해진 상태에서 꼭 필요하지는 않음.
(
    MOVIE_IDX    int              not null, 
    POSTER       varchar2(255)    not null, 
    THUM         varchar2(255)    not null, 
    SC1          varchar2(255)    not null, 
    SC2          varchar2(255)    not null, 
    SC3          varchar2(255)    default '-', 
    SC4          varchar2(255)    default '-', 
    SC5          varchar2(255)    default '-', 
    constraint MOVIE_IMG_PK primary key (MOVIE_IDX)
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

alter table MOVIE_IMG add constraint FK_MOVIE_IMG_MOVIE_IDX_MOVI foreign key (MOVIE_IDX) references MOVIE (IDX);

	
--drop table MOVIE_IMG cascade constraints;
-----------------------------------------------------------------------------

create table WISH_LIST
(
    MEM_IDX      int              not null, 
    MOVIE_IDX    int              not null, 
    FLAG         varchar2(200)    not null, 
    constraint WISH_LIST_PK primary key (MEM_IDX, MOVIE_IDX)
);

comment on table WISH_LIST is '찜목록 테이블';

comment on column WISH_LIST.MEM_IDX is '회원번호(참초키)';

comment on column WISH_LIST.MOVIE_IDX is '영화번호(참조키)';

comment on column WISH_LIST.FLAG is'플래그';----------------- 어디에 쓰는 플래그?

alter table WISH_LIST add constraint FK_WISH_LIST_MEM_IDX_MEMBER foreign key (MEM_IDX) references MEMBER (IDX);

alter table WISH_LIST add constraint FK_WISH_LIST_MOVIE_IDX_MOVI foreign key (MOVIE_IDX) references MOVIE (IDX);


--drop table WISH_LIST cascade constraints;
-----------------------------------------------------------------------------

create table INQUIRE
(
    IDX			int     not null, 
    MEM_IDX		int     not null, 
    CONTENTS	clob    not null, 
    RESPONSE	clob    null, 
    REG_DATE	date    not null, 
    RES_DATE	date    null, 
    constraint INQUIRE_PK primary key (IDX)
);

create sequence INQUIRE_SEQ start with 1 increment by 1;

/
create or replace trigger INQUIRE_IDX_TRG
before insert on INQUIRE 
referencing new as new for each row 
begin 
    select INQUIRE_SEQ.nextval
    into:new.IDX
    from DUAL;
end;
/

comment on table INQUIRE is '문의내역';

comment on column INQUIRE.IDX is '문의번호';

comment on column INQUIRE.MEM_IDX is '회원번호(참조키)';

comment on column INQUIRE.CONTENTS is '문의내용';

comment on column INQUIRE.RESPONSE is '답변내용';

comment on column INQUIRE.REG_DATE is '문의일자';

comment on column INQUIRE.RES_DATE is '답변일자';

alter table INQUIRE add constraint FK_INQUIRE_MEM_IDX_MEMBER_ID foreign key (MEM_IDX) references MEMBER (IDX);


--drop trigger INQUIRE_IDX_TRG;
--drop sequence INQUIRE_SEQ;
--drop table INQUIRE cascade constraints;
-----------------------------------------------------------------------------

create table TRAILERS
(
    IDX					int              not null, 
    MOVIE_IDX			int              not null, 
    TRAILER_FILE		varchar2(200)    not null,--트레일러 영상을 어떻게 송출할 것인가에 따라 필요 없을 수 있음. 
    TRAILER_TITLE		varchar2(200)    not null, --위와 마찬가지
    constraint TRAILERS_PK primary key (IDX)
);

create sequence TRAILERS_SEQ start with 1 increment by 1;

/
create or replace trigger TRAILERS_IDX_TRG
before insert on TRAILERS 
referencing new as new for each row 
begin 
    select TRAILERS_SEQ.nextval
    into:new.IDX
    from DUAL;
end;
/

comment on table TRAILERS is '트레일러(영상) 테이블';

comment on column TRAILERS.IDX is '영상식별번호';

comment on column TRAILERS.MOVIE_IDX is '영화번호(참조키)';

comment on column TRAILERS.TRAILER_FILE is '파일이름';

comment on column TRAILERS.TRAILER_TITLE is '영상제목';

alter table TRAILERS add constraint FK_TRAILERS_MOVIE_IDX_MOVIE foreign key ( MOVIE_IDX ) references MOVIE ( IDX );


--drop trigger TRAILERS_IDX_TRG;
--drop sequence TRAILERS_SEQ;
--drop table TRAILERS cascade constraints;
