USE coursework;

DROP TABLE users;

create table users (
    id  int(3) NOT NULL AUTO_INCREMENT,
    name varchar(120) NOT NULL,
    email varchar(220) NOT NULL,
    country varchar(120),
    password varchar(220) NOT NULL,
    PRIMARY KEY (id)
);
