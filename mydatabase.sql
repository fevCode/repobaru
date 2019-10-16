-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.71-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mydatabase
CREATE DATABASE IF NOT EXISTS `mydatabase` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mydatabase`;

-- Dumping structure for table mydatabase.department
CREATE TABLE IF NOT EXISTS `department` (
  `DEPT_NO` varchar(255) NOT NULL,
  `DEPT_NAME` varchar(255) NOT NULL,
  `LOCATION` varchar(255) NOT NULL,
  PRIMARY KEY (`DEPT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mydatabase.department: ~2 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`DEPT_NO`, `DEPT_NAME`, `LOCATION`) VALUES
	('D12432', 'Informatika', 'Gedung 4'),
	('D43243', 'Elektro', 'Gedung 13'),
	('D65656', 'Teknik sipil & Arsitektur', 'Jln. Kenangan bersamu, Gedung 7'),
	('D67555', 'Ilmu Seni', 'Gedung utama, Jl. jalan dihatimu'),
	('D74564', 'Psikologi & Manajemen', 'Gedung 5');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table mydatabase.dosen
CREATE TABLE IF NOT EXISTS `dosen` (
  `IDDosen` varchar(50) NOT NULL,
  `namaDosen` varchar(50) NOT NULL,
  `dept_no` varchar(50) NOT NULL,
  PRIMARY KEY (`IDDosen`),
  KEY `FK_dosen_department` (`dept_no`),
  CONSTRAINT `FK_dosen_department` FOREIGN KEY (`dept_no`) REFERENCES `department` (`DEPT_NO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mydatabase.dosen: ~1 rows (approximately)
/*!40000 ALTER TABLE `dosen` DISABLE KEYS */;
INSERT INTO `dosen` (`IDDosen`, `namaDosen`, `dept_no`) VALUES
	('D43434', 'Rara', 'D65656'),
	('D47656', 'R.L.Permatasari', 'D12432'),
	('D7878', 'Ridwanto', 'D65656'),
	('D86766', 'Anjasmara ', 'D43243');
/*!40000 ALTER TABLE `dosen` ENABLE KEYS */;

-- Dumping structure for table mydatabase.login
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mydatabase.login: ~1 rows (approximately)
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`username`, `password`) VALUES
	('user', 'pass');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Dumping structure for table mydatabase.mahasiswa
CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `IDMahasiswa` varchar(50) NOT NULL,
  `namaMahasiswa` varchar(50) DEFAULT NULL,
  `dept_no` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDMahasiswa`),
  KEY `FK_mahasiswa_department` (`dept_no`),
  CONSTRAINT `FK_mahasiswa_department` FOREIGN KEY (`dept_no`) REFERENCES `department` (`DEPT_NO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mydatabase.mahasiswa: ~1 rows (approximately)
/*!40000 ALTER TABLE `mahasiswa` DISABLE KEYS */;
INSERT INTO `mahasiswa` (`IDMahasiswa`, `namaMahasiswa`, `dept_no`) VALUES
	('M3434', 'Irwan S.', 'D65656'),
	('M8967', 'Septi puriawati', 'D74564'),
	('M97687', 'Ferdi R. L', 'D67555');
/*!40000 ALTER TABLE `mahasiswa` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
