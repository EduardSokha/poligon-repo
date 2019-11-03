DROP SCHEMA IF EXISTS payment_system;

CREATE SCHEMA payment_system;

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `idaccount` int(11) NOT NULL AUTO_INCREMENT,
  `balance` int(11) DEFAULT NULL,
  `creation_date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `currency_idcurrency` int(11) NOT NULL,
  PRIMARY KEY (`idaccount`,`currency_idcurrency`),
  KEY `fk_account_currency1_idx` (`currency_idcurrency`),
  CONSTRAINT `fk_account_currency1` FOREIGN KEY (`currency_idcurrency`) REFERENCES `currency` (`idcurrency`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,38,'Sun Sep 08 21:56:50 GMT+03:00 2019','unlocked',2),(2,30,'Sun Sep 08 22:00:17 GMT+03:00 2019','unlocked',2),(3,90,'Sun Sep 08 22:00:59 GMT+03:00 2019','unlocked',2),(4,69,'Sun Sep 08 22:01:34 GMT+03:00 2019','unlocked',2),(5,36,'Sun Sep 08 22:01:59 GMT+03:00 2019','unlocked',2),(6,56,'Sun Sep 08 22:06:15 GMT+03:00 2019','unlocked',2),(7,93,'Sun Sep 08 22:06:51 GMT+03:00 2019','unlocked',2),(8,72,'Sun Sep 08 22:07:53 GMT+03:00 2019','unlocked',2),(9,0,'Mon Sep 09 23:46:15 GMT+03:00 2019','unlocked',2),(10,0,'Mon Sep 09 23:48:43 GMT+03:00 2019','unlocked',2),(11,0,'Mon Sep 09 23:51:28 GMT+03:00 2019','unlocked',2),(12,0,'Thu Oct 03 18:03:55 GMT+03:00 2019','unlocked',1),(13,0,'Thu Oct 31 00:12:29 GMT+03:00 2019','unlocked',1),(14,0,'Thu Oct 31 00:14:48 GMT+03:00 2019','unlocked',2);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `idcard` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `account_idaccount` int(11) NOT NULL,
  `payment_system_card_idpayment_system_card` int(11) NOT NULL,
  `name_card_idname_card` int(11) NOT NULL,
  PRIMARY KEY (`idcard`,`account_idaccount`,`payment_system_card_idpayment_system_card`,`name_card_idname_card`),
  KEY `fk_card_account1_idx` (`account_idaccount`),
  KEY `fk_card_payment_system_card1_idx` (`payment_system_card_idpayment_system_card`),
  KEY `fk_card_name_card1_idx` (`name_card_idname_card`),
  CONSTRAINT `fk_card_account1` FOREIGN KEY (`account_idaccount`) REFERENCES `account` (`idaccount`),
  CONSTRAINT `fk_card_name_card1` FOREIGN KEY (`name_card_idname_card`) REFERENCES `name_card` (`idname_card`),
  CONSTRAINT `fk_card_payment_system_card1` FOREIGN KEY (`payment_system_card_idpayment_system_card`) REFERENCES `payment_system_card` (`idpayment_system_card`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,'Sun Sep 08 22:21:18 GMT+03:00 2019','unlocked',1,1,1),(2,'Sun Sep 08 22:23:33 GMT+03:00 2019','unlocked',2,2,2),(3,'Sun Sep 08 22:23:59 GMT+03:00 2019','unlocked',3,3,4),(4,'Sun Sep 08 22:26:39 GMT+03:00 2019','unlocked',4,2,3),(5,'Sun Sep 08 22:33:31 GMT+03:00 2019','unlocked',5,3,4),(6,'Sun Sep 08 22:34:07 GMT+03:00 2019','unlocked',6,1,2),(7,'Sun Sep 08 22:35:55 GMT+03:00 2019','unlocked',7,3,1),(8,'Sun Sep 08 22:36:33 GMT+03:00 2019','unlocked',8,3,3),(9,'Mon Sep 09 23:46:15 GMT+03:00 2019','unlocked',9,1,3),(10,'Mon Sep 09 23:48:43 GMT+03:00 2019','unlocked',10,3,4),(11,'Mon Sep 09 23:51:28 GMT+03:00 2019','unlocked',11,3,4),(12,'Thu Oct 03 18:03:55 GMT+03:00 2019','unlocked',12,1,1),(13,'Thu Oct 31 00:12:29 GMT+03:00 2019','unlocked',13,1,1),(14,'Thu Oct 31 00:14:48 GMT+03:00 2019','unlocked',14,2,3);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `idcurrency` int(11) NOT NULL AUTO_INCREMENT,
  `name_currency` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcurrency`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'USD'),(2,'BYN'),(3,'RUB');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposits`
--

DROP TABLE IF EXISTS `deposits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deposits` (
  `iddeposits` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `currency_idcurrency` int(11) NOT NULL,
  PRIMARY KEY (`iddeposits`,`currency_idcurrency`),
  KEY `fk_deposits_currency1_idx` (`currency_idcurrency`),
  CONSTRAINT `fk_deposits_currency1` FOREIGN KEY (`currency_idcurrency`) REFERENCES `currency` (`idcurrency`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposits`
