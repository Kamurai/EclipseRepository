CREATE OR REPLACE PROCEDURE ADD_ISSUEUPDATE
(
  i_issueUpdateId IN number,
  i_issueId IN number,
  i_submittedby IN number,
  i_updateDate IN date,
  i_updateComment IN varchar
)
IS
BEGIN
    INSERT INTO ISSUEUPDATES(ISSUEID, SUBMITTEDBY, UPDATEDATE, UPDATECOMMENT) 
    VALUES (i_issueId, i_submittedby, i_updateDate, i_updateComment);
    COMMIT;
END ADD_ISSUEUPDATE;