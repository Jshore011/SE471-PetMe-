-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2021 at 06:00 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pet_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `pet_data`
--

CREATE TABLE `pet_data` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `tracking_id` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `age` varchar(255) NOT NULL,
  `breed` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `icon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pet_logs`
--

CREATE TABLE `pet_logs` (
  `id` int(10) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `pet_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `profile_data`
--

CREATE TABLE `profile_data` (
  `id` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `lightmode` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profile_data`
--

INSERT INTO `profile_data` (`id`, `email`, `name`, `hash`, `salt`, `lightmode`) VALUES
(1, 'praty@gmail.com', 'praty', 'IJCGbgds7mA/WJrgepYpxT3B2xx5Piy', '$2a$12$QLY3.hz2ngvDx1WWDzveh.', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pet_data`
--
ALTER TABLE `pet_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pet_logs`
--
ALTER TABLE `pet_logs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profile_data`
--
ALTER TABLE `profile_data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pet_data`
--
ALTER TABLE `pet_data`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pet_logs`
--
ALTER TABLE `pet_logs`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `profile_data`
--
ALTER TABLE `profile_data`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
