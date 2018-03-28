
select C.IDX COMMENT_IDX, C.TITLE COMMENT_TITLE, MOVIE_IDX, MOVIE_TITLE, ACCOUNT_IDX, ACCOUNT_ID,
            case 
 --               when T.MOVIE_IDX = ? then 'MOVIE_SELECTED'
                when T.MOVIE_IDX is not null then 'MOVIE'
 --               when T.ACCOUNT_IDX = ? then 'ACCOUNT_SELECTED'
                when T.ACCOUNT_IDX is not null then 'ACCOUNT'
 --               when C.IDX = ? then 'COMMENT_SELECTED'
                when C.IDX is not null then 'COMMENT'
            end as TAG
        from MOVIE_COMMENTS C full outer join (
            select M.IDX MOVIE_IDX , A.IDX ACCOUNT_IDX, M.TITLE MOVIE_TITLE , A.ID ACCOUNT_ID from MOVIES M full outer join ACCOUNTS A on 1=2) T 
    on 1=2;