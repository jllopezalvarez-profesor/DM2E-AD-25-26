-- =========================
-- CATEGORÍAS (5)
-- =========================
insert into category(name)
values ('Electrónica');
insert into category(name)
values ('Hogar');
insert into category(name)
values ('Deporte');
insert into category(name)
values ('Juguetes');
insert into category(name)
values ('Oficina');
-- SIN productos


-- =========================
-- MARCAS (5)
-- =========================
insert into brand(brand_id, name)
values ('B1', 'Samsung');
insert into brand(brand_id, name)
values ('B2', 'Ikea');
insert into brand(brand_id, name)
values ('B3', 'Nike');
insert into brand(brand_id, name)
values ('B4', 'Lego');
insert into brand(brand_id, name)
values ('B5', 'PaperPro');
-- SIN productos


-- =========================
-- PRODUCTOS (20)
-- AHORA CON description
-- =========================
insert into product(name, description, price, brand_id)
values ('Televisor 55 pulgadas 4K',
        'Smart TV con resolución 4K UHD y tecnología HDR.',
        699.99, 'B1'),

       ('Smartphone Galaxy A54',
        'Teléfono móvil con pantalla AMOLED y cámara de alta resolución.',
        349.90, 'B1'),

       ('Tablet Galaxy Tab S6',
        'Tablet ligera ideal para entretenimiento y productividad.',
        429.00, 'B1'),

       ('Auriculares Bluetooth',
        'Auriculares inalámbricos con cancelación de ruido.',
        79.99, 'B1'),

       ('Monitor LED 27 pulgadas',
        'Monitor de 27 pulgadas con panel LED y alta definición.',
        249.00, 'B1'),

       ('Sofá de 3 plazas',
        'Sofá cómodo de tres plazas con tapizado resistente.',
        599.00, 'B2'),

       ('Mesa de comedor extensible',
        'Mesa extensible ideal para reuniones familiares.',
        399.00, 'B2'),

       ('Silla de oficina ergonómica',
        'Silla ajustable con soporte lumbar y reposabrazos.',
        149.99, 'B2'),

       ('Estantería modular',
        'Estantería configurable para salón u oficina.',
        129.00, 'B2'),

       ('Lámpara de pie LED',
        'Lámpara LED de bajo consumo con diseño moderno.',
        89.50, 'B2'),

       ('Zapatillas running Air Zoom',
        'Zapatillas de running con amortiguación avanzada.',
        129.99, 'B3'),

       ('Camiseta deportiva transpirable',
        'Camiseta ligera con tejido transpirable.',
        29.99, 'B3'),

       ('Pantalón corto entrenamiento',
        'Pantalón corto cómodo para actividades deportivas.',
        34.99, 'B3'),

       ('Sudadera con capucha',
        'Sudadera deportiva con capucha y bolsillo frontal.',
        69.99, 'B3'),

       ('Mochila deportiva',
        'Mochila resistente con múltiples compartimentos.',
        54.99, 'B3'),

       ('Set LEGO Ciudad Policía',
        'Set de construcción LEGO con temática policial.',
        59.99, 'B4'),

       ('Set LEGO Star Wars Nave',
        'Nave espacial LEGO basada en Star Wars.',
        129.99, 'B4'),

       ('Set LEGO Technic Coche',
        'Modelo LEGO Technic con mecanismos realistas.',
        149.99, 'B4'),

       ('Set LEGO Friends Casa',
        'Casa LEGO Friends con múltiples accesorios.',
        79.99, 'B4'),

       ('Set LEGO Classic Creativo',
        'Caja LEGO Classic para construcciones libres.',
        39.99, 'B4');


-- =========================
-- PRODUCTO - CATEGORÍA
-- =========================
insert into prod_cat(product_id, category_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (3, 1),
       (4, 1),
       (4, 3),
       (5, 1),
       (5, 2),

       (6, 2),
       (7, 2),
       (8, 2),
       (8, 1),
       (9, 2),
       (10, 2),
       (10, 1),

       (11, 3),
       (12, 3),
       (13, 3),
       (14, 3),
       (14, 2),
       (15, 3),
       (15, 2),

       (16, 4),
       (17, 4),
       (17, 1),
       (18, 4),
       (18, 1),
       (19, 4),
       (19, 2),
       (20, 4);
