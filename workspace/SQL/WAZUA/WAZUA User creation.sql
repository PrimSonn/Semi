
/*
	ID:WAZUA
	PW:WAZUA
*/
create user WAZUA identified by WAZUA;
grant CREATE SESSION, CONNECT, RESOURCE, UNLIMITED TABLESPACE, CREATE SEQUENCE, CREATE PROCEDURE to WAZUA identified by WAZUA;
alter user WAZUA default TABLESPACE USERS;
alter user WAZUA temporary TABLESPACE TEMP;