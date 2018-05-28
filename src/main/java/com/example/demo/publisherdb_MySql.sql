-- ===========================================
-- DATABASE FOR PUBLISHER SYSTEM
-- ===========================================
create table PUBLISHERS
(
  ID Bigint,
  NAME VARCHAR(255),
  Primary key (ID)
);
 
insert into publishers (ID, NAME)
values (1, 'publisher 1');
 
insert into publishers (ID, NAME)
values (2, 'publisher 2');
 
