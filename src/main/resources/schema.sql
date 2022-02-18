Drop table IF EXISTS public.authority;
Drop table IF EXISTS public.users;
Drop table IF EXISTS public.product;

CREATE TABLE IF NOT EXISTS public.users
(
  id        serial,
  username  VARCHAR(45) NOT NULL,
  password  TEXT        NOT NULL,
  algorithm VARCHAR(10) not null,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS public.authority
(
  id      serial,
  name    VARCHAR(45) NOT NULL,
  user_id int,
  foreign key (user_id) references public.users (id),
  PRIMARY KEY (id)
);

CREATE table if not exists public.product
(
  id       serial,
  name     varchar(45) not null,
  price    varchar(45) not null,
  currency varchar(45) not null,
  primary key (id)
)