--

LOCK TABLES `deposits` WRITE;
/*!40000 ALTER TABLE `deposits` DISABLE KEYS */;
/*!40000 ALTER TABLE `deposits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_deposits`
--

DROP TABLE IF EXISTS `list_deposits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_deposits` (
  `idlist_deposits` int(11) NOT NULL AUTO_INCREMENT,
  `users_idusers` int(11) NOT NULL,
  `deposits_iddeposits` int(11) NOT NULL,
  PRIMARY KEY (`idlist_deposits`,`users_idusers`,`deposits_iddeposits`),
  KEY `fk_list_deposits_users1_idx` (`users_idusers`),
  KEY `fk_list_deposits_deposits1_idx` (`deposits_iddeposits`),
  CONSTRAINT `fk_list_deposits_deposits1` FOREIGN KEY (`deposits_iddeposits`) REFERENCES `deposits` (`iddeposits`),
  CONSTRAINT `fk_list_deposits_users1` FOREIGN KEY (`users_idusers`) REFERENCES `users` (`idusers`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_deposits`
--

LOCK TABLES `list_deposits` WRITE;
/*!40000 ALTER TABLE `list_deposits` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_deposits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `name_card`
--

DROP TABLE IF EXISTS `name_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `name_card` (
  `idname_card` int(11) NOT NULL AUTO_INCREMENT,
  `name_card` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idname_card`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `name_card`
--

LOCK TABLES `name_card` WRITE;
/*!40000 ALTER TABLE `name_card` DISABLE KEYS */;
INSERT INTO `name_card` VALUES (1,'GOLD'),(2,'PRIME'),(3,'GUIDE'),(4,'HOTPOTATO');
/*!40000 ALTER TABLE `name_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_system_card`
--

DROP TABLE IF EXISTS `payment_system_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_system_card` (
  `idpayment_system_card` int(11) NOT NULL AUTO_INCREMENT,
  `type_paym_syst_card` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpayment_system_card`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_system_card`
--

LOCK TABLES `payment_system_card` WRITE;
/*!40000 ALTER TABLE `payment_system_card` DISABLE KEYS */;
INSERT INTO `payment_system_card` VALUES (1,'VISA'),(2,'MASTERCARD'),(3,'BELCARD');
/*!40000 ALTER TABLE `payment_system_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `idpayments` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `sender` varchar(45) DEFAULT NULL,
  `users_idusers` int(11) NOT NULL,
  `recipient` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpayments`,`users_idusers`),
  KEY `fk_payments_users1_idx` (`users_idusers`),
  CONSTRAINT `fk_payments_users1` FOREIGN KEY (`users_idusers`) REFERENCES `users` (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,'approved','Mon Sep 09 23:54:19 GMT+03:00 2019','16','sergey',2,'27');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `idrole` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'User');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `role_idrole` int(11) NOT NULL,
  `series_number_passport` varchar(45) DEFAULT NULL,
  `identification_number_passport` varchar(45) DEFAULT NULL,
  `codeword` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `residence_registr_data_passport` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusers`,`role_idrole`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_users_role1_idx` (`role_idrole`),
  CONSTRAINT `fk_users_role1` FOREIGN KEY (`role_idrole`) REFERENCES `role` (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ale','111','Alexandr','Kedd','Маяковского 114, кв 16',1,'BB26898','46646v66','каваль','+375338942326','Маяковского 114, кв 16'),(2,'Dmitr','222','Dmitriy','Yushko','Deriglazova, 20 flat 27',2,'VV99999','99999v99','venom','+375336897422','Deriglazova, 20 flat 666'),(3,'Vova','333','Vladimir','Smirnov','Baranova, 2 flat 9',2,'BB98743','11236v742','lucky','+375293213971','Baranova, 2 flat 9'),(4,'Fed','444','Fedor','Kashaev','Pushkina, 20 flat 36',2,'BB38946','94380v984','fedric','+375299439620','Pushkina, 20 flat 36'),(5,'Nilik','555','Roma','Nilikovskiy','Dolgobrodskaya 2, flat 20',2,NULL,NULL,NULL,NULL,NULL),(7,'Niliki','555','Roma','Nilikovskiy','Dolgobrodskaya 2, flat 20',2,'BB78123','48937v69','ÑÐµÑÐ¸Ðº','+37293697841','Dolgobrodskaya 2, flat 20'),(8,'Nilikiii','666','Roma','Nilikovskiy','Dolgobrodskaya 2, flat 20',2,'BB26898','46646v66','ÐºÐ¾Ð²Ð°Ð»Ñ','+37293697841','Dolgobrodskaya 2, flat 20'),(9,'Nilik34','777','Roma','Nilikovskiy','Dolgobrodskaya 2, flat 20',2,'BB26898','46646v66','ÐºÐ¾Ð²Ð°Ð»Ñ','+37293697841','Dolgobrodskaya 2, flat 20'),(10,'Nilikttt','888','Roma','Nilikovskiy','Dolgobrodskaya 2, flat 20',2,'BB26898','46646v66','ÐºÐ¾Ð²Ð°Ð»Ñ','+37293697841','Dolgobrodskaya 2, flat 20');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_account`
--

DROP TABLE IF EXISTS `users_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_account` (
  `idusers_account` int(11) NOT NULL AUTO_INCREMENT,
  `users_idusers` int(11) NOT NULL,
  `account_idaccount` int(11) NOT NULL,
  PRIMARY KEY (`idusers_account`,`users_idusers`,`account_idaccount`),
  KEY `fk_users account_users1_idx` (`users_idusers`),
  KEY `fk_users account_account1_idx` (`account_idaccount`),
  CONSTRAINT `fk_users account_account1` FOREIGN KEY (`account_idaccount`) REFERENCES `account` (`idaccount`),
  CONSTRAINT `fk_users account_users1` FOREIGN KEY (`users_idusers`) REFERENCES `users` (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_account`
--

LOCK TABLES `users_account` WRITE;
/*!40000 ALTER TABLE `users_account` DISABLE KEYS */;
INSERT INTO `users_account` VALUES (1,1,1),(2,2,2),(3,2,3),(9,2,9),(10,2,10),(11,2,11),(12,2,12),(13,2,13),(14,2,14),(4,3,4),(5,3,5),(6,3,6),(7,4,7),(8,4,8);
/*!40000 ALTER TABLE `users_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-03 19:46:00
