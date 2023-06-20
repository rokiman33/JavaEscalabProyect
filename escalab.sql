-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: app.redware.cl    Database: escalab
-- ------------------------------------------------------
-- Server version	5.7.42

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
-- Table structure for table `phones`
--

DROP TABLE IF EXISTS `phones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phones` (
  `phone_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `citycode` varchar(255) NOT NULL,
  `countrycode` varchar(255) NOT NULL,
  `number` varchar(255) NOT NULL,
  `usuario_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`phone_id`),
  UNIQUE KEY `UK_iyb1ctsfd11m9cbkngt35br2v` (`number`),
  KEY `FKdl0nl3chnil3eigbpabvulj77` (`usuario_id`),
  CONSTRAINT `FKdl0nl3chnil3eigbpabvulj77` FOREIGN KEY (`usuario_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phones`
--

LOCK TABLES `phones` WRITE;
/*!40000 ALTER TABLE `phones` DISABLE KEYS */;
INSERT INTO `phones` VALUES (10,'32','56','45454545',_binary '\ÀÒò\Ã¡BSçåˇ#\r\‘'),(12,'32','56','46567899',_binary '\ÀÒò\Ã¡BSçåˇ#\r\‘'),(14,'32','56','232323',_binary '\ÀÒò\Ã¡BSçåˇ#\r\‘'),(15,'32','56','656578',_binary '\ÀÒò\Ã¡BSçåˇ#\r\‘'),(18,'32','56','45454588',_binary 'ê7®[øLrÜØI\Ãj£'),(19,'32','56','555566785',_binary '\Œ/îîD˜óîzF0\”\…\—');
/*!40000 ALTER TABLE `phones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` binary(16) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(60) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (_binary '\Œ/îîD˜óîzF0\”\…\—','2023-06-19 18:29:55','gam@gmail.com',_binary '','2023-06-19 22:29:55','123777','Gabriel'),(_binary 'ê7®[øLrÜØI\Ãj£','2023-06-19 13:06:07','francisca@gmail.com',_binary '','2023-06-19 17:06:07','999777','francisca'),(_binary '\ÀÒò\Ã¡BSçåˇ#\r\‘','2023-06-17 23:06:32','rdiazo@gmail.com',_binary '','2023-06-19 12:13:21','123456','richard');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-19 21:23:46
