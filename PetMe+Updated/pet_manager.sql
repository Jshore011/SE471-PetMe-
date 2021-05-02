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
  `icon` varchar(255) NULL
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

-- --------------------------------------------------------

--
-- Table structure for table `pet_services`
--

CREATE TABLE `pet_services` (
  `id` int(10) NOT NULL,
  `type` varchar(255) NOT NULL,
  `servicename` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phonenumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pet_services`
--

INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (1, 'VETERINARY', 'Gotham Veterinary Center', '700 Columbus Ave, New York, NY 10025, United States', '+1 212-222-1900');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (2, 'VETERINARY', 'Abingdon Square Veterinary Clinic', '130 W 10th St, New York, NY 10014, United States', '+1 212-242-9169');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (3, 'VETERINARY', 'Downtown Veterinary Clinic', '244 9th Ave, New York, NY 10011, United States', '+1 212-463-8705');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (4, 'VETERINARY', 'Pearly Bites Veterinary', '162 W 21st St 4th Floor, New York, NY 10011, United States', '+1 646-828-9270');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (5, 'VETERINARY', 'Rivergate Veterinary Clinic', '403 E 37th St, New York, NY 10016, United States', '+1 212-213-9885');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (6, 'GROOMING', 'American Academy of Pet Grooming', '202 E 25th St, New York, NY 10010, United States', '+1 212-686-3890');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (7, 'GROOMING', 'Cats & Dogs Grooming School', '73 E 21st St, Bayonne, NJ 07002, United States', '+1 201-437-0016');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (8, 'GROOMING', 'House Pet Grooming and Trainer', '1327 Clinton Ave, The Bronx, NY 10456, United States', '+1 347-552-7354');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (9, 'GROOMING', 'New York Dog Nanny Inc', '126 Lexington Ave 2nd fl, New York, NY 10016, United States', '+1 917-261-7333');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (10, 'GROOMING', 'Towne House Grooming', '288 8th Ave, New York, NY 10001, United States', '+1 212-929-2910');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (11, 'PARK', 'Riverside Park', ' New York, NY, United States', '+1 212-870-3070');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (12, 'PARK', 'Theodore Roosevelt Park', '200 Central Park West, New York, NY 10024, United States', '+1 212-639-9675');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (13, 'PARK', 'Inwood Hill Park', 'Payson Ave. &, Seaman Ave, New York, NY 10034, United States', '+1 212-639-9675');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (14, 'PARK', 'Fort Washington Park', 'Hudson River Greenway, New York, NY 10032, United States', '+1 212-639-9675');
INSERT INTO `pet_services` (`id`, `type`, `servicename`, `address`, `phonenumber`) VALUES (15, 'PARK', 'Marcus Garvey Park', '6316, Mt Morris Park W, New York, NY 10027, United States', '+1 212-639-9675');


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
  `icon` varchar(255) NULL,
  `phone` varchar(255) NULL,
  `lightmode` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profile_data`
--

INSERT INTO `profile_data` (`id`, `email`, `name`, `hash`, `salt`, `icon`, `phone`, `lightmode`) VALUES
(1, 'praty@gmail.com', 'praty', 'IJCGbgds7mA/WJrgepYpxT3B2xx5Piy', '$2a$12$QLY3.hz2ngvDx1WWDzveh.', '', '', '1');

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
-- Indexes for table `pet_services`
--
ALTER TABLE `pet_services`
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
