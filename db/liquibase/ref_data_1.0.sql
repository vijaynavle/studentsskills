SET SCHEMA 'people_skills'; 

insert into people (surname,firstname,email,position) values ('Navle','Vijay','vijay.navle@nhs.net','Developer');
insert into people (surname,firstname,email,position) values ('Gates','Billy','billygates@somewhere.com','Manager');

insert into ref_skill (description) values ('Java');
insert into ref_skill (description) values ('Oracle SQL');
insert into ref_skill (description) values ('Spring');
insert into ref_skill (description) values ('Postgres');

insert into ref_skill_level (description) values ('Expert');
insert into ref_skill_level (description) values ('Practitioner');
insert into ref_skill_level (description) values ('Working');
insert into ref_skill_level (description) values ('Awareness');

insert into people_skills (people_id,skill_id,skill_level_id,start_date) values ( 1,1,1,'01-01-2019');
 