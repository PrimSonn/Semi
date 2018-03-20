SET TERMOUT OFF
SET ECHO OFF

CONNECT SCOTT/TIGER

drop table MOVIES;
drop table ACCOUNTS;
drop table MOVIE_COMMENTS;
drop table MOVIE_IMGS;
drop table ACCOUNT_IMGS;

create table MOVIES (IDX number, TITLE varchar2(20));
create table ACCOUNTS (IDX number, ID varchar2(20));
create table MOVIE_COMMENTS (IDX number, TITLE varchar2(20));
Rem create table MOVIE_IMGS (TYPE varchar2(20));
Rem create table ACCOUNT_IMGS (TYPE varchar2(20));

insert all
	into MOVIES (IDX, TITLE) values (1,'Movie1')
	into MOVIES (IDX, TITLE) values (2, '영화2')
	into ACCOUNTS (IDX, ID) values (1, 'Id1')
	into ACCOUNTS (IDX, ID) values (2, '아이디2')
	into MOVIE_COMMENTS (IDX, TITLE) values (1, 'Comment1')
	into MOVIE_COMMENTS (IDX, TITLE) values (2, '아이디2')
Rem 	into MOVIE_IMGS (TYPE) values ('thumb')
Rem 	into MOVIE_IMGS (TYPE) values ('poster')
Rem 	into ACCOUNT_IMGS (TYPE) values ('poster')
Rem 	into ACCOUNT_IMGS (TYPE) values ('back')
select 1 from DUAL;

commit;

SET TERMOUT ON
SET ECHO ON