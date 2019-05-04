//%% NEW FILE RegistrerStandServlet BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `registrer_stand_servlet`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*registrer_stand_servlet Associations*/
  db_handler_url VARCHAR(255),
  login_util_stand_admin_servlet_db_handler_url VARCHAR(255),
  java_email_mail_session BLOB,
    PRIMARY KEY(db_handler_url)

);


ALTER TABLE `registrer_stand_servlet` ADD CONSTRAINT `fk_registrerstandservlet_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);
ALTER TABLE `registrer_stand_servlet` ADD CONSTRAINT `fk_registrerstandservlet_login_util_stand_admin_servlet_db_handler_url` FOREIGN KEY (`login_util_stand_admin_servlet_db_handler_url`) REFERENCES `login_util`(`stand_admin_servlet_db_handler_url`);
ALTER TABLE `registrer_stand_servlet` ADD CONSTRAINT `fk_registrerstandservlet_java_email_mail_session` FOREIGN KEY (`java_email_mail_session`) REFERENCES `java_email`(`mail_session`);




//%% NEW FILE StandOverview BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `stand_overview`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*stand_overview Associations*/
  db_handler_url VARCHAR(255),
  stand_id INT,
    PRIMARY KEY(db_handler_url)

);


ALTER TABLE `stand_overview` ADD CONSTRAINT `fk_standoverview_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);
ALTER TABLE `stand_overview` ADD CONSTRAINT `fk_standoverview_stand_id` FOREIGN KEY (`stand_id`) REFERENCES `stand`(`id`);




//%% NEW FILE Stand BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `stand`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*stand Associations*/
  stand_admin_servlet_db_handler_url VARCHAR(255),
  stand_servlet_db_handler_url VARCHAR(255),
  stand_overview_db_handler_url VARCHAR(255),
  db_handler_url VARCHAR(255),
  login_servlet_admin_user VARCHAR(255),
  result_servlet_db_handler_url VARCHAR(255),
  registrer_stand_servlet_db_handler_url VARCHAR(255),
  admin_servlet_db_handler_url VARCHAR(255),
  
  /*stand Attributes*/
  id INT,
  name VARCHAR(255),
  image_url VARCHAR(255),
  epostadmin VARCHAR(255),
  pin VARCHAR(255),
  PRIMARY KEY(id)

);


ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_stand_admin_servlet_db_handler_url` FOREIGN KEY (`stand_admin_servlet_db_handler_url`) REFERENCES `stand_admin_servlet`(`db_handler_url`);
ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_stand_servlet_db_handler_url` FOREIGN KEY (`stand_servlet_db_handler_url`) REFERENCES `stand_servlet`(`db_handler_url`);
ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_stand_overview_db_handler_url` FOREIGN KEY (`stand_overview_db_handler_url`) REFERENCES `stand_overview`(`db_handler_url`);
ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);
ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_login_servlet_admin_user` FOREIGN KEY (`login_servlet_admin_user`) REFERENCES `login_servlet`(`admin_user`);
ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_result_servlet_db_handler_url` FOREIGN KEY (`result_servlet_db_handler_url`) REFERENCES `result_servlet`(`db_handler_url`);
ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_registrer_stand_servlet_db_handler_url` FOREIGN KEY (`registrer_stand_servlet_db_handler_url`) REFERENCES `registrer_stand_servlet`(`db_handler_url`);
ALTER TABLE `stand` ADD CONSTRAINT `fk_stand_admin_servlet_db_handler_url` FOREIGN KEY (`admin_servlet_db_handler_url`) REFERENCES `admin_servlet`(`db_handler_url`);




//%% NEW FILE Vote BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `vote`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*vote Associations*/
  db_handler_url VARCHAR(255),
  stand_servlet_db_handler_url VARCHAR(255),
  
  /*vote Attributes*/
  id INT,
  user_name VARCHAR(255),
  stand INT,
  score INT,
  PRIMARY KEY(id)

);


ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);
ALTER TABLE `vote` ADD CONSTRAINT `fk_vote_stand_servlet_db_handler_url` FOREIGN KEY (`stand_servlet_db_handler_url`) REFERENCES `stand_servlet`(`db_handler_url`);




//%% NEW FILE StandAdminServlet BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `stand_admin_servlet`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*stand_admin_servlet Associations*/
  db_handler_url VARCHAR(255),
  login_util_stand_admin_servlet_db_handler_url VARCHAR(255),
    PRIMARY KEY(db_handler_url)

);


ALTER TABLE `stand_admin_servlet` ADD CONSTRAINT `fk_standadminservlet_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);
ALTER TABLE `stand_admin_servlet` ADD CONSTRAINT `fk_standadminservlet_login_util_stand_admin_servlet_db_handler_url` FOREIGN KEY (`login_util_stand_admin_servlet_db_handler_url`) REFERENCES `login_util`(`stand_admin_servlet_db_handler_url`);




//%% NEW FILE AdminServlet BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `admin_servlet`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*admin_servlet Associations*/
  db_handler_url VARCHAR(255),
  login_util_stand_admin_servlet_db_handler_url VARCHAR(255),
    PRIMARY KEY(db_handler_url)

);


ALTER TABLE `admin_servlet` ADD CONSTRAINT `fk_adminservlet_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);
ALTER TABLE `admin_servlet` ADD CONSTRAINT `fk_adminservlet_login_util_stand_admin_servlet_db_handler_url` FOREIGN KEY (`login_util_stand_admin_servlet_db_handler_url`) REFERENCES `login_util`(`stand_admin_servlet_db_handler_url`);




