create table if not exists public."student" (
    "id" int AUTO_INCREMENT primary key,
    "name" varchar(100) not null,
    "standard" int not null,
    "section" varchar(50) not null,
    "creation_time" varchar(50) not null,
    "modification_time" varchar(50) default null
);