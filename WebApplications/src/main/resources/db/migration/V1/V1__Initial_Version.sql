CREATE TABLE AUTO_PK_SUPPORT (TABLE_NAME CHAR(100) NOT NULL,  NEXT_ID BIGINT NOT NULL,  PRIMARY KEY(TABLE_NAME));

INSERT INTO AUTO_PK_SUPPORT (TABLE_NAME, NEXT_ID) VALUES ('PEOPLE', 200);

CREATE TABLE PEOPLE (email_address VARCHAR(50) NULL, first_name VARCHAR(25) NULL, id BIGINT NOT NULL, last_name VARCHAR(25) NULL, password VARCHAR(40) NULL, PRIMARY KEY (id));