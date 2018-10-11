-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 02-10-2018 a las 00:27:44
-- Versión del servidor: 5.7.19-0ubuntu0.16.04.1
-- Versión de PHP: 7.1.9-1+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdgipar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `idEvento` int(11) NOT NULL,
  `idActividad` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `costo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `actividades`
--

INSERT INTO `actividades` (`idEvento`, `idActividad`, `nombre`, `costo`) VALUES
(1, 2, 'reparto de refireria', 5100),
(2, 3, 'refrescarse', 2000),
(1, 4, 'entrega de medallas', 675),
(3, 5, 'exposicion de articulos', 7654),
(3, 6, 'charlas de robots', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `idArticulo` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `area` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `link` text COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`idArticulo`, `nombre`, `area`, `link`) VALUES
(7, 'hols', 'holistica', 'hola,com'),
(8, 'cables', 'electronica', 'blogspot.com'),
(9, 'leds', 'iluminacon', 'brillo.com'),
(10, 'Proyecto', 'afaf', 'rrwetetwt'),
(11, 'fsdsgseg', 'etetset', 'sesetset');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos_eventos`
--

CREATE TABLE `articulos_eventos` (
  `idEvento` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `articulos_eventos`
--

INSERT INTO `articulos_eventos` (`idEvento`, `idArticulo`) VALUES
(1, 7),
(2, 7),
(3, 7),
(1, 8),
(3, 8),
(3, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos_proyectos`
--

CREATE TABLE `articulos_proyectos` (
  `idProyecto` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `articulos_proyectos`
--

INSERT INTO `articulos_proyectos` (`idProyecto`, `idArticulo`) VALUES
(1, 9),
(1, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias_eventos`
--

CREATE TABLE `asistencias_eventos` (
  `idEvento` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `asistencias_eventos`
--

INSERT INTO `asistencias_eventos` (`idEvento`, `idMiembro`) VALUES
(1, 5),
(1, 9),
(3, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias_reuniones`
--

CREATE TABLE `asistencias_reuniones` (
  `idReunion` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `asistencias_reuniones`
--

INSERT INTO `asistencias_reuniones` (`idReunion`, `idMiembro`) VALUES
(3, 5),
(4, 5),
(3, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comisiones`
--

CREATE TABLE `comisiones` (
  `idActividad` int(11) NOT NULL,
  `idComision` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `comisiones`
--

INSERT INTO `comisiones` (`idActividad`, `idComision`, `idMiembro`, `nombre`) VALUES
(3, 18, 9, 'anuncios'),
(4, 9, 5, 'logistica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disponibilidad_miembros`
--

CREATE TABLE `disponibilidad_miembros` (
  `idDisponibilidad` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL,
  `dia` varchar(12) COLLATE utf8_spanish2_ci NOT NULL,
  `horaInicio` int(11) NOT NULL,
  `horaFinal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `disponibilidad_miembros`
--

INSERT INTO `disponibilidad_miembros` (`idDisponibilidad`, `idMiembro`, `dia`, `horaInicio`, `horaFinal`) VALUES
(18, 5, 'Jueves', 8, 13),
(11, 9, 'Jueves', 13, 19),
(15, 10, 'Miercoles', 10, 13),
(16, 11, 'Miercoles', 17, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `egresados`
--

CREATE TABLE `egresados` (
  `idMiembro` int(11) NOT NULL,
  `idEgresado` int(11) NOT NULL,
  `ocupacion` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `areaEspecialidad` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `idMiembro` int(11) NOT NULL,
  `idEstudiante` int(11) NOT NULL,
  `semestre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`idMiembro`, `idEstudiante`, `semestre`) VALUES
(5, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `idEvento` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFinal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`idEvento`, `nombre`, `fechaInicio`, `fechaFinal`) VALUES
(1, 'competencia', '2016-03-05', '2016-04-13'),
(2, 'maraton', '2015-05-06', '2015-06-20'),
(3, 'convencion', '2015-11-14', '2015-12-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fases_proyectos`
--

CREATE TABLE `fases_proyectos` (
  `idProyecto` int(11) NOT NULL,
  `idFase` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(140) COLLATE utf8_spanish2_ci NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `progreso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `fases_proyectos`
--

INSERT INTO `fases_proyectos` (`idProyecto`, `idFase`, `nombre`, `descripcion`, `fechaInicio`, `fechaFin`, `progreso`) VALUES
(1, 1, 'buscar info', 'se buscara informacion sobre lñas competencias de robtoca\nen las zona de\npuerto ordaz', '2015-02-28', '2015-04-01', 100),
(1, 2, 'compras', 'sevan a comprar materiales para la competacia\nque se tendra,', '2015-03-24', '2015-05-01', 0),
(1, 3, 'recoger fondo', 'se recaudaran fondos para fiancias todo\nlas comspetencia de trobots', '2017-02-03', '2020-11-03', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generaciones`
--

CREATE TABLE `generaciones` (
  `idArticulo` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `generaciones`
--

INSERT INTO `generaciones` (`idArticulo`, `idMiembro`) VALUES
(7, 5),
(8, 5),
(10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembros`
--

CREATE TABLE `miembros` (
  `idMiembro` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `cedula` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `clave` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `sexo` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `cargo` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `imagen` text COLLATE utf8_spanish2_ci NOT NULL,
  `areaInteres` varchar(30) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `miembros`
--

INSERT INTO `miembros` (`idMiembro`, `nombre`, `apellido`, `cedula`, `clave`, `sexo`, `correo`, `telefono`, `cargo`, `imagen`, `areaInteres`) VALUES
(5, 'stalin', 'sanchez', '1234567', 'e10adc3949ba59abbe56e057f20f883e', 'Masculino', 'stalin@hotmail.com', '04241234567', 'CoordinadorGeneral', '/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAGQAZADASIA\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD5/ooo\noAKWinAUAAFSKmackeasxw0gGRxZ7Vchtye1TQ22e1adtacjIqGwK9vaEkcVpQWWeMVes7EsR8tb\nFvYdPlxWbkBn29hyPl5rVg089xWjBY4AO2tW3tBxWTmBmw2PAOK0YtPAVX7HtWiloPl9vQVdjtQy\nlf6Vk5AZyWihM4596si3XcDt/CtFYGPYdPSpUtxkZIBqeYDPSAIvyjOewqVIMYHQnnmrvk7eQM+9\nBRcgnjPFK4FYW/JyRkUCHG4sPpVvYo5Hb0p23npz6GkBVWIZ3D8qVVUE8GrKpk+/tR5e5cjr3ouB\nW2kDHX60qxtg8ipWGHBOfenEKQCON3WgCBVAxxilVOvapOvaiONiytyM0AM8vMxycAnoPWnyRj7Q\ny9eadIuJTjPDUsqfvpCBx60XAgliUhMDAwcA1EYuiKB61dlX5I8joKgZlU7jke9AEDRAORwStZWr\najY6VEZr64iiQdyev4VzHjL4mW2j3Mtrpe24uhkF/wCBTXjGqaxf6xdNPe3DyuTnBPA+ldFOi5as\nD0jWPilCnmRadahyOBJJ0/KuIvfGmt3xbfeOin+GP5RXP8mkrqjSjHoBak1G8l+/cyn6uaal7coc\nrcSKfUMarilNXZAa1v4j1S3XC3bsM/dbmuhsvGdvOdl7B5Rx99ORmuIzSdKThFgerLFDcwCaFw6N\n/EKpzWftXJ6F4jm0l/Kcb7VuqH+H3FeiQ/Z7+0W4t3EkbDORWEk4sDk57QZ6VnT22GPFdjPY8g44\nrLurH5zx3qlIDlJocE1UePFdDdWhVzxWbNBitEwMplxUZFXZI8VXZaoCGkp5FNoASiiimAUtFPA5\noAAKmRM0ImauQw5xU3ASKHNaEFtk9Kkt7XOOK2bWyz2qHICK1tMgcVtWtj/s1Ys9PJFblrZY2jbW\nMpAQWVkMgba1bez+bgVftLHBBrRt7XjoB6GsXICnBZkHkcVfitsdAM1cjt8Dnk981YjgTbg8Gs2w\nKywbdvykH9KsLGAAMYPerEcHzbvalMbLjAx6mpuAxFwpXOcUm3K7dv4mpsADCjmlCleXGQe1ICFs\nDAA+tKkeSzHkLT5IwgIAzzUscYELY7ii4FVlVTlDn1FLg8nGakVMEOvbg1IEYjlRzQBWiH7z5/yp\nSh7cEnOKkKZ3cfgaREBYEtgUwI2HPA59aj42BfQ1ZdPm6mmYA4K8etADV2FfmPzetIA3mIOgFSAg\n/LxzQq5kHHfFADAQ03AyQadOf3hIB6mjaRKcYxu6iq+rX9rp0M1zczCKGPJZmPFACX1xFbWwuLiR\nY4o1JZ26CvEPHfxKl1SV9P0ljFZjhpRwZP8A61Z3j34g3fia4+yW5MWnRH5UB5k9zXCli3FdtGhb\n3pAEjmRyxJ59aQNg5pD1NJXUAtJS0lABS0naloAKBiig8mgArc8OeIJdEvBuy9q5xIn9RWHSjGcG\nk1dWYHtyLDfQJc2zb4pBuUiqd1Z/vSMfNmuU8A+IhZ3X9l3Uh+zzN+7J6K1ekXVp+/zjjd3rkknB\n2A4m9svmbjvWNcWtd1fWWJGyO5rBu7TbnjNXGQHHz2+D0qjJFjtXS3NryeKypoMZ4rVMDHZMVERV\n6SLHaqrrirAhpKeRTaAHAVMiZpETNXIYsmkA6CHNaltbZxxTba3yRW/ZWZOOKiTAS0szxxW/a2GQ\nBjFPsrTp8vFdBaWY4+WsJTAitLIAA9x+tblrZfLzUtvZ7cZXntWlDbN+Hc1hKQCWtttYZFXI7U9M\ncEc1PDC+5crVlISFBXvWbYFeO3yDzkelSeVtYDtUjKE4OfpSjO35e9K4EePn5bj6U51wwGD9fWpN\nu1AOvrSrHltuffBpARkHdjGKFyzc4INP8vd/FgjtSjj1z9KAE2Eghhzjk0Daqt7dBS/P/wDWpqp+\n7Yk0AM3csNoGT1pMMVIGKds+buUHrS/Io3IDjoQaAIiGB5PSlGwqSoPSpRwWJ5HYGmKoU5JxntQA\nwgDt+dAQNycEnpUsm3cMc0zG0MefagCIR4VgBjJpQpLKew4pxTp61De3sWl273V1MscMfLM1MCLU\nL620+3lubqby4lPJNfPXxF8Z3viDVprNWMdjDIQkYP3sdzUvjjx5ceJtYWGF2jsI5Rsj/vc9TXG6\n0SdavP8Arq3867qFHld2BRJzgYpKM+lGM11ABpKUjBoxigAFBpKKADNKME80ZozQAlLS546UnGfW\ngBe1HcelIKOpwKAJFYocg4I6fWvc/Betf8JHoMcsuGu7dhHKB39DXhi4AGRmuy+GutHTPFsNvIwF\nveHyn9j2P51jWjzRA9S1C2/eSHZz71g3FpleldteW2Zn+X+I1jT2gJ6cVyxkBxN3ZgZ4rDurXHbi\nu6u7XAbisC8teW+WtoyA42eHBNZ8seDXS3NrjoKyLiEjtWyYGSy4qIirkkZFV2XFWBbiizWpa2+S\nKitoM44rcs7XJHFRJgTWdpnBxXR2FnwOKjsLL7uBmunsbMHGRzXPOQDrKz5AxW/aWgI+Zec9abZ2\ngwCK2LW3fO0cVzykAQ2uznGWFXI4dp+Y/hU6IwUYGT61MIlHUDnrms2wI4lyy5p6xMQcDAHfNSxx\n4lGB8vagxsGxkGpuBEELnBOSKds2kbPmBPWneXgkBckilwAu0HrQABF3HvntTVG5mU8N2IqVlK4P\ntSpxk44bjPpSAgVSGLMeOmKVlGSD60pPB7+9OY7l3+9MCBgwbqeOaXy3Kg5yDUhPzfMPaj0GCT2x\nQAhAKkAZFNKkryKkQFc98ULnByOOtAECr85/nQ4O0EEcd+9TlVbngAU2QLlc/doAgEYOTzz3ocbW\nyH9ulPyikkttHvWfd6zp9mvmXN5AgXJPzjNPVgSXV5b6bayXN7KiRRjczE188/ELx5P4kvHghZot\nOR/kjB+97mpPiJ48n8Q3bQWrFNPjYgKDgv7mvOnYu/JJHau6hQt70gHxMWuo+c/OP51Y1gFdYuwf\n+erfzqtb/wDHzF/vj+dWdYP/ABOLz/rq3866uoFKig9uKO1MA6mjJzR3pKAFFBoxSUALnjFKDwRT\naWgAFHvQTR0oAACRTlHYdaT+dOHTPTHWgBMc4zVq0cx38EiEh1lUg/jVZe57GrNquby34/5aKP1q\nWB9QO63dtDcxcrIgb/GqE0Hz9ie+Kp+Br37d4YcbiXtrqWLnp97IraeM4JGPmrzXo7Ac/dW+Q5Aw\nKxLu0zziuuntdynbywrLubfIOU68VpGQHCXtrgtxWDdW/JruL2z45HT0rnry1xnAreMgORniIqhI\nmK6G6gxnismeLBrZMDds7bOK6PT7PIXjmqlha8rxXU6da9OKwnIC5YWfA45rpLO0AAqCwtcYbGMV\nv21v+IrmlIB9ra7QOMVoQw4PNLFDtAHY1cRAr5IrFsBFUAdOKf5aH5e47VIABnIp2Mx5xj6VIDIl\nKuCSTjtTWbLZAxirAG4A/pUIAAJoAac7vm49MUgXHzcZqQPyAAAtBQg5ByKAEA3n26ZoKbQPWlPL\ncDg+lIg/eYJ+lIBCBsyR8x68Uh+UYAGKcCArHk54pAOSDz3wKYDXCnDDG71oKhYw/f0FBGw5zwO1\nYWueMNF0KMm7vY/OxnykO5j+FNJvYDbK4O7d17VXu7+1sIvNvLmOFPV2xXjniL4w3dwGi0WEQIOD\nK/LV5vf6xqGqz+ZeXk0rt/ebpXRDDye+gHuur/FfQdPZ47cteSdvLHH51wurfGPWbpmSwgjtl6Zx\nk15oX67eTUas7twc5rojQggN698Wa5qLsZ9QuGL9V34FZFxfSICXkZ292zSTyLbgbSCx71kSymRi\nSa2jFdgCWXzWzimDrSUZzWgEkP8Ax8x/74/nVjWP+Qxef9dW/nUFv/x9Rf74/nVnWeNavP8Arq38\n6XUCjmijGMUUwAnJpKU9emKBQADODSUtFAADg+tHb+VFAoAXORzTad+tIetAC8Y96PbpQOODS9BS\nAcwCkD9antCRew8c+Yv86gDEspA6CrNruS/hHB/eKf1pMD3P4VkNbeIod3C3u4fiK7hrc7TjBHYi\nuF+E6MIvErqBg3qgH35rvw+HbPTvXnVPjYGdJHkHtjuKz7qMFT3xWywZiwAIzVS4hHI/GkmBy91b\ng5wtc/e22DyBiu1uLcEAq34GsHULcqx+XNaxkBw15b4J4rDuYcZNdneW/HTrXO3kFbxYHY6ba5C/\nLXV2FngA4rP022wR8tdTY2xIXnFc05AW7O22rx0rZhg28gcVHbW67eTzWlCgCY5zWEmALFgj5uKm\nVOw5NSOgHoc9qVY8OdvQVmA0IMnJ5FOYFcDOc09hj5uMVFcySRwb4ofNf+FAcUAVZdTtor5LJN8t\nw3VIxnb/ALx7VZaJl+XH5VX0W1ngWaa7jjW4uJC5EfOB2Ga0WQg5GBim9AK5TceE6daeAPm+U80/\nPyEgfiKaACvJOaQEYxuyucZ6UMokyyrt96kG0kDbz70lzOlrbyzTSrFDGMs7cACgCNUypBICnnJr\nm9b8baD4dhY3N7G83OIoW3GvI/iH8UpdZlfTNEd4rNGw8ynBl/8ArV5kryO4LyFiTyTzXXTwzavI\nD0XxL8WdY1mSSGw/0O2PAKffYe5rgZ555ZmeaVnc9WJ5pm4eawHGO9I8m9th4PY11xgo6IBofbJw\nf/r0rOXyQPl71GwAYFj9PeiFHkf5c7f7xqwFWOV3UL0PpSzzrbsyoBk9T6Us84t4WCNls1mSzGTr\nQlcAnmMjc1FR2oAqwCjvS44zSsAOmaAHwc3UX++P51b1vB1q8wMfvWqpbjF1EO+9f51a1cY1q87g\nSt/Ol1ApMRgDHSm96VgM8GkApgKwG480lKRgmkzQAUlOHQ96SgAFLtOM0hpRyMUAHK+xoXA5PNBB\nzz2oxQA7aDk5pvHNL1GKcBkZ/WkAqgFh3PtVi1GNRhIPIkX+dQKCh+p7GrNtvGoRc4PmLyfrSYHv\nnwut/J0XV7kkjz9RbaPpxXYt83AUFvU1S8M6YNN8MWlv0d2edh/vMTWkIMZcnAFeZN3k2BX/ANYr\nI3T+tQyxDlCTnpmp8ryR0zRKdz/dzt9aQGbcQYU9DisW8iVwVIropImbcw9OlZtxCOW9auLA4y7t\n+G4Nc7eQYJG2u3vYcHBJxXPX9uoOAOa3iwO70+2XaOxrprK3OBjj61nafb7dueRXQ2sQ3Z7dhXLJ\ngWII9uB171ejjUjjmo44hjkc1bjj+XAGMViwGtHnB/ShVy56jAqTGOp/Olx19BQA1kBUcZxQseD0\nyKeMDNKMA4FAwAAA7Ypu0Enn8KeoAwO9NwAxoAibIHAz7CgAhSPTqal68rxTdu5Bg89aBEE8kNtb\nvNcSLHGi7ndugFfO3xK+I83iG9m0/TJymloduV480+p9q6L40+MHE8fhmyn2oAGumU8k9lrxkrjc\nCFzmu3D0ftSAiTYrruHHWkLkvjbjPpUmwtk8DFRyq0e18gV2ALlg+MAjvTHuAXICZOOlRq5mcog4\nPGatwW8dsrM+CfU0ARRQEsXl+6ei0s1ysS4QjHTio7u9zhVJ/CqJO4ii19wHSO8h579qiAy2KkVC\nzjHJ96nSPZjK8/yqrgVRGxyO4qQRYj+ap/K+fefX86tGE+UMAbutJsCh5ZwAQdo7VK1t6DIPatAW\nxYqSvzGrEdngoo/iPU0uYDKtbf8A0yLJxh1/nU+uQ7tbu8ZH71uPxq/FZhL5DgE+YOfxqbW7UDWr\nsvjc0rfhS5tQOcltyFVlyQajMWFznmtR7d12d1PJA61WkhO/bjGfSmmBQZeT2pMVbe2YMw9O9Q7C\nBhl79aq4EeeBxTalKYzk5pmD6UwEo60UGgBRzxTgwBUDmmDpSrnIAoAc2CSfegfKQe3pRnGeacpZ\nV3cc+tIAAZ39O+a1NC0+41bxBp+nwgtNNOq59s1mocuSefavWPgdoP2vxBda48eYrNPLiJ/56N/g\nKzqS5Ytge3TrsmEWAAoC/kMVWaIbTubr2q1OSZ3Dfezg1GwGAvXnAFeYBUEQChI+T3pZEZn2bx06\n1MyCPKdxwSKYqopbdn2xTAqsvGBjPSqU8SA7envWlL93KkFvWqFwvIbPAqkBg3luXG/jGelYF9bg\n5/nXWTowz7881hXsDsWIXitIsD0GzgztXFblvEF9MjpVO0iIwf1rWjQVzyYx6DOODU2GxTVG3rxU\no5BqAQ08DnmgDHNOIGc0Y5oHYackcce1GMtzxTuAKByaAE+6B3NNJJbGDUh5PIpMDbigY1sdK5nx\nt4mi8I+HJr/hp2+S3j9WrpyVAyxwF5Jr5h+J/i5vEnipxbvmxs8xRDPBPdq1o0+eRLOOu7ma+vZr\nq4cySzkuzuecmq8iNksn3DTZG3454HWmkrCg+civTSsIY7FN2TwPSoUWScjcTs6VGkiSOxkY49B3\npZbos/7v5UHanYCy0sNupjCiqkt1I54JPYU3y9x3OTg+nakEW1uTwPSnoBEc/ewakihMhGD+FSrE\nXOFrc0vRZZQrhCVz6UOVgM+O2J5KZPqKtR2DPyx4+ld3pngqWeNJHTaOuCtbA8FGNgSnynqKwdVA\neapYcqdmR14rQXTHlT/V5PpXoSeDUVP3gI9CKuw+F0Em9QSAOnaodVAedpo0jhcxlcc5FWU0eRZY\nzglcjgV6XHosOAEUbhV2PQYguVAzkc4qXWA8ibTdmogqPlV+/wBaj1m2P9rXW5fvSHtmvRpfC5iv\nCpIfMmf1rP1jQ1bVLjAwNx5pqomwPPbm1AghwmMrz+dURbAyheTk8V1+raWiQ2qqzEhCP1rLNmdy\noEAbPU1opaAc9c2bRySBl+73qo0RAAwK6C8gMd9OjHIDEdazpowZOeo54FWmBkSQ+Y43DtVWaDZn\nkfStVoycsTtU981UlQumc8jge9WmBmnrQRUsyng7cduKi6VYAPrilAyeBSD3pUGWGKAFAw3Tn3p2\nMntk0jtuk7U4ZbB7+1ICSOJmdUTLSNwoHrX1P4F8Of8ACM+FrCwORcNie4P+23+FePfB3wl/b3ix\ndQuUJsLAhzno8n8Ir6IYM14XbnDflzXDiql3yoCGc7rt1XsTk1AoyxKc44qxc5aZ+AQCeKjjTOcA\njPYVygQcOzHOB0561HtKjOetWDH821sioChRgeopgQOoSMgZyetRSRkY4BX2qzhdoO/B9KZIvmLh\nm2leTTAyriMBTg556VlXMW7Kjmt6UKEOSOe9ZMyBSRnirTA9CtkwBV9B7VXt0woq4gxWDLsPAoC4\nJpQKXAzQFhCKWlIFJigYmB3oz2oxzzS0CDvSDmnYpuQOvAHegZw3xU8T/wDCO+EpY4pQl5eZii55\nx/Ea+YxiM9CS345Ndr8TfE58ReL7jYd9paEwwgHjjqa4ncm8nnjpXo0IcsSGRFdgboGPUVnyTGVi\npwBnrU91MHbZFyP4qYqYjA8sccc9a3QiAoVkCnA9hUzQ7G4GBn86ljjDckc+9KQ+4DO5e1O4EDgb\nRjge3NTLCrKd2cntQUxGcAg1bs03SqGBLnpSYFrStO+0zRpgfMeK9m8O+FVMcKOihB8xIH3jXL+F\n9ISC+h85QWYZ+lez6VaJ5KY3Ko6Vx1qgEcWlxxbcLj2xViSwiKBiCQO1a6W2Acr16UjxnysYx256\n1yczAwzbRiJsD2pht1P3cD5cD0rTdVQFGPftUTpuIIGPfFO4GLG8azvH8pdP4c1ahbdOokA254Aq\npfacFuGuVTEzfKzjuKbDuE6gMc5AyasC1JEGuC6ABt1YWrxI97Pjj5j0rRuZZIbokyfIG6CqOqbf\nPmePk7jxREDltZsTstxs/hP86xJ4EABPPIHHWuq1C5RreBcAOVOfzrEuURmQgqWyMgVvFsDlNVgV\nNRmwuPmPU1k7RyxOM98V0Gswj7TcBc8P0rn50wcBieOlbR2Az54+Txx71WKMEyDj2q/Kvpn15qkW\nwzHIGO1aICjcKwXHHWqePxrRkXdzjnrg1QkXY5q0AwYp4bbnb3poPtQuNwzVAL1Pqatafp9xqWo2\n9laoXnncIi+5qrXv/wAHPA4020TxHqMOLuYf6MjD7if3vqayqVFCNwO98G+HbbwpodppkON6ndO4\nH3pD1Na8rj7Scg43Zp8ChrpWVurcg0r7EunBYg7q8ttt3YEMygtIw55PFMErJhsYzxT7jLzOByMm\noDuyHGAAO5oAR9xJfk5qN1LOBnn+VTZXAHaotjY+7hf1pgQEhmK9/aopGDAqQw+vepigB44I/Wo2\nIbOATxTAqsFK/N26Ed6zrlBg459605Yzjbt5qpPlVKsBj1qkB38K4FWlGKhiGBVgVnY0FFBoxS0W\nASiloosAlFLSYxRYArl/iFrLaF4K1C6RtszJ5UZ/2m4rqa8U+PeqHy9L0lXwCxnkGe3QVdOPNJIT\n2PE1VlJZvvnnnuarXMuwAcB26VdkP7sue3esdT59x5jdBxXpIglWPZjfgkntTjJvJDDDf0oGCOmd\ntKNu/JHNMBRtDYY5x3NOCgYYHkcjmnIvzAAZbGOaaVJ4H50gHBsKSMbq2dDjHno7kZ96x4UDKD3z\n0rStXIKKAA1Jge0+HrW2lVHBBIH3xXounxLGiZclcV5p4JgklhQbmwo6Hoa9PtYCFXjFedV3AvBu\ngBJPtSSbARv6+tOJZVbFVnORy2RjnNYgQy7FZircDviq5k+TgdakuEBj4bAFZlzc+XjBwKpK4Er7\nnO1h371B9mDTgqcbTTf7TVv94dqIbxPlZVPJ5qrMCndW/mXGe27rj3rL1QOl1NsYAhjxXUM8LyDP\nzNuwazNRsVN9MeCC3ftVJgcLqalRCzN85Xn86xppWyiqQDu6122t2gMMQCDOw8gc9a4q+tpBKn+y\neQK3g7gZWpyB7y5+Y53HpWLnI54NauoZS6lLZ3bzWXKNxOCBWyAoyqeV/WqkihCScVpSQgDjoecC\nqU8PzZVfqKtAZ0mGLH16ZqlcDBHy49TV+Zdg5XnPHtVa537QWxk9QKtAUs4FKB0pK6TwV4TvPF/i\nCDT7dWEW4NNJ2Re9U2krsDo/hX4DfxNqo1G9jP8AZVqwZ88ea3ZRX0ax2hViQRxgYUDoBUOlaLZa\nHpkWmWK7LeEbVHdj3JqzuCNjB4ry6tV1JXAIcC4QpknPX1p8sYa5Ysc7WpEw1zEcYb0pHwt2ctyz\n81kAyYqkzhV53HrUEuGJCgbferFwd8km3pvPNQMn8JUZB6k00AzCsCueabIykEE04ISpBwCOaicj\nOD1IpgRO6EDaee2aT5guSBzxUqxJjdk5zimzqN6jP/1qYFdn3AZ6jiqc67mO0fL71dK7F+bAzyCa\nqyIDyx4X0pgd9GKmFRoKlFKxoFFFFFgCijFGKdgCkpTRipAK+WPiRrI1zx3qUyOWht2EEef9mvpr\nWLo2Wi310v3oYHcfULXx0T50stzKTvlZnP4mumhHVsmRR1JzEhiAwW4xUEICoD2p04NxdFsn5eKG\n2qPmOF712LYkMZDfpUkfDIOp/WoTyMZJHTpU8Q2sCDkepoAsbemxfxqPadrYHFSFmAO3oe1OVJDj\njG6pAS3j3khRh8V1Gi+Fr++ImgTP1qz4T8Jz6zfIAMKMFjj71e/aT4cttPt0CpiQADpXPVrKOiAp\neD/Dp06wiSfmTHNdcIgMcdKdHHsUU4g7uK4m23dlWIWzzkcH0qtMqxx7i3403VNVtdJs5Lq9lWKO\nMdTXhHi34s6nqUjw6eFgtUJG4dWqqdOU3oSz1XU/FWj6d8tzdqGXqFOa4vUfHumXUm2ItgHgeteL\n3OoTyyF5GZy3JYmqz3r8tubePUV1xwyQHqNx4tdpmZCQoPGTV2w8YuJI0DruJGR+NePf2jMAP3hJ\nPXNWbTWPKmV3TzOc1boqwHt1v4tRr3YT8+/BFbF9qwkvJfn4V+RXg0XiGQ3yOu3e0g6fWr+peL7q\nDXbyF3+TzCKh0NdAPYZb+FrdJGwAynAP1rl768iml+RlI3Vxlx4rkvLWKIcBF5Ofes1danilDb8p\nnJFEaTQHQa4sbXszDIbeeKx1Az8o+uafd6gt3cPMDkZzj0zUAlAJ7H61olZAWHVeABn1HpWfOu3B\nU9qtNId5kUnGOlU5H8xvmXFUgKlxyo4y1VHTK/MmfTFW5twO7qoquZAeOhqkBn2lhPfajFY2sZkn\nmcIijqSa+r/AfhO28F6NDaRqGvJcPdS45Zv7v0Feb/A3w/bXF5qOvTRhpbZhFBuH3Sepr21f9cpH\nXdXJiqt3yIAkyJChwfmzmkf5gSMe9OuApuDxtwOaibB5BzXIA6Lm5Rc/NnqaGI+1jgZDYp0C/vk3\nDk81FKP3/AwC3agBk+FuHx/eOcVEyhtwB+7U86f6U4zlc1BJ8pwf/wBdNARvxjac/SmSgfKQO3T1\nqQo+Nw+XFRtuz82d3YimAzeEjGBk+1MVd4OcAj1p7R87lYH2qKJc7v7wz1qgIyA2QeccVA6ZGM4N\nWtvXNVpYuMk45poDvVp4pq08dKaNAooopgFFFFIBKKOc0UrAYni+YQ+EdUYnBNu6j8RXyIfktwcd\nK+qviLLs8JzRAEtMdgA69DXzFf6LqkEIJs7gRdclDXTQsrkMxjwCxPJqBVVmyxz6CnSHDBWyO5Bp\nyqiEEgkdq6hCn7pxxU9sApG4ZPrURXn2PepIwTkFvlHU0mBZU75fkYEZ6Cuv0zwlPqUdpNDHuVh8\n/tzXOaVYCWYNjgYJ+lfSfg/TLZNJsygwPL7isK1TkWgE/hTw3baVZxMifPjBNdaBxSRxpEuFAApx\nNcL1d2WlYMis7UtXt9PgLl1LdAuatzOoX7w54rgvFdvDMzwhypYcnNC1Ymzyn4h+JtU1zVWtZZCs\nCH5Ygflrivsczoytwfp1r1Oy8IW6TmaVt4Jzk81r3tloz2rI9vGuxPvHg12KooqyJPB5YpU3ADj1\nquY5nPOT9K6/ULSxhu5HjcNH2ArMkltgG2KF9BW6kBz5t5N+3aWpm3y/lYfWtiW4h8zKcECqrPBK\n4Z8HJ6GquBUtfmvoSjYy46/WruurnXLstyfOYVLBDE9zGVT/AJaADHbmrus2gfWrxAR/rWNK+oGL\nDIFdRnCjoKWeT58/w9Dmrzae4Csy/MRxVX7I7yfMvA7Y607oBsc7MrKDhavRyhNm49Rzmo1sSsrM\nqH2FQ3LPGwLYTPHrS3AsyXzrkYJHrUP23zWz0qmZARjcSKqmXDDPQd6dgNR7sGPC1DHcq27PJ6Vn\nCQ9uKTeRgg45p2A94+BWphRqmktICzETKP517LFhZQTyc18g+F/Ec3hzX7XUonI2PhwO696+t9Pu\nob+ytryOXcs6q6kehrz8TC0ubuBYvF/elu+OlVj93BP5VZutzTdR04qPHpjNc6AajN5iH3GaGRln\nbI6NT4yWmRCvQ4plw227ZR60ALcJtmduvzcgVDOAVDdB2p9y4WSTPRm5FRlssuPxFMBhi6gk+tQE\nnK7RxjBqdpBgr1PTNR4C55yvtTAj2qOCcA9Ki8oLncS2O4p8ZXf0yvvRI55VR+VMCJmxnj6e1V3K\nn7496sNllAHPNRS4x0yPSmB269KeOlMWnjpVmgUUUUAFFFFACZ5ooKg1zHjrxF/wjfhm4u0I89hs\ni/3jSfkI0dU1XR7R401C4gDjLIjHJ474rDh8SeGfEe61ibOfl+aLANcJ4F8KXGuzwa1qkzyPKGPz\nHNepad4asLCLakKA+uKU0k7dSdzxj4ifD6Kz87UrSJRCq7jsryFYpOVKHHavqjxHeW8F3FZyxrJb\nzNsINec+LPhgHuHutLYoW5MZ6V0Ua1laQjxoxlXx0b0q9b2+5HHZsVPc6XLaXbLIo3q23OafZK8b\nTFjhiOPzrpbuB1fhzTzJPHtzjjNe/wCgKsdhAgOBivGfBSu7gLk56k17vpcSiwgymCFrhxD1sNF4\ne9IwBz2pcZxSY75rnKMjUZdkZOOB3Fcfq86LEXkbP92u5u0UkjHB61zeqaNFcxuWGOOlVBpEHk+r\neLLmFnhtEJIrlptUlubgCeSWe4kPEaH5RXoF14NN3eP5h8q3HTZ1ao5vAqafNHead88ychH711xn\nBAcqvgTWL6OV4hCpWLzNq5/L61w9zHEbUusr/aVdldD04r6Qh8X2lptgvbFrV9m19q5X3rwfxjpV\ntDr9zPYTLLb3DmQKv8NXSm27SA5EGTf7+lW1ifaCcf4Uq2oDqf4j1NWiSCEVRXQ2BJppJuolGd29\nTgfWuiv7Yy61dKWCkynrWLYBFvITjq45/Gu6sbOO88R3CugO2Ukn8ayk7O4Fm18Ktf2trtAGU/rW\nrD8MZJZVfkLn0r0jSdOhis7X5ABs9OldFaRKgznNccq0ugHjmv8Aw8TT7eSZSxfNeOavbeRcSI55\nz0Ir691m2SezkXAJIOPrXzR44sDBqE/7vac9RWtCo27MDgJjyVPyjqM1C0ZIXbzUjB3faOq0Rnbn\nPQV2gRiFskAZakdcNt5Jq0rqDuHUU8o0is4UZouBRA6CvoH4E+Ibi/0250edt62ZDR+u09q8E8pg\nQMD2r3T4B2H2Sz1O8ljYGVlVGI+8KwxNvZu4Hs1wA0vT+HsarDr14zVm4jXzMDqRUOwck8CvNAWE\n/vkIbJ3YpLhczuRwd2afCqvMrKuBnrUcrbrxuD97HNACTgC5fG1iT+VMWJwuW5p11tFwzbeA3Wos\nkc87aYDXCMrEdd1NY9AT+A704hgWyfemLl/uY9+KYELxjkjjntTSxGA/K+1SzHI+c4HtUI3KwHUY\npgMeUqm1eF65FRTOr4wPm7CpG4wU+7396rzMFHzZBFNAdypqUVCh4qUVZoLRRRQAUUUUAJXkfxql\nMqaXp44Mr5zXruK8m+LlszarolwThEl2k/jVRtzIlnceGbJLPRdPjT+GLB+tbVw5jhJqjpWDBBsY\nlfLrJ8S+KLbRwwlZfl7Z5NYWbYuhQutNmvr8TNHkqeDWpc4utN+cYflSK8l1r4t36Zh01EQn+Mjm\num8Aarc6r4dU6lI8lz57Hex7GtJU5JXYjhfFfh1tO1Gd2RWSRTt9jXIaZCZJJUfkDaPpzXsHxG0K\nSON9TkmlUKu1AnSvL/DcBuJp4+hLLlj2+aumnK8Lgej+CtGf7erEbMgYx3r2WKPZEijoBiuJ8LW/\nkXCquNoQdK7tc7RmuWb5pDiGMCo5GCjJ6VJUE0ZYj2rORT2M+/udjn0rntSvptuQ/wAp7V0slvvd\nw69/SsS/0tnU/JnvTjYgxbeQyHcx5B6VdiuFijbcitn3qvNbtCoCAf7XqKgEThgqtgdRmr3AxtfK\nTbio+6OuM5rzPVrJWJZITgdsda9Sv90cmHUNnrxxWHeQRTgqQoP5YrenKwHlU1o6kjYQfpT4LMmV\nEQfeOMGusudO3ziOMDrmtjSvDJa7Rn4G8cYrZ1EkBy2l6DPd6hEnlceYPw5r17S/DEdvqMsrqWLu\nfwq3pOkW1rMNiDduyDiup+yYuGJ5yxIrlqVWwH2kBWJArcKOBWnEuBk5zUSx7FVAARVroK5xop3q\nbgyjI3d68X+IemZV22568+te23Cqed3I5rgfHGn/AGrT22DDHJrSlK0gZ8x3FuIb0q6n2FVZipLj\nBUqegrd163Mc7rjLIetYJi3k7Tl+9epF3EQjg8MaswuQ2NzHPNMjRcZbhhxilhUq7dB9apga2j6Z\nNq+rW1lCvzyOB+FfVmgaVDoml2tjAmEjUKx9+9eXfBjw1izOu3KAlyVi+leyqC0iDB2mvOxNS75V\n0AfcELKR0G2oiw24JFSXLfvscBQB+NV+2Qcc1zIB8QkMyfNhe4psuTeEr82H5FEbv9oTauTmnTKz\nz7twTJ7UwGXXz3DKOefyqOX5hheQDwKmnwbtvnzzz7VFngjGR9MUAQOGGBu5PUUiMY+nANTbU6sM\nr0z3qLhMgAbf4c0wAx5Xj1xVZmzI5/hX5eanbAO4Nx9ahlTI4U4z1poBmcewHSqs7sR8wGR0NTE7\nsADGO5qGQp5hB/nVAdvGeKmFVojxVgGnc0H0UlLRcAooopgFcV8SNKF/oImBw0Dh8/jXa1S1OzW/\n0+a2ZQwdcYpXsJlTQ2QaHBMrbh5QOfwr5z8Z+IZtU1y5V22orsBivf8ARZxaWv8AZEw2yojbQe61\n84+JrB7bxRcwngGYnOPU1pQtzMkraJpb3+orGF3L1JPavePAmjrYiPzSCpzsFcx4R0azsrWOdim4\njLlhW2/iW3HibS7O2bbbK5Lv2NFSTk7IR1ni64tU0a7S4QFVjLcivnHTrlrWa7KDaZmAXt/F1r1H\n4m6yb27/ALMtWdYgm+4fGAR2Ga8o8yIzzOScoBtzz+VVRjaIM9s8FaiiP5cswfPGa9HG2SMYPB9K\n+d/CN/KNSjV2wnX0r3axux9lgJbjZnFYVY8rGmatGBTI5BIgYAjPY07PrWZY07S/I5FV5EZ84XgV\nYbjJFRl8qApBNIhmNNaJJk4APqKx7+zaJsnIA711kiqCcHnrisXUlkuJQBH8veqixHF6jKqSYHzA\n1zEnmTzOhH0JrvrnSow5dVOe1c/fRQwlnYKCO9bRkBgwBoHV3Xdt7Yres7oGZHA8vDAHntWHdXW0\nZwCD6VBb6gTdRhjk7h/OtGrgd/a3rC5wpB/eYrtY87mYfez+VeZ6PdeZqDbyMb8V6F9rihmJLAtn\nGK5pqzA1Aw2jdwaje4EbYLDGcVnTzrJG5Mm09aiglR5B85JzgVFgLF3dpGzsScfxCuX15/7QtHVD\njC5reuYC7Ou0nJ6k1l3UCW0D7l5PTNXGwHz34jtts8gYDrziuW2eVLgdCO1eleNbWMXrPCMA9R6V\n5/OoEgwARmvRpu6AplcFtyncTTjGdjbsip0UtKQ3X1FOVMMV5aruB9ReBLeNPA2kpAEwIBk9810S\nEo43dq4T4X3El54UR3Yho/3YHbAru1Dbkz64zXl1FaTALpcykgjGBUEqqEzyAO4qe7JWVVBJNQSK\n4YDkA9SahASW7bpkA6HrSuqm65OGVuPeo4wROoXkhsZpsjub4ZBBD4+tMB0+PPkI67qC6kHPQiku\nC/2h1Xhc8kjpUBPG5SQAfmxQA/GE65GOKilUdB0xSODHsHt1qMDY+R82e1MCEkr8vSpQSuctyRTX\nLEEEHH5VXeXypPduAPSqAnUofmI3djVC4+YtgY9Ksu20gEZHXINVZgMl+lNAdpC3FW1NZ8D5FXkN\nI0JaWmilpoAooooAKD0opKVwMTV9OZ7yHUIOJYVbj+9x0rzrXvDdt4vxNGRa3qnn616/tB681zmu\nWMNhC93BGFfqxoi2ndEtHmv/AAhWvwWLxC9Vz7d6NG09NIHmarHIso3KuRx1611+neIbeSPbuBkz\n+NaGsRreWEL+SsjdeRVub2ZJwmt30GoaRc2lvtfOOTyTXldyoiu2hVQuzrnua9j8Z2seleE7q8jR\nYJiFAGOteLSJLOyzSP8AePLVvR20A0o9QkjMLKMGM8kd69s8Ka01zp9nJIuCY/z5rwSWVUxGi/Lj\nmu38P+KBZizgkJ2tHjj60VYcyA97trvePmNSSyk4KNxXL6Zq6kopHGMitVtQQptXB7E5ricWguX5\nbxUm8vk5pinaxO7D1myTBblmLY5q3FL8ykd/WlYCzIRjex+b0qor5RuDn0p0jbn7jNQyPtYENgdK\nAM++Jj3OCVB6j1rir8eax6YFdTqd6BKU3dO3rXH6pOsQZlcY6kDrW9MDntQOzeFKrWNHck3kO44H\nmAHFPv7gzM+3OTWXG8kd0mT/ABjg10xWgHXadrX2G+2A7h5vX8a62DVby61C4bPyhyEX1FeVWzPc\naukRcLiUd/evdNH0NPOZ3/vbuayqpRApCW6LFZGw5/LFatg2ZAgHI6mtN7S1tzul2jr171j3Gtad\np84/epgnp6Vhe+wHSJbb5XO7A5zmuf16Pb+7X58c1jXXjiL7dNbQTDeTgYqK910fZd8mCcdc0KDT\nA4fxgiS42MOP1rzK56sOhBrs/EurC5ZygH0zXDyyK74OT3OK76asgEjBCneMZ75qRcsODz3pvmDG\n2jO0jrx3rQD3H4MXrvpV3CzZEb/LXqUcuSij+93ryD4IyhrfUkfJG4EGvWQVEynfwD1Irzay99gT\nXTsJh3xUTthSwbcakm+/uCjJHWojyrkkBhxgVkAltIxuFyeM5I9KY3/H4W+8S/FEYLTxFjgE4psg\nH2pin3g3HPFUBJcSOk8vG4bugqAyKuRj5vSnXMubqTac4PIFQlC7ZX6GhAMLOxP8QXimxNjtz34p\nGDEkhsLTslYzmmA7ccH+RqnPuLjoF7VYMjBMY/OqrkmT58DFNAIoyGUZOfWorjAXH5c04tsY7T16\n4qncMxAwflpgdlavkCtKNuKwrOXgVrwvnFJmhdU06o1PFPBqbgLRSUtO+oCUUGm5qQHd6q6hEJrN\n0ZQwI6GrC5zyaUgMCD0pvYTPOYPCKW948sbk/NlR6VsvBNbwRrI/c1paxt022+0oGIB2kD3qhrCX\n408OkHmbl4xTu3uQeY/FnV/O06DT0bq+XGc15abgqkcYIKoO3rW34rgvzqTm4R03N0eucEEjBnYf\nKO1d9OKUbAK0xd+/HU1p2141u8UuQxA+Uf3ayWDeYSFA4q5C8bIgwVdRyT3q2B3WieJLm5vY0Z9u\n75WOeAK7m31cI8KjBUPjNeIJdNBMvlHn2rp9J1eQIqzO2GPBB6VhOmmB7K87PdSDzF9Qp71bWZ1c\nFsZ6Y9K4Kw1mV5suNxVuprqNPv1uUWUOHYnp6GueUbAdVFJsj35yKzL66VkJKsBn8af9pQKEU5f2\n7VlajJOkwXb8pP51mkBzmp3BhvCV3Eda5fWJJbhvNU7R3xXX6tbSDaT8uP1rAv8AT3a3wqn15710\nQaA4mV2YMWOMH86qw7zeJxuO4AA1p3tp5TMFBx/Wq2nwOb6FsZ+cZrovoA23RYdcjeRSF80E5+te\n533ia10ezdpHC8ZBFeUSWKyXnQL+95/OsvxVLeLf3ELSGSJXbHNZyiptAS+JviXf3N4yW0jhewHp\nXJvruq3Mhd5DuJ7mkt7eKWUu2EPrViZYIpNqAHHzc962UYx0SAdYapfWl6JHw53ZbPetzUPELvbB\nA23PauZaUby2NpzkAdqpXF3KxKnAxRypsCze3JeVvmwAM/WqCEOWOBmmRllO9yT7ZqbIDHsG7Vdr\nAKhLEhsf7J7VIrKpO8jI7Z4NRbgcbMjHXNAG9Au3nsaAPb/gpAU0e8uAgHmS9a9PKsQfzri/hrY/\n2b4ZhVlOXG412QcBSeRznmvNqu82wLMy4ZTu/hGRVYMAzcgVLMW2I3BOB1qqybT2ORWaAsRRr5ke\nR82ailjH2kknHzdKWB3juIxuU84BNNnkzPjHO+mATqouZD33U0DeoYEZP60y8ZvtEu096jinY7SB\nnHFMCd4wBhuSeoHaoJPmHyjKVYeVdu5UxkVWkIYKM49gaEAirtxyGb0NVJG+YkdR2NOfLs/X5ars\n3JCrzjmqAQs/mE5+tVLlgcnjjtUskwQ/ODyKybi4IZu4NUkB1lhNnFb1vJmuO0+44XmuktJcgVEk\nWjdjbIqUc1TifIFWlNQMkozzTc/NTqQCZzSGijpTQhoLZ6Cnc4zSHnnPFBHHPIpMCjrLRLp0jS8o\nBkinWsyX2jwzRco8YK5qvrsckumTKqgkoQB+FU/A0jv4Qs1kBEkYZGB7EGqS0F1PJfipbFtRgiIw\nRl8+1ef3TwQ2qJGwMrckDoor3D4iadHc+YzookePYGP8I9a8AngeOdo9+5V6muyg7xJIl3tkn7p7\nirU0CRrAwkzuXn86qIAXKpkd85q3J5SLCiyYOOSR71uwIETErHqAcZrRt5ZPvjGN2MVAVREO05yc\nKakkUIvyGkwNeHWWgmkBY7t3Sus0TXUEifvAG64HrXmzyMkjMvNSWFzO10mw4PpUSgmB71pOppJa\nvK5AcSc1rXTpdxLJAwbB7141Ya8eAj7WDfOC3Brdh8U+W8cU0vb+HtXPKk76Advd/vWRpsCqF9be\nXa+Y/I68elc7N4mijUSSSZGflFV7zxgp01hjLNxjPQUKDAxta1K2Z/LiUEk81lR3sdvcRFBzuBOa\nxb++3TPIvGayzeSSPgP+NdShoB1UuuN9uzkZd8Y/GmazqSm+vUON4kP865mGNvt8b7iTvU81p6zb\nvJql0VHPmtRypMDHubuQb0A+YHNV1uWKjec5q99iknPKfNUS2LRoB3PBrTQCNJg7cjjPWobkpI+c\n/KO9AgmhmdWz9DUco/dlMYJ9KYEayIQ230qyeF4JJx1qgMo2COlWo51zggZ6U2BOQdobJyewq5p6\nB7+GOUqqbgS5/hqrvZV+9nHerWmPGt6hkwyMRuGKl7AfTOgsG0eBkO7KgAr3rR83dgEd+lZGjFJt\nPgaA7Igg+6MVrSRYj3h+RXmPcCeV/nVfbmo2AkXjgjkc9aquzrIoAzhR+NSJJ8uDw2aVgJoQXlj2\nAEq1R3TZvBuO356WOUx3A7Lnt3qK5Lm5Ocbd3egB11gXkmefmqtM+1/l4OegqacgXMhOMhu9QuXZ\nsgjNNAOM21QzfxdBTJ7lNnHb0FQyZDD5+o6CmFMKdzZJpgRrLnPzEHtmopHxIccYp04jEKgA7qrS\nsqjc/OewpoCOe4G09/TNYd5KePnwD2q7cTKqnNYt1MA3XNaRQHQaZdfd5rqrG5zjmvOtMu87ea63\nT7oYBzUzQ7na2025RWhG/pXP21wNoNasMwYdawY7miDmgGoFftUoPWkFxxPy0gyRzQDmg/lQgFZQ\ny4pc4HNNYnoD+dNxgZ70MBtwA0bAjjHWq2jRJbacVQfLuY/rUzMTkE9RxmpbaNUg2gYoTBbnmXxU\nu2GkERKcs2CR1xXi2rWz2zRwyKA0kYk4PrXu/wAStGW50iWSOVkdAXznivBJ5HTJm/eSsoXLdVrt\nw/wkmeqsp+7yeKsTwkpFlccZNVzceS21FyaVZ2bCbyD/AJ4roAtbk+VXfFPVApjTPHc1FDsmkAzt\n2mpCUMmzc26kwHXMXlvtPFRQxyvdJghefvdKsXEi7lXdk5yaRnMjD8qAK4jZncjt3z1qcCR5Au9j\ngZzmqJJWRnX5RnoantjLPMNrYH97pQBJczzmMqXyFqu9y62wRSScVL5bSs3Hyjqc1ZCJFz8uaAMY\nwSSFWdiuamtreIOqYG4tjNSzOWl2DHrxVXzzG6vg789KYGxaWlv9sRZGCjzBg/jWxrl7apezwQoD\nIJD8+K5GK5Z7yJtrH96OPxq7q0k0OsXReJ8GRsHHvUtagSTOwc8j7vIFVomjkkG44B61TNywZiyt\n0xmmvdADGDVWAsXm0XUm0ZXcRn2qjIBG+0kH3FSS3W9yMjc1VHf95zwe1UkBDMilsqSB61Bja2Qc\n4q2PvFcjNROFLHKjOKoCaI74whH4itDR4Xub+KOMbndgqAdzWNFI6vivRPhZpf27xDGT8qwEyZ96\nib5U2B7T4ct5LPTLeCXPmBMPmtV5MrtXt2qHb5aBucY5qvJKwk554rzXq7gWJ3/0gb8jgdKazqW4\n/EVDLOCUyccDrTWeNSGTkdDQBcgKtcIQwxuHekuv+Pxyp/j6VTyY2wvHekmlc3fP3lbpRYCe7I+1\nSryTmoTNjbjrjmi4k2XczZ4Y1XLhlJHXPSmA9WZiCR8x/WmSDAOOtND42FxzSSSZOF4P96mBGzpG\nuC3IqjdTEKTjI60+5ldVYjBP86zJrsmPkdqpICvc3CGIjPJrnrq7AyMcirN5Mck8isG7mO4nORW0\nYgaOnXeMc11+nXmdvNea2F1jHNdVp9505pziB6VZXWQuDxW7bTqelcJp94Cq/PXS2V4GHv2rllED\np0bcQe9TrLiTkn6VkpP8vXFXI5dw5JFZMC6W7ilDde9Qo3YfnSjKL1z9aBk2W24zTTu27ifypiux\nAIP5UkjMOTQFxZSu3fU1ucwjPNVyqFRnIB9TUtrtEPykkZ70AtzH8SwrcWE0OFYMmDur5l8V2b2m\nrNEZEPy5+Svp/USJFkKoG9vWvnfx3bIfEUo2FAozg966cM9bCONyoYbiAAKc23ahDdu1NlQbwCgy\nO5oJiTHIBxXYBMgZP4uTVuFQ3zOSPf1qixUyfK3X0q3DJxsbkjvQwFlkQklcg989qjF6A4Ef3s8m\nq8jP5pD5C+lJFDuK8dTRYCWZzJz29qktsFlTNN2LGgAOD3OKVLpEb92BuzyaAFgQrcEjdtz0Jqed\nvm2YyTSRkn5yMemO9EbJJeKHPGaQFrStCm1GbYFKhT8zV2knw6jntEkhYiUY7VS0vVLLTzhmAPSu\nks/FsJmihVxjIwBWM5SvoByFl4baz1IQ3MXPmdcdea29c0yI30ilQx3H8K173WbeS9Bk2B9/B/Gu\nc8Q3udTuDHPghjSTk2Bj6pptrHZg4USHqa5aW3XzA20Htj1rTurt5G2OxOKzJZCZRngDsK2jdAQy\n2CfOq5yG59aoyWbo5ySPethpsbwBjJqpNIGb5x0FWmwMtlKruck4Pak27hkHjrzU8jb1JwBUDMQu\n3GSaoBI0GQejZ6V7f8MNLSwsZLx0bfL0b2rxzTLWS+1SG2VSxYjgdq+mdHtEtNKt4VRfljCnisMR\nKysBc83zBgKcHvUU5VTjdkVOAqoQvGKrzphckACuMBZBjjqdoxTGKqq89OoFI7ATDPHyDGagbcNx\n6selMCQTK6huchsCnTMDdF+nz9DVcfeXaMnNPuFL3WV4+b8qQC3UgS8lTbkbic1GZtwACnGKmuyP\ntEnzAYbNUpp9vyjk9eKaAlkkA2tt496je4LISxHI61WeUsrZ7djVNpwD1+XoRTSAZNd8YPGKyrq4\nB/iAIp93ISWrBvbkBjW0YgNvLrggtmsC7uRzipricHJzmsa5nBJraKAks7jBHNdHYXeMc1xNvNgi\ntqzuduOaqUQPRdPvAVXNdPY3ZyvNebWN7jb81dRYXxyDu4rmnED0O3uhsHOSa14Jgcc81xdre7j1\n4rftbpdvynnHeueUQN+Jyuc9PWnLcbmIJ4FZ9tMSB83erSOrSHH51nsBdyAgP8qjdiygHk0b8xYF\nQtLhdvXNAEhQFSTyBVpFK2424Bqi0v7rjH41dgbMAOaQGTeyiIqAMg9+9eO/EvTPtN7FMgfODvkA\n6CvYrwBmYHG761z2rW8VzBsdMgrjmtqcuV3A+dntSVLbs4OOaqsmHGQF/Cut8Q+Gns7o+U2FJJ4r\nmpohE6c5+Xn2rvjJNAQiSNZeCOtPiCl8g4HWnxxByX6AHtRHgMVGNvSmAOFlUsO1RWy/vcLuPofS\nngoskgXoOKURiMiQnjPagBoV3LFvu+lOgtd+1iMLmp0LLEcKDnvV22URwF36npSuBUkURABf0qLO\n1dxODTrhiz5A71RujIvCnAIpoCSS7LMT1561Lb3jrNGcnhs8Vj73ZcdKfHLyB3FVygdANWKXqHzS\nSZe/1qPXtSc6pdgvjbKf51kqcXMbAbvnGfzo112bWLvHTzTU8quANqRJJ55HfvVV9Q3OCc1TYgSY\nJBpjjB4rRJAaTXyP90kHPANI8pZeeBjNZ7FgxORU0cgPzE5b3osBLkFTzxTWfDBQRTOWUjAGDnrT\nlMhfcVByeuKAO9+FelSXXihrwkCOFOQe9e6pEBxyB2rg/hXp6R6D9pkh2yyOQSe4r0B3YHHYCvPr\nSvMCs5KsGXlarzJhWOSx6ip5GDjb078VWkDOVPmYXpWYDp23bRtBbYKYMMuCMVPcEKygjnaOR3qq\npDEPuxt6g0AKQ8SjK8eop8+z7SX5HPWmNMkkuCSRnpSXIY3Df7LUwKt/KGvp+CDn0qEMHcqQOB1q\nfUCftL4wDurLmuUViAPm9apK4DriTaCPu4rKu7hV+62AP1p11O46nOaw7664LZrSMQHXN56t1rn7\n2cdelFxdbgSDg1j3Nwc/e5reMQFuJuOtZc0uTTpp6oyyZNapAEUmK0becg1jq2KsxS4ptAdTaXWN\nvNdHY3uCPmrhbe4xjmtq0u+nNZSiB6JZ3/zAbuK6SxvicV5vZXmWHPFdLYX4LDk4Fc8oAeg2t2Np\nLcelXoZt7ZZsVyFrfAqeRWpBe/dJI+lYOIHStORtC8D1pDv69qzI5vNCEHp1FaJuo2AB4qGgJG+7\nkHd7VpROREoIxWTGVaTC5q+8nlou7r2qWBSvVGWIKg+tYV1N5YJxkHjNbFzPkspAPvWVcxeZGQfq\nKuIHFeJLGS5gd4RuYHgGvNPEUTW8luxVAXj+YD6mvbby0/c7hkV5r440h5NkgT5Qnb6100pa2A4J\nZsDCNz3GOKVpFEoDEYOM4qB4Sjg4IHTFIu15AeSK6gJZpgt1JtXgnFPSUFQuMZqrcqqysQc55FRx\nyOG+bgUWA3UZkQbWB3VOZMrtdflX9ax/OBO7p7VOLjPqSPek0Bc4mYhRgepqhcgbm3YZf9mpWnwi\ngZ59KrSkMxLHGRQgKEpTzM+npUSr+8LbsU+5Zd/ydPXFV0+8CeKsDQhlCzwjr8w/nS65zrV3tyB5\nrVSt2xeRf9dAP1qfXT/xO7puR+9b+dFtQKBAB29u5pCFONp6djQc53d/em5+Y56HvVAH8f409H2H\n7oPPWmNgEjrSD60AWVV3J4xz+FekeCPB6aiqXd0u9N3C44rhNCtmutQhgAJMjhcV9K6Lp8enWaW0\naAIi4z61z158qsgLdvbQ2kCxQrsCjGBTvMBLfxehqQqpzjIB9agZ8OVCba4gF80Hk9McVXkGxxg5\nB5pdyAFWzjPOKWT7wxgr60wGFQ+SM4qJotvIbnrTixGOfwodSSuWwfSgBgGcN09qW4dRKQ2Bg5Pv\nVSSQhtpbIFRXU26Q84Ge3emkAajMfPk24HzHmsKeTH3zj3q5qM2yaXkn5q5+9u88ZNaRQBd3XHB7\ndawry4JbBpbi74KGse5uvvVvGIDLuUtnk1kTueualmnJPNUZpM1qkBE75qBmzSs1Rk1YCA1Kj4qE\nU4GgC9FLitC3uMEDNYqPirMUuKTQHV2t5gjmt2yvvm5PFcPBc471rWt5yBmspRA9CtL/AOZRnArc\nguwy5D151bX3KnPSt+01HG1s81i4Aeh2V1hOTVuO6AZckfjXF22rHIGasnVHkZQKxcQO1TUYPtEa\nR5Lk84rUuZCdpHI9a5HRXBfzTya3pLpfL2lgfes3HUAlYNyD7iqzsBywqOSUxqCTwah8zj1B9e1O\nwEjEYw3SsjWtIj1G1aPowXg1otIBuGc1C82NpZsU1oB4p4h0eaxlIkXjOMgVzDMikqOCK9s8RwwX\n9m42DeOhxXjmq2TwTsSpG04zXZTlzLUDML5lLnOFpd6EZXt3qOUZQjkEUwl1j2+tbAWA58ofNipC\n6gKB1J6k1SQHbyenQU8TgtjZnFAF+R1Bxkn6UySVWX8KrvP5gIUfL6momYtkZwMcUrAI3GQDUe7Y\n3972NMZ2C4GRSbgX5y1VYCxFg3cL5/jU/rU+ssW1i8HbzjVODi5ix03jr9as6xn+2Lzt+9NHUCi5\nJ47UnUUMc0naqAXpnmkzzSsR6Ug60Aeg/C7S1vNX89x8sXJYjha94t8xxYdgwPTFeffC7RZrTww0\nzkRyTvnBHO2vQ0Hkxqvp+tedWlebAVn9+KpyqeXyc+tSP80vK8e1I+W4PHc1kBVjcOzA5+lKW4GC\ncilm2o2QckjsageQnjgEUwJHlwxLZ9KrSS7flXP1NV5ZSTjjIqCWfauWOPQmqSAJ5dsnOcVTvpx5\n5IOKr3N02fvZz3FZN5cuZydwzmtFECbUbzdPKMnhjWBdXOQeaW/umEz896yLq6z0NaxiAy4nyTzW\nXPOOaJ5utZ80uTWyQBJJ71Wd6HaoiasAJppNBNJTAKXNJRQA4GpFaoqUHFIC5HLirsNztxWSrYqZ\nJMUrAdBDeHjmte0vyB96uSjmxV6G5IxzUOIHaWV+TIOa1be83OOa4u0usN1rWtLoetZSiB6Vpd55\ncJw2BWot6pAy1cLZajhBWmt/vUfzrBw1A6b7YZDjOTTTOWDAnAFYcV4AeTzTjeDf972xU8oGrPdq\niHbycdazZLnLLvb3qtJOz8KcD1qKQCNE3N261SiATT74wp6Zz1rEvdNt7piSgIJ9KvOcydflNMIY\nDB4GataAcBrnh9IJXaFTjdnAFc7LEUBzkjuDXsD2ENzuV1yCK4vX9Fkt23xx5RuOK2hPowOK27WB\nQmgHk/Kc1dubWQN0x61UeLY3f3Jra4EbPt4GcUblAY5+btmmyKAiktk56U0HJDHkUwFdiwz09qYB\nzxTmwW4Py01Ths0wJIMm4iBP8Q/nVrWSf7Zu8/8APVqqQsftCf7w/nVrVsHV7s/9NG/nS6gUaD1o\nJJ79KOhpgLgmrukW32nVbeJoy6lxuA9KrxxMQGHSu8+G2km41Oe8li3RoAqZ7NmonLlTYHr9vdRW\n3k20cbAFVC4HCjFafn72K7hUBYYXKAEVWadBIenHpXm7gX3dSMAnIqAyBVzvyfeqJv8AYWG4E1G1\n8FUg49qdgLU0qE8cHHNZ80wxlDyPWq0l2CPv1nTXxTgGqUQLUtyAuSf/AK9Z11eArt3fNVW5vtwP\nNZM93gk7q1UQLk18doB6isu8vP3rHPeqlxd/Nwazbm6y5zWiiBPe3W6ViDWVPcUy4nJY81RklzWq\nQDpZSaqu+aGfNRE1YATTTQTSUwCiiigAooooAKWkooAdmnBqjpaQFhXqxHLiqIapFegDXguMEVp2\n93tNc5HLjpVqO4xjmpaA7C2vzjritKK/+Uc1xcV2R3q7FedMms3EDtI78HvU4vMHO7PvXIx3uO9X\nEvvlFZuAHSJeMRjfU811GYlGc/L0PeuYW8PXNSS3vCDdnI60uUDZEyHC8D0p7uQeuRXPi68zlT0q\n5bXZQKrncM0coGysoXr+VEjRTQlGhDDtVWRg7HAwKakzIrCpsBzus6SWJeJAK5mexfaxYfMOtd3c\n3AbjGcDODWHesjKV2ct6VtFsDjGtic+1QuhGOgJroJ0QfKFx61QmjCfNjpWiYGWVI7c0KAWz6VO7\nEckfWhF+cdDmqAjtwftERxwWH86n1cf8Te7/AOurUxVIni7KHH86sapH/wATS5JOCZDgUX1AzwpY\n9KckeXAHPNTZZBtHQ+lNGcsc4p3A3NHuNPt5it9b+YjccH7tep6PruiQWaRWUsceeq9DXifmAg88\n1JHO8YBU4waynTUgPoA6/ZyAAXUfA6E1Xk1S1fftmjBPvXj1hrPlHZcp5g9c81spNZ3K7oX5PbNY\n+xsB6A95CANsyMfrVOS+QlsSDH1riHgTb/rXB+tVPLMbtsmf86apoDuBfDdwwPHrWdc6hyfmNcp8\n4fInccetU3MwbP2hqtUwOjmveTms2e9rHknmGcyk1WeaY/x1aiBozXWe9U5Z8vVNpn7mo2kYnJq7\nATyS5Y1AzUxnOaaSaYCk00mjNJTAKKKKACiiigD/2Q==', 'robotica');
INSERT INTO `miembros` (`idMiembro`, `nombre`, `apellido`, `cedula`, `clave`, `sexo`, `correo`, `telefono`, `cargo`, `imagen`, `areaInteres`) VALUES
(9, 'Delyuri', 'Guzman', '1234568', 'e10adc3949ba59abbe56e057f20f883e', 'Femenino', 'deisyuris@hotmail.com', '04261234567', 'Miembro', '/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAGLAVwDASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDJooor\r\n7Q/PAooooAKKKKQBRRRQAYooFPeORFV2RlDcqWUgN9PWlfuOzGUUYJOACT7CincLMKKOtJii4WFo\r\no6UrKy4LKygjI3LjI9aV1sFnuJRSA+lLTAKMUVYjsLuazlu47d2t4jiSQDgGlKSjuxqLeyK9FFFO\r\n4rMKMUUZouFmFFFFFwCiiii4WYUUlLii4BRS7WKFtp2g43Y4z6ZpKLhZhRSGlHPSi4BRTtjhAxVg\r\nrEgMV4JHXBpo56YpXCzCikPHWgcjI6U7gLRRRTEFFFFABUkf3fxqOpI/u/jUsCOiiiqAKKKKACii\r\nigAoopM0mBe0u2W6vDG8LSosTyMA+zaACdxPoP16V0VraW19omnG7jknW3064nVVlK8rIawdOv4L\r\n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', 'informatica');
INSERT INTO `miembros` (`idMiembro`, `nombre`, `apellido`, `cedula`, `clave`, `sexo`, `correo`, `telefono`, `cargo`, `imagen`, `areaInteres`) VALUES
(10, 'Roiner', 'Hernandez', '1234569', 'e10adc3949ba59abbe56e057f20f883e', 'Masculino', 'roiner@gmail.com', '04141234567', 'CoordinadorGeneral', '/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAFPAcIDASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDk/wDh\r\nTLEZ/t4f+An/ANnTx8Fif+Y+P/AP/wCzr1VVO0YAPHApUaQ+WdgGWxIM9K35EK55WPgmx/5j4/8A\r\nAP8A+zp//Cj2z/yMI/8AAP8A+zr1wDOB71JghRyM5GeO1HIgueQj4Gsf+ZhH/gF/9spw+BTH/mYh\r\n/wCAX/2yvYUDeYRgbcdc96mC9Of/AK9HJELnjX/Ch3z/AMjEP/AL/wC2Uo+A7Y/5GMf+AX/2yvaF\r\nTinhORzS5UFzxRvgOw/5mMe2LL/7ZQPgM5Gf+EiHt/oR/wDi69paMseh9Fp3lc7dp6eoo5UFzxY/\r\nARgQP+EkX/wCP/xdL/woN92P+EjH/gCf/jleytHsIU4P1qRIsKHIHXpnHFHKgueKj4CMTj/hIxyc\r\n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\r\n/wCJorXmRFj/2Q==', 'Informatica');
INSERT INTO `miembros` (`idMiembro`, `nombre`, `apellido`, `cedula`, `clave`, `sexo`, `correo`, `telefono`, `cargo`, `imagen`, `areaInteres`) VALUES
(11, 'Raquel', 'Colmenares', '1234560', 'e10adc3949ba59abbe56e057f20f883e', 'Femenino', 'Raquel_colmenares@hotmail.es', '04121234567', 'Miembro', '/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCADhAOEDASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDzZRUg\r\nFNSplFWMQCnbacFpaYEeKRhUxppWgCm9Qk1akFV2qbFDKQmnU9IZZfuq1IZGKUVeTSm/ibbVlNPi\r\nT/apNk3MkU/DVsLZr/zyX8qspaL/AHVouFzn8NSV1C2UT/8ALJaU6VA//LJf0oC5yoFOroJdCif/\r\nAFTMv8v5VnXGkXMX8O5fagZRFFBVk/8Ar0maYAQtMzQTS5pAOopKUUAPC1MhqJBUwFFgJVp9RqtO\r\nC0wHUUu2iqAoR1YUVBFVyOmSIFpxWpQKdigRABQwqYrTHRkoEUZBVUqzv8vzVf2tK+1V+atiy0tY\r\nk3Mv7xqTHcy7TSWf5pfyrUSBYk2qu2rpiphiqbCciqVpyxVOIqeI6LAQLFU6x1IkdTItFhjUjqVY\r\nqkValVKdgIxFTjDU6rUojosBhX2iQXafd8uT1GB/SuXvtNlsn2yq23se1ej7KrXdjFdwtFKu5W9u\r\nlOwXPMmX+7Sbq0dTsJdPumiZfl7H1FUKljuAalBpBT1NBRIhqdDUCGpcUEk4NPFQru/3qmUNVAPo\r\npKKVgM2M1ciNUUNWY5KaEXhT8VWWSn+a1USPc7KhZt9LJKz0Wi/aLpV96b0QLU1tKsf+WrL9K2lg\r\n31LbwbEVV/hrSgt6cImNSdjL+yVGbaui+zVXlgWteRGCq3Zz7Q03y60JkqsRWMlY64u5Eq1Kq0KK\r\nnVaksFjqwkVOiiq5HBQBXWKpRFV1Lap1tqqwGb5dNKVovBUEiUWA53xBpS6hp7bf9YnI/wAK84b5\r\nH2su1q9iK15p4isvsmrSL/C3I/Gk1oCZkUoNMxS4rM0Jg1SK1VxUi0IkuJUymqSM38X51OslUIsU\r\nVF5lFMDNU1MrVXDVIppIC0rUu6oVNOzVEkm6tbQYt91u9Kxc10Xhsf6yhgdVbR1s28NZtmK3IFra\r\nJzTVxDHVG5jrUK1RuhWtzBQ1MOdapEVfuBVFqwmdcAWrMS1XSrsC1kbItwRVpwQVWtlrZtoqpDCO\r\n2qf7NVtIqm2VQGPLb1nzxV0MsVZV1FTJZjMPnrjPGtt/qZ/qDXbSj565zxdD5uis39wg0hHnZFMI\r\np5GymGsjQKUNTfmoxUgTLJU6yVSVtlSq1UBb8yiq+6igRVIZKVWpuaeKYiRTT6YKdQIWun8Nfck/\r\nCuXzXTeGT8kn4UuqH0O0sv4a3YPuVhWVb1v9yuhGTRKRWfditE1QuhVGbRh3A+9VBq0Lqs9qzkaR\r\nBKv29Ulq5AayNTZtK3LYVhWrVt2zVSKNNKfiokkqTetUiWMkFZV2K0pZV/vL+YrKu7iL+8v5iqEz\r\nHnHz1keIU36LcfStSeeLf96qV06y2skTdwRS6ks8pxvoIqe6ia0maJvm2ntUBasbFjCtNxTy1MJ/\r\n2aBiUirSE06gBflopaKAIVqRakEa0rIv8LU0hDRS4pAGp22gBM10fhpvnkrnMLV6x1RrT5VVefwo\r\nEelWbVvW8q7PvL+YrzqPWYokjZt3zema2bK5+1orRM23/erVSRm7nZtNF/eX8xVC5ni/56r+YqjB\r\nZNL95m/Op5NGXZ96ruQ4yMy5li/vL+YrPeSrl1ZrF91v0qjtqJMuKBZP9lqnjkl/hib8jWno2mNq\r\n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\r\n3BWC9FFJ9RRCiiioKP/Z', 'informatica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organizaciones`
--

CREATE TABLE `organizaciones` (
  `idEvento` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participaciones_proyectos`
--

CREATE TABLE `participaciones_proyectos` (
  `idProyecto` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `participaciones_proyectos`
--

INSERT INTO `participaciones_proyectos` (`idProyecto`, `idMiembro`) VALUES
(1, 5),
(2, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `idMiembro` int(11) NOT NULL,
  `idProfesor` int(11) NOT NULL,
  `areaEspecialidad` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `idProyecto` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `areaAccion` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`idProyecto`, `idMiembro`, `nombre`, `areaAccion`) VALUES
(1, 9, 'robots', 'robtica'),
(2, 9, 'camputadora', 'tecnologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntos_fijos`
--

CREATE TABLE `puntos_fijos` (
  `idReunion` int(11) NOT NULL,
  `idPuntoFijo` int(11) NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `puntos_fijos`
--

INSERT INTO `puntos_fijos` (`idReunion`, `idPuntoFijo`, `descripcion`, `nombre`) VALUES
(4, 2, 'se discutiran posibles nombres para los usuarios', 'nombre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntos_varios`
--

CREATE TABLE `puntos_varios` (
  `idReunion` int(11) NOT NULL,
  `idPuntoVario` int(11) NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci NOT NULL,
  `idResponsable` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `puntos_varios`
--

INSERT INTO `puntos_varios` (`idReunion`, `idPuntoVario`, `descripcion`, `idResponsable`, `nombre`) VALUES
(4, 2, 'sasass', 5, 'casa'),
(4, 3, 'se discutrian politicas para la\neleccion de camisas de los \nusuarios', 9, 'camisas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recursos_proyectos`
--

CREATE TABLE `recursos_proyectos` (
  `idProyecto` int(11) NOT NULL,
  `idRecurso` int(11) NOT NULL,
  `recurso` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `recursos_proyectos`
--

INSERT INTO `recursos_proyectos` (`idProyecto`, `idRecurso`, `recurso`) VALUES
(1, 1, 'leds'),
(1, 3, 'cables'),
(1, 4, '2000 bsf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reuniones`
--

CREATE TABLE `reuniones` (
  `idReunion` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `reuniones`
--

INSERT INTO `reuniones` (`idReunion`, `idMiembro`, `fecha`, `hora`) VALUES
(3, 9, '2015-02-10', 7),
(4, 5, '2015-04-05', 13),
(5, 9, '2017-06-06', 19);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`idActividad`),
  ADD UNIQUE KEY `idEvento_2` (`idEvento`,`nombre`),
  ADD KEY `idEvento` (`idEvento`);

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`idArticulo`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `articulos_eventos`
--
ALTER TABLE `articulos_eventos`
  ADD PRIMARY KEY (`idEvento`,`idArticulo`),
  ADD KEY `idArticulo` (`idArticulo`);

--
-- Indices de la tabla `articulos_proyectos`
--
ALTER TABLE `articulos_proyectos`
  ADD PRIMARY KEY (`idProyecto`,`idArticulo`),
  ADD KEY `idArticulo` (`idArticulo`);

--
-- Indices de la tabla `asistencias_eventos`
--
ALTER TABLE `asistencias_eventos`
  ADD PRIMARY KEY (`idEvento`,`idMiembro`),
  ADD KEY `idEvento` (`idEvento`,`idMiembro`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `asistencias_reuniones`
--
ALTER TABLE `asistencias_reuniones`
  ADD PRIMARY KEY (`idReunion`,`idMiembro`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `comisiones`
--
ALTER TABLE `comisiones`
  ADD PRIMARY KEY (`idComision`),
  ADD UNIQUE KEY `nombre` (`nombre`,`idActividad`,`idMiembro`),
  ADD KEY `idActividad` (`idActividad`,`idMiembro`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `disponibilidad_miembros`
--
ALTER TABLE `disponibilidad_miembros`
  ADD PRIMARY KEY (`idDisponibilidad`),
  ADD UNIQUE KEY `idMiembro_2` (`idMiembro`,`dia`,`horaInicio`,`horaFinal`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `egresados`
--
ALTER TABLE `egresados`
  ADD PRIMARY KEY (`idEgresado`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`idEstudiante`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`idEvento`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `fases_proyectos`
--
ALTER TABLE `fases_proyectos`
  ADD PRIMARY KEY (`idFase`),
  ADD KEY `idProyecto` (`idProyecto`);

--
-- Indices de la tabla `generaciones`
--
ALTER TABLE `generaciones`
  ADD PRIMARY KEY (`idArticulo`,`idMiembro`),
  ADD KEY `idArticulo` (`idArticulo`,`idMiembro`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `miembros`
--
ALTER TABLE `miembros`
  ADD PRIMARY KEY (`idMiembro`),
  ADD UNIQUE KEY `cedula` (`cedula`,`correo`);

--
-- Indices de la tabla `organizaciones`
--
ALTER TABLE `organizaciones`
  ADD PRIMARY KEY (`idEvento`,`idMiembro`),
  ADD KEY `idEvento` (`idEvento`,`idMiembro`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `participaciones_proyectos`
--
ALTER TABLE `participaciones_proyectos`
  ADD PRIMARY KEY (`idProyecto`,`idMiembro`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`idProfesor`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`idProyecto`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `idCoordinador` (`idMiembro`);

--
-- Indices de la tabla `puntos_fijos`
--
ALTER TABLE `puntos_fijos`
  ADD PRIMARY KEY (`idPuntoFijo`),
  ADD KEY `idReunion` (`idReunion`);

--
-- Indices de la tabla `puntos_varios`
--
ALTER TABLE `puntos_varios`
  ADD PRIMARY KEY (`idPuntoVario`),
  ADD KEY `idReunion` (`idReunion`),
  ADD KEY `idResponsable` (`idResponsable`);

--
-- Indices de la tabla `recursos_proyectos`
--
ALTER TABLE `recursos_proyectos`
  ADD PRIMARY KEY (`idRecurso`),
  ADD UNIQUE KEY `idRecurso` (`idRecurso`),
  ADD KEY `idProyecto` (`idProyecto`);

--
-- Indices de la tabla `reuniones`
--
ALTER TABLE `reuniones`
  ADD PRIMARY KEY (`idReunion`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `idActividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `articulos`
--
ALTER TABLE `articulos`
  MODIFY `idArticulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `comisiones`
--
ALTER TABLE `comisiones`
  MODIFY `idComision` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT de la tabla `disponibilidad_miembros`
--
ALTER TABLE `disponibilidad_miembros`
  MODIFY `idDisponibilidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT de la tabla `egresados`
--
ALTER TABLE `egresados`
  MODIFY `idEgresado` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `idEvento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `fases_proyectos`
--
ALTER TABLE `fases_proyectos`
  MODIFY `idFase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `miembros`
--
ALTER TABLE `miembros`
  MODIFY `idMiembro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `idProfesor` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `idProyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `puntos_fijos`
--
ALTER TABLE `puntos_fijos`
  MODIFY `idPuntoFijo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `puntos_varios`
--
ALTER TABLE `puntos_varios`
  MODIFY `idPuntoVario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `recursos_proyectos`
--
ALTER TABLE `recursos_proyectos`
  MODIFY `idRecurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `reuniones`
--
ALTER TABLE `reuniones`
  MODIFY `idReunion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `actividades_ibfk_1` FOREIGN KEY (`idEvento`) REFERENCES `eventos` (`idEvento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `articulos_eventos`
--
ALTER TABLE `articulos_eventos`
  ADD CONSTRAINT `articulos_eventos_ibfk_3` FOREIGN KEY (`idEvento`) REFERENCES `eventos` (`idEvento`) ON UPDATE CASCADE,
  ADD CONSTRAINT `articulos_eventos_ibfk_4` FOREIGN KEY (`idArticulo`) REFERENCES `articulos` (`idArticulo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `articulos_proyectos`
--
ALTER TABLE `articulos_proyectos`
  ADD CONSTRAINT `articulos_proyectos_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectos` (`idProyecto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `articulos_proyectos_ibfk_2` FOREIGN KEY (`idArticulo`) REFERENCES `articulos` (`idArticulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `asistencias_eventos`
--
ALTER TABLE `asistencias_eventos`
  ADD CONSTRAINT `asistencias_eventos_ibfk_1` FOREIGN KEY (`idEvento`) REFERENCES `eventos` (`idEvento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `asistencias_eventos_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `asistencias_reuniones`
--
ALTER TABLE `asistencias_reuniones`
  ADD CONSTRAINT `asistencias_reuniones_ibfk_1` FOREIGN KEY (`idReunion`) REFERENCES `reuniones` (`idReunion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `asistencias_reuniones_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `comisiones`
--
ALTER TABLE `comisiones`
  ADD CONSTRAINT `comisiones_ibfk_1` FOREIGN KEY (`idActividad`) REFERENCES `actividades` (`idActividad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comisiones_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `disponibilidad_miembros`
--
ALTER TABLE `disponibilidad_miembros`
  ADD CONSTRAINT `disponibilidad_miembros_ibfk_1` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `egresados`
--
ALTER TABLE `egresados`
  ADD CONSTRAINT `egresados_ibfk_1` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `fases_proyectos`
--
ALTER TABLE `fases_proyectos`
  ADD CONSTRAINT `fases_proyectos_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectos` (`idProyecto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `generaciones`
--
ALTER TABLE `generaciones`
  ADD CONSTRAINT `generaciones_ibfk_1` FOREIGN KEY (`idArticulo`) REFERENCES `articulos` (`idArticulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `generaciones_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `organizaciones`
--
ALTER TABLE `organizaciones`
  ADD CONSTRAINT `organizaciones_ibfk_1` FOREIGN KEY (`idEvento`) REFERENCES `eventos` (`idEvento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `organizaciones_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `participaciones_proyectos`
--
ALTER TABLE `participaciones_proyectos`
  ADD CONSTRAINT `participaciones_proyectos_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectos` (`idProyecto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participaciones_proyectos_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD CONSTRAINT `proyectos_ibfk_1` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `puntos_fijos`
--
ALTER TABLE `puntos_fijos`
  ADD CONSTRAINT `puntos_fijos_ibfk_1` FOREIGN KEY (`idReunion`) REFERENCES `reuniones` (`idReunion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `puntos_varios`
--
ALTER TABLE `puntos_varios`
  ADD CONSTRAINT `puntos_varios_ibfk_1` FOREIGN KEY (`idReunion`) REFERENCES `reuniones` (`idReunion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `puntos_varios_ibfk_2` FOREIGN KEY (`idResponsable`) REFERENCES `miembros` (`idMiembro`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `recursos_proyectos`
--
ALTER TABLE `recursos_proyectos`
  ADD CONSTRAINT `recursos_proyectos_ibfk_1` FOREIGN KEY (`idProyecto`) REFERENCES `proyectos` (`idProyecto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reuniones`
--
ALTER TABLE `reuniones`
  ADD CONSTRAINT `reuniones_ibfk_1` FOREIGN KEY (`idMiembro`) REFERENCES `miembros` (`idMiembro`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
