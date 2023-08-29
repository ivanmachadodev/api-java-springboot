CREATE DATABASE  IF NOT EXISTS `segundoparciallabiv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `segundoparciallabiv`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: segundoparciallabiv
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `Legajo` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Apellido` varchar(100) NOT NULL,
  `Fecha_Nacimiento` date NOT NULL,
  `Fecha_Ingreso` date NOT NULL,
  `Area` varchar(100) NOT NULL,
  `Sueldo_Bruto` double NOT NULL,
  PRIMARY KEY (`Legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (7,'Ivan','Machado','1988-01-10','2012-02-14','Innovacion & Reporting',100000.5),(8,'Juan','Ortiz','1988-03-25','2017-05-30','RR.HH',125032.8),(9,'Lucio','Palacios','1995-09-05','2021-04-18','Soporte Tecnico',94865.23),(10,'Jeronimo','Vera','2002-12-01','2020-12-18','Control de Gestion',101563.9),(11,'Iñaki','Eguia','1996-07-22','2017-10-31','Soporte Tecnico',98532.58),(12,'Andres','Asis','1994-08-29','2013-09-10','Innovacion & Reporting',98532.58),(13,'Matias','Buenvecino','1994-08-29','2013-09-10','RR.HH',110235.26),(14,'Andrea','Niemis','1992-06-11','2021-12-20','Control de Gestion',110235.26),(15,'Giannina','Savid','1990-08-16','2010-10-15','Innovacion & Reporting',105895.34),(21,'Ismael','Machado','1989-05-23','2013-11-29','RR.HH',95687.23),(24,'Nicolas','Machado','1989-05-23','2013-11-29','Innovacion & Reporting',105265.95),(29,'Leandro','Machado','1983-10-26','2015-09-05','Soporte Tecnico',110652.29);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recibo` (
  `Nro_Recibo` int NOT NULL AUTO_INCREMENT,
  `Mes` int NOT NULL,
  `Anio` int NOT NULL,
  `Antiguedad` double NOT NULL,
  `Jubilacion` double NOT NULL,
  `Obra_Social` double NOT NULL,
  `Fondo_Complejidad` double NOT NULL,
  `Legajo` int DEFAULT NULL,
  PRIMARY KEY (`Nro_Recibo`),
  KEY `legajo_idx` (`Legajo`),
  CONSTRAINT `legajo` FOREIGN KEY (`Legajo`) REFERENCES `empleado` (`Legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
INSERT INTO `recibo` VALUES (18,11,2022,1500.2,1300.3,2560.4,1850.5,10),(19,11,2022,1600.2,1156.3,3259.4,1850.5,8),(20,11,2022,1950.2,2560.3,1289.4,1685.5,7),(22,11,2022,1950.2,2560.3,1289.4,1685.5,13),(23,11,2022,1584.36,2560.3,1289.4,1685.5,12),(27,11,2022,1869.47,2560.3,1289.4,1685.5,24),(28,11,2022,1195.47,1354.3,1056.4,945.5,21);
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-15 22:31:09
