-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 08, 2022 at 08:53 PM
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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `assign_user_id` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `task_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `assign_user_id`, `comments`, `date`, `task_id`) VALUES
(8, '106', 'Create angular project and design login page', '06-Jan-2022', '7'),
(9, '109', 'Ok, can I also design the registration page?', '06-Jan-2022', '7'),
(20, '106', 'Junit Test Comment', '07-Jan-2022', '10'),
(21, '106', 'Junit Test Comment 2', '07-Jan-2022', '13'),
(23, '2', 'Test comment from unit test', '11-12-2022', '2'),
(25, '1', 'Test comment for Add new Task for test', '09-Jan-2022', '24'),
(26, '4', 'Replay from Farishta', '09-Jan-2022', '24'),
(28, '3', 'Comment from Admin 2', '09-Jan-2022', '27'),
(29, '4', 'Comment from user 2', '09-Jan-2022', '27');

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
(30);

-- --------------------------------------------------------

--
-- Table structure for table `priority_setup`
--

DROP TABLE IF EXISTS `priority_setup`;
CREATE TABLE IF NOT EXISTS `priority_setup` (
  `priority_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priority_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`priority_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `priority_setup`
--

INSERT INTO `priority_setup` (`priority_id`, `priority_name`) VALUES
(1, ' High '),
(2, 'Medium  '),
(3, 'Low'),
(8, 'Test');

-- --------------------------------------------------------

--
-- Table structure for table `task_create_assign`
--

DROP TABLE IF EXISTS `task_create_assign`;
CREATE TABLE IF NOT EXISTS `task_create_assign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_user_id` varchar(255) DEFAULT NULL,
  `assign_date` varchar(255) DEFAULT NULL,
  `assign_user_id` varchar(255) DEFAULT NULL,
  `due_date` varchar(255) DEFAULT NULL,
  `priority_id` varchar(255) DEFAULT NULL,
  `task_details` varchar(255) DEFAULT NULL,
  `task_id` int(11) NOT NULL,
  `task_status_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_create_assign`
--

INSERT INTO `task_create_assign` (`id`, `admin_user_id`, `assign_date`, `assign_user_id`, `due_date`, `priority_id`, `task_details`, `task_id`, `task_status_id`) VALUES
(4, '1', '        3/01/2022       ', '2', '15/01/2022   ', '1', ' Project plan ', 0, '6'),
(5, '1', '   4/01/2022  ', '2', '  4/01/2022  ', '2', 'ERD diagram design', 0, '4'),
(6, '1', '01/01/2022  ', '4', ' 01/01/2022 ', '3', 'UML Use case Design ', 0, '5'),
(7, '1', '  6/01/2022  ', '4', '  7/01/2022  ', '1', '  Angular project creation and home page design  ', 0, '4'),
(10, '1', '7/01/2022', '4', ' 9/01/2022 ', '1', 'Spring Boot project creation and REST API for home page', 0, '1'),
(11, '1', '3/01/2022', '2', '3/01/2022', '3', 'Rest API for user registration', 0, '6'),
(12, '1', '3/01/2022', '2', '3/01/2022', '2', 'Task priority setup API develop', 0, '4'),
(13, '1', '3/01/2022', '2', '3/01/2022', '2', 'REST API for task status setup', 0, '2'),
(14, '1', '5/01/2022', '4', '5/01/2022', '2', 'Rest API for user setup', 0, '1'),
(15, '1', '8/01/2022', '2', '8/01/2022', '3', 'Rest API for comment', 0, '3'),
(16, '1', '9/01/2022', '4', '9/01/2022', '2', 'Unit testing for user get all task list', 0, '2'),
(18, '1', ' 7/01/2022', '2', '7/01/2022', '1', 'JUnit Testing', 0, '1'),
(24, '1', '10/01/2022', '4', '  16/01/2022 ', '1', ' Add new Task for test changed', 0, '4'),
(22, '1', '10-12-2121', '2', '10-12-2121', '1', 'Test Junit intrigation', 2, '2'),
(27, '3', ' 10/01/2022', '4', '11/01/2022', '2', 'From admin 2', 0, '4');

-- --------------------------------------------------------

--
-- Table structure for table `task_status_setup`
--

DROP TABLE IF EXISTS `task_status_setup`;
CREATE TABLE IF NOT EXISTS `task_status_setup` (
  `task_status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`task_status_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_status_setup`
--

INSERT INTO `task_status_setup` (`task_status_id`, `task_status_name`) VALUES
(1, '  Open  '),
(2, 'Pending'),
(3, 'In-Progress'),
(4, 'Completed'),
(5, 'In-Review'),
(6, 'Rejected');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` decimal(19,2) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`id`, `email`, `name`, `password`, `role`, `username`) VALUES
(1, 'evaldastylas@gmail.com', 'Evaldas Tylas', '$2a$10$bpokWNoqyDqrFGSJbE6MO.20ZXPbjqr6LiJuWuAnIkVp5HisBziCS', 'Admin', 'evaldas'),
(2, 'arifultonu007@gmail.com', 'Ariful Tonu', '$2a$10$beSNU/QbznU5yZsVrYOn8uPMCT98ZUWKLCp3c4bgO258htQ1fdq1G', 'User', 'ariful'),
(3, 'mohieminulhossain@gmail.com', 'Mohieminul Hossain', '$2a$10$oDdkYbmgXhKOSj8EEBY8reI5sEfL0MRGqBUNAY7DIY1rZ7A4hciFu', 'Admin', 'mohieminul'),
(4, 'farishtajahan@gmail.com', 'Farishta Jahan', '$2a$10$jzO0Cya3avqm2uESa5iIRemeBJu3wD2WdWl5drDVv0vm/EDdAOWhy', 'User', 'farishta'),
(5, 'JUnitTesting2@gmail.com', 'JUnit Testing 2', '$2a$10$S0QLZPXGsBIimdRIjkQUQ.8Co6mAWe14CVeeLeBRKUodMek7kDYSS', 'User', 'JUnit2');

-- --------------------------------------------------------

--
-- Table structure for table `user_task_info`
--

DROP TABLE IF EXISTS `user_task_info`;
CREATE TABLE IF NOT EXISTS `user_task_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `due_date` varchar(255) DEFAULT NULL,
  `priority_id` varchar(255) DEFAULT NULL,
  `task_details` varchar(255) DEFAULT NULL,
  `task_id` varchar(255) DEFAULT NULL,
  `task_status` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
