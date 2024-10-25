create database deivi_excursion_bbdd; 
use deivi_excursion_bbdd;

CREATE TABLE excursion (
    id_excursion INT PRIMARY KEY,
    descripcion VARCHAR(455),
    origen VARCHAR(255),
    destino VARCHAR(255),
    fecha_excursion DATE,
    duracion INT,
    estado VARCHAR(20) CHECK (estado IN ('CREADO', 'CANCELADO', 'TERMINADO')),
    destacado CHAR(1) CHECK (destacado IN ('S', 'N')),
    aforo_maximo INT,
    minimo_asistentes INT,
    precio_unitario DOUBLE,
    imagen VARCHAR(255),
    fecha_alta DATE
);

-- Insertar valores en la tabla excursion
INSERT INTO excursion (
    id_excursion, descripcion, origen, destino, fecha_excursion, duracion, estado, destacado, aforo_maximo, minimo_asistentes, precio_unitario, imagen, fecha_alta
) VALUES
(1, 'Excursión a la montaña', 'Madrid', 'Sierra de Guadarrama', '2024-11-15', 8, 'CREADO', 'S', 50, 10, 25.50, 'montana.jpg', '2024-10-25'),
(2, 'Visita guiada al museo', 'Sevilla', 'Museo del Prado', '2024-12-01', 5, 'CREADO', 'N', 30, 5, 15.75, 'museo.jpg', '2024-10-22'),
(3, 'Excursión en barco', 'Barcelona', 'Costa Brava', '2024-10-28', 6, 'TERMINADO', 'S', 40, 12, 35.00, 'barco.jpg', '2024-09-01'),
(4, 'Caminata por el desierto', 'Granada', 'Desierto de Tabernas', '2025-01-10', 10, 'CREADO', 'N', 20, 8, 40.00, 'desierto.jpg', '2024-10-23'),
(5, 'Ruta de bodegas', 'La Rioja', 'Bodegas de La Rioja', '2024-11-20', 7, 'CANCELADO', 'N', 15, 6, 50.50, 'bodegas.jpg', '2024-10-21');


