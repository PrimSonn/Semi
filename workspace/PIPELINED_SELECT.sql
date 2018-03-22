drop function GATHER_AMC;
drop type RES_TABLE;
drop type RES_TABLE_TYPE;

/
create or replace type RES_TABLE_TYPE as object (TAG varchar2(20)
                        , ACCOUNT_IDX number, ACCOUNT_ID varchar2(20)
                        , MOVIE_IDX number, MOVIE_TITLE varchar2(20)
                        , COMMENT_IDX number, COMMENT_TITLE varchar2(20));
/
create or replace type RES_TABLE as table of RES_TABLE_TYPE;
/
create or replace function GATHER_AMC ( MA in number, MM in number, MC in number)

return RES_TABLE pipelined as cursor CUR is
        (select C.IDX COMMENT_IDX, C.TITLE COMMENT_TITLE, MOVIE_IDX, MOVIE_TITLE, ACCOUNT_IDX, ACCOUNT_ID,
            case 
                when T.MOVIE_IDX = MM then 'MOVIE_SELECTED'
                when T.MOVIE_IDX is not null then 'MOVIE'
                when T.ACCOUNT_IDX = MA then 'ACCOUNT_SELECTED'
                when T.ACCOUNT_IDX is not null then 'ACCOUNT'
                when C.IDX = MC then 'COMMENT_SELECTED'
                when C.IDX is not null then 'COMMENT'
            end as TAG
        from MOVIE_COMMENTS C full outer join (
            select M.IDX MOVIE_IDX , A.IDX ACCOUNT_IDX, M.TITLE MOVIE_TITLE , A.ID ACCOUNT_ID from MOVIES M full outer join ACCOUNTS A on 1=2) T 
        on 1=2);
   begin
    for I in CUR
    loop
        pipe row (RES_TABLE_TYPE( I.TAG, I.ACCOUNT_IDX, I.ACCOUNT_ID, I.MOVIE_IDX, I.MOVIE_TITLE, I.COMMENT_IDX, I.COMMENT_TITLE));
        exit when CUR%notfound;
    end loop;
    return;
end;
/
commit;

--select COLUMN_NAME from ALL_TAB_COLUMNS where TABLE_NAME='ACCOUNTS';

--select * from table(GATHER_AMC(#(ACCOUNTS idx),#(MOVIEs idx),#(MOVIE_COMMENTS idx))) order by TAG desc;