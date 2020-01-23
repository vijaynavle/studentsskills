Using PGadmin tool, create Database with name "people_skills" and then schema in that as "people_skills".
change the password if needed in liquibase.properties file.

Open Gitbash in db script directory
 
Please validate the script by using the command
java -jar liquibase-core-3.5.3.jar validate

Once you are confident that the script have no error, you can run using the following command
java -jar liquibase-core-3.5.3.jar update
