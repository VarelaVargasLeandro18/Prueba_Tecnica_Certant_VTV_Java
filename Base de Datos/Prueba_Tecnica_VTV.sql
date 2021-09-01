-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-08-2021 a las 14:22:51
-- Versión del servidor: 8.0.26-0ubuntu0.21.04.3
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Prueba_Tecnica_VTV`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `AUTOMOVILES`
--

CREATE TABLE `AUTOMOVILES` (
  `dominio` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `marca` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `modelo` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `propietario_CUIL` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `AUTOMOVILES`
--

INSERT INTO `AUTOMOVILES` (`dominio`, `marca`, `modelo`, `propietario_CUIL`) VALUES
('AA 219 AV', 'Marca', 'Modelo', 55493239563),
('AA 493 AC', 'Marca', 'Modelo', 8458293459),
('AA 495 BD', 'Marca', 'Modelo', 59395436540),
('AB 000 AA', 'Marca', 'Modelo', 70990405904),
('AB 493 LZ', 'Marca', 'Modelo', 54339643956),
('AB 903 CA', 'Marca', 'Modelo', 96954954390),
('AC 234 CA', 'Marca', 'Modelo', 546789456092),
('AD 130 JA', 'Marca', 'Modelo', 90584945685),
('AE 012 PD', 'Marca', 'Modelo', 34689459546),
('AE 234 DD', 'Marca', 'Modelo', 96954954390),
('AE 954 AA', 'Marca', 'Modelo', 59395436540),
('AGE 007', 'Marca', 'Modelo', 59492590493),
('AQ 432 AD', 'Marca', 'Modelo', 55493239563),
('CDD 322', 'Marca', 'Modelo', 54339643956),
('LOZ 076', 'Marca', 'Modelo', 44904569490),
('LPO 999', 'Marca', 'Modelo', 34689459546),
('MOA 589', 'Juanete', 'Pimiento', 8458293459),
('MZZ 950', 'Marca', 'Modelo', 8458293459),
('ZKO 111', 'Marca', 'Modelo', 29345449990),
('ZPQ 431', 'Marca', 'Modelo', 546789456092),
('ZQI 432', 'Marca', 'Modelo', 29345449990);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ESTADOS_INSPECCION`
--

