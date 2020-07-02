-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5709
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para bd_votantes
CREATE DATABASE IF NOT EXISTS `bd_votantes` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_votantes`;

-- Volcando estructura para tabla bd_votantes.candidatos
CREATE TABLE IF NOT EXISTS `candidatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_apellidos` varchar(1000) NOT NULL,
  `orden` int(11) NOT NULL,
  `id_partido` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_partido` (`id_partido`),
  CONSTRAINT `FK_partido` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_votantes.candidatos: ~20 rows (aproximadamente)
/*!40000 ALTER TABLE `candidatos` DISABLE KEYS */;
REPLACE INTO `candidatos` (`id`, `nombre_apellidos`, `orden`, `id_partido`) VALUES
	(1, 'Carmen Navarro Lacoba', 1, 1),
	(2, 'Manuel Serrano López', 2, 1),
	(3, 'Manuel Serena  Fernández', 3, 1),
	(4, 'Cristina García Martínez', 4, 1),
	(5, 'Manuel Gabriel González Ramos', 1, 2),
	(6, 'María Luisa Vilches Ruiz', 2, 2),
	(7, 'José Carlos Díaz Rodríguez', 3, 2),
	(8, 'Estefanía Escribano Villena', 4, 2),
	(9, 'María Dolores Arteaga Espinosa de los Monteros', 1, 4),
	(10, 'Hugo Gabriel Guillen Malagón', 2, 4),
	(11, 'Ana Isabel Martínez Molina', 3, 4),
	(12, 'Cristian Cuerda González', 4, 4),
	(13, 'María Pérez Segovia', 1, 3),
	(14, 'Emilio Zamora Martínez', 2, 3),
	(15, 'Darcy Gioconda Cárdenas Barrera', 3, 3),
	(16, 'Sergio León Bullón', 4, 3),
	(17, 'Rafael Fernández-Lomana Gutiérrez', 1, 5),
	(18, 'Juan Francisco Robles Descalzo', 2, 5),
	(19, 'María Remedios Gil Martínez', 3, 5),
	(20, 'María Teresa Fernández Lara', 4, 5);
/*!40000 ALTER TABLE `candidatos` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votantes.parametros
CREATE TABLE IF NOT EXISTS `parametros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `circunscripcion` varchar(50) NOT NULL,
  `candidatos` int(11) NOT NULL DEFAULT 0,
  `tipoConsulta` varchar(50) NOT NULL,
  `fechaConsulta` date NOT NULL,
  `estadoEscrutiño` enum('Cerrado','Abierto','Finalizado') NOT NULL DEFAULT 'Cerrado',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_votantes.parametros: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
REPLACE INTO `parametros` (`id`, `circunscripcion`, `candidatos`, `tipoConsulta`, `fechaConsulta`, `estadoEscrutiño`) VALUES
	(1, 'ALBACETE', 4, 'ELECCIONES ', '2019-11-10', 'Cerrado');
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votantes.partido
CREATE TABLE IF NOT EXISTS `partido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombrepartido` varchar(90) NOT NULL,
  `siglas` varchar(50) NOT NULL,
  `logo` varchar(50) NOT NULL,
  `votos` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombrepartido` (`nombrepartido`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_votantes.partido: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
REPLACE INTO `partido` (`id`, `nombrepartido`, `siglas`, `logo`, `votos`) VALUES
	(1, 'PARTIDO POPULAR', 'PP', '../FOTOS/pp.png', 26593),
	(2, 'PARTIDO SOCIALISTA OBRERO ESPAÑOL', 'PSOE', '../FOTOS/psoe.png', 27080),
	(3, 'UNIDAS PODEMOS', 'UP', '../FOTOS/podemos.png', 10222),
	(4, 'CIUDADANOS', 'CS', '../FOTOS/cs.png', 8713),
	(5, 'VOX', 'VOX', '../FOTOS/vox.png', 20480);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votantes.votante
CREATE TABLE IF NOT EXISTS `votante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nif` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `fechanac` date NOT NULL,
  `password` varbinary(16) NOT NULL,
  `votado` enum('V','NV') DEFAULT 'NV',
  `rol` enum('Administrador','Votante') DEFAULT 'Votante',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nif` (`nif`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_votantes.votante: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `votante` DISABLE KEYS */;
/*!40000 ALTER TABLE `votante` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
