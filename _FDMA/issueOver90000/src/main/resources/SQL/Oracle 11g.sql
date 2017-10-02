SELECT USERID, DEPTID, USERNAME, PASSWORD, EMAIL FROM USERS;

call remove_user(5);
commit;

SELECT * FROM USERROLES;



DELETE FROM USERROLES WHERE userid = 4;
DELETE FROM USERS WHERE userid = 4;
commit;

select * from departments;

select * from issueupdates;