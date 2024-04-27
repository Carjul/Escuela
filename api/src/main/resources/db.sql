-- Crear secuencias para las claves primarias
CREATE SEQUENCE estudiante_id_seq;
CREATE SEQUENCE profesor_id_seq;
CREATE SEQUENCE curso_id_seq;
CREATE SEQUENCE grado_id_seq;
CREATE SEQUENCE grupo_id_seq;
CREATE SEQUENCE actividad_id_seq;
CREATE SEQUENCE nota_id_seq;
CREATE SEQUENCE escuela_id_seq;

-- Crear tabla para la entidad Escuela
CREATE TABLE escuela (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    imagen VARCHAR(255)
);

-- Crear tabla para la entidad Grado
CREATE TABLE grado (
    id INTEGER PRIMARY KEY DEFAULT nextval('grado_id_seq'),
    gradonum INTEGER NOT NULL,
	escuela_id INTEGER REFERENCES escuela(id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Crear tabla para la entidad Profesor
CREATE TABLE profesor (
    id INTEGER PRIMARY KEY DEFAULT nextval('profesor_id_seq'),
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    especialidad VARCHAR(100)
);

-- Crear tabla para la entidad Curso
CREATE TABLE curso (
    id INTEGER PRIMARY KEY DEFAULT nextval('curso_id_seq'),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    creditos INTEGER,
    grado_id INTEGER REFERENCES grado(id) ON DELETE CASCADE ON UPDATE CASCADE
    docente_id INTEGER REFERENCES profesor(id) ON DELETE CASCADE ON UPDATE CASCADE
	
);

-- Crear tabla para la entidad Grupo
CREATE TABLE grupo (
    id INTEGER PRIMARY KEY DEFAULT nextval('grupo_id_seq'),
    nombre VARCHAR(50) NOT NULL,
    periodo_academico VARCHAR(100),
    grado_id INTEGER REFERENCES grado(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Crear tabla para la entidad Estudiante
CREATE TABLE estudiantes (
    id INTEGER PRIMARY KEY DEFAULT nextval('estudiante_id_seq'),
    name VARCHAR(50) NOT NULL,
	grado_anterior integer,
    imagen VARCHAR(255),
    fecha_nacimiento DATE,
    tipo_identificacion VARCHAR(255),
    identificacion VARCHAR(255),
    edad integer,
    genero VARCHAR(255),
    grado_id INTEGER REFERENCES grado(id) ON DELETE CASCADE ON UPDATE CASCADE,
    grupo_id INTEGER REFERENCES grupo(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Crear tabla para la entidad Actividad
CREATE TABLE actividad (
    id INTEGER PRIMARY KEY DEFAULT nextval('actividad_id_seq'),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha DATE,
    ponderacion FLOAT,
    curso_id INTEGER REFERENCES curso(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Crear tabla para la entidad Nota
CREATE TABLE nota (
    id INTEGER PRIMARY KEY DEFAULT nextval('nota_id_seq'),
    valor FLOAT NOT NULL,
    fecha_registro DATE,
    estudiante_id INTEGER REFERENCES estudiantes(id) ON DELETE CASCADE ON UPDATE CASCADE,
    actividad_id INTEGER REFERENCES actividad(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- Insertar datos en la tabla Escuela
INSERT INTO escuela (nombre, descripcion, imagen) VALUES
('Escuela Primaria', 'Escuela pública de educación primaria', 'imagen1.png'),
('Escuela Secundaria', 'Escuela privada de educación secundaria', 'imagen2.png');

-- Insertar datos en la tabla Grado
INSERT INTO grado (nombre, escuela_id) VALUES
(1, 1), -- Grado 1 en Escuela Primaria
(7, 2); -- Grado 7 en Escuela Secundaria

-- Insertar datos en la tabla Profesor
INSERT INTO profesor (nombre, apellido, telefono, email, especialidad) VALUES
('Juan', 'Pérez', '123456789', 'juan@example.com', 'Matemáticas'),
('María', 'Gómez', '987654321', 'maria@example.com', 'Historia');

-- Insertar datos en la tabla Curso
INSERT INTO curso (nombre, descripcion, creditos, grado_id, profesor_id) VALUES
('Matemáticas Avanzadas', 'Curso de matemáticas avanzadas', 3, 1, 1),
('Historia del Mundo', 'Curso de historia mundial', 4, 2, 2);

-- Insertar datos en la tabla Grupo
INSERT INTO grupo (nombre, periodo_academico, grado_id) VALUES
('Grupo A', 'Primer semestre', 1), -- Grupo A para Grado 1
('Grupo B', 'Segundo semestre', 2); -- Grupo B para Grado 7

-- Insertar datos en la tabla Estudiantes
INSERT INTO estudiantes (name, grado_anterior, imagen, fecha_nacimiento, tipo_identificacion, identificacion, edad, genero, grado_id, grupo_id) VALUES
('Pedro', NULL, 'imagen_estudiante1.png', '2010-05-15', 'Cédula', '123456789', 12, 'Masculino', 1, 1),
('Ana', 6, 'imagen_estudiante2.png', '2009-07-20', 'Cédula', '987654321', 13, 'Femenino', 2, 2);

-- Insertar datos en la tabla Actividad
INSERT INTO actividad (nombre, descripcion, fecha, ponderacion, curso_id) VALUES
('Examen Parcial', 'Examen parcial de matemáticas avanzadas', '2024-05-20', 0.3, 1),
('Tarea 1', 'Tarea de historia mundial', '2024-05-22', 0.2, 2);

-- Insertar datos en la tabla Nota
INSERT INTO nota (valor, fecha_registro, estudiante_id, actividad_id) VALUES
(8.5, '2024-05-20', 1, 1), -- Nota de Pedro para el Examen Parcial
(9.0, '2024-05-22', 2, 2); -- Nota de Ana para la Tarea 1
