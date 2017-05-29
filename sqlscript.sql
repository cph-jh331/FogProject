-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 207.154.197.253    Database: FogShop
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `customerId` int(12) NOT NULL AUTO_INCREMENT,
  `userName` varchar(36) NOT NULL,
  `userLastname` varchar(36) NOT NULL,
  `userAddress` varchar(36) NOT NULL,
  `userZip` int(10) NOT NULL,
  `userCity` varchar(20) NOT NULL,
  `userPhone` int(12) NOT NULL,
  `userEmail` varchar(36) NOT NULL,
  `password` varchar(36) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerId` (`customerId`),
  UNIQUE KEY `userEmail` (`userEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'skeNavn','erikLast','SkeVej 45',6969,'SkeBy',69696969,'user@test.dk','123',0),(2,'Lasse','Andersen','Strodem doemdo',3400,'hilleroed',40504040,'la@dld.com','2131231',0),(3,'Lasse','Andersen','Strodem doemdo',3400,'hilleroed',40504040,'bob@bob.dk','123',0),(4,'Peter','Plys','Dødensgade',2739,'Holmen',87986554,'hest@hest.dk','1234',0),(5,'Gal','Fynbo','hestgade',2830,'Herlev',83838383,'ged@ged.dk','1234',0),(7,'Peter','Plyss','Dødensgade',2739,'Holmen',87986554,'hest1@hest.dk','1234',0),(8,'Lasse','Andersen','Stro',3400,'hilleroed',40504040,'la@la.com','123',0),(9,'Fiskfar','Laksedronning','Sildevej',2020,'Torskeby',20202020,'fisk@fisk','fisk',0),(10,'hans','hans','hansenvej',5050,'hansby',20202020,'hans@hans','1234',0);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FogUser`
--

DROP TABLE IF EXISTS `FogUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FogUser` (
  `empId` int(12) NOT NULL AUTO_INCREMENT,
  `empEmail` varchar(36) NOT NULL,
  `empName` varchar(36) NOT NULL,
  `password` varchar(36) NOT NULL,
  `admin` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`empId`),
  UNIQUE KEY `empId` (`empId`),
  UNIQUE KEY `empEmail` (`empEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FogUser`
--

LOCK TABLES `FogUser` WRITE;
/*!40000 ALTER TABLE `FogUser` DISABLE KEYS */;
INSERT INTO `FogUser` VALUES (1,'test@test.dk','Fog1','123',1);
/*!40000 ALTER TABLE `FogUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Odetails`
--

DROP TABLE IF EXISTS `Odetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Odetails` (
  `odetailsId` int(12) NOT NULL AUTO_INCREMENT,
  `orderId` int(12) NOT NULL,
  `partId` int(12) NOT NULL,
  `partQuantity` int(12) NOT NULL,
  PRIMARY KEY (`odetailsId`),
  UNIQUE KEY `odetailsId` (`odetailsId`),
  KEY `orderId` (`orderId`),
  KEY `partId` (`partId`),
  CONSTRAINT `Odetails_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `Orders` (`orderId`),
  CONSTRAINT `Odetails_ibfk_2` FOREIGN KEY (`partId`) REFERENCES `Part` (`partId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Odetails`
--

LOCK TABLES `Odetails` WRITE;
/*!40000 ALTER TABLE `Odetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `Odetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `orderId` int(12) NOT NULL AUTO_INCREMENT,
  `customerId` int(12) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `orderId` (`orderId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `Orders_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Part`
--

DROP TABLE IF EXISTS `Part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Part` (
  `partId` int(12) NOT NULL,
  `type` varchar(36) NOT NULL,
  `category` varchar(12) NOT NULL,
  `length` int(10) DEFAULT NULL,
  `packetSize` int(10) DEFAULT NULL,
  `unitName` varchar(10) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `typeCategory` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`partId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Part`
--

LOCK TABLES `Part` WRITE;
/*!40000 ALTER TABLE `Part` DISABLE KEYS */;
INSERT INTO `Part` VALUES (1001,'25x200 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Understernbrædder til for & bag ende','Understern'),(1002,'25x200 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Understernbrædder til siderne','Understern'),(1003,'25x125 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Oversternbrædder til forenden','Overstern'),(1004,'25x125 mm. trykimp. brædt','Træ',NULL,NULL,'stk','Oversternbrædder til siderne','Overstern'),(1005,'38x75 mm. Lægte ubh.','Træ',NULL,NULL,'stk','Til z på bagside af dør',NULL),(1006,'45x95 mm. Reglar ub.','Træ',NULL,NULL,'stk','Løsholter til skur gavle',NULL),(1007,'45x95 mm. Reglar ub.','Træ',NULL,NULL,'stk','Løsholter til skur sider',NULL),(1008,'45x195 mm. Spærtræ ubh.','Træ',NULL,NULL,'stk','Remme i sider sadles ned i stolper','Rem'),(1009,'45x195 mm. Spærtræ ubh.','Træ',NULL,NULL,'stk','Remme i sider sadles ned i stolper (skur del, deles)',NULL),(1010,'45x195 mm. Spærtræ ubh.','Træ',NULL,NULL,'stk','Spær monteres på rem','Spær'),(1011,'97x97 mm. Trykimp. Stolpe','Træ',NULL,NULL,'stk','Stolper nedgraves 90cm i jord','Stolpe'),(1012,'19x100 mm. Trykimp. Bræt','Træ',NULL,NULL,'stk','til beklædning af skur 1 på 2',NULL),(1013,'19x100 mm. Trykimp. Bræt','Træ',NULL,NULL,'stk','Vandbræt på stern i sider',NULL),(1014,'19x100 mm. Trykimp. Bræt','Træ',NULL,NULL,'stk','Vandbræt på stern i forende',NULL),(2001,'Plasmo Ecolite blåtonet','Tag',600,NULL,'stk','Tagplader monteres på spær','Tag'),(2002,'Plasmo Ecolite blåtonet','Tag',360,NULL,'stk','Tagplader monteres på spær','Tag'),(3001,'Plastmo bundskruer 200 stk','Løsdele',NULL,NULL,'pakke','Skruer til tagplader','Skruer'),(3002,'Hulbånd 1x20mm. 10 mtr','Løsdele',NULL,NULL,'rulle','Til vindkryds på spær','Hulbånd'),(3003,'Universal 190mm. højre','Løsdele',NULL,NULL,'stk','Til montering af spær på rem',NULL),(3004,'Universal 190mm. venstre','Løsdele',NULL,NULL,'stk','Til montering af spær på rem',NULL),(3005,'4,5 x 60mm. skruer 200 stk.','Løsdele',NULL,NULL,'pakke','Til montering af stern og vandbræt',NULL),(3006,'4,0 x 50mm. beslagskruer 250 stk.','Løsdele',NULL,NULL,'pakke','Til montering af universalbeslag + hulbånd',NULL),(3007,'Breddebolt 10 x 120 mm.','Løsdele',NULL,NULL,'stk','Til montering af rem på stolper','Bolt/møtrik'),(3008,'Firkantskriver 40x40x11 mm.','Løsdele',NULL,NULL,'stk','Til montering af rem på stolper',NULL),(3009,'4,5 x 70mm. skruer 400 stk.','Løsdele',NULL,NULL,'pakke','Til montering af yderste beklædning',NULL),(3010,'4,5 x 50mm. skruer 300 stk.','Løsdele',NULL,NULL,'pakke','Til montering af inderste beklædning',NULL),(3011,'Stalddørsgreb 50x75','Løsdele',NULL,NULL,'sæt','Til lås på dør i skur',NULL),(3012,'T-hængsel 390 mm.','Løsdele',NULL,NULL,'stk','Til skurdør',NULL),(3013,'Vinkelbeslag 35','Løsdele',NULL,NULL,'stk','Til monetring af løsholter i skur',NULL);
/*!40000 ALTER TABLE `Part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Svg`
--

DROP TABLE IF EXISTS `Svg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Svg` (
  `svgId` int(12) NOT NULL AUTO_INCREMENT,
  `customerId` int(12) NOT NULL,
  `dateCreate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `empId` int(12) DEFAULT NULL,
  `dateAccept` datetime DEFAULT NULL,
  `svgImage` longtext NOT NULL,
  `status` enum('created','reqApproved','approved','done') NOT NULL DEFAULT 'created',
  PRIMARY KEY (`svgId`),
  UNIQUE KEY `svgId` (`svgId`),
  KEY `customerId` (`customerId`),
  KEY `Svg_ibfk_2` (`empId`),
  CONSTRAINT `Svg_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`customerId`),
  CONSTRAINT `Svg_ibfk_2` FOREIGN KEY (`empId`) REFERENCES `FogUser` (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Svg`
--

LOCK TABLES `Svg` WRITE;
/*!40000 ALTER TABLE `Svg` DISABLE KEYS */;
INSERT INTO `Svg` VALUES (9,8,'2017-05-10 07:41:47',NULL,NULL,'<svg id=\'svg1\' xmlns=\'http://www.w3.org/2000/svg\' xmlns:xlink=\'http://www.w3.org/1999/xlink\'\nwidth=\'100%\'viewbox=\'0,0,800,310\' preserveaspectratio=\'none\'>\n<rect x=\'1\' y=\'1\' width=\'800\' height=\'310\' style=\'stroke:000000;fill:white;\'/>\n<rect x=\'65\' y=\'50\' width=\'5\' height=\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'575\' y=\'50\' width=\'5\' height =\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'320\' y=\'50\' width=\'5\' height=\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'20\' y=\'39\' width=\'600\' height=\'20\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<rect x=\'20\' y=\'39\' width =\'600\' height=\'15\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<text x=\'110\' y=\'300\'style=\'fill:black;\'>længde: 600</text>\n<line x1=\'20\' y1=\'280\' x2=\'620\' y2=\'280\'style=\'stroke:black;stroke-width:1;\'/><text x=\'650\' y=\'40\' style=\'fill:black\'>Højde:210</text>\n\n</svg>','created'),(12,10,'2017-05-10 11:47:08',NULL,NULL,'<svg id=\'svg1\' xmlns=\'http://www.w3.org/2000/svg\' xmlns:xlink=\'http://www.w3.org/1999/xlink\'\nwidth=\'100%\'viewbox=\'0,0,400,500\' preserveaspectratio=\'none\'>\n<rect x=\'1\' y=\'1\' width=\'400\' height=\'500\' style=\'stroke:000000;fill:white;\'/>\n<rect x=\'65\' y=\'50\' width=\'5\' height=\'400\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'175\' y=\'50\' width=\'5\' height =\'400\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'20\' y=\'39\' width=\'200\' height=\'20\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<rect x=\'20\' y=\'39\' width =\'200\' height=\'15\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<text x=\'110\' y=\'490\'style=\'fill:black;\'>længde: 200</text>\n<line x1=\'20\' y1=\'470\' x2=\'220\' y2=\'470\'style=\'stroke:black;stroke-width:1;\'/><text x=\'250\' y=\'40\' style=\'fill:black\'>Højde:400</text>\n\n</svg>','created'),(13,10,'2017-05-10 11:47:20',NULL,NULL,'<svg id=\'svg1\' xmlns=\'http://www.w3.org/2000/svg\' xmlns:xlink=\'http://www.w3.org/1999/xlink\'\nwidth=\'100%\'viewbox=\'0,0,400,500\' preserveaspectratio=\'none\'>\n<rect x=\'1\' y=\'1\' width=\'400\' height=\'500\' style=\'stroke:000000;fill:white;\'/>\n<rect x=\'65\' y=\'50\' width=\'5\' height=\'400\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'175\' y=\'50\' width=\'5\' height =\'400\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'20\' y=\'39\' width=\'200\' height=\'20\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<rect x=\'20\' y=\'39\' width =\'200\' height=\'15\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<text x=\'110\' y=\'490\'style=\'fill:black;\'>længde: 200</text>\n<line x1=\'20\' y1=\'470\' x2=\'220\' y2=\'470\'style=\'stroke:black;stroke-width:1;\'/><text x=\'250\' y=\'40\' style=\'fill:black\'>Højde:400</text>\n\n</svg>','created'),(18,8,'2017-05-10 11:57:39',NULL,NULL,'<svg id=\'svg1\' xmlns=\'http://www.w3.org/2000/svg\' xmlns:xlink=\'http://www.w3.org/1999/xlink\'\nwidth=\'100%\'viewbox=\'0,0,800,310\' preserveaspectratio=\'none\'>\n<rect x=\'1\' y=\'1\' width=\'800\' height=\'310\' style=\'stroke:000000;fill:white;\'/>\n<rect x=\'65\' y=\'50\' width=\'5\' height=\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'575\' y=\'50\' width=\'5\' height =\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'320\' y=\'50\' width=\'5\' height=\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'20\' y=\'39\' width=\'600\' height=\'20\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<rect x=\'20\' y=\'39\' width =\'600\' height=\'15\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<text x=\'110\' y=\'300\'style=\'fill:black;\'>længde: 600</text>\n<line x1=\'20\' y1=\'280\' x2=\'620\' y2=\'280\'style=\'stroke:black;stroke-width:1;\'/><text x=\'650\' y=\'40\' style=\'fill:black\'>Højde:210</text>\n\n</svg>','created'),(31,1,'2017-05-25 03:50:09',NULL,NULL,'<svg id=\'svg1\' xmlns=\'http://www.w3.org/2000/svg\' xmlns:xlink=\'http://www.w3.org/1999/xlink\'\nwidth=\'100%\'viewbox=\'0,0,800,310\' preserveaspectratio=\'none\'>\n<rect x=\'1\' y=\'1\' width=\'800\' height=\'310\' style=\'stroke:000000;fill:white;\'/>\n<rect x=\'65\' y=\'50\' width=\'5\' height=\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'575\' y=\'50\' width=\'5\' height =\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'320\' y=\'50\' width=\'5\' height=\'210\'\nstyle=\'stroke:#000000;fill:none;\'/>\n<rect x=\'20\' y=\'39\' width=\'600\' height=\'20\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<rect x=\'20\' y=\'39\' width =\'600\' height=\'15\'\nstyle=\'stroke:#000000;fill:white;\'/>\n<text x=\'110\' y=\'300\'style=\'fill:black;\'>længde: 600</text>\n<line x1=\'20\' y1=\'280\' x2=\'620\' y2=\'280\'style=\'stroke:black;stroke-width:1;\'/><text x=\'650\' y=\'40\' style=\'fill:black\'>Højde:210</text>\n\n</svg>','approved');
/*!40000 ALTER TABLE `Svg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-29 11:51:50
