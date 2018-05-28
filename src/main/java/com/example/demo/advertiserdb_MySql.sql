
-- ===========================================
-- DATABASE FOR ADVERTISER SYSTEM
-- ===========================================
create table ADVERTISERS
(
  ID Bigint,
  NAME VARCHAR(255),
  Primary key (ID)
);
 
insert into advertisers (ID, NAME)
values (1, 'Advertiser 1');
 
insert into advertisers (ID, NAME)
values (2, 'Advertiser 2');