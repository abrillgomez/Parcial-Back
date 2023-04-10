CREATE TABLE IF NOT EXISTS `odontologo` (
    `id` INTEGER PRIMARY KEY,
    `numeroMatricula` VARCHAR,
    `nombre`        VARCHAR,
    `apellido` VARCHAR
);

DELETE FROM odontologo;

INSERT INTO odontologo(id, numeroMatricula, nombre, apellido) VALUES (1, '123ABC', 'Abril', 'Gómez');
INSERT INTO odontologo(id, numeroMatricula, nombre, apellido) VALUES (2, '345DEF', 'Lautaro', 'Leguizamón');
INSERT INTO odontologo(id, numeroMatricula, nombre, apellido) VALUES (3, '789GHI', 'Manuela', 'Maggi');

