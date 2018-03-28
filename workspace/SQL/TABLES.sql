
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
    DEL_FLAG		varchar2(100) default 'N',------Ż�����ڿ� ��� �ߺ�
    IMG			varchar2(255) default '-',------������ �̹����� DBMS�� ����� ó���� ���� �ƴ϶�� �ʿ� ����
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

comment on table MEMBER is 'ȸ�����̺�';

comment on column MEMBER.IDX is 'ȸ����ȣ';

comment on column MEMBER.EMAIL is '�̸���';

comment on column MEMBER.PW is '��й�ȣ';

comment on column MEMBER.NAME is '�̸�';

comment on column MEMBER.BIRTH is '�������';

comment on column MEMBER.REG_DATE is '��������';

comment on column MEMBER.LEFT_DATE is 'Ż������';

comment on column MEMBER.DEL_FLAG is '�����÷���';

comment on column MEMBER.IMG is '�������̹���';------������ �̹����� DBMS�� ����� ó���� ���� �ƴ϶�� �ʿ� ����#2


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
    PLAYTIME		varchar2(50)      not null, -- �ð��� ó���� ���� �ٸ� ������ Ÿ�Ե� ���� �� ��?
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

comment on table MOVIE is '��ȭ ���̺�';

comment on column MOVIE.IDX is '��ȭ��ȣ';

comment on column MOVIE.KORTITLE is '��ȭ����(�ѱ�)';

comment on column MOVIE.TITLE is '����';

comment on column MOVIE.DIRECTOR is '����';

comment on column MOVIE.ACTOR is '���';

comment on column MOVIE.COUNTRY is '���۱���';

comment on column MOVIE.RELEASEDATE is '��������';

comment on column MOVIE.RATING is '���ɵ��';

comment on column MOVIE.PLAYTIME is '�÷���Ÿ��';

comment on column MOVIE.GERNE is '�帣';

comment on column MOVIE.VIEWCOUNT is '��û(��)��';

comment on column MOVIE.OUTLINE is '�ٰŸ�';

comment on column MOVIE.TICKETSOLD is '��������';

comment on column MOVIE.PRICE is '����';


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

comment on table WAZPOINT is '��������Ʈ ���̺�';

comment on column WAZPOINT.IDX is '�ĺ���ȣ';

comment on column WAZPOINT.MEM_IDX is 'ȸ����ȣ(����Ű)';

comment on column WAZPOINT.INIT_POINTS is '�ش� ������ �ʱ� ����Ʈ';

comment on column WAZPOINT.LEFT_POINTS is '�ش� ������ �ܿ� ����Ʈ';

comment on column WAZPOINT.GIVEN_FOR is '�ο�����';

comment on column WAZPOINT.GIVEN_DATE is '�ο�����';

comment on column WAZPOINT.EXP_DATE is '��������';

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

comment on table WAZLEVEL is 'ȸ����� ���̺�';

comment on column WAZLEVEL.MEM_IDX is 'ȸ����ȣ(����Ű)';

comment on column WAZLEVEL.LEV_NAME is 'ȸ�����';

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

comment on table COMMENTS is '�ڸ�Ʈ ���̺�';

comment on column COMMENTS.IDX is '�ڸ�Ʈ�ĺ���ȣ';

comment on column COMMENTS.MEM_IDX is 'ȸ����ȣ(����Ű)';

comment on column COMMENTS.MOVIE_IDX is '��ȭ��ȣ(����Ű)';

comment on column COMMENTS.REG_DATE is '�������';

comment on column COMMENTS.CONTENTS is '�ڸ�Ʈ����';

comment on column COMMENTS.ISBLIND is '����ε�';

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
    DEALT				varchar2(200)    not null,-- �Ű� ������ == �ٷ� �Ű� ���̺� �ö�´� ? NULL �ʿ� : �Ű� ������ �͵��� ��� �� ���̺��� ���� �ʿ��ϴ�;
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

comment on table REPORT is '�Ű����� ���̺�';

comment on column REPORT.IDX is '�Ű�ĺ���ȣ';

