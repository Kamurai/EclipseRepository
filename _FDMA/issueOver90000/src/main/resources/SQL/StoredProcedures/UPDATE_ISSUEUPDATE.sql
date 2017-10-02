create or replace PROCEDURE UPDATE_ISSUEUPDATE
(
  i_issueUpdateId IN number,
  i_issueId IN number,
  i_SubmittedBy IN number,
  i_UpdateDate IN date,
  i_UpdateComment IN VARCHAR2
)
IS
BEGIN
  UPDATE ISSUEUPDATES SET issueId = i_issueId, SubmittedBy = i_SubmittedBy, UpdateDate = i_UpdateDate, UpdateComment = i_UpdateComment
  where issueUpdateId = i_issueUpdateId;
  COMMIT;
END UPDATE_ISSUEUPDATE;