-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 12, 2021 at 02:37 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smefinancetodoapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(16) NOT NULL,
  `task_id` int(16) NOT NULL,
  `assign_user_id` int(16) NOT NULL,
  `comments` varchar(1000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(34);

-- --------------------------------------------------------

--
-- Table structure for table `main_menu_entity`
--

DROP TABLE IF EXISTS `main_menu_entity`;
CREATE TABLE IF NOT EXISTS `main_menu_entity` (
  `id` bigint(20) NOT NULL,
  `branch_code` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `nodeid` varchar(255) DEFAULT NULL,
  `nodename` varchar(255) DEFAULT NULL,
  `parentid` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `priority_setup`
--

DROP TABLE IF EXISTS `priority_setup`;
CREATE TABLE IF NOT EXISTS `priority_setup` (
  `priority_id` int(16) DEFAULT NULL,
  `priority_name` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `priority_setup`
--

INSERT INTO `priority_setup` (`priority_id`, `priority_name`) VALUES
(1, 'High'),
(2, 'Medium'),
(3, 'Low');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'developer'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `task_assign`
--

DROP TABLE IF EXISTS `task_assign`;
CREATE TABLE IF NOT EXISTS `task_assign` (
  `id` int(16) NOT NULL,
  `admin_user_id` int(16) NOT NULL,
  `assign_user_id` int(16) NOT NULL,
  `task_id` int(16) NOT NULL,
  `task_details` varchar(1000) NOT NULL,
  `assign_date` date NOT NULL,
  `due_date` date NOT NULL,
  `priority_id` int(16) NOT NULL,
  `task_status_id` int(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_assign`
--

INSERT INTO `task_assign` (`id`, `admin_user_id`, `assign_user_id`, `task_id`, `task_details`, `assign_date`, `due_date`, `priority_id`, `task_status_id`) VALUES
(2, 2, 1, 3, 'Login page design Correction please', '2021-12-02', '2021-12-17', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `task_create_assign`
--

DROP TABLE IF EXISTS `task_create_assign`;
CREATE TABLE IF NOT EXISTS `task_create_assign` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `admin_user_id` varchar(16) NOT NULL,
  `assign_user_id` varchar(16) NOT NULL,
  `task_id` int(16) NOT NULL DEFAULT 0,
  `task_details` varchar(1000) NOT NULL,
  `assign_date` varchar(255) NOT NULL,
  `due_date` varchar(255) NOT NULL,
  `priority_id` varchar(16) NOT NULL,
  `task_status_id` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_create_assign`
--

INSERT INTO `task_create_assign` (`id`, `admin_user_id`, `assign_user_id`, `task_id`, `task_details`, `assign_date`, `due_date`, `priority_id`, `task_status_id`) VALUES
(21, '2', '1', 2, '         Task Assign page Rest API develop Test final   ', '  2021-11-28  ', '2021-10-29', '1', '1'),
(17, '1', '1', 1, 'Task Assign page Rest API develop Bug', '2021-12-12', '2021-12-12', '3', '3'),
(11, '1', '2', 2, 'Task Info page Rest API develop Test', '2021-12-07', '2021-12-07', '2', '1'),
(15, '2', '2', 2, '       Task Assign ', ' 2021-12-08 ', '  2021-10-30  ', '2', '1'),
(14, '2', '1', 2, '  Task Assign page Rest API develop Test  ', ' 2021-11-29 ', '2021-10-30', '1', '1'),
(18, '2', '1', 2, '  Tonu 2 Task Assign page Rest API        ', '2021-11-28', '2021-10-29', '1', '3'),
(19, '2', '1', 2, 'Task Assign page Rest API develop Test 3', ' 2021-11-28 ', '2021-10-29', '1', '1'),
(22, '2', '2', 2, 'Task Assign page Rest API develop Test 2', '2021-12-08', ' 2021-12-08 ', '1', '1'),
(23, '2', '2', 2, 'Task Assign page Rest API develop Test 2', ' 2021-12-08 ', '2021-12-08', '1', '1'),
(24, '2', '2', 2, 'Task Assign page Rest API develop Test 2', '2021-12-08', ' 2021-12-08 ', '1', '1'),
(25, '2', '2', 2, 'Task Assign page Rest API develop Test 2', '  08/12/2021  ', '  08/12/2021  ', '1', '1'),
(33, '2', '1', 0, '  ', '  ', '', '2', '2'),
(31, '2', '', 0, '', '  ', '', '2', '2'),
(32, '2', '1', 0, 'Testing', '12-12-2021', '12-11-2021', '2', '3'),
(30, '2', '1', 0, 'Add new Task successfully', '2021-12-12', '2021-12-21', '1', '3');

-- --------------------------------------------------------

--
-- Table structure for table `task_setup`
--

DROP TABLE IF EXISTS `task_setup`;
CREATE TABLE IF NOT EXISTS `task_setup` (
  `task_id` int(16) DEFAULT NULL,
  `task_category` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_setup`
--

INSERT INTO `task_setup` (`task_id`, `task_category`) VALUES
(1, 'Development'),
(2, 'Testing');

-- --------------------------------------------------------

--
-- Table structure for table `task_status_setup`
--

DROP TABLE IF EXISTS `task_status_setup`;
CREATE TABLE IF NOT EXISTS `task_status_setup` (
  `task_status_id` int(16) DEFAULT NULL,
  `task_status_name` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_status_setup`
--

INSERT INTO `task_status_setup` (`task_status_id`, `task_status_name`) VALUES
(1, 'Pending'),
(2, 'Complete'),
(3, 'Running'),
(4, 'On Development');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`, `username`) VALUES
(1, 'tonu2050@gmail.com', 'Tonu', '123456', 'tonu'),
(2, 'arifultonu007@gmail.com', 'Ariful', '123456', 'ariful');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_task_info`
--

DROP TABLE IF EXISTS `user_task_info`;
CREATE TABLE IF NOT EXISTS `user_task_info` (
  `id` int(16) NOT NULL,
  `user_id` int(16) NOT NULL,
  `task_id` int(16) DEFAULT NULL,
  `task_details` varchar(1000) NOT NULL,
  `due_date` date NOT NULL,
  `create_date` date NOT NULL,
  `task_status` varchar(16) NOT NULL,
  `comments` varchar(1000) NOT NULL,
  `priority_id` int(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_task_info`
--

INSERT INTO `user_task_info` (`id`, `user_id`, `task_id`, `task_details`, `due_date`, `create_date`, `task_status`, `comments`, `priority_id`) VALUES
(1, 2, 1, 'Todo Web Application UML diagram', '2021-12-10', '2021-12-02', '1', '', 1),
(2, 2, 2, 'Login page design', '2021-12-17', '2021-12-02', '3', 'I didn\'t understand!', 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
