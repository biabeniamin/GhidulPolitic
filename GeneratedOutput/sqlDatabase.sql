-- generated by database functions generator automatically
-- for mysql 
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

-- Following lines remove old tables from database
DROP TABLE IF EXISTS`Partids`;
DROP TABLE IF EXISTS`Candidats`;
DROP TABLE IF EXISTS`Notifications`;

CREATE TABLE `Partids` (
`PartidId` INT  NOT NULL,
`Nume` VARCHAR(20)  NOT NULL,
`Pozitie` INT  NOT NULL,
`CreationTime` DATETIME  NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `Partids` ADD PRIMARY KEY(`PartidId`); 
ALTER TABLE `Partids`  MODIFY `PartidId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 1; 

CREATE TABLE `Candidats` (
`CandidatId` INT  NOT NULL,
`Nume` VARCHAR(20)  NOT NULL,
`Descriere` TEXT  NOT NULL,
`Functie` VARCHAR(40)  NOT NULL,
`CreationTime` DATETIME  NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `Candidats` ADD PRIMARY KEY(`CandidatId`); 
ALTER TABLE `Candidats`  MODIFY `CandidatId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 1; 

CREATE TABLE `Notifications` (
`NotificationId` INT  NOT NULL,
`Title` VARCHAR(15)  NOT NULL,
`CreationTime` DATETIME  NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `Notifications` ADD PRIMARY KEY(`NotificationId`); 
ALTER TABLE `Notifications`  MODIFY `NotificationId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 1; 

