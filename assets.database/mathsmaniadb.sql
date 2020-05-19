-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2020 at 11:04 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mathsmaniadb`
--
CREATE DATABASE IF NOT EXISTS `mathsmaniadb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `mathsmaniadb`;

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
CREATE TABLE `results` (
  `Id` int(11) NOT NULL,
  `category` varchar(55) NOT NULL,
  `type` varchar(55) NOT NULL,
  `difficulty` varchar(55) NOT NULL,
  `question` varchar(250) NOT NULL,
  `correct_answer` varchar(55) NOT NULL,
  `incorrect_answers1` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `results`
--

INSERT INTO `results` (`Id`, `category`, `type`, `difficulty`, `question`, `correct_answer`, `incorrect_answers1`) VALUES
(4, 'Maths', 'Torture', 'Easy', 'how many lights do you see', '5', '1 2 3'),
(100, 'Maths', '3rd class', 'Easy', '4 + 4', '8', '5 3 7'),
(102, 'Maths', '3rd class', 'Easy', 'Andrew had 98 stamps, he made them into groups of 7. How many groups did he make?', '14', '13 15 16');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `f_name` varchar(55) NOT NULL,
  `l_name` varchar(55) NOT NULL,
  `email` varchar(50) NOT NULL,
  `AccountType` varchar(20) NOT NULL DEFAULT 'Student',
  `username` varchar(28) NOT NULL,
  `profile_pic` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `bio` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `f_name`, `l_name`, `email`, `AccountType`, `username`, `profile_pic`, `password`, `bio`) VALUES
(12, 'Admin', 'Admin', 'c@c.c', 'Admin', 'Admin', '1.jpg', 'Admin', 'wwwwwwwwwwwww'),
(17, 'qqq12345', 'q', 'q@qqqqqq', 'Student', 'qwert', '1.jpg', 'q', 'qqqqq'),
(21, 'q234', 'q2ewew', 'q@qqqqqq', 'Student', 'qwert', '1.jpg', 'q', 'qqqqq'),
(22, 't', 't', 't@ttttt', 'Student', 'ttttttrrrrrrrr', '1.jpg', 't', 'tttttttttttttttttttttttttttt'),
(26, 'Q', 'Q', 'Q@Q.IE', 'Student', 'Q', '1.jpg', 'Q', 'Q');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `results`
--
ALTER TABLE `results`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
