create table routes (

    id bigint not null auto_increment,
    source varchar(128) not null,
    destiny varchar(128) not null,
    distance float not null,

    primary key(id)

);