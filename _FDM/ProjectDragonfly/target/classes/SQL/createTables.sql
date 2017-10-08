CREATE TABLE departments ( 
    deptid number NOT NULL,
    CONSTRAINT pk_departments_deptid PRIMARY KEY(deptid),        
    name varchar2(30) NOT NULL
  );  
  CREATE SEQUENCE  "departments_SEQ"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ;
  CREATE OR REPLACE TRIGGER "departments_TRG" 
  BEFORE INSERT ON departments 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.deptid IS NULL THEN
        SELECT "departments_SEQ".NEXTVAL INTO :NEW.deptid FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
  
 CREATE TABLE roles ( 
    roleid number,
    CONSTRAINT pk_roles_roleid PRIMARY KEY(roleid),
    rolename varchar2(30) NOT NULL
  );
  CREATE SEQUENCE  "roles_SEQ"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ;
  CREATE OR REPLACE TRIGGER "roles_TRG" 
  BEFORE INSERT ON roles 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.roleid IS NULL THEN
        SELECT "roles_SEQ".NEXTVAL INTO :NEW.roleid FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
  
  CREATE TABLE users (
    userid number, 
    CONSTRAINT pk_users_userid PRIMARY KEY (userid),
    deptid number NOT NULL,
    CONSTRAINT fk_users_deptid FOREIGN KEY(deptid) REFERENCES departments(deptid),
    username varchar2(30) NOT NULL,
	CONSTRAINT UNIQUE_USERS_USERNAME UNIQUE (USERNAME),
    password varchar2(30) NOT NULL,
    email varchar2(30) NOT NULL );
  CREATE SEQUENCE  "USERS_SEQ"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ;
  CREATE OR REPLACE TRIGGER "USERS_TRG" 
  BEFORE INSERT ON USERS 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.USERID IS NULL THEN
        SELECT "USERS_SEQ".NEXTVAL INTO :NEW.USERID FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;

  
  CREATE TABLE userroles (
    userid number NOT NULL,
    CONSTRAINT fk_userroles_userid FOREIGN KEY(userid) REFERENCES users(userid),
    roleid number NOT NULL,
    CONSTRAINT fk_userroles_roleid FOREIGN KEY(roleid) REFERENCES roles(roleid)
  );
  CREATE OR REPLACE TRIGGER "USERS_USERROLES_TRG" 
  AFTER INSERT ON USERS
  FOR EACH ROW
  BEGIN
    INSERT INTO USERROLES VALUES ("USERS_SEQ".CURRVAL, 0);
  END;
  
  CREATE TABLE statuss ( 
    statusid number, 
    CONSTRAINT pk_statuss_statusid PRIMARY KEY(statusid),
    status varchar2(30) NOT NULL
  );
  CREATE SEQUENCE  "statuss_SEQ"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ;
  CREATE OR REPLACE TRIGGER "statuss_TRG" 
  BEFORE INSERT ON statuss 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.statusid IS NULL THEN
        SELECT "statuss_SEQ".NEXTVAL INTO :NEW.statusid FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
  
  CREATE TABLE issues ( 
    issueid number CONSTRAINT pk_issues_issueid PRIMARY KEY, 
    Title varchar2(30) NOT NULL, 
	CONSTRAINT UNIQUE_ISSUES_TITLE UNIQUE (TITLE),
    UserDescription varchar2(300) NOT NULL, 
    AdminComment varchar2(300), 
    AssignedTo number, 
    CONSTRAINT fk_issues_AssignedTo FOREIGN KEY(AssignedTo) REFERENCES users(userid),
    SubmittedBy number NOT NULL, 
    CONSTRAINT fk_issues_SubmittedBy FOREIGN KEY(SubmittedBy) REFERENCES users(userid),
    StatusId number NOT NULL, 
    CONSTRAINT fk_issues_StatusId FOREIGN KEY(StatusId) REFERENCES statuss(StatusId),
    priority number NOT NULL, 
    DateSubmitted date NOT NULL, 
    DateResolved date,
    DeptId number NOT NULL, 
    CONSTRAINT fk_issues_DeptId FOREIGN KEY(DeptId) REFERENCES departments(deptid)    
  );
  CREATE SEQUENCE  "issues_SEQ"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ;
  CREATE OR REPLACE TRIGGER "issues_TRG" 
  BEFORE INSERT ON issues 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.issueid IS NULL THEN
        SELECT "issues_SEQ".NEXTVAL INTO :NEW.issueid FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
  
  CREATE TABLE issueupdates ( 
    issueupdateid number,
    CONSTRAINT pk_issueupdates_issueupdateid PRIMARY KEY(issueupdateid),
    issueid number, 
    CONSTRAINT fk_issueupdates_issueid FOREIGN KEY(issueid) REFERENCES issues(issueid),
    submittedby number NOT NULL, 
    CONSTRAINT fk_issueupdates_submittedby FOREIGN KEY(submittedby) REFERENCES users(userid),
    updateDate date NOT NULL, 
    updateComment varchar2(300) NOT NULL
  );
  
  CREATE SEQUENCE  "issueupdates_SEQ"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 0 CACHE 20 NOORDER  NOCYCLE ;
  CREATE OR REPLACE TRIGGER "issueupdates_TRG" 
  BEFORE INSERT ON issueupdates 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      IF INSERTING AND :NEW.issueupdateid IS NULL THEN
        SELECT "issueupdates_SEQ".NEXTVAL INTO :NEW.issueupdateid FROM SYS.DUAL;
      END IF;
    END COLUMN_SEQUENCES;
  END;
  
commit;