CREATE TABLE `ESTADOS_INSPECCION` (
  `Id` bigint NOT NULL,
  `estado` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `veracidad` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ESTADOS_INSPECCION`
--

INSERT INTO `ESTADOS_INSPECCION` (`Id`, `estado`, `veracidad`) VALUES
(1, 'Apto', 0),
(2, 'Condicional', 1),
(3, 'Rechazado', 2),
(4, 'En Proceso', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `INSPECCIONES`
--

CREATE TABLE `INSPECCIONES` (
  `numero` bigint NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `estado` bigint NOT NULL,
  `auto_inspeccionado` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `inspector` bigint NOT NULL,
  `medicion` bigint DEFAULT NULL,
  `observacion` bigint DEFAULT NULL,
  `exento` varchar(255) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `INSPECCIONES`
--

INSERT INTO `INSPECCIONES` (`numero`, `fecha`, `estado`, `auto_inspeccionado`, `inspector`, `medicion`, `observacion`, `exento`) VALUES
(1, '2021-08-15 09:32:43.000000', 1, 'AA 219 AV', 32303555239, 1, 1, 'Comun'),
(8, '2021-08-11 04:31:40.000000', 2, 'AA 219 AV', 15405679340, 2, 1, 'Exento'),
(9, '2021-08-09 09:33:38.000000', 1, 'AA 493 AC', 20594039401, 5, 2, 'Comun'),
(11, '2020-08-01 11:10:06.000000', 1, 'AA 495 BD', 20594039401, 1, 1, 'Comun'),
(12, '2021-08-14 11:48:17.000000', 3, 'LOZ 076', 32303555239, 25, 13, 'Exento'),
(13, '2021-08-16 10:23:00.514432', 1, 'MOA 589', 20434598886, NULL, NULL, 'Comun'),
(14, '2020-09-28 08:56:12.000000', 1, 'AB 000 AA', 20434598886, 10, 8, 'Exento'),
(15, '2020-04-19 08:56:12.000000', 3, 'AB 493 LZ', 15405679340, 16, 8, 'Exento'),
(16, '2021-02-19 09:00:12.000000', 2, 'AB 903 CA', 32303555239, 15, 5, 'Exento'),
(19, '2021-04-20 09:01:56.000000', 1, 'AC 234 CA', 20434598886, 14, 30, 'Exento'),
(20, '2021-05-25 09:01:56.000000', 2, 'AD 130 JA', 32303555239, 7, 15, 'Exento'),
(23, '2019-10-29 09:05:46.000000', 2, 'AE 012 PD', 29376545438, 12, 18, 'Exento'),
(24, '2020-09-09 09:05:46.000000', 1, 'AE 234 DD', 20434598886, 12, 15, 'Exento'),
(25, '2021-08-01 09:08:55.000000', 1, 'AE 954 AA', 29376545438, 11, 11, 'Exento'),
(26, '2021-08-02 09:08:55.000000', 2, 'AGE 007', 15405679340, 5, 17, 'Comun'),
(27, '2020-12-17 09:11:55.000000', 3, 'AQ 432 AD', 20434598886, 16, 5, 'Comun'),
(28, '2020-03-19 09:11:55.000000', 1, 'CDD 322', 20434598886, 6, 23, 'Comun'),
(29, '2021-03-30 09:17:01.000000', 2, 'LPO 999', 32303555239, 18, 2, 'Exento'),
(30, '2020-09-16 09:17:01.000000', 3, 'MZZ 950', 20434598886, 27, 29, 'Comun'),
(31, '2021-05-18 09:17:01.000000', 2, 'ZKO 111', 20434598886, 10, 3, 'Exento'),
(32, '2020-02-05 09:17:01.000000', 1, 'ZPQ 431', 20434598886, 1, 1, 'Exento');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `INSPECTORES`
--

CREATE TABLE `INSPECTORES` (
  `CUIL` bigint NOT NULL,
  `nro_telefono` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha_nacimiento` datetime(6) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `contrasenia` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `usuario` varchar(255) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `INSPECTORES`
--

INSERT INTO `INSPECTORES` (`CUIL`, `nro_telefono`, `apellido`, `email`, `fecha_nacimiento`, `nombre`, `contrasenia`, `usuario`) VALUES
(15405679340, '+54 1111111111', 'Suarez', 'mail@mail.com', '1996-05-21 01:58:27.000000', 'Pedro', '123', 'pedros'),
(20434598886, '+54 11111111111', 'Varela Vargas', 'lean@mail.com', '2001-06-18 03:00:00.000000', 'Leandro Gaston', '123', 'lvv'),
(20594039401, '+54 1111111111', 'Martinez', 'mail@mail.com', '1990-05-02 02:01:37.000000', 'Alberto', '123', 'albertom'),
(29376545438, '+54 1111111111', 'Perez', 'mail@mail.com', '1989-10-18 01:58:27.000000', 'Juan', '123', 'juanp'),
(32303555239, '+54 1111111111', 'Gutierrez', 'mail@mail.com', '2000-02-29 02:01:37.000000', 'Lucas', '123', 'lucasg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MEDICIONES`
--

CREATE TABLE `MEDICIONES` (
  `Id` bigint NOT NULL,
  `direccion` bigint NOT NULL,
  `sist_de_frenos` bigint NOT NULL,
  `suspension` bigint NOT NULL,
  `tren_delantero` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `MEDICIONES`
--

INSERT INTO `MEDICIONES` (`Id`, `direccion`, `sist_de_frenos`, `suspension`, `tren_delantero`) VALUES
(1, 1, 1, 1, 1),
(2, 1, 2, 1, 2),
(3, 1, 1, 3, 1),
(4, 1, 1, 1, 1),
(5, 1, 1, 1, 1),
(6, 1, 1, 1, 1),
(7, 1, 1, 2, 2),
(8, 2, 2, 1, 1),
(9, 1, 1, 1, 1),
(10, 1, 1, 1, 1),
(11, 1, 1, 1, 1),
(12, 1, 1, 1, 1),
(13, 2, 2, 2, 2),
(14, 1, 1, 1, 1),
(15, 2, 1, 3, 3),
(16, 3, 1, 3, 1),
(17, 1, 1, 1, 1),
(18, 1, 1, 1, 1),
(19, 3, 3, 3, 3),
(20, 1, 1, 1, 1),
(21, 1, 1, 1, 1),
(22, 2, 1, 2, 2),
(23, 1, 1, 1, 1),
(24, 1, 1, 1, 1),
(25, 1, 2, 2, 1),
(26, 1, 1, 1, 1),
(27, 2, 3, 3, 1),
(28, 1, 2, 3, 2),
(29, 2, 2, 3, 2),
(30, 1, 1, 1, 3),
(31, 1, 1, 1, 1),
(32, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `OBSERVACIONES`
--

CREATE TABLE `OBSERVACIONES` (
  `Id` bigint NOT NULL,
  `chasis` bigint NOT NULL,
  `emergencia` bigint NOT NULL,
  `espejos` bigint NOT NULL,
  `luces` bigint NOT NULL,
  `patente` bigint NOT NULL,
  `seguridad` bigint NOT NULL,
  `vidrios` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `OBSERVACIONES`
--

INSERT INTO `OBSERVACIONES` (`Id`, `chasis`, `emergencia`, `espejos`, `luces`, `patente`, `seguridad`, `vidrios`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 2, 1, 1, 1, 1, 1, 1),
(3, 1, 1, 1, 2, 1, 3, 1),
(4, 1, 1, 2, 1, 2, 1, 1),
(5, 1, 1, 1, 1, 1, 1, 1),
(6, 2, 1, 1, 1, 1, 1, 1),
(7, 1, 1, 1, 1, 1, 1, 1),
(8, 1, 1, 1, 1, 1, 1, 1),
(9, 1, 1, 1, 1, 1, 1, 1),
(10, 1, 1, 1, 3, 1, 3, 1),
(11, 1, 1, 1, 1, 1, 1, 1),
(12, 2, 3, 1, 2, 1, 1, 1),
(13, 3, 3, 1, 3, 1, 3, 2),
(14, 1, 1, 1, 1, 1, 1, 1),
(15, 1, 1, 1, 1, 1, 1, 1),
(16, 1, 1, 1, 1, 1, 3, 1),
(17, 1, 2, 1, 1, 1, 1, 1),
(18, 2, 2, 1, 1, 1, 1, 1),
(19, 1, 1, 1, 1, 1, 2, 1),
(20, 1, 1, 1, 1, 1, 2, 1),
(21, 1, 1, 1, 1, 1, 1, 1),
(22, 1, 1, 1, 1, 1, 1, 1),
(23, 1, 2, 2, 2, 1, 2, 1),
(24, 1, 1, 1, 1, 1, 1, 1),
(25, 1, 1, 1, 1, 1, 1, 1),
(26, 1, 1, 1, 1, 1, 1, 1),
(27, 1, 1, 1, 1, 1, 1, 1),
(28, 1, 2, 2, 2, 1, 1, 2),
(29, 1, 1, 1, 1, 1, 1, 1),
(30, 1, 1, 1, 1, 1, 1, 1),
(31, 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PROPIETARIOS`
--

CREATE TABLE `PROPIETARIOS` (
  `CUIL` bigint NOT NULL,
  `nro_telefono` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha_nacimiento` datetime(6) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `tipo` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `PROPIETARIOS`
--

INSERT INTO `PROPIETARIOS` (`CUIL`, `nro_telefono`, `apellido`, `email`, `fecha_nacimiento`, `nombre`, `tipo`) VALUES
(8458293459, '+54 8458293459l', 'DosApellido', 'mail@mail.com', '1992-01-09 02:05:42.000000', 'DosNombre', 11),
(29345449990, '+54 29345449990', 'CincoApellido', 'mail@mail.com', '2003-12-19 02:08:17.000000', 'CincoNombre', 1),
(34689459546, '+54 34689459546', 'OchoApellido', 'mail@mail.com', '1998-01-14 02:12:03.000000', 'OchoNombre', 1),
(44904569490, '+54 44904569490', 'OnceApellido', 'mail@mail.com', '2002-08-21 02:16:35.000000', 'OnceNombre', 1),
(54339643956, '+54 54339643956l', 'TresApellido', 'mail@mail.com', '2002-01-21 02:08:17.000000', 'TresNombre', 1),
(55493239563, '+54 55493239563', 'CuatroApellido', 'mail@mail.com', '1993-12-24 02:08:17.000000', 'CuatroNombre', 1),
(59395436540, '+54 59395436540', 'UnoApellido', 'mail@mail.com', '1990-01-16 02:05:42.000000', 'UnoNombre', 11),
(59492590493, '+54 59492590493', 'DoceApellido', 'mail@mail.com', '1991-04-18 02:16:35.000000', 'DoceNombre', 11),
(70990405904, '+54 70990405904l', 'DiezApellido', 'mail@mail.com', '1991-05-14 02:12:03.000000', 'DiezNombre', 1),
(90584945685, '+54 90584945685', 'NueveApellido', 'mail@mail.com', '1994-08-25 02:12:03.000000', 'NueveNombre', 1),
(96954954390, '+54 96954954390l', 'SeisApellido', 'mail@mail.com', '1997-01-16 02:08:17.000000', 'SeisNombre', 1),
(546789456092, '+54 546789456092l', 'SieteApellido', 'mail@mail.com', '1994-08-16 02:12:03.000000', 'SieteNombre', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TIPOS_PROPIETARIO`
--

CREATE TABLE `TIPOS_PROPIETARIO` (
  `Id` bigint NOT NULL,
  `tipo` varchar(255) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `TIPOS_PROPIETARIO`
--

INSERT INTO `TIPOS_PROPIETARIO` (`Id`, `tipo`) VALUES
(11, 'Comun'),
(1, 'Exento');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `AUTOMOVILES`
--
ALTER TABLE `AUTOMOVILES`
  ADD PRIMARY KEY (`dominio`),
  ADD KEY `FK_Propietario` (`propietario_CUIL`);

--
-- Indices de la tabla `ESTADOS_INSPECCION`
--
ALTER TABLE `ESTADOS_INSPECCION`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `INSPECCIONES`
--
ALTER TABLE `INSPECCIONES`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FK_Estado` (`estado`),
  ADD KEY `FK_Auto` (`auto_inspeccionado`),
  ADD KEY `FK_Inspector` (`inspector`),
  ADD KEY `FK_Medicion` (`medicion`),
  ADD KEY `FK_Observacion` (`observacion`),
  ADD KEY `FK_Tipo` (`exento`);

--
-- Indices de la tabla `INSPECTORES`
--
ALTER TABLE `INSPECTORES`
  ADD PRIMARY KEY (`CUIL`);

--
-- Indices de la tabla `MEDICIONES`
--
ALTER TABLE `MEDICIONES`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Direccion` (`direccion`),
  ADD KEY `FK_SistDeFrenos` (`sist_de_frenos`),
  ADD KEY `FK_Suspension` (`suspension`),
  ADD KEY `FK_TrenDelantero` (`tren_delantero`);

--
-- Indices de la tabla `OBSERVACIONES`
--
ALTER TABLE `OBSERVACIONES`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Chasis` (`chasis`),
  ADD KEY `FK_Emergencia` (`emergencia`),
  ADD KEY `FK_Espejos` (`espejos`),
  ADD KEY `FK_Luces` (`luces`),
  ADD KEY `FK_Patente` (`patente`),
  ADD KEY `FK_Seguridad` (`seguridad`),
  ADD KEY `FK_Vidrios` (`vidrios`);

--
-- Indices de la tabla `PROPIETARIOS`
--
ALTER TABLE `PROPIETARIOS`
  ADD PRIMARY KEY (`CUIL`),
  ADD KEY `FK_TipoPropietario` (`tipo`);

--
-- Indices de la tabla `TIPOS_PROPIETARIO`
--
ALTER TABLE `TIPOS_PROPIETARIO`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `UK_6tb2vci645cdl50gdmaakh37r` (`tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ESTADOS_INSPECCION`
--
ALTER TABLE `ESTADOS_INSPECCION`
  MODIFY `Id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `INSPECCIONES`
--
ALTER TABLE `INSPECCIONES`
  MODIFY `numero` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `MEDICIONES`
--
ALTER TABLE `MEDICIONES`
  MODIFY `Id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `OBSERVACIONES`
--
ALTER TABLE `OBSERVACIONES`
  MODIFY `Id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `TIPOS_PROPIETARIO`
--
ALTER TABLE `TIPOS_PROPIETARIO`
  MODIFY `Id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `AUTOMOVILES`
--
ALTER TABLE `AUTOMOVILES`
  ADD CONSTRAINT `FK_Propietario` FOREIGN KEY (`propietario_CUIL`) REFERENCES `PROPIETARIOS` (`CUIL`);

--
-- Filtros para la tabla `INSPECCIONES`
--
ALTER TABLE `INSPECCIONES`
  ADD CONSTRAINT `FK_Auto` FOREIGN KEY (`auto_inspeccionado`) REFERENCES `AUTOMOVILES` (`dominio`),
  ADD CONSTRAINT `FK_Estado` FOREIGN KEY (`estado`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Inspector` FOREIGN KEY (`inspector`) REFERENCES `INSPECTORES` (`CUIL`),
  ADD CONSTRAINT `FK_Medicion` FOREIGN KEY (`medicion`) REFERENCES `MEDICIONES` (`Id`),
  ADD CONSTRAINT `FK_Observacion` FOREIGN KEY (`observacion`) REFERENCES `OBSERVACIONES` (`Id`),
  ADD CONSTRAINT `FK_Tipo` FOREIGN KEY (`exento`) REFERENCES `TIPOS_PROPIETARIO` (`tipo`);

--
-- Filtros para la tabla `MEDICIONES`
--
ALTER TABLE `MEDICIONES`
  ADD CONSTRAINT `FK_Direccion` FOREIGN KEY (`direccion`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_SistDeFrenos` FOREIGN KEY (`sist_de_frenos`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Suspension` FOREIGN KEY (`suspension`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_TrenDelantero` FOREIGN KEY (`tren_delantero`) REFERENCES `ESTADOS_INSPECCION` (`Id`);

--
-- Filtros para la tabla `OBSERVACIONES`
--
ALTER TABLE `OBSERVACIONES`
  ADD CONSTRAINT `FK_Chasis` FOREIGN KEY (`chasis`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Emergencia` FOREIGN KEY (`emergencia`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Espejos` FOREIGN KEY (`espejos`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Luces` FOREIGN KEY (`luces`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Patente` FOREIGN KEY (`patente`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Seguridad` FOREIGN KEY (`seguridad`) REFERENCES `ESTADOS_INSPECCION` (`Id`),
  ADD CONSTRAINT `FK_Vidrios` FOREIGN KEY (`vidrios`) REFERENCES `ESTADOS_INSPECCION` (`Id`);

--
-- Filtros para la tabla `PROPIETARIOS`
--
ALTER TABLE `PROPIETARIOS`
  ADD CONSTRAINT `FK_TipoPropietario` FOREIGN KEY (`tipo`) REFERENCES `TIPOS_PROPIETARIO` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
