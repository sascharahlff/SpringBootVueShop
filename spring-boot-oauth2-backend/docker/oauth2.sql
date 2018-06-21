CREATE TABLE OAUTH_CLIENT_DETAILS (
  CLIENT_ID VARCHAR(255) PRIMARY KEY,
  RESOURCE_IDS VARCHAR(255),
  CLIENT_SECRET VARCHAR(255),
  SCOPE VARCHAR(255),
  AUTHORIZED_GRANT_TYPES VARCHAR(255),
  WEB_SERVER_REDIRECT_URI VARCHAR(255),
  AUTHORITIES VARCHAR(255),
  ACCESS_TOKEN_VALIDITY INTEGER,
  REFRESH_TOKEN_VALIDITY INTEGER,
  ADDITIONAL_INFORMATION VARCHAR(4096),
  AUTOAPPROVE VARCHAR(255)
);

CREATE TABLE OAUTH_CLIENT_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN BYTEA,
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255)
);

CREATE TABLE OAUTH_ACCESS_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN BYTEA,
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255),
  AUTHENTICATION BYTEA,
  REFRESH_TOKEN VARCHAR(255)
);

CREATE TABLE OAUTH_REFRESH_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN BYTEA,
  AUTHENTICATION BYTEA
);

CREATE TABLE OAUTH_CODE (
  CODE VARCHAR(255),
  AUTHENTICATION BYTEA
);

CREATE TABLE OAUTH_APPROVALS (
  USERID VARCHAR(255),
  CLIENTID VARCHAR(255),
  SCOPE VARCHAR(255),
  STATUS VARCHAR(10),
  EXPIRESAT TIMESTAMP,
  LASTMODIFIEDAT TIMESTAMP
);

INSERT INTO OAUTH_CLIENT_DETAILS
	(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES
 	('itemis', 'resource-server-rest-api', '$2a$04$RqhUV763hw5GInigRbcJjeLMTaZJtaOO4..xlKtHIO81vICHqM0xi', 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

/*
INSERT INTO OAUTH_CLIENT_DETAILS
	(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES
 	('user', 'resource-server-rest-api', '$2a$04$XTBVpMZhkKYdBewIZs6/IORJwDYBbp6Pa3mjLA.iTY0wLZjXrwTKS', 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

INSERT INTO OAUTH_CLIENT_DETAILS
	(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES
 	('read-client', 'resource-server-rest-api', '$2a$04$XTBVpMZhkKYdBewIZs6/IORJwDYBbp6Pa3mjLA.iTY0wLZjXrwTKS', 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

INSERT INTO OAUTH_CLIENT_DETAILS
	(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES
 	('write-client', 'resource-server-rest-api', '$2a$04$XTBVpMZhkKYdBewIZs6/IORJwDYBbp6Pa3mjLA.iTY0wLZjXrwTKS', 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);
*/