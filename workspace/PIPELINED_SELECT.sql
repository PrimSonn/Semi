
--------------- PipeLined Select ----------------------------


create or replace type RES_TABLE_TYPE as object (TAG varchar2(4)
                        , A_IDX number, A_ID varchar2(20)
                        , M_IDX number, M_TITLE varchar2(20)
                        , C_IDX number, C_TITLE varchar2(20));
                        
create or replace type RES_TABLE as table of RES_TABLE_TYPE;

create or replace function GATHER_AMC ( MA in number, MM in number, MC in number)

return RES_TABLE pipelined as cursor CUR is
        (select C.IDX C_IDX, C.TITLE C_TITLE, M_IDX, M_TITLE, A_IDX, A_ID,
            case 
                when T.M_IDX = MM then 'MM'
                when T.M_IDX is not null then 'M'
                when T.A_IDX = MA then 'MA'
                when T.A_IDX is not null then 'A'
                when C.IDX = MC then 'MC'
                when C.IDX is not null then 'C'
            end as TAG
        from MOVIE_COMMENTS C full outer join (
            select M.IDX M_IDX , A.IDX A_IDX, M.TITLE M_TITLE , A.ID A_ID from MOVIES M full outer join ACCOUNTS A on 1=2) T 
        on 1=2);
   begin
    for I in CUR
    loop
        pipe row (RES_TABLE_TYPE( I.TAG, I.A_IDX, I.A_ID, I.M_IDX, I.M_TITLE, I.C_IDX, I.C_TITLE));
        exit when CUR%notfound;
    end loop;
    return;
end;
/
