CREATE DATABASE  IF NOT EXISTS `prodetpi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `prodetpi`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: prodetpi
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `escudo_url` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,'México','https://flagcdn.com/mx.svg'),(2,'Sudáfrica','https://flagcdn.com/za.svg'),(3,'Corea del Sur','https://flagcdn.com/kr.svg'),(4,'República Checa','https://flagcdn.com/cz.svg'),(5,'Canadá','https://flagcdn.com/ca.svg'),(6,'Bosnia y Herzegovina','https://flagcdn.com/ba.svg'),(7,'Catar','https://flagcdn.com/qa.svg'),(8,'Suiza','https://flagcdn.com/ch.svg'),(9,'Brasil','https://flagcdn.com/br.svg'),(10,'Marruecos','https://flagcdn.com/ma.svg'),(11,'Haití','https://flagcdn.com/ht.svg'),(12,'Escocia','https://flagcdn.com/gb-sct.svg'),(13,'Estados Unidos','https://flagcdn.com/us.svg'),(14,'Paraguay','https://flagcdn.com/py.svg'),(15,'Australia','https://flagcdn.com/au.svg'),(16,'Turquía','https://flagcdn.com/tr.svg'),(17,'Alemania','https://flagcdn.com/de.svg'),(18,'Curazao','https://flagcdn.com/cw.svg'),(19,'Costa de Marfil','https://flagcdn.com/ci.svg'),(20,'Ecuador','https://flagcdn.com/ec.svg'),(21,'Países Bajos','https://flagcdn.com/nl.svg'),(22,'Japón','https://flagcdn.com/jp.svg'),(23,'Suecia','https://flagcdn.com/se.svg'),(24,'Túnez','https://flagcdn.com/tn.svg'),(25,'Bélgica','https://flagcdn.com/be.svg'),(26,'Egipto','https://flagcdn.com/eg.svg'),(27,'Irán','https://flagcdn.com/ir.svg'),(28,'Nueva Zelanda','https://flagcdn.com/nz.svg'),(29,'España','https://flagcdn.com/es.svg'),(30,'Cabo Verde','https://flagcdn.com/cv.svg'),(31,'Arabia Saudita','https://flagcdn.com/sa.svg'),(32,'Uruguay','https://flagcdn.com/uy.svg'),(33,'Francia','https://flagcdn.com/fr.svg'),(34,'Senegal','https://flagcdn.com/sn.svg'),(35,'Irak','https://flagcdn.com/iq.svg'),(36,'Noruega','https://flagcdn.com/no.svg'),(37,'Argentina','https://flagcdn.com/ar.svg'),(38,'Argelia','https://flagcdn.com/dz.svg'),(39,'Austria','https://flagcdn.com/at.svg'),(40,'Jordania','https://flagcdn.com/jo.svg'),(41,'Portugal','https://flagcdn.com/pt.svg'),(42,'RD Congo','https://flagcdn.com/cd.svg'),(43,'Uzbekistán','https://flagcdn.com/uz.svg'),(44,'Colombia','https://flagcdn.com/co.svg'),(45,'Inglaterra','https://flagcdn.com/gb-eng.svg'),(46,'Croacia','https://flagcdn.com/hr.svg'),(47,'Ghana','https://flagcdn.com/gh.svg'),(48,'Panamá','https://flagcdn.com/pa.svg');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fecha`
--

DROP TABLE IF EXISTS `fecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fecha` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `estado` enum('PROGRAMADA','EN_JUEGO','FINALIZADO') NOT NULL DEFAULT 'PROGRAMADA',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fecha`
--

LOCK TABLES `fecha` WRITE;
/*!40000 ALTER TABLE `fecha` DISABLE KEYS */;
/*!40000 ALTER TABLE `fecha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fecha_jornada`
--

DROP TABLE IF EXISTS `fecha_jornada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fecha_jornada` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estado` enum('EN_JUEGO','FINALIZADA','PROGRAMADA') NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKnpfnqg3gajmnbqtxw3dgi52if` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fecha_jornada`
--

