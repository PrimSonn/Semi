
/*
	ID:WAZUA
	PW:WAZUA
*/
create user WAZUA identified by WAZUA;
grant CONNECT,RESOURCE,UNLIMITED TABLESPACE to WAZUA identified by WAZUA;
alter user WAZUA default TABLESPACE USERS;
alter user WAZUA temporary TABLESPACE TEMP;