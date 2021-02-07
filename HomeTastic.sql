CREATE DATABASE  IF NOT EXISTS `hometastic` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hometastic`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: quickhome
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `ADMIN_ID` varchar(12) NOT NULL,
  `ADMIN_PASS` varchar(15) NOT NULL,
  `ADMIN_NAME` varchar(45) CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('aalia','aalia123','Aalia Najwa'),('adlin','adlin123','Adlin Muhsin'),('harith','harith123','Harith'),('ilyana','ilyana123','Ilyana Mazlan');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `BOOKING_ID` int(11) NOT NULL,
  `USER_ID` varchar(13) DEFAULT NULL,
  `PROPERTY_ID` int(11) DEFAULT NULL,
  `PAYMENT_ID` int(11) DEFAULT NULL,
  `DATE_IN` date DEFAULT NULL,
  `DATE_OUT` date DEFAULT NULL,
  `NUM_DAYS` int(11) DEFAULT NULL,
  `STATUS` varchar(7) DEFAULT NULL,
  `GUEST_NUM` int(11) DEFAULT NULL,
  `BOOKING_DATE` date DEFAULT NULL,
  PRIMARY KEY (`BOOKING_ID`),
  KEY `PAYMENT_ID_idx` (`PAYMENT_ID`),
  KEY `USER_ID_idx` (`USER_ID`) /*!80000 INVISIBLE */,
  CONSTRAINT `BKG_PAYMENT_ID` FOREIGN KEY (`PAYMENT_ID`) REFERENCES `payment` (`PAYMENT_ID`),
  CONSTRAINT `BKG_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'aina',1,1,'2019-12-12','2019-12-14',2,'PAID',5,'2019-09-30'),(2,'aisyah',2,2,'2019-07-11','2019-07-15',4,'PAID',9,'2019-06-02'),(3,'adlin',3,3,'2019-12-12','2019-12-16',4,'PAID',10,'2019-04-03'),(4,'cekel',2,4,'2019-12-12','2019-12-13',1,'PAID',40,'2019-07-03'),(5,'aina',1,5,'2019-12-15','2019-12-16',1,'PAID',12,'2019-10-02'),(6,'adlin',3,6,'2019-07-12','2019-07-15',3,'PAID',12,'2019-10-02'),(7,'aina',2,7,'2019-11-12','2019-11-14',2,'PAID',12,'2019-10-02'),(8,'aina',3,8,'2019-09-12','2019-09-14',2,'PAID',12,'2019-10-02'),(9,'aina',2,9,'2019-09-12','2019-09-14',2,'PAID',12,'2019-10-02');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host`
--

DROP TABLE IF EXISTS `host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `host` (
  `HOST_ID` varchar(12) NOT NULL,
  `HOST_PASS` varchar(15) NOT NULL,
  `HOST_FNAME` varchar(25) NOT NULL,
  `HOST_LNAME` varchar(25) NOT NULL,
  `HOST_PHONE` varchar(12) NOT NULL,
  `HOST_EMAIL` varchar(35) NOT NULL,
  `HOST_STREET` varchar(30) DEFAULT NULL,
  `HOST_CITY` varchar(30) DEFAULT NULL,
  `HOST_STATE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`HOST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES ('host1','host1','Muhammad Kamarul','Zaman','0148529637','kamarul@gmail.com','No.12','Cyber','Selangor'),('host2','host2','Husna Aisyah','Ali','0178521455','husna@gmail.com','No. 14','Shah Alam','Selangor'),('host3','host3','Amirah Anis','Adlin','0133467901','amirah@gmail.com','No.12','Bukit Jelutong','Kelantan'),('host4','host4','Aalia Najwa','Pakhri','0133546595','aalia@gmail.com','No.44','Damansara','Perlis');
/*!40000 ALTER TABLE `host` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `PAYMENT_ID` int(11) NOT NULL,
  `TOTAL_PRICE` decimal(6,2) DEFAULT NULL,
  `TOTAL_PAID` decimal(6,2) DEFAULT NULL,
  `BANK_NAME` varchar(20) DEFAULT NULL,
  `CARD_NUMBER` char(16) DEFAULT NULL,
  `EXPIRY_DATE` char(4) DEFAULT NULL,
  `CVV` char(3) DEFAULT NULL,
  PRIMARY KEY (`PAYMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,52.30,52.30,'MAYBANK','4561789512345612','0212','322'),(2,100.30,50.20,'CIMB','6789023567890123','0404','210'),(3,400.50,300.20,'BANK ISLAM','8930123468903412','0707','333'),(4,5000.00,5000.00,'CIMB','9901234567891234','0909','451'),(5,85.33,85.33,'Maybank','0912385763098765','1221','123'),(6,612.00,612.00,'Agro Bank','1234769074213468','1234','123'),(7,185.40,185.40,'Maybank','1234567890123456','1245','123'),(8,412.00,412.00,'Maybank','1234567891234567','1220','123'),(9,185.40,185.40,'Maybank','12345678912345','1220','12');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `PROPERTY_ID` int(11) NOT NULL,
  `PROPERTY_NAME` varchar(40) DEFAULT NULL,
  `PROPERTY_IMG` mediumblob,
  `PROPERTY_TYPE` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `STREET` varchar(30) DEFAULT NULL,
  `CITY` varchar(30) DEFAULT NULL,
  `STATE` varchar(20) DEFAULT NULL,
  `PRICE` decimal(6,2) DEFAULT NULL,
  `HOST_ID` varchar(16) DEFAULT NULL,
  `QUEEN_BED` int(11) DEFAULT NULL,
  `SINGLE_BED` int(11) DEFAULT NULL,
  `WIFI` varchar(5) DEFAULT NULL,
  `BACKYARD` varchar(5) DEFAULT NULL,
  `MAX_PERSON` int(11) DEFAULT NULL,
  `AIRCOND` varchar(5) DEFAULT NULL,
  `PARKING` varchar(5) DEFAULT NULL,
  `POOL` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`PROPERTY_ID`),
  KEY `HOST_ID_idx` (`HOST_ID`),
  CONSTRAINT `HOST_ID` FOREIGN KEY (`HOST_ID`) REFERENCES `host` (`HOST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'Homestay Terengganu',NULL,'Bungalow','Beautiful homestay around Terengganu','No. 32, Jalan Warisan','Dungun','Terengganu',80.50,'host1',2,1,'Yes','Yes',7,'Yes','2','Yes'),(2,'Homestay Suraya',NULL,'Bungalow','Got new aircond  and renovated living room','No. 38','Machang','Kelantan',90.00,'host2',2,2,'yes','yes',5,'yes','2','yes'),(3,'Homestay Johor',NULL,'Apartment','Beautiful view','No. 40','Desaru','Johor Bahru',200.00,'host3',4,2,'Yes','Yes',9,'Yes','2','Yes'),(4,'Homestay Bukit Jelutong',NULL,'Mansion','Great space for fun activities','No. 33','Shah Alam','Selangor',5000.00,'host4',10,12,'Yes','Yes',20,'Yes','10','Yes'),(5,'Homestay Abe',_binary '?','Bungalow','Beautiful homestay around Terengganu','No. 38','Machang','Kelantan',90.00,'host2',3,1,'No','No',5,'No','3','No');
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `REPORT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REPORT_TYPE` varchar(25) DEFAULT NULL,
  `REPORT_DESC` varchar(45) DEFAULT NULL,
  `REPORT_STATUS` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`REPORT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,'TECHNICAL','ADA MASALAH BANG','DONE'),(2,'UI','BUTTON NOT FUNCTION','DONE'),(3,'FRAUD','DIDNT GET MONEY RETURN',NULL),(4,'TECHNICAL','TAKTAHU LAH','DONE'),(5,'Performance','2weqqwe',NULL),(6,'Performance','The app is very slow','DONE');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `REVIEW_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REVIEW_DESC` varchar(45) DEFAULT NULL,
  `USER_ID` varchar(13) DEFAULT NULL,
  `PROPERTY_ID` int(11) DEFAULT NULL,
  `RATING` int(11) DEFAULT NULL,
  PRIMARY KEY (`REVIEW_ID`),
  KEY `PROPERTY_ID_idx` (`PROPERTY_ID`),
  KEY `USER_ID_idx` (`USER_ID`),
  CONSTRAINT `PROPERTY_ID` FOREIGN KEY (`PROPERTY_ID`) REFERENCES `property` (`PROPERTY_ID`),
  CONSTRAINT `USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'BOEK AH','aina',1,4),(2,'Great',NULL,NULL,5),(3,'wdqwd',NULL,NULL,3),(4,'Best homestay i ever stayed!',NULL,NULL,4);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USER_ID` varchar(13) NOT NULL,
  `USER_PASS` varchar(15) NOT NULL,
  `USER_FNAME` varchar(40) NOT NULL,
  `USER_LNAME` varchar(25) NOT NULL,
  `USER_PHONE` varchar(15) NOT NULL,
  `USER_EMAIL` varchar(35) NOT NULL,
  `STREET` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('aalia','aalia123','Aalia','Najwa','0123784212','aalia@gmail.com','No. 33, Jalan Kubah','Shah Alam','Selangor'),('adlin','adlin123','Amirah Anis','Adlin','0142325894','adlin@gmail.com','No.2, Jalan Srikaya','Segamat','Johor'),('aina','aina123','Fatin Aina','Abdullah','0145829638','aina@gmail.com','No.32, Jalan Baru','Semenyih','23000 Selangor'),('aisyah','aisyah123','Aisyah','Jamal','0174047441','aisyah@gmail.com','No.32, Jalan Teratai','Kulai','Johor'),('cekel','cekel123','Ilyana','Jamal','0123456892','cekel@gmail.com','No. 33 Jalan Kelantan','Bachok','Kelantan');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-02  3:09:45