LOCK TABLES `fecha_jornada` WRITE;
/*!40000 ALTER TABLE `fecha_jornada` DISABLE KEYS */;
INSERT INTO `fecha_jornada` VALUES (1,'FINALIZADA','Grupo A - Fecha 1'),(2,'FINALIZADA','Grupo A - Fecha 2'),(3,'FINALIZADA','Grupo A - Fecha 3'),(4,'FINALIZADA','Grupo B - Fecha 1'),(5,'FINALIZADA','Grupo B - Fecha 2'),(6,'FINALIZADA','Grupo B - Fecha 3'),(7,'FINALIZADA','Grupo C - Fecha 1'),(8,'FINALIZADA','Grupo C - Fecha 2'),(9,'FINALIZADA','Grupo C - Fecha 3'),(10,'FINALIZADA','Grupo D - Fecha 1'),(11,'FINALIZADA','Grupo D - Fecha 2'),(12,'FINALIZADA','Grupo D - Fecha 3'),(13,'FINALIZADA','Grupo E - Fecha 1'),(14,'FINALIZADA','Grupo E - Fecha 2'),(15,'FINALIZADA','Grupo E - Fecha 3'),(16,'FINALIZADA','Grupo F - Fecha 1'),(17,'FINALIZADA','Grupo F - Fecha 2'),(18,'FINALIZADA','Grupo F - Fecha 3'),(19,'FINALIZADA','Grupo G - Fecha 1'),(20,'FINALIZADA','Grupo G - Fecha 2'),(21,'FINALIZADA','Grupo G - Fecha 3'),(22,'FINALIZADA','Grupo H - Fecha 1'),(23,'FINALIZADA','Grupo H - Fecha 2'),(24,'FINALIZADA','Grupo H - Fecha 3'),(25,'FINALIZADA','Grupo I - Fecha 1'),(26,'FINALIZADA','Grupo I - Fecha 2'),(27,'FINALIZADA','Grupo I - Fecha 3'),(28,'FINALIZADA','Grupo J - Fecha 1'),(29,'FINALIZADA','Grupo J - Fecha 2'),(30,'FINALIZADA','Grupo J - Fecha 3'),(31,'FINALIZADA','Grupo K - Fecha 1'),(32,'FINALIZADA','Grupo K - Fecha 2'),(33,'FINALIZADA','Grupo K - Fecha 3'),(34,'FINALIZADA','Grupo L - Fecha 1'),(35,'FINALIZADA','Grupo L - Fecha 2'),(36,'FINALIZADA','Grupo L - Fecha 3'),(37,'EN_JUEGO','Dieciseisavos de Final');
/*!40000 ALTER TABLE `fecha_jornada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_equipo`
--

DROP TABLE IF EXISTS `historial_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial_equipo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `equipo_id` bigint NOT NULL,
  `partidos_jugados` int DEFAULT '0',
  `victorias` int DEFAULT '0',
  `empates` int DEFAULT '0',
  `derrotas` int DEFAULT '0',
  `goles_favor` int DEFAULT '0',
  `goles_contra` int DEFAULT '0',
  `ultimos_resultados` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_equipo_id` (`equipo_id`),
  CONSTRAINT `fk_historial_equipo` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_equipo`
--

LOCK TABLES `historial_equipo` WRITE;
/*!40000 ALTER TABLE `historial_equipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_id` bigint NOT NULL,
  `equipo_local_id` bigint NOT NULL,
  `equipo_visitante_id` bigint NOT NULL,
  `fecha_hora_inicio` datetime NOT NULL,
  `estado` enum('POR_JUGARSE','EN_JUEGO','FINALIZADO') NOT NULL DEFAULT 'POR_JUGARSE',
  `goles_local` int DEFAULT NULL,
  `goles_visitante` int DEFAULT NULL,
  `resultado` enum('LOCAL','EMPATE','VISITANTE') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fecha_id` (`fecha_id`),
  KEY `equipo_local_id` (`equipo_local_id`),
  KEY `equipo_visitante_id` (`equipo_visitante_id`),
  CONSTRAINT `fk_partido_fecha_jornada` FOREIGN KEY (`fecha_id`) REFERENCES `fecha_jornada` (`id`),
  CONSTRAINT `fk_partido_local` FOREIGN KEY (`equipo_local_id`) REFERENCES `equipo` (`id`),
  CONSTRAINT `fk_partido_visitante` FOREIGN KEY (`equipo_visitante_id`) REFERENCES `equipo` (`id`),
  CONSTRAINT `chk_equipos_distintos` CHECK ((`equipo_local_id` <> `equipo_visitante_id`))
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,1,1,2,'2026-06-11 19:00:00','FINALIZADO',2,0,'LOCAL'),(2,1,3,4,'2026-06-12 02:00:00','FINALIZADO',2,1,'LOCAL'),(3,2,4,2,'2026-06-18 16:00:00','FINALIZADO',1,1,'EMPATE'),(4,2,1,3,'2026-06-19 01:00:00','FINALIZADO',1,0,'LOCAL'),(5,3,4,1,'2026-06-25 01:00:00','FINALIZADO',0,3,'VISITANTE'),(6,3,2,3,'2026-06-25 01:00:00','FINALIZADO',1,0,'LOCAL'),(7,4,5,6,'2026-06-12 18:00:00','FINALIZADO',1,1,'EMPATE'),(8,4,7,8,'2026-06-13 18:00:00','FINALIZADO',1,1,'EMPATE'),(9,5,8,6,'2026-06-18 21:00:00','FINALIZADO',4,1,'LOCAL'),(10,5,5,7,'2026-06-19 20:00:00','FINALIZADO',2,1,'LOCAL'),(11,6,8,5,'2026-06-25 20:00:00','FINALIZADO',1,2,'VISITANTE'),(12,6,6,7,'2026-06-25 20:00:00','FINALIZADO',2,0,'LOCAL'),(13,7,9,10,'2026-06-13 21:00:00','FINALIZADO',1,1,'EMPATE'),(14,7,11,12,'2026-06-14 00:00:00','FINALIZADO',0,1,'VISITANTE'),(15,8,9,11,'2026-06-20 17:00:00','FINALIZADO',3,0,'LOCAL'),(16,8,10,12,'2026-06-20 20:00:00','FINALIZADO',1,0,'LOCAL'),(17,9,9,12,'2026-06-26 01:00:00','FINALIZADO',3,0,'LOCAL'),(18,9,10,11,'2026-06-26 01:00:00','FINALIZADO',2,0,'LOCAL'),(19,10,13,14,'2026-06-13 01:00:00','FINALIZADO',4,1,'LOCAL'),(20,10,15,16,'2026-06-14 04:00:00','FINALIZADO',2,0,'LOCAL'),(21,11,13,15,'2026-06-19 17:00:00','FINALIZADO',2,1,'LOCAL'),(22,11,14,16,'2026-06-20 01:00:00','FINALIZADO',1,0,'LOCAL'),(23,12,13,16,'2026-06-26 21:00:00','FINALIZADO',3,1,'LOCAL'),(24,12,15,14,'2026-06-26 21:00:00','FINALIZADO',1,1,'EMPATE'),(25,13,17,18,'2026-06-14 17:00:00','FINALIZADO',7,1,'LOCAL'),(26,13,19,20,'2026-06-14 23:00:00','FINALIZADO',1,0,'LOCAL'),(27,14,17,19,'2026-06-20 20:00:00','FINALIZADO',5,1,'LOCAL'),(28,14,20,18,'2026-06-21 00:00:00','FINALIZADO',3,0,'LOCAL'),(29,15,20,17,'2026-06-25 21:00:00','FINALIZADO',0,2,'VISITANTE'),(30,15,18,19,'2026-06-25 21:00:00','FINALIZADO',1,2,'VISITANTE'),(31,16,21,22,'2026-06-14 19:00:00','FINALIZADO',2,2,'EMPATE'),(32,16,23,24,'2026-06-15 01:00:00','FINALIZADO',5,1,'LOCAL'),(33,17,21,24,'2026-06-20 22:00:00','FINALIZADO',5,1,'LOCAL'),(34,17,22,23,'2026-06-21 21:00:00','FINALIZADO',2,1,'LOCAL'),(35,18,21,23,'2026-06-25 21:00:00','FINALIZADO',2,1,'LOCAL'),(36,18,22,24,'2026-06-26 01:00:00','FINALIZADO',1,1,'EMPATE'),(37,19,25,26,'2026-06-15 19:00:00','FINALIZADO',1,1,'EMPATE'),(38,19,27,28,'2026-06-16 00:00:00','FINALIZADO',2,2,'EMPATE'),(39,20,25,27,'2026-06-21 19:00:00','FINALIZADO',2,0,'LOCAL'),(40,20,26,28,'2026-06-22 00:00:00','FINALIZADO',2,0,'LOCAL'),(41,21,25,28,'2026-06-27 21:00:00','FINALIZADO',5,1,'LOCAL'),(42,21,26,27,'2026-06-28 00:00:00','FINALIZADO',1,1,'EMPATE'),(43,22,29,30,'2026-06-15 15:00:00','FINALIZADO',0,0,'EMPATE'),(44,22,31,32,'2026-06-16 01:00:00','FINALIZADO',0,1,'VISITANTE'),(45,23,29,31,'2026-06-21 21:00:00','FINALIZADO',3,1,'LOCAL'),(46,23,32,30,'2026-06-22 02:00:00','FINALIZADO',2,0,'LOCAL'),(47,24,29,32,'2026-06-26 21:00:00','FINALIZADO',2,0,'LOCAL'),(48,24,31,30,'2026-06-26 21:00:00','FINALIZADO',1,0,'LOCAL'),(49,25,33,34,'2026-06-16 19:00:00','FINALIZADO',3,1,'LOCAL'),(50,25,35,36,'2026-06-16 22:00:00','FINALIZADO',1,4,'VISITANTE'),(51,26,33,35,'2026-06-22 19:00:00','FINALIZADO',4,0,'LOCAL'),(52,26,36,34,'2026-06-22 23:00:00','FINALIZADO',2,1,'LOCAL'),(53,27,33,36,'2026-06-27 21:00:00','FINALIZADO',2,1,'LOCAL'),(54,27,34,35,'2026-06-27 21:00:00','FINALIZADO',3,0,'LOCAL'),(55,28,37,38,'2026-06-17 01:00:00','FINALIZADO',3,0,'LOCAL'),(56,28,39,40,'2026-06-17 03:00:00','FINALIZADO',3,1,'LOCAL'),(57,29,37,39,'2026-06-22 16:00:00','FINALIZADO',2,0,'LOCAL'),(58,29,40,38,'2026-06-23 03:00:00','FINALIZADO',1,3,'VISITANTE'),(59,30,40,37,'2026-06-27 02:00:00','FINALIZADO',1,3,'VISITANTE'),(60,30,38,39,'2026-06-27 02:00:00','FINALIZADO',3,3,'EMPATE'),(61,31,41,42,'2026-06-17 15:00:00','FINALIZADO',1,1,'EMPATE'),(62,31,43,44,'2026-06-18 00:00:00','FINALIZADO',1,3,'VISITANTE'),(63,32,41,43,'2026-06-23 15:00:00','FINALIZADO',4,0,'LOCAL'),(64,32,44,42,'2026-06-23 22:00:00','FINALIZADO',1,1,'EMPATE'),(65,33,44,41,'2026-06-27 22:30:00','FINALIZADO',0,0,'EMPATE'),(66,33,42,43,'2026-06-27 22:30:00','FINALIZADO',3,1,'LOCAL'),(67,34,45,46,'2026-06-17 19:00:00','FINALIZADO',4,2,'LOCAL'),(68,34,47,48,'2026-06-18 22:00:00','FINALIZADO',1,0,'LOCAL'),(69,35,45,47,'2026-06-23 19:00:00','FINALIZADO',2,0,'LOCAL'),(70,35,48,46,'2026-06-24 22:00:00','FINALIZADO',0,2,'VISITANTE'),(71,36,48,45,'2026-06-27 21:00:00','FINALIZADO',0,2,'VISITANTE'),(72,36,46,47,'2026-06-27 21:00:00','FINALIZADO',2,1,'LOCAL'),(73,37,2,5,'2026-06-28 21:00:00','FINALIZADO',0,1,'VISITANTE'),(74,37,9,22,'2026-06-29 16:00:00','FINALIZADO',2,1,'LOCAL'),(75,37,17,14,'2026-06-29 20:30:00','EN_JUEGO',NULL,NULL,NULL),(76,37,21,10,'2026-06-29 23:00:00','EN_JUEGO',NULL,NULL,NULL),(77,37,19,36,'2026-06-30 16:00:00','POR_JUGARSE',NULL,NULL,NULL),(78,37,33,23,'2026-06-30 20:00:00','POR_JUGARSE',NULL,NULL,NULL),(79,37,1,20,'2026-07-01 00:00:00','POR_JUGARSE',NULL,NULL,NULL),(80,37,45,42,'2026-07-01 15:00:00','POR_JUGARSE',NULL,NULL,NULL),(81,37,25,34,'2026-07-01 19:00:00','POR_JUGARSE',NULL,NULL,NULL),(82,37,13,6,'2026-07-01 23:00:00','POR_JUGARSE',NULL,NULL,NULL),(83,37,29,39,'2026-07-02 18:00:00','POR_JUGARSE',NULL,NULL,NULL),(84,37,41,46,'2026-07-02 22:00:00','POR_JUGARSE',NULL,NULL,NULL),(85,37,8,38,'2026-07-03 02:00:00','POR_JUGARSE',NULL,NULL,NULL),(86,37,15,26,'2026-07-03 17:00:00','POR_JUGARSE',NULL,NULL,NULL),(87,37,37,30,'2026-07-03 21:00:00','POR_JUGARSE',NULL,NULL,NULL),(88,37,44,47,'2026-07-04 00:30:00','POR_JUGARSE',NULL,NULL,NULL);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronostico`
--

DROP TABLE IF EXISTS `pronostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronostico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint NOT NULL,
  `partido_id` bigint NOT NULL,
  `puntos_otorgados` int NOT NULL DEFAULT '0',
  `fecha_creacion` datetime NOT NULL,
  `goles_local_pronosticado` int NOT NULL,
  `goles_visitante_pronosticado` int NOT NULL,
  `puntos_obtenidos` int DEFAULT NULL,
  `puntos_calculados` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_usuario_partido` (`usuario_id`,`partido_id`),
  UNIQUE KEY `UKolucsw3brbyoq3mnhxb3da7t6` (`usuario_id`,`partido_id`),
  KEY `partido_id` (`partido_id`),
  CONSTRAINT `fk_pronostico_partido` FOREIGN KEY (`partido_id`) REFERENCES `partido` (`id`),
  CONSTRAINT `fk_pronostico_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronostico`
--

LOCK TABLES `pronostico` WRITE;
/*!40000 ALTER TABLE `pronostico` DISABLE KEYS */;
INSERT INTO `pronostico` VALUES (1,2,1,3,'2026-06-11 18:00:00',2,0,3,_binary ''),(2,4,1,1,'2026-06-11 18:00:00',1,0,1,_binary ''),(3,5,1,1,'2026-06-11 18:00:00',3,1,1,_binary ''),(4,6,1,0,'2026-06-11 18:00:00',0,1,0,_binary ''),(5,7,1,3,'2026-06-11 18:00:00',2,0,3,_binary ''),(6,8,1,0,'2026-06-11 18:00:00',1,1,0,_binary ''),(7,9,1,1,'2026-06-11 18:00:00',2,1,1,_binary ''),(8,10,1,0,'2026-06-11 18:00:00',0,0,0,_binary ''),(9,11,1,1,'2026-06-11 18:00:00',3,0,1,_binary ''),(10,12,1,3,'2026-06-11 18:00:00',2,0,3,_binary ''),(16,2,2,1,'2026-06-11 18:30:00',1,0,1,_binary ''),(17,4,2,3,'2026-06-11 18:30:00',2,1,3,_binary ''),(18,5,2,0,'2026-06-11 18:30:00',0,1,0,_binary ''),(19,6,2,1,'2026-06-11 18:30:00',2,0,1,_binary ''),(20,7,2,0,'2026-06-11 18:30:00',1,1,0,_binary ''),(21,8,2,1,'2026-06-11 18:30:00',3,1,1,_binary ''),(22,9,2,3,'2026-06-11 18:30:00',2,1,3,_binary ''),(23,10,2,0,'2026-06-11 18:30:00',0,2,0,_binary ''),(24,11,2,0,'2026-06-11 18:30:00',1,2,0,_binary ''),(25,12,2,0,'2026-06-11 18:30:00',2,2,0,_binary ''),(31,2,3,3,'2026-06-18 15:00:00',1,1,3,_binary ''),(32,4,3,0,'2026-06-18 15:00:00',0,1,0,_binary ''),(33,5,3,1,'2026-06-18 15:00:00',2,2,1,_binary ''),(34,6,3,0,'2026-06-18 15:00:00',1,0,0,_binary ''),(35,7,3,3,'2026-06-18 15:00:00',1,1,3,_binary ''),(36,8,3,1,'2026-06-18 15:00:00',0,0,1,_binary ''),(37,9,3,0,'2026-06-18 15:00:00',2,1,0,_binary ''),(38,10,3,3,'2026-06-18 15:00:00',1,1,3,_binary ''),(39,11,3,1,'2026-06-18 15:00:00',0,0,1,_binary ''),(40,12,3,0,'2026-06-18 15:00:00',2,0,0,_binary '');
/*!40000 ALTER TABLE `pronostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` enum('ADMIN','JUGADOR') NOT NULL DEFAULT 'JUGADOR',
  `puntos_totales` int NOT NULL DEFAULT '0',
  `resultados_exactos` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','admin@prode.com','$2a$10$ockaP2RPj0W.xJR4bDLjU.aBiHaVGWMfzWT7L9xI8x/cska//6tYq','ADMIN',0,0),(2,'Efrain','efrainprode@gmail.com','$2a$10$FI7LAB7DMEGem5/XZPxiieVUZgxJHVPGHWhQQW843KCS2ByktDjPe','JUGADOR',7,2),(4,'Estefania','estefaniaprode@gmail.com','$2a$10$vMJqwvvpMqiwQo6zsZg7KeRzW3O8XcoZeqvXzwUdi8V3ZRJEut5yS','JUGADOR',4,1),(5,'Juan','juanprode@gmail.com','$2a$10$MoxRO9v7XQrCyi7S3ozpc.8jPQYjGnT7vJjv19tt3f79Li.g.437u','JUGADOR',2,0),(6,'Ramiro','ramiroprode@gmail.com','$2a$10$UfTpZM1xrTnbrxgkUmUvT.NupaQAWcT/Ksp6lDFn5Ak9/u21x/cQO','JUGADOR',1,0),(7,'carlos_prode','carlosprode@gmail.com','$2a$10$FI7LAB7DMEGem5/XZPxiieVUZgxJHVPGHWhQQW843KCS2ByktDjPe','JUGADOR',6,2),(8,'lucia_world','lucia.world@gmail.com','$2a$10$FI7LAB7DMEGem5/XZPxiieVUZgxJHVPGHWhQQW843KCS2ByktDjPe','JUGADOR',2,0),(9,'pablo_prode','pabloprode@hotmail.com','$2a$10$FI7LAB7DMEGem5/XZPxiieVUZgxJHVPGHWhQQW843KCS2ByktDjPe','JUGADOR',4,1),(10,'valentina_f','valentina.f@gmail.com','$2a$10$FI7LAB7DMEGem5/XZPxiieVUZgxJHVPGHWhQQW843KCS2ByktDjPe','JUGADOR',3,1),(11,'maxi_goleador','maxi.goleador@gmail.com','$2a$10$FI7LAB7DMEGem5/XZPxiieVUZgxJHVPGHWhQQW843KCS2ByktDjPe','JUGADOR',2,0),(12,'sofi_mundial','sofimundial@gmail.com','$2a$10$FI7LAB7DMEGem5/XZPxiieVUZgxJHVPGHWhQQW843KCS2ByktDjPe','JUGADOR',3,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `puntos_totales` int NOT NULL,
  `resultados_exactos` int NOT NULL,
  `rol` enum('ADMIN','JUGADOR') NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`),
  UNIQUE KEY `UKm2dvbwfge291euvmk6vkkocao` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-29 23:16:00