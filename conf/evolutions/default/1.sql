# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table evento (
  id                        bigint not null,
  descricao                 varchar(255),
  observacao                varchar(255),
  local                     varchar(255),
  data                      timestamp,
  constraint pk_evento primary key (id))
;

create table usuario (
  id                        bigint not null,
  username                  varchar(255) not null,
  password                  varchar(255) not null,
  nome                      varchar(255),
  constraint pk_usuario primary key (id))
;

create sequence evento_seq;

create sequence usuario_seq;




# --- !Downs

drop table if exists evento cascade;

drop table if exists usuario cascade;

drop sequence if exists evento_seq;

drop sequence if exists usuario_seq;

