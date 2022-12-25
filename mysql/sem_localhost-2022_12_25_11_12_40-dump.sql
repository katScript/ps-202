-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sem
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'test','2022-12-24 02:47:44','2022-12-24 09:47:44'),(2,'a','2022-12-24 02:57:01','2022-12-24 09:57:01'),(3,'b','2022-12-24 02:57:04','2022-12-24 09:57:04'),(4,'c','2022-12-24 02:57:06','2022-12-24 09:57:06'),(5,'d','2022-12-24 02:57:09','2022-12-24 09:57:09'),(6,'e','2022-12-24 02:57:11','2022-12-24 09:57:11');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily`
--

DROP TABLE IF EXISTS `daily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daily` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `staff_id` int unsigned NOT NULL,
  `student_id` int unsigned NOT NULL,
  `schedule_id` int unsigned NOT NULL,
  `present` tinyint DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_daily_staff_id` (`staff_id`),
  KEY `fk_daily_student_id` (`student_id`),
  KEY `fk_daily_schedule_id` (`schedule_id`),
  CONSTRAINT `fk_daily_schedule_id` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_daily_staff_id` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_daily_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily`
--

LOCK TABLES `daily` WRITE;
/*!40000 ALTER TABLE `daily` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mark` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `student_id` int unsigned NOT NULL,
  `subject_id` int unsigned NOT NULL,
  `w_first_atterm` int NOT NULL,
  `w_second_atterm` int NOT NULL,
  `p_first_atterm` int NOT NULL,
  `p_second_atterm` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_mark_student_id` (`student_id`),
  KEY `fk_mark_subject_id` (`subject_id`),
  CONSTRAINT `fk_mark_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_mark_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark`
--

LOCK TABLES `mark` WRITE;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
INSERT INTO `mark` VALUES (1,3,3,1,2,3,4,'2022-12-24 11:33:36','2022-12-24 18:33:36');
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `class_id` int unsigned NOT NULL,
  `day` varchar(255) NOT NULL,
  `start_time` varchar(255) NOT NULL,
  `end_time` varchar(255) NOT NULL,
  `subject_id` int unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_schedule_subject_id` (`subject_id`),
  KEY `fk_schedule_class_id` (`class_id`),
  CONSTRAINT `fk_schedule_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_schedule_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `staff_no` varchar(255) NOT NULL,
  `full_name` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `gender` tinyint NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(255) NOT NULL,
  `user_id` int unsigned DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (2,'qwe','qwe','qwe','123123',0,'2022-12-14','qweqwe',3,'2022-12-24 11:32:45','2022-12-24 18:32:45');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `roll_number` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'test','test','qwe@rty/uio','1234567122','1','2012-10-12','asdasdassadasd','2022-12-23 08:00:09','2022-12-23 21:21:13'),(3,'other','other','other@other.other','1234567890','0','2012-05-23','12312asdasdas','2022-12-23 08:00:50','2022-12-23 21:21:02'),(4,'rttryrty','asdsa','qwewq@xczxc.vbnvbn','123123123','1','2011-03-23','sdadsfgarefdsaf','2022-12-23 09:58:38','2022-12-23 16:58:38'),(5,'zxczxc','test new','qwe@asd.zxc','0123456789','0','2012-12-12','qwewqeqwe','2022-12-24 07:42:59','2022-12-24 14:42:59');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_class`
--

DROP TABLE IF EXISTS `student_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_class` (
  `class_id` int unsigned NOT NULL,
  `student_id` int unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `fk_class_student_class` (`class_id`),
  KEY `fk_student_student_class` (`student_id`),
  CONSTRAINT `fk_class_student_class` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_student_student_class` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class`
--

LOCK TABLES `student_class` WRITE;
/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` VALUES (1,2,'2022-12-24 02:47:56','2022-12-24 09:47:56'),(1,3,'2022-12-24 07:56:32','2022-12-24 14:56:32'),(1,4,'2022-12-24 07:56:32','2022-12-24 14:56:32'),(2,3,'2022-12-24 07:57:54','2022-12-24 14:57:54'),(2,4,'2022-12-24 07:57:54','2022-12-24 14:57:54'),(2,5,'2022-12-24 07:57:54','2022-12-24 14:57:54'),(5,2,'2022-12-24 08:07:21','2022-12-24 15:07:21'),(5,3,'2022-12-24 08:07:21','2022-12-24 15:07:21'),(5,4,'2022-12-24 08:07:21','2022-12-24 15:07:21'),(5,5,'2022-12-24 08:07:21','2022-12-24 15:07:21');
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `total_hour` double NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (3,'test','TEST',12.2,'2022-12-24 11:33:27','2022-12-24 18:33:27');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'test','098f6bcd4621d373cade4e832627b4f6','test','2022-12-23 07:59:40','2022-12-23 14:59:40');
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

-- Dump completed on 2022-12-25 11:12:40
