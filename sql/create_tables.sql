USE coursework;
DROP TABLE users, product_order,picture,hotel,hotel_pic_rel;

create table users (
                       id  int(3) NOT NULL AUTO_INCREMENT,
                       name varchar(120) NOT NULL,
                       email varchar(220) NOT NULL,
                       country varchar(120),
                       password varchar(220) NOT NULL,
                       identity varchar(10) NOT NULL,
                       avatar TEXT NOT NULL,
                       PRIMARY KEY (id)
);

create table product_order (
                               order_id int(100) NOT NULL AUTO_INCREMENT,
                               product varchar(200) NOT NULL,
                               uid int(3) NOT NULL,
                               price float NOT NULL,
                               PRIMARY KEY (order_id),
                               FOREIGN KEY (uid) references users(id)
);

create table hotel (
    id int(255) NOT NULL AUTO_INCREMENT,
    name varchar(200) NOT NULL,
    description BLOB NOT NULL,
    city varchar(10) NOT NULL,
    PRIMARY KEY (id)

);

create table picture (
    id int(255) NOT NULL AUTO_INCREMENT,
    pic TEXT NOT NULL,
    PRIMARY KEY (id)
);

create table hotel_pic_rel (
    id int(255) NOT NULL AUTO_INCREMENT,
    hotel_id int(255) NOT NULL,
    pic_id int(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (hotel_id) references hotel(id),
    FOREIGN KEY (pic_id) references picture(id)

);
# ALTER TABLE users ADD COLUMN avatar int(1000) AUTO_INCREMENT;
# UPDATE users SET avatar = 1 where id = 1;

