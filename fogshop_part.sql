-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: fogshop
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part` (
  `partId` int(12) NOT NULL,
  `type` varchar(36) NOT NULL,
  `category` varchar(12) NOT NULL,
  `length` int(10) DEFAULT NULL,
  `packetsize` int(10) DEFAULT NULL,
  `unitname` varchar(10) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`partId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (1,'25x200 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Understernbrædder til for & bag ende'),(2,'25x200 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Understernbrædder til siderne'),(3,'25x125 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Oversternbrædder til forenden'),(4,'25x125 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Oversternbrædder til siderne'),(5,'38x75 mm. Lægte ubh.','Træ',NULL,NULL,'stk','Til z på bagside af dør'),(6,'45x95 mm. Reglar ub.','Træ',NULL,NULL,'stk','Løsholter til skur gavle'),(7,'45x95 mm. Reglar ub.','Træ',NULL,NULL,'stk','Løsholter til skur sider'),(8,'45x195 mm. Spærtræ ubh.','Træ',NULL,NULL,'stk','Remme i sider sadles ned i stolper'),(9,'45x195 mm. Spærtræ ubh.','Træ',NULL,NULL,'stk','Remme i sider sadles ned i stolper (skur del, deles)'),(10,'45x195 mm. Spærtræ ubh.','Træ',NULL,NULL,'stk','Spær monteres på rem'),(11,'97x97 mm. Trykimp. Stolpe','Træ',NULL,NULL,'stk','Stolper nedgraves 90cm i jord'),(12,'19x100 mm. Trykimp. Bræt','Træ',NULL,NULL,'stk','til beklædning af skur 1 på 2'),(13,'19x100 mm. Trykimp. Bræt','Træ',NULL,NULL,'stk','Vandbræt på stern i sider'),(14,'19x100 mm. Trykimp. Bræt','Træ',NULL,NULL,'stk','Vandbræt på stern i forende'),(15,'Plasmo Ecolite blåtonet','Tag',600,NULL,'stk','Tagplader monteres på spær'),(16,'Plasmo Ecolite blåtonet','Tag',360,NULL,'stk','Tagplader monteres på spær'),(17,'Plastmo bundskruer 200 stk','Løsdele',NULL,NULL,'pakke','Skruer til tagplader'),(18,'Hulbånd 1x20mm. 10 mtr','Løsdele',NULL,NULL,'rulle','Til vindkryds på spær'),(19,'Universal 190mm. højre','Løsdele',NULL,NULL,'stk','Til montering af spær på rem'),(20,'Universal 190mm. venstre','Løsdele',NULL,NULL,'stk','Til montering af spær på rem'),(21,'4,5 x 60mm. skruer 200 stk.','Løsdele',NULL,NULL,'pakke','Til montering af stern og vandbræt'),(22,'4,0 x 50mm. beslagskruer 250 stk.','Løsdele',NULL,NULL,'pakke','Til montering af universalbeslag + hulbånd'),(23,'Breddebolt 10 x 120 mm.','Løsdele',NULL,NULL,'stk','Til montering af rem på stolper'),(24,'Firkantskriver 40x40x11 mm.','Løsdele',NULL,NULL,'stk','Til montering af rem på stolper'),(25,'4,5 x 70mm. skruer 400 stk.','Løsdele',NULL,NULL,'pakke','Til montering af yderste beklædning'),(26,'4,5 x 50mm. skruer 300 stk.','Løsdele',NULL,NULL,'pakke','Til montering af inderste beklædning'),(27,'Stalddørsgreb 50x75','Løsdele',NULL,NULL,'sæt','Til lås på dør i skur'),(28,'T-hængsel 390 mm.','Løsdele',NULL,NULL,'stk','Til skurdør'),(29,'Vinkelbeslag 35','Løsdele',NULL,NULL,'stk','Til monetring af løsholter i skur');
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-04 12:59:48
