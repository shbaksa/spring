-- MariaDB dump 10.19  Distrib 10.5.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	10.5.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dae`
--

DROP TABLE IF EXISTS `dae`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dae` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(2) DEFAULT NULL,
  `title` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dae`
--

LOCK TABLES `dae` WRITE;
/*!40000 ALTER TABLE `dae` DISABLE KEYS */;
INSERT INTO `dae` VALUES (1,'01','농산물'),(2,'02','수산물'),(3,'03','축산물'),(4,'04','가공품');
/*!40000 ALTER TABLE `dae` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jung`
--

DROP TABLE IF EXISTS `jung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(2) DEFAULT NULL,
  `title` char(50) DEFAULT NULL,
  `daecode` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jung`
--

LOCK TABLES `jung` WRITE;
/*!40000 ALTER TABLE `jung` DISABLE KEYS */;
INSERT INTO `jung` VALUES (1,'01','야채류','01'),(2,'02','과일류','01'),(3,'03','쌀잡곡','01'),(4,'01','생선','02'),(5,'02','조개','02'),(6,'03','갑각류','02'),(7,'01','돼지','03'),(8,'02','소','03'),(9,'03','양','03'),(10,'01','농산물가공','04'),(11,'02','축산물 가공','04'),(12,'03','수산물 가공','04');
/*!40000 ALTER TABLE `jung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pcode` char(10) DEFAULT NULL,
  `pimg` varchar(100) DEFAULT NULL,
  `cimg` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `made` varchar(50) DEFAULT NULL,
  `halin` int(11) DEFAULT NULL,
  `juk` int(11) DEFAULT NULL,
  `su` int(11) DEFAULT NULL,
  `baesong` int(11) DEFAULT NULL,
  `baeday` int(11) DEFAULT NULL,
  `pstar` int(11) DEFAULT NULL,
  `writeday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pcode` (`pcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `so`
--

DROP TABLE IF EXISTS `so`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `so` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(2) DEFAULT NULL,
  `title` char(50) DEFAULT NULL,
  `daejung` char(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `so`
--

LOCK TABLES `so` WRITE;
/*!40000 ALTER TABLE `so` DISABLE KEYS */;
INSERT INTO `so` VALUES (1,'01','쌈채소','0101'),(2,'02','뿌리채소','0101'),(3,'03','열매채소','0101'),(4,'01','수입과일','0102'),(5,'02','국산과일','0102'),(6,'03','통조림','0102'),(7,'01','햅쌀','0103'),(8,'02','잡곡','0103'),(9,'03','수입','0103'),(10,'01','구이용','0201'),(11,'02','조림용','0201'),(12,'03','횟감','0201'),(13,'01','찌개용','0202'),(14,'02','조림용','0202'),(15,'03','구이용','0202'),(16,'01','찜용','0203'),(17,'02','구이용','0203'),(18,'03','조림용','0203'),(19,'01','구이용','0301'),(20,'02','찌개용','0301'),(21,'03','다진고기','0301'),(22,'01','구이용','0302'),(23,'02','찌개용','0302'),(24,'03','다진고기','0302'),(25,'01','구이용','0303'),(26,'02','꼬치용','0303'),(27,'03','종류','0303'),(28,'01','치킨무','0401'),(29,'02','햇반','0401'),(30,'03','후르츠','0401'),(31,'01','가공우유','0402'),(32,'02','가공육','0402'),(33,'03','런천미트','0402'),(34,'01','게맛살','0403'),(35,'02','맥스봉','0403'),(36,'03',NULL,'0403');
/*!40000 ALTER TABLE `so` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-22 17:25:50