//%% NEW FILE LoginUtil BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `login_util`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*login_util Associations*/
  stand_admin_servlet_db_handler_url VARCHAR(255),
  registrer_stand_servlet_db_handler_url VARCHAR(255),
  login_servlet_admin_user VARCHAR(255),
  admin_servlet_db_handler_url VARCHAR(255),
    PRIMARY KEY(stand_admin_servlet_db_handler_url)

);


ALTER TABLE `login_util` ADD CONSTRAINT `fk_loginutil_stand_admin_servlet_db_handler_url` FOREIGN KEY (`stand_admin_servlet_db_handler_url`) REFERENCES `stand_admin_servlet`(`db_handler_url`);
ALTER TABLE `login_util` ADD CONSTRAINT `fk_loginutil_registrer_stand_servlet_db_handler_url` FOREIGN KEY (`registrer_stand_servlet_db_handler_url`) REFERENCES `registrer_stand_servlet`(`db_handler_url`);
ALTER TABLE `login_util` ADD CONSTRAINT `fk_loginutil_login_servlet_admin_user` FOREIGN KEY (`login_servlet_admin_user`) REFERENCES `login_servlet`(`admin_user`);
ALTER TABLE `login_util` ADD CONSTRAINT `fk_loginutil_admin_servlet_db_handler_url` FOREIGN KEY (`admin_servlet_db_handler_url`) REFERENCES `admin_servlet`(`db_handler_url`);




//%% NEW FILE JavaEmail BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `java_email`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*java_email Associations*/
  registrer_stand_servlet_db_handler_url VARCHAR(255),
  
  /*java_email Attributes*/
  mail_session BLOB,
  PRIMARY KEY(mail_session)

);


ALTER TABLE `java_email` ADD CONSTRAINT `fk_javaemail_registrer_stand_servlet_db_handler_url` FOREIGN KEY (`registrer_stand_servlet_db_handler_url`) REFERENCES `registrer_stand_servlet`(`db_handler_url`);




//%% NEW FILE ResultServlet BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `result_servlet`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*result_servlet Associations*/
  db_handler_url VARCHAR(255),
    PRIMARY KEY(db_handler_url)

);


ALTER TABLE `result_servlet` ADD CONSTRAINT `fk_resultservlet_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);




//%% NEW FILE DbHandler BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `db_handler`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*db_handler Associations*/
  login_servlet_admin_user VARCHAR(255),
  stand_admin_servlet_db_handler_url VARCHAR(255),
  registrer_stand_servlet_db_handler_url VARCHAR(255),
  stand_servlet_db_handler_url VARCHAR(255),
  result_servlet_db_handler_url VARCHAR(255),
  admin_servlet_db_handler_url VARCHAR(255),
  
  /*db_handler Attributes*/
  url VARCHAR(255),
  user VARCHAR(255),
  password VARCHAR(255),
  db_handler_url VARCHAR(255),
  db_handler_url VARCHAR(255),
  db_handler_url VARCHAR(255),
  db_handler_url VARCHAR(255),
  db_handler_url VARCHAR(255),
  PRIMARY KEY(url)

);


ALTER TABLE `db_handler` ADD CONSTRAINT `fk_dbhandler_login_servlet_admin_user` FOREIGN KEY (`login_servlet_admin_user`) REFERENCES `login_servlet`(`admin_user`);
ALTER TABLE `db_handler` ADD CONSTRAINT `fk_dbhandler_stand_admin_servlet_db_handler_url` FOREIGN KEY (`stand_admin_servlet_db_handler_url`) REFERENCES `stand_admin_servlet`(`db_handler_url`);
ALTER TABLE `db_handler` ADD CONSTRAINT `fk_dbhandler_registrer_stand_servlet_db_handler_url` FOREIGN KEY (`registrer_stand_servlet_db_handler_url`) REFERENCES `registrer_stand_servlet`(`db_handler_url`);
ALTER TABLE `db_handler` ADD CONSTRAINT `fk_dbhandler_stand_servlet_db_handler_url` FOREIGN KEY (`stand_servlet_db_handler_url`) REFERENCES `stand_servlet`(`db_handler_url`);
ALTER TABLE `db_handler` ADD CONSTRAINT `fk_dbhandler_result_servlet_db_handler_url` FOREIGN KEY (`result_servlet_db_handler_url`) REFERENCES `result_servlet`(`db_handler_url`);
ALTER TABLE `db_handler` ADD CONSTRAINT `fk_dbhandler_admin_servlet_db_handler_url` FOREIGN KEY (`admin_servlet_db_handler_url`) REFERENCES `admin_servlet`(`db_handler_url`);




//%% NEW FILE StandServlet BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `stand_servlet`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*stand_servlet Associations*/
  db_handler_url VARCHAR(255),
    PRIMARY KEY(db_handler_url)

);


ALTER TABLE `stand_servlet` ADD CONSTRAINT `fk_standservlet_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);




//%% NEW FILE LoginServlet BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `login_servlet`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*login_servlet Associations*/
  login_util_stand_admin_servlet_db_handler_url VARCHAR(255),
  db_handler_url VARCHAR(255),
  
  /*login_servlet Attributes*/
  admin_user VARCHAR(255),
  admin_pass VARCHAR(255),
  PRIMARY KEY(admin_user)

);


ALTER TABLE `login_servlet` ADD CONSTRAINT `fk_loginservlet_login_util_stand_admin_servlet_db_handler_url` FOREIGN KEY (`login_util_stand_admin_servlet_db_handler_url`) REFERENCES `login_util`(`stand_admin_servlet_db_handler_url`);
ALTER TABLE `login_servlet` ADD CONSTRAINT `fk_loginservlet_db_handler_url` FOREIGN KEY (`db_handler_url`) REFERENCES `db_handler`(`url`);
