USE coursework;

create table users (
                       id  int(3) NOT NULL AUTO_INCREMENT,
                       name varchar(120) NOT NULL,
                       email varchar(220) NOT NULL,
                       country varchar(120),
                       password varchar(220) NOT NULL,
                       isAdmin varchar(10) NOT NULL,
                       avatar varchar(10000) NOT NULL,
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

# ALTER TABLE users ADD COLUMN avatar int(1000) AUTO_INCREMENT;
# UPDATE users SET avatar = 1 where id = 1;

