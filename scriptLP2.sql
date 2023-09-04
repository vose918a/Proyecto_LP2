create sequence porducto_id_seq;

alter sequence porducto_id_seq owner to postgres;

create sequence "Empresa_id_seq"
    as integer;

alter sequence "Empresa_id_seq" owner to postgres;

create table if not exists marca
(
    id          integer generated always as identity
        constraint marca_pk
            primary key,
    descripcion varchar(45) not null
);

alter table marca
    owner to postgres;

create table if not exists iva
(
    id          integer generated always as identity
        constraint iva_pk
            primary key,
    descripcion varchar(45) not null
);

alter table iva
    owner to postgres;

create table if not exists empresa
(
    id        integer default nextval('"Empresa_id_seq"'::regclass) not null
        constraint empresa_pk
            primary key,
    nombre    varchar(100)                                          not null,
    direccion varchar(100)                                          not null,
    telefono  varchar(15)                                           not null,
    ruc       varchar(20)                                           not null
);

alter table empresa
    owner to postgres;

alter sequence "Empresa_id_seq" owned by empresa.id;

create table if not exists producto
(
    id            integer generated always as identity
        constraint producto_pk
            primary key,
    descripcion   varchar(45)       not null,
    precio_compra integer default 0 not null,
    precio_venta  integer default 0,
    id_marca      integer
        constraint porducto___fk
            references marca
            on update cascade,
    id_iva        integer
        constraint producto_iva_id_fk
            references iva,
    id_empresa    integer
        constraint producto_empresa_id_fk
            references empresa
);

alter table producto
    owner to postgres;

alter sequence porducto_id_seq owned by producto.id;

create table if not exists cliente
(
    id           serial
        constraint cliente_pk
            primary key,
    ruc          varchar(20),
    razon_social varchar(100) not null,
    telefono     varchar(20),
    direccion    varchar(100),
    id_empresa   integer
        constraint cliente_empresa_id_fk
            references empresa
);

alter table cliente
    owner to postgres;

create table if not exists caja
(
    id          serial
        constraint caja_pk
            primary key,
    descripcion varchar(45) not null,
    id_empresa  integer
        constraint caja_empresa_id_fk
            references empresa,
    nro_caja    varchar(10) not null
);

alter table caja
    owner to postgres;

create table if not exists usuario
(
    id         serial
        constraint usuario_pk
            primary key,
    usuario    varchar(45) not null,
    clave      varchar(45) not null,
    id_empresa integer     not null
        constraint usuario_empresa_id_fk
            references empresa,
    rango      integer     not null
);

comment on column usuario.rango is '1 - admin 2 - cajero';

alter table usuario
    owner to postgres;

create table if not exists factura
(
    id              serial
        constraint factura_pk
            primary key,
    fecha           timestamp not null,
    condicion_venta integer   not null,
    id_empresa      integer   not null
        constraint factura_empresa_id_fk
            references empresa,
    id_cliente      integer   not null
        constraint factura_cliente_id_fk
            references cliente,
    nro_factura     integer   not null,
    total           integer   not null,
    id_caja         integer   not null
        constraint factura_caja_id_fk
            references caja,
    id_usuario      integer   not null
        constraint factura_usuario_id_fk
            references usuario
);

comment on column factura.condicion_venta is '1 - Contado 2 - Credito';

alter table factura
    owner to postgres;

create table if not exists det_factura
(
    id_producto integer     not null
        constraint det_factura_producto_id_fk
            references producto,
    id_factura  integer     not null
        constraint det_factura_factura_id_fk
            references factura,
    cantidad    integer     not null,
    importe     integer     not null,
    descripcion varchar(45) not null,
    id_iva      integer     not null
        constraint det_factura_iva_id_fk
            references iva
);

alter table det_factura
    owner to postgres;


