# SQL Manager 2007 for MySQL 4.5.0.4
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : etesting


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `etesting`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `etesting`;

#
# Structure for the `program_files` table : 
#

CREATE TABLE `program_files` (
  `id` int(11) NOT NULL auto_increment,
  `status` varchar(20) default NULL,
  `program_name` varchar(50) NOT NULL,
  `plagiat1` int(3),
  `plagiat2` int(3),
  `file` longblob,
  `file_name` varchar(20) NOT NULL,
  `content_type` varchar(100) default NULL,
  `testResults` longblob,
  `tree_content` longblob,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340 COMMENT='InnoDB free: 11264 kB';


#
# Structure for the `attribute_countings` table : 
#

CREATE TABLE `attribute_countings` (
  `id` int(11) NOT NULL auto_increment,
  `ProgrName` varchar(50) NOT NULL,
  `imports` int(3) NOT NULL,
  `functions` int(3) NOT NULL,
  `calls` int(3) NOT NULL,
  `assigns` int(3) NOT NULL,
  `pluses` int(3) NOT NULL,
  `minuses` int(3) NOT NULL,
  `multiples` int(3) NOT NULL,
  `divides` int(3) NOT NULL,
  `variables` int(3) NOT NULL,
  `ifs` int(3) NOT NULL,
  `cycles` int(3) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2365 COMMENT='InnoDB free: 11264 kB';


#
# Structure for the `user_info` table : 
#

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL auto_increment,
  `FirstName` varchar(50) NOT NULL,
  `SecondName` varchar(50) NOT NULL,
  `Form` varchar(20) NOT NULL,
  `Login` varchar(50) UNIQUE NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=5461 COMMENT='InnoDB free: 11264 kB';



#
# Data for the `user_info` table  (LIMIT 0,500)
#

INSERT INTO `user_info` (`id`, `FirstName`, `SecondName`, `Form`, `Login`, `Password`) VALUES 
  (1,'Nataliya','Karpovich','admin','etesting.admin@tut.by','1234'),
  (2,'Iryna','Ason','11','irina.ason@gmail.com','test');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;