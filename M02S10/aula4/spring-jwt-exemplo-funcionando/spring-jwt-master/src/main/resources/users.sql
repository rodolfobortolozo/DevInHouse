create table users (
                       username varchar(50) not null primary key,
                       password varchar(120) not null,
                       enabled boolean not null
);

create table authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             foreign key (username) references users (username)
);