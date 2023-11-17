create table stations (

    id bigint not null auto_increment,
    name varchar(128) not null unique,
    heuristic float not null,

    primary key(id)

);