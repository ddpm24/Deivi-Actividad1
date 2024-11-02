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
(5, 'Ruta de bodegas', 'La Rioja', 'Bodegas de La Rioja', '2024-11-20', 7, 'CANCELADO', 'N', 15, 6, 50.50, 'bodegas.jpg', '2024-10-21'),
(6, 'Tour en bicicleta por la ciudad', 'Valencia', 'Centro histórico de Valencia', '2024-11-25', 3, 'CREADO', 'N', 25, 8, 20.00, 'bicicleta.jpg', '2024-10-28'),
(7, 'Excursión a una reserva natural', 'Bilbao', 'Parque Natural de Urkiola', '2024-11-30', 6, 'CREADO', 'S', 30, 10, 28.75, 'reserva.jpg', '2024-10-20'),
(8, 'Ruta por el Camino de Santiago', 'Pamplona', 'Camino de Santiago', '2025-04-15', 12, 'CREADO', 'S', 15, 5, 60.00, 'camino.jpg', '2024-10-30'),
(9, 'Escapada de fin de semana en la playa', 'Málaga', 'Costa del Sol', '2024-12-10', 48, 'CREADO', 'N', 50, 20, 80.00, 'playa.jpg', '2024-10-19'),
(10, 'Exploración de cuevas', 'Santander', 'Cuevas de Altamira', '2025-02-15', 4, 'CREADO', 'S', 20, 5, 45.50, 'cuevas.jpg', '2024-11-01'),
(11, 'Paseo en globo aerostático', 'Segovia', 'Vistas de Segovia', '2024-12-18', 2, 'CREADO', 'S', 10, 4, 150.00, 'globo.jpg', '2024-10-29'),
(12, 'Observación de estrellas', 'Madrid', 'Parque Nacional de Guadarrama', '2025-01-20', 5, 'CREADO', 'N', 35, 10, 25.00, 'estrellas.jpg', '2024-10-30'),
(13, 'Aventura en kayak', 'Zaragoza', 'Río Ebro', '2024-11-12', 3, 'TERMINADO', 'N', 20, 8, 40.00, 'kayak.jpg', '2024-09-15'),
(14, 'Safari fotográfico', 'Córdoba', 'Parque Natural de Hornachuelos', '2025-03-05', 7, 'CREADO', 'S', 25, 10, 70.00, 'safari.jpg', '2024-10-24'),
(15, 'Tour de tapas', 'San Sebastián', 'Parte Vieja de San Sebastián', '2024-12-05', 4, 'CREADO', 'S', 30, 15, 35.50, 'tapas.jpg', '2024-11-02'),
(16, 'Ruta de senderismo', 'León', 'Montañas de León', '2024-11-27', 6, 'CREADO', 'N', 25, 10, 22.00, 'senderismo.jpg', '2024-10-26'),
(17, 'Visita a viñedos', 'Valladolid', 'Ribera del Duero', '2025-02-08', 8, 'CREADO', 'S', 15, 5, 55.00, 'viñedos.jpg', '2024-10-25'),
(18, 'Excursión histórica', 'Toledo', 'Casco antiguo de Toledo', '2024-12-15', 5, 'CANCELADO', 'N', 35, 12, 30.00, 'toledo.jpg', '2024-10-20'),
(19, 'Escalada en roca', 'Alicante', 'Sierra de Bernia', '2025-01-25', 6, 'CREADO', 'S', 10, 4, 65.00, 'escalada.jpg', '2024-10-31'),
(20, 'Visita a un castillo medieval', 'Burgos', 'Castillo de Burgos', '2024-11-18', 4, 'TERMINADO', 'N', 40, 15, 18.75, 'castillo.jpg', '2024-09-30'),
(21, 'Aventura en rafting', 'Huesca', 'Río Gállego', '2025-03-20', 5, 'CREADO', 'S', 25, 8, 75.00, 'rafting.jpg', '2024-10-27'),
(22, 'Recorrido por cuevas de hielo', 'Granada', 'Sierra Nevada', '2025-01-08', 4, 'CREADO', 'N', 15, 5, 90.00, 'hielo.jpg', '2024-11-01'),
(23, 'Tour gastronómico', 'Valencia', 'Mercado Central', '2024-12-22', 3, 'CREADO', 'S', 30, 10, 25.50, 'gastronomia.jpg', '2024-10-28'),
(24, 'Avistamiento de aves', 'Doñana', 'Parque Nacional de Doñana', '2025-02-12', 4, 'CREADO', 'N', 20, 8, 32.00, 'aves.jpg', '2024-11-02'),
(25, 'Excursión en tren histórico', 'Madrid', 'Aranjuez', '2024-11-10', 5, 'TERMINADO', 'S', 40, 12, 28.00, 'tren.jpg', '2024-10-05'),
(26, 'Tour en la ciudad medieval', 'Ávila', 'Casco histórico de Ávila', '2025-01-30', 4, 'CREADO', 'S', 40, 15, 25.00, 'avila.jpg', '2024-11-01'),
(27, 'Visita al volcán', 'Lanzarote', 'Parque Nacional de Timanfaya', '2025-02-25', 6, 'CREADO', 'N', 30, 10, 55.50, 'volcan.jpg', '2024-11-03'),
(28, 'Excursión a un bosque encantado', 'Madrid', 'Hayedo de Montejo', '2025-03-10', 5, 'CREADO', 'S', 20, 6, 18.75, 'bosque.jpg', '2024-11-04'),
(29, 'Paseo en catamarán', 'Ibiza', 'Islas de Ibiza', '2025-04-05', 4, 'CREADO', 'N', 50, 15, 60.00, 'catamaran.jpg', '2024-11-02'),
(30, 'Exploración arqueológica', 'Mérida', 'Ruinas Romanas de Mérida', '2025-05-18', 5, 'CREADO', 'S', 30, 8, 45.00, 'ruinas.jpg', '2024-11-05'),
(31, 'Ruta por acantilados', 'Asturias', 'Acantilados de la costa asturiana', '2025-05-25', 6, 'CREADO', 'N', 25, 10, 33.00, 'acantilados.jpg', '2024-11-06'),
(32, 'Visita a un castillo templario', 'León', 'Castillo de Ponferrada', '2025-06-10', 4, 'CREADO', 'S', 40, 12, 27.50, 'ponferrada.jpg', '2024-11-07'),
(33, 'Tour por molinos de viento', 'Toledo', 'Consuegra', '2025-07-01', 3, 'CREADO', 'N', 35, 8, 20.00, 'molinos.jpg', '2024-11-08'),
(34, 'Excursión de espeleología', 'Cantabria', 'Cueva del Soplao', '2025-08-12', 5, 'CREADO', 'S', 15, 5, 50.00, 'espeleologia.jpg', '2024-11-09'),
(35, 'Caminata nocturna', 'Granada', 'Parque Nacional de Sierra Nevada', '2025-08-20', 5, 'CREADO', 'N', 25, 10, 22.00, 'caminata.jpg', '2024-11-10');