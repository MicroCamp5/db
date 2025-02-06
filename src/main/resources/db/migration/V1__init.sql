create table microcamp.customer
(
    date_birth    datetime(6) null,
    id            bigint      not null
        primary key,
    name_customer varchar(20) not null,
    unique_key    varchar(25) not null,
    constraint CUSTOMER_KEY_UNIQUE
        unique (unique_key)
);

create table microcamp.customer_seq
(
    next_val bigint null
);

create table microcamp.shop_order
(
    customer_id bigint       null,
    id          bigint       not null
        primary key,
    name        varchar(255) null,
    constraint SHOP_ORDER_CUSTOMER_ID_FK
        foreign key (customer_id) references microcamp.customer (id)
);

create table microcamp.shop_order_seq
(
    next_val bigint null
);

