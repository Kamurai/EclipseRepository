create or replace PROCEDURE UPDATE_ISSUE
(
  i_issueid IN number,
  i_Title IN VARCHAR2,
  i_UserDescription IN VARCHAR2,
  i_AdminComment IN VARCHAR2,
  i_AssignedTo IN number,
  i_SubmittedBy IN number,
  i_StatusId IN number,
  i_priority IN number,
  i_DateSubmitted IN date,
  i_DateResolved IN date,
  i_DeptId IN number
)
IS
BEGIN
  UPDATE ISSUES SET Title = i_Title, UserDescription = i_UserDescription, AdminComment = i_AdminComment, AssignedTo = i_AssignedTo, SubmittedBy = i_SubmittedBy,
  StatusId = i_StatusId, priority = i_priority, DateSubmitted = i_DateSubmitted, DateResolved = i_DateResolved, DeptId = i_DeptId
  where issueid = i_issueid;
  COMMIT;
END UPDATE_ISSUE;