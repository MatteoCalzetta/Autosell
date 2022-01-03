-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ispw_project
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `automobile`
--

DROP TABLE IF EXISTS `automobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `automobile` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `casa_produttrice` varchar(45) NOT NULL,
  `modello` varchar(45) NOT NULL,
  `alimentazione` varchar(45) NOT NULL,
  `potenza_in_cv` varchar(45) NOT NULL,
  `numero_porte` varchar(45) NOT NULL,
  `numero_posti` varchar(45) NOT NULL,
  `colore` varchar(45) NOT NULL,
  `tipo_cambio` varchar(45) NOT NULL,
  `carrozzeria` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobile`
--

LOCK TABLES `automobile` WRITE;
/*!40000 ALTER TABLE `automobile` DISABLE KEYS */;
INSERT INTO `automobile` VALUES (1,'Alfa Romeo','Mito','Benzina','78','3','5','Bianco','Manuale','Hatchback'),(2,'BMW','i8','Ibrida','231','2','4','Nero','Automatico','Coupé'),(3,'Mercedes','CLA AMG 35','Benzina','306','4','5','Bianco','Automatico','Berlina'),(4,'Audi','Q8','Ibrida','286','5','5','Nero','Automatico','SUV'),(5,'Tesla','Model 3','Elettrica','136','5','5','Bianco','Automatico','Berlina');
/*!40000 ALTER TABLE `automobile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-03 18:44:13
