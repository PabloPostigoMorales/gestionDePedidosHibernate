-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-12-2023 a las 23:38:07
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestorpedidos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepedido`
--

CREATE TABLE `detallepedido` (
  `id` int(11) NOT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallepedido`
--

INSERT INTO `detallepedido` (`id`, `id_pedido`, `id_producto`, `cantidad`) VALUES
(141, 1, 1, 1),
(142, 1, 3, 2),
(143, 1, 5, 3),
(144, 2, 2, 4),
(145, 2, 4, 5),
(146, 2, 6, 6),
(147, 3, 3, 7),
(148, 3, 5, 8),
(149, 3, 7, 9),
(150, 4, 4, 1),
(151, 4, 6, 2),
(152, 4, 8, 3),
(153, 5, 5, 4),
(154, 5, 7, 5),
(155, 5, 9, 6),
(156, 6, 6, 7),
(157, 6, 8, 8),
(158, 6, 10, 9),
(159, 7, 1, 1),
(160, 7, 8, 2),
(161, 7, 10, 3),
(162, 8, 2, 4),
(163, 8, 5, 5),
(164, 8, 9, 6),
(165, 9, 3, 7),
(166, 9, 7, 8),
(167, 9, 10, 9),
(168, 10, 4, 1),
(169, 10, 6, 2),
(170, 10, 9, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `cod_pedido` varchar(7) NOT NULL,
  `order_date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `cod_pedido`, `order_date`, `user_id`, `total`) VALUES
(1, 'Pedido1', '2023-12-14', 1, 1860),
(2, 'Pedido2', '2023-12-15', 1, 5030),
(3, 'Pedido3', '2023-12-14', 2, 4760),
(4, 'Pedido4', '2023-12-15', 2, 520),
(5, 'Pedido5', '2023-12-14', 3, 2740),
(6, 'Pedido6', '2023-12-15', 3, 2010),
(7, 'Pedido7', '2023-12-14', 4, 1120),
(8, 'Pedido8', '2023-12-15', 4, 6040),
(9, 'Pedido9', '2023-12-14', 5, 2700),
(10, 'Pedido1', '2023-12-15', 5, 580);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `prod_name` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `avail_quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `prod_name`, `price`, `avail_quantity`) VALUES
(1, 'Ordenador Portátil', 800, 20),
(2, 'PC de Escritorio', 1000, 15),
(3, 'Teclado mecánico', 80, 50),
(4, 'Ratón Gaming', 50, 30),
(5, 'Monitor 27\"', 300, 25),
(6, 'Disco Duro SSD 1TB', 130, 40),
(7, 'Impresora Multifunción', 200, 15),
(8, 'Router WiFi AC', 70, 30),
(9, 'Auriculares Inalámbricos', 90, 40),
(10, 'Cámara Web HD', 60, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `name`, `password`, `email`) VALUES
(1, 'Usuario1', 'contraseña1', 'usuario1@email.com'),
(2, 'Usuario2', 'contraseña2', 'usuario2@email.com'),
(3, 'Usuario3', 'contraseña3', 'usuario3@email.com'),
(4, 'Usuario4', 'contraseña4', 'usuario4@email.com'),
(5, 'Usuario5', 'contraseña5', 'usuario5@email.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pedido` (`id_pedido`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=171;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=495;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
