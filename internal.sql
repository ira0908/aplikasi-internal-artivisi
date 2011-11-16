-- MySQL dump 10.13  Distrib 5.1.49, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: internal
-- ------------------------------------------------------
-- Server version	5.1.49-1ubuntu8.1

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
-- Table structure for table `TrKasbon`
--

DROP TABLE IF EXISTS `TrKasbon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TrKasbon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ket` varchar(255) DEFAULT NULL,
  `nilai` decimal(19,2) DEFAULT NULL,
  `saldoAkhir` decimal(19,2) DEFAULT NULL,
  `saldoAwal` decimal(19,2) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `pegawai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK29F13F02906675FA` (`pegawai_id`),
  CONSTRAINT `FK29F13F02906675FA` FOREIGN KEY (`pegawai_id`) REFERENCES `mPegawai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TrKasbon`
--

LOCK TABLES `TrKasbon` WRITE;
/*!40000 ALTER TABLE `TrKasbon` DISABLE KEYS */;
INSERT INTO `TrKasbon` VALUES (1,'Saldo 28 Sep 2011','640014.00','640014.00','0.00','2011-09-28','kasbon',1),(2,'Saldo 28 Sep 2011','950000.00','950000.00','0.00','2011-09-28','kasbon',2),(3,'Saldo 28 Sep 2011','1000000.00','1000000.00','0.00','2011-09-28','kasbon',4),(4,'Saldo 28 Sep 2011','4670000.00','4670000.00','0.00','2011-09-28','kasbon',5),(5,'Saldo 28 Sep 2011','300000.00','300000.00','0.00','2011-09-28','kasbon',10),(6,'Saldo 28 Sep 2011','2800000.00','2800000.00','0.00','2011-09-28','kasbon',8),(7,'Kasbon buat bayar mobil','3619000.00','4259014.00','640014.00','2011-10-10','kasbon',1),(8,'Kasbon buat bayar BTN','1000000.00','5259014.00','4259014.00','2011-10-10','kasbon',1),(9,'Kasbon buat bayar ke Martinus','160000.00','5419014.00','5259014.00','2011-10-10','kasbon',1),(10,'Bayar Kasbon dari Reimburse transport','192000.00','5227014.00','5419014.00','2011-10-10','bayar',1),(11,'Kasbon','500000.00','5727014.00','5227014.00','2011-10-13','kasbon',1),(12,'Kasbon bayar telpon cibinong','73797.00','5800811.00','5727014.00','2011-10-13','kasbon',1),(13,'Kasbon bayar listrik cibinong','342286.00','6143097.00','5800811.00','2011-10-13','kasbon',1),(14,'Kasbon bayar listrik a/n Muchtadi','91914.00','6235011.00','6143097.00','2011-10-13','kasbon',1),(15,'Bayar kasbon dari bonus EDC Server','5000000.00','1235011.00','6235011.00','2011-10-31','bayar',1),(16,'Kasbon dari potongan terlambat','46000.00','996000.00','950000.00','2011-10-28','kasbon',2),(17,'Kasbon','500000.00','1496000.00','996000.00','2011-11-07','kasbon',2),(18,'Bayar dipotong gaji','400000.00','600000.00','1000000.00','2011-10-28','bayar',4),(19,'Kasbon','200000.00','500000.00','300000.00','2011-10-11','kasbon',10),(20,'Kasbon','50000.00','550000.00','500000.00','2011-10-17','kasbon',10),(21,'Bayar dipotong gaji Oktober','100000.00','450000.00','550000.00','2011-10-28','bayar',10),(22,'Kasbon','70000.00','70000.00','0.00','2011-10-10','kasbon',7),(23,'Kasbon','30000.00','100000.00','70000.00','2011-10-27','kasbon',7),(24,'Bayar dipotong gaji Oktober','100000.00','0.00','100000.00','2011-10-28','bayar',7),(25,'Kasbon','100000.00','100000.00','0.00','2011-11-04','kasbon',7),(26,'Kasbon','50000.00','2850000.00','2800000.00','2011-10-19','kasbon',8),(27,'Bayar dipotong gaji Oktober','50000.00','2800000.00','2850000.00','2011-10-28','bayar',8),(28,'Kasbon','50000.00','2850000.00','2800000.00','2011-11-04','kasbon',8);
/*!40000 ALTER TABLE `TrKasbon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mPegawai`
--

DROP TABLE IF EXISTS `mPegawai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mPegawai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `alamat` varchar(255) NOT NULL,
  `kodePegawai` varchar(255) NOT NULL,
  `namaPegawai` varchar(255) NOT NULL,
  `noTelp` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mPegawai`
--

LOCK TABLES `mPegawai` WRITE;
/*!40000 ALTER TABLE `mPegawai` DISABLE KEYS */;
INSERT INTO `mPegawai` VALUES (1,'Cibinong','200802-01','Endy Muhardin','02183401940 / 08155284463'),(2,'Sukabumi','200802-02','Ira Dwi Rahmah','02196034911 / 087882288926'),(3,'Kediri','200809-03','Martinus Ady H','02185421726 / 08979531137'),(4,'Malang','200903-06','Jimmy Rengga','08970122438'),(5,'Surabaya','200906-07','Adi Sulistiono','02128946300 / 085210831766'),(6,'Sukabumi','200902-05','Meliawati','087877126622'),(7,'Banyuwangi','200812-04','Dadang Iswanto','085781600773'),(8,'Kuningan','200909-08','Ade Irawan','02194270861'),(9,'Kediri','201007-10','Fanani M. Ihsan','087880098484'),(10,'Garut','201001-09','Doni M. Ramdhani','08997724234'),(11,'Depok','201105-11','Rangga Eka','08988781062'),(12,'Depok','201105-12','Feldy Yusuf','087886955868');
/*!40000 ALTER TABLE `mPegawai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterGroup`
--

DROP TABLE IF EXISTS `masterGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterGroup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `namaGroup` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterGroup`
--

LOCK TABLES `masterGroup` WRITE;
/*!40000 ALTER TABLE `masterGroup` DISABLE KEYS */;
INSERT INTO `masterGroup` VALUES (2,'ADMINISTRATOR'),(3,'USER'),(4,'SUPER USER');
/*!40000 ALTER TABLE `masterGroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterGroupPermission`
--

DROP TABLE IF EXISTS `masterGroupPermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterGroupPermission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC8B502ECBD8191A` (`permission_id`),
  KEY `FKC8B502EC13FF279A` (`group_id`),
  CONSTRAINT `FKC8B502EC13FF279A` FOREIGN KEY (`group_id`) REFERENCES `masterGroup` (`id`),
  CONSTRAINT `FKC8B502ECBD8191A` FOREIGN KEY (`permission_id`) REFERENCES `masterPermission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterGroupPermission`
--

LOCK TABLES `masterGroupPermission` WRITE;
/*!40000 ALTER TABLE `masterGroupPermission` DISABLE KEYS */;
INSERT INTO `masterGroupPermission` VALUES (1,2,1),(3,2,3),(4,2,4),(5,3,3),(6,4,1),(7,4,3);
/*!40000 ALTER TABLE `masterGroupPermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterPermission`
--

DROP TABLE IF EXISTS `masterPermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterPermission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `namaPermission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterPermission`
--

LOCK TABLES `masterPermission` WRITE;
/*!40000 ALTER TABLE `masterPermission` DISABLE KEYS */;
INSERT INTO `masterPermission` VALUES (1,'KARYAWAN_EDIT'),(3,'KARYAWAN_VIEW'),(4,'KARYAWAN_ALL');
/*!40000 ALTER TABLE `masterPermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterUser`
--

DROP TABLE IF EXISTS `masterUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterUser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enable` bit(1) DEFAULT NULL,
  `namaUser` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  `pegawai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8675894D13FF279A` (`group_id`),
  KEY `FK8675894D906675FA` (`pegawai_id`),
  CONSTRAINT `FK8675894D906675FA` FOREIGN KEY (`pegawai_id`) REFERENCES `mPegawai` (`id`),
  CONSTRAINT `FK8675894D13FF279A` FOREIGN KEY (`group_id`) REFERENCES `masterGroup` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterUser`
--

LOCK TABLES `masterUser` WRITE;
/*!40000 ALTER TABLE `masterUser` DISABLE KEYS */;
INSERT INTO `masterUser` VALUES (1,'','ira','iradwi',2,2),(2,NULL,'meli','meli01',4,6);
/*!40000 ALTER TABLE `masterUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saldoKasbon`
--

DROP TABLE IF EXISTS `saldoKasbon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saldoKasbon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `saldoAkhir` decimal(19,2) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `pegawai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8C0590D906675FA` (`pegawai_id`),
  CONSTRAINT `FK8C0590D906675FA` FOREIGN KEY (`pegawai_id`) REFERENCES `mPegawai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saldoKasbon`
--

LOCK TABLES `saldoKasbon` WRITE;
/*!40000 ALTER TABLE `saldoKasbon` DISABLE KEYS */;
INSERT INTO `saldoKasbon` VALUES (1,'1235011.00','2011-10-31',1),(2,'1496000.00','2011-11-07',2),(3,'0.00',NULL,3),(4,'600000.00','2011-10-28',4),(5,'4670000.00','2011-09-28',5),(6,'0.00',NULL,6),(7,'100000.00','2011-11-04',7),(8,'2850000.00','2011-11-04',8),(9,'0.00',NULL,9),(10,'450000.00','2011-10-28',10),(11,'0.00',NULL,11),(12,'0.00',NULL,12);
/*!40000 ALTER TABLE `saldoKasbon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-11-16 17:43:09