comment on column REPORT.MEM_IDX is 'ȸ����ȣ(����Ű)';

comment on column REPORT.COMM_IDX is '�ڸ�Ʈ��ȣ(����Ű)';

comment on column REPORT.REPORT_DATE is '�Ű�����';

comment on column REPORT.DEALT is '��ġ����';

alter table REPORT add constraint FK_REPORT_MEM_IDX_MEMBER foreign key (MEM_IDX) references MEMBER (IDX);

alter table REPORT add constraint FK_REPORT_COMM_IDX_COMMENT_T foreign key (COMM_IDX) references COMMENTS (IDX);


--drop trigger REPORT_IDX_TRG;
--drop sequence REPORT_SEQ;
--drop table REPORT cascade constraints;
-----------------------------------------------------------------------------

create table MOVIE_IMG--�̹��� ������ DBMS���� �Ѵٸ� �ʿ�.(���� �� ������ ������ �ް� ��) �̹� �̹����� �����ؾ��� ��ġ�� ������ ���¿��� �� �ʿ������� ����.
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

comment on table MOVIE_IMG is '��ȭ�̹��� ���̺�';

comment on column MOVIE_IMG.MOVIE_IDX is '��ȭ��ȣ(����Ű)';

comment on column MOVIE_IMG.POSTER is '������';

comment on column MOVIE_IMG.THUM is '�����';

comment on column MOVIE_IMG.SC1 is '��ƿ��1';

comment on column MOVIE_IMG.SC2 is '��ƿ��2';

comment on column MOVIE_IMG.SC3 is '��ƿ��3';

comment on column MOVIE_IMG.SC4 is '��ƿ��4';

comment on column MOVIE_IMG.SC5 is '��ƿ��5';

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

comment on table WISH_LIST is '���� ���̺�';

comment on column WISH_LIST.MEM_IDX is 'ȸ����ȣ(����Ű)';

comment on column WISH_LIST.MOVIE_IDX is '��ȭ��ȣ(����Ű)';

comment on column WISH_LIST.FLAG is'�÷���';----------------- ��� ���� �÷���?

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

comment on table INQUIRE is '���ǳ���';

comment on column INQUIRE.IDX is '���ǹ�ȣ';

comment on column INQUIRE.MEM_IDX is 'ȸ����ȣ(����Ű)';

comment on column INQUIRE.CONTENTS is '���ǳ���';

comment on column INQUIRE.RESPONSE is '�亯����';

comment on column INQUIRE.REG_DATE is '��������';

comment on column INQUIRE.RES_DATE is '�亯����';

alter table INQUIRE add constraint FK_INQUIRE_MEM_IDX_MEMBER_ID foreign key (MEM_IDX) references MEMBER (IDX);


--drop trigger INQUIRE_IDX_TRG;
--drop sequence INQUIRE_SEQ;
--drop table INQUIRE cascade constraints;
-----------------------------------------------------------------------------

create table TRAILERS
(
    IDX					int              not null, 
    MOVIE_IDX			int              not null, 
    TRAILER_FILE		varchar2(200)    not null,--Ʈ���Ϸ� ������ ��� ������ ���ΰ��� ���� �ʿ� ���� �� ����. 
    TRAILER_TITLE		varchar2(200)    not null, --���� ��������
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

comment on table TRAILERS is 'Ʈ���Ϸ�(����) ���̺�';

comment on column TRAILERS.IDX is '����ĺ���ȣ';

comment on column TRAILERS.MOVIE_IDX is '��ȭ��ȣ(����Ű)';

comment on column TRAILERS.TRAILER_FILE is '�����̸�';

comment on column TRAILERS.TRAILER_TITLE is '��������';

alter table TRAILERS add constraint FK_TRAILERS_MOVIE_IDX_MOVIE foreign key ( MOVIE_IDX ) references MOVIE ( IDX );


--drop trigger TRAILERS_IDX_TRG;
--drop sequence TRAILERS_SEQ;
--drop table TRAILERS cascade constraints;
