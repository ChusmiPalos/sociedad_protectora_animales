
create table if not exists Mascota (
    Id identity,
    nombre varchar(50) not null,
    fecha_nac date not null,
    raza varchar(50),
    peso float not null,
    tiene_chip boolean not null,
    url_foto varchar(200) not null
);