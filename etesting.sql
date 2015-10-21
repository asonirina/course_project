# SQL Manager 2007 for MySQL 4.5.0.4
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : etesting


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `etesting`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `etesting`;

CREATE TABLE `user_task` (
  `id` int(11) NOT NULL auto_increment,
  `try_no` int(3) default 0,
  `status` int(3) default 0,
  `task_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `program_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_UT1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_UT2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `FK_UT3` FOREIGN KEY (`program_id`) REFERENCES `program_files` (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2365 COMMENT='InnoDB free: 11264 kB';

ALTER TABLE `user_task`
  ADD CONSTRAINT UQ_UT UNIQUE(`task_id`, `user_id`);

CREATE TABLE `single_test` (
  `id` int(11) NOT NULL auto_increment,
  `test_no` int(3) NOT NULL,
  `data_in` longblob,
  `data_out` longblob,
  `task_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_ST` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2365 COMMENT='InnoDB free: 11264 kB';

CREATE TABLE `task` (
  `id` int(11) NOT NULL auto_increment,
  `form` varchar(20) NOT NULL,
  `program_name` int(3) NOT NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2365 COMMENT='InnoDB free: 11264 kB';


CREATE TABLE `attribute_countings` (
  `id` int(11) NOT NULL auto_increment,
  `line_count` int(3) NOT NULL,
  `methods` int(3) NOT NULL,
  `spaces` int(3) NOT NULL,
  `tabs` int(3) NOT NULL,
  `ident` int(3) NOT NULL,
  `comments` int(3) NOT NULL,
  `program_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_AC` FOREIGN KEY (`program_id`) REFERENCES `program_files` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2365 COMMENT='InnoDB free: 11264 kB';



CREATE TABLE `neural_node` (
  `id` int(11) NOT NULL auto_increment,
  `methods` int(3) NOT NULL,
  `spaces` int(3) NOT NULL,
  `tabs` int(3) NOT NULL,
  `ident` int(3) NOT NULL,
  `comments` int(3) NOT NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_NN` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2365 COMMENT='InnoDB free: 11264 kB';




CREATE TABLE `program_files` (
  `id` int(11) NOT NULL auto_increment,
  `status` varchar(20) default NULL,
  `program_name` varchar(50) NOT NULL,
  `run_status` int(2) NOT NULL,
  `plagiat1` int(3),
  `plagiat2` int(3),
  `cluster` int(3),
  `file` longblob,
  `file_name` varchar(20) NOT NULL,
  `content_type` varchar(100) default NULL,
  `testResults` varchar(150),
  `tree_content` longblob,
  `user_id` int(11) NULL default NULL,
  PRIMARY KEY  (`id`),
  INDEX `FK_DEPT` (`user_id`),
  CONSTRAINT `FK_DEPT` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340 COMMENT='InnoDB free: 11264 kB';


CREATE TABLE `user_info` (
  `id` int(11) NOT NULL auto_increment,
  `FirstName` varchar(50) NOT NULL,
  `SecondName` varchar(50) NOT NULL,
  `Form` varchar(20) NOT NULL,
  `Login` varchar(50) UNIQUE NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=5461 COMMENT='InnoDB free: 11264 kB';



INSERT INTO `user_info` (`id`, `FirstName`, `SecondName`, `Form`, `Login`, `Password`) VALUES
  (1,'Nataliya','Karpovich','admin','etesting.admin@tut.by','1234');
--   (2,'Iryna','Ason','11','irina.ason@gmail.com','test'),
--   (3,'XXX','XXX','11','asonirina@mail.ru','111');

-- INSERT INTO `task` (`id`, `form`, `program_name`, `description`) values
-- (1, '11', '1', 'Lab 1'),
-- (2, '11', '2', 'Lab 2');

--
-- INSERT INTO `single_test` (`id`, `test_no`,  `data_in`, `data_out`, `task_id`) VALUES
-- (1, 1,  '1 2 3', '1 2 3', 1),
-- (2, 2,  '1 2 3', '1 2 3', 1),
-- (3, 3,  '1 2 3', '1 2 3', 1),
-- (4, 1,  '1 2 3', '1 2 3', 2),
-- (5, 2,  '1 2 3', '1 2 3', 2),
-- (6, 3,  '1 2 3', '1 2 3', 2);

-- INSERT INTO `neural_node`  (`id`, `methods`, `spaces`, `tabs`, `ident`, `comments`, `user_id`) VALUES
--  (1,1,1,1,1,1,2),
--  (2,1,1,1,1,1,3);
COMMIT;
