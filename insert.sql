INSERT INTO `user_info` (`id`, `FirstName`, `SecondName`, `Form`, `Login`, `Password`) VALUES
  (1,'Nataliya','Karpovich','admin','etesting.admin@tut.by','1234'),
   (2,'Iryna','Ason','11','irina.ason@gmail.com','test'),
   (3,'XXX','XXX','11','asonirina@mail.ru','111');

INSERT INTO `neural_node`  (`id`, `methods`, `spaces`, `tabs`, `ident`, `comments`, `user_id`) VALUES
(1,1,1,1,1,1,2),
(2,1,1,1,1,1,3);

INSERT INTO `task` (`id`, `form`, `program_name`, `description`) values
(1, '11', '1', 'Lab 1'),
(2, '11', '2', 'Lab 2');


INSERT INTO `single_test` (`id`, `test_no`,  `data_in`, `data_out`, `task_id`, `idx`) VALUES
(1, 1,  '1 2 3', '1 2 3', 1, 0),
(2, 2,  '1 2 3', '1 2 3', 1, 1),
(3, 3,  '1 2 3', '1 2 3', 1, 2),
(4, 1,  '1 2 3', '1 2 3', 2, 0),
(5, 2,  '1 2 3', '1 2 3', 2, 1),
(6, 3,  '1 2 3', '1 2 3', 2, 2);

