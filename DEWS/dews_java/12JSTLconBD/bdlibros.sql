-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-12-2020 a las 10:16:04
-- Versión del servidor: 5.7.14
-- Versión de PHP: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdlibros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

CREATE TABLE `autores` (
  `idautor` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `fechanac` date NOT NULL,
  `nacionalidad` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `autores`
--

INSERT INTO `autores` (`idautor`, `nombre`, `fechanac`, `nacionalidad`) VALUES
(1, 'Charles Dickens', '1812-02-07', 'Reino Unido'),
(2, 'Miguel de Cervantes Saavedra', '1516-04-22', 'España'),
(3, 'Fiodor Dostoievsky', '1821-11-11', 'Rusia'),
(4, 'aaa', '1990-01-01', 'Rusia'),
(5, 'bbb', '1990-01-01', 'EEUU'),
(6, 'ccc', '0000-00-00', 'Rusia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`dni`, `nombre`, `password`) VALUES
('111A', 'Ibon Garcia de Cortázar', '123'),
('222B', 'Yeray Tirado', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `idlibro` int(11) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `paginas` int(11) NOT NULL,
  `genero` varchar(40) NOT NULL,
  `idautor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`idlibro`, `titulo`, `paginas`, `genero`, `idautor`) VALUES
(3, 'Grandes esperanzas', 664, 'Drama', 1),
(4, 'David Copperfield', 716, 'Narrativa', 1),
(5, 'Cuento de Navidad', 112, 'Narrativa', 1),
(8, 'Don Quijote de La Mancha', 1250, 'Novela', 2),
(9, 'Novelas ejemplares', 530, 'Novela', 2),
(10, 'Viaje del Parnaso', 216, 'Poesia', 2),
(11, 'Noches blancas', 72, 'Novela', 3),
(12, 'Los hermanos Karamazov', 1120, 'Novela', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `idprestamo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idlibro` int(11) NOT NULL,
  `fechadev` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`idprestamo`, `fecha`, `idlibro`, `fechadev`) VALUES
(24, '2015-10-28', 11, '2020-11-05'),
(32, '2015-10-28', 11, '2020-11-05'),
(35, '2015-10-28', 11, '2020-11-03'),
(36, '2015-10-28', 12, '2020-11-05'),
(40, '2015-10-28', 10, '2020-11-05'),
(41, '2015-10-28', 10, '2020-11-05'),
(42, '2015-10-28', 3, '2020-11-05'),
(43, '2015-10-28', 3, '2020-11-05'),
(45, '2015-10-28', 5, '2020-11-05'),
(49, '2015-10-28', 5, '2020-11-05'),
(50, '2015-10-28', 8, '2020-11-05'),
(51, '2015-10-28', 9, NULL),
(52, '2015-10-28', 11, '2020-11-05'),
(53, '2015-10-28', 9, '2020-11-05'),
(54, '2015-10-28', 10, '2020-11-05'),
(55, '2015-10-28', 10, '2020-11-05');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autores`
--
ALTER TABLE `autores`
  ADD PRIMARY KEY (`idautor`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`idlibro`),
  ADD KEY `idautor` (`idautor`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`idprestamo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autores`
--
ALTER TABLE `autores`
  MODIFY `idautor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `idlibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `idprestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `fk_autor` FOREIGN KEY (`idautor`) REFERENCES `autores` (`idautor`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
