
INSERT INTO departments(NAME) VALUES( 'heroes' );
INSERT INTO departments(NAME) VALUES( 'antiheroes' );
COMMIT;

INSERT INTO roles(ROLENAME) VALUES( 'basic' );
INSERT INTO roles(ROLENAME) VALUES( 'deptadmin' );
INSERT INTO roles(ROLENAME) VALUES( 'genadmin' );
COMMIT;

INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Steve.Rogers', 'peggy', 'Steve.Rogers@marvel.com' );
INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Tony.Stark', 'pepper', 'Tony.Stark@marvel.com' );
INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Matt.Murdock', 'foggy', 'Matt.Murdock@marvel.com' );
INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Luke.Cage', 'jessica', 'Luke.Cage@marvel.com' );
INSERT INTO USERS(DEPTID, USERNAME, PASSWORD, EMAIL) VALUES( 0, 'Jessica.Jones', 'luke', 'Jessica.Jones@marvel.com' );
COMMIT;

SELECT * FROM USERS;

INSERT INTO userroles VALUES( 0, 2 );
INSERT INTO userroles VALUES( 1, 1 );
COMMIT;

INSERT INTO STATUSS(STATUS) VALUES( 'New' );
INSERT INTO STATUSS(STATUS) VALUES( 'Work In Progress' );
INSERT INTO STATUSS(STATUS) VALUES( 'Waiting on Resources' );
INSERT INTO STATUSS(STATUS) VALUES( 'Resolved' );
INSERT INTO STATUSS(STATUS) VALUES( 'Complete' );
COMMIT;

select * from statuss;

INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED) 
VALUES( 'Need Unobtainium', 'I do not have enough unobtainium', 2, 0, 1, to_date('19-09-2017 09:00:00', 'dd-mm-yyyy hh24:mi:ss'), 0  );
INSERT INTO ISSUES(TITLE, USERDESCRIPTION, SUBMITTEDBY, STATUSID, PRIORITY, DATESUBMITTED) 
VALUES( 'Broke desk chair', 'My desk chair is broken', 3, 0, 1, to_date('19-09-2017 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), 0  );
COMMIT;

INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 0, 2, to_date('19-09-2017 09:10:00', 'dd-mm-yyyy hh24:mi:ss'), 'Unable to obtain unobtainium' );
INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 0, 2, to_date('19-09-2017 09:20:00', 'dd-mm-yyyy hh24:mi:ss'), 'Unobtainium may not be real' );
INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) VALUES( 1, 3, to_date('19-09-2017 10:30:00', 'dd-mm-yyyy hh24:mi:ss'), 'I am too awesome' );
COMMIT;

select * from users;
