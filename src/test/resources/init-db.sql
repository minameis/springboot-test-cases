-- this will fail since users created as part of app start up and config
CREATE TABLE USERS(
   ID INT PRIMARY KEY     NOT NULL,
   NAME VARCHAR,
   EMAIL VARCHAR
);
-- this will be appending to existing records due to automated
-- record insert via TestingApplication.java
INSERT INTO USERS
(
 ID, NAME, EMAIL
)
VALUES
(
 3, 'Jenny', 'jenny@gmail.com'
),
(
 4, 'Kelly', 'kelly@gmail.com'
);
