CREATE OR REPLACE PROCEDURE REMOVE_STATUS
(
  i_statusId IN NUMBER
)
IS
BEGIN
	DELETE FROM STATUSS WHERE statusId = i_statusId;
	COMMIT;
END REMOVE_STATUS;