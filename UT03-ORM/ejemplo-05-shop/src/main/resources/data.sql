insert into category(name)
values ('Aviones');
insert into category(name)
values ('Barcos');
insert into category(name)
values ('Coches');

insert into brand(brand_id, name)
values ('M1', 'Marca 1');
insert into brand(brand_id, name)
values ('M2', 'Marca 2');
insert into brand(brand_id, name)
values ('M3', 'Marca 3');
insert into brand(brand_id, name)
values ('M4', 'Marca 4');

insert into product(name, price, brand_id)
values ('Producto 1', 100.30, 'M1'),
       ('Producto 2', 20.45, 'M2');


insert into prod_cat(product_id, category_id)
values (1, 1),
       (1,2 ),
       (2,2 ),
       (2,3 );



