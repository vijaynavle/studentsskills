-- SET SCHEMA 'people_skills';

CREATE TABLE people (
  people_id                  serial NOT NULL,
  surname         varchar(200) NOT NULL,
  firstname         varchar(200) NOT NULL,
  email              varchar(100),
  position 			varchar(80),
  CONSTRAINT pk_people_id PRIMARY KEY ( people_id )
);

 CREATE TABLE ref_skill (
    skill_id                  serial NOT NULL, 
	description      varchar(100) NOT NULL,
	CONSTRAINT pk_skill_id UNIQUE ( skill_id )
 );   

 CREATE TABLE ref_skill_level (
    skill_level_id                  serial NOT NULL, 
	description      varchar(100) NOT NULL,
	CONSTRAINT pk_skill_level_id UNIQUE ( skill_level_id )
 );
  
CREATE TABLE people_skills (
	people_skill_id        serial NOT NULL,
	people_id              integer NOT NULL,
	skill_id               integer NOT NULL,
	skill_level_id         integer NOT NULL,
	start_date             timestamp NOT NULL,
    end_date               timestamp,
    CONSTRAINT pk_people_skill_id PRIMARY KEY ( people_skill_id ),
	CONSTRAINT fk_people FOREIGN KEY ( people_id ) REFERENCES people( people_id ),
	CONSTRAINT fk_skill FOREIGN KEY ( skill_id ) REFERENCES ref_skill( skill_id ),
	CONSTRAINT fk_skill_level FOREIGN KEY ( skill_level_id ) REFERENCES ref_skill_level( skill_level_id )	
);

 CREATE INDEX idx_people ON people ( people_id );
CREATE INDEX idx_ref_skill ON ref_skill( skill_id );
CREATE INDEX idx_ref_skill_level ON ref_skill_level ( skill_level_id );
CREATE INDEX idx_people_skills ON people_skills ( people_skill_id );


CREATE SEQUENCE people_id_seq RESTART WITH 1;
CREATE SEQUENCE ref_skill_seq RESTART WITH 1;
CREATE SEQUENCE ref_skill_level_seq RESTART WITH 1;
CREATE SEQUENCE people_skill_id_seq RESTART WITH 1;
  



