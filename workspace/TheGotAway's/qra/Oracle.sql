create table payment(
    idx number,
    mem_idx number,
    mv_idx number,
    fs_idx number,
    p_date date,
    pay number,
    method varchar2(100),
    status varchar2(50));

insert into payment values(
    8,8,8,8,'20180103',4200,'영화취소','n');
    
 select * from payment;
commit;
select * from payment where status = 'y';
