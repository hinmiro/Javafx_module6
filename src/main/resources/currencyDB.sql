


-- Dumping database structure for currencyconverter
CREATE DATABASE IF NOT EXISTS `currencyconverter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `currencyconverter`;

create user 'appuser'@'localhost' IDENTIFIED BY 'appuser';
GRANT SELECT ON currencyconverter TO 'appuser'@'127.0.0.1';

-- Dumping structure for taulu currencyconverter.currency
CREATE TABLE IF NOT EXISTS `currency` (
  `rate` float NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- European central bank 05.03.2024 11:00

-- Dumping data for table currencyconverter.currency: ~9 rows (suunnilleen)
INSERT INTO `currency` (`rate`, `name`) VALUES
	(1.0846, 'USD'),
	(163.22, 'JPY'),
	(1.9558, 'BGN'),
	(25.356, 'CZK'),
	(7.4539, 'DKK'),
	(0.85583, 'GBP'),
	(4.322, 'PLN'),
	(11.2424, 'SEK'),
	(1, 'EUR');

