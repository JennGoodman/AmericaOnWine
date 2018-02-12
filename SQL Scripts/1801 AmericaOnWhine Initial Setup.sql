/*******************************************************************************
   America On Whine Initial Database Installation and reset Script - Version 1
   Script: 1801 AmericaOnWhine Initial Setup.sql
   Description: Creates and populates the AmericaOnWhine database.
   DB Server: Oracle
   Author: Jenn Goodman
********************************************************************************/

/*******************************************************************************
   Drop Tables if they exist
********************************************************************************/

drop table aow_user cascade constraints;
drop table aow_tag cascade constraints;
drop table aow_country cascade constraints;
drop table aow_type cascade constraints;
drop table aow_sub_type cascade constraints;
drop table aow_brand cascade constraints;
drop table aow_inventory cascade constraints;
drop table aow_inventory_audit cascade constraints;
drop table aow_transaction cascade constraints;
drop table aow_inventory_tag cascade constraints;

/*******************************************************************************
   Drop Sequences if they exist
********************************************************************************/

drop sequence aow_user_seq;
drop sequence aow_tag_seq;
drop sequence aow_country_seq;
drop sequence aow_type_seq;
drop sequence aow_sub_type_seq;
drop sequence aow_brand_seq;
drop sequence aow_inventory_seq;
drop sequence aow_inventory_audit_seq;
drop sequence aow_transaction_seq;
drop sequence aow_inventory_tag_seq;

/*******************************************************************************
   Create Tables
********************************************************************************/

create table aow_user (
    id          number(6)       primary key,
    username    varchar2(50)    unique not null,
    password    varchar2(50)    not null,
    email       varchar2(50)    unique not null,
    role        number(1)       not null,
    active      number(1)       not null,
    cancelled   number(1)       not null
);
create table aow_tag (
    id          number(6)       primary key,
    tag         varchar2(25)    not null
);
create table aow_country (
    id          number(6)       primary key,
    country     varchar2(50)    unique not null
);
create table aow_type (
    id          number(6)       primary key,
    type        varchar2(50)    unique not null
);
create table aow_sub_type (
    id          number(6)       primary key,
    type_id     number(6)       not null references aow_type(id),
    sub_type    varchar2(50)    unique not null
);
create table aow_brand (
    id          number(6)       primary key,
    brand       varchar2(50)    unique not null
);
create table aow_inventory (
    id          number(6)       primary key,
    name        varchar2(50)    not null,
    brand_id    number(6)       not null references aow_brand(id),
    user_id     number(6)       not null references aow_user(id),
    country_id  number(6)       not null references aow_country(id),
    type_id     number(6)       not null references aow_type(id),
    sub_type_id number(6)       not null references aow_sub_type(id),
    volume      number(5,2)     not null,
    year        number(4)       not null,
    price       number(8,2)     not null,
    submitted   Date            not null,
    description varchar2(256),
    image_url   varchar2(256)
);
create table aow_inventory_audit (
    id              number(6)   primary key,
    old_id          number(6),
    new_id          number(6),
    old_name        varchar2(50),
    new_name        varchar2(50),
    old_brand_id    number(6),
    new_brand_id    number(6),
    old_user_id     number(6),
    new_user_id     number(6),
    old_country_id  number(6),
    new_country_id  number(6),
    old_type_id     number(6),
    new_type_id     number(6),
    old_sub_type_id number(6),
    new_sub_type_id number(6),
    new_volume      number(5,2),
    old_volume      number(5,2),
    old_year        number(4),
    new_year        number(4),
    old_price       number(8,2),
    new_price       number(8,2),
    old_submitted   date,
    new_submitted   date,
    old_description varchar2(256),
    new_description varchar2(256),
    old_image_url   varchar2(256),
    new_image_url   varchar2(256)
);
create table aow_transaction (
    id                  number(6)   primary key,
    order_number        number(6)   not null,
    inventory_id        number(6)   not null references aow_inventory(id),
    quantity            number(3)   not null,
    user_id             number(6)   not null references aow_user(id),
    total               number(9,2) not null,
    rating              number(1)   not null,
    transaction_date    date        not null,
    comments            varchar2(2000)
);
create table aow_inventory_tag (
    inventory_id    number(6) references aow_inventory(id),
    tag_id          number(6) references aow_tag(id),
    constraint inv_tag primary key(inventory_id, tag_id)
);

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

create sequence aow_user_seq;
create sequence aow_tag_seq;
create sequence aow_country_seq;
create sequence aow_type_seq;
create sequence aow_sub_type_seq;
create sequence aow_brand_seq;
create sequence aow_inventory_seq;
create sequence aow_inventory_audit_seq;
create sequence aow_transaction_seq;
create sequence aow_inventory_tag_seq;

/*******************************************************************************
   Create Triggers
********************************************************************************/

create or replace trigger aow_inventory_audit_trig
before insert on aow_inventory for each row
begin
    if INSERTING then
        insert into aow_inventory_audit (
            id,
            new_id,
            new_name,
            new_brand_id,
            new_user_id,
            new_country_id,
            new_type_id,
            new_sub_type_id,
            new_volume,
            new_year,
            new_price,
            new_submitted,
            new_description,
            new_image_url
        ) values (
            aow_inventory_audit_seq.nextVal,
            :new.id,
            :new.name,
            :new.brand_id,
            :new.user_id,
            :new.country_id,
            :new.type_id,
            :new.sub_type_id,
            :new.volume,
            :new.year,
            :new.price,
            :new.submitted,
            :new.description,
            :new.image_url
        );
    elsif UPDATING then
        insert into aow_inventory_audit (
            id,
            new_id,             old_id,
            new_name,           old_name,
            new_brand_id,       old_brand_id,
            new_user_id,        old_user_id,
            new_country_id,     old_country_id,
            new_type_id,        old_type_id,
            new_sub_type_id,    old_sub_type_id,
            new_volume,         old_volume,
            new_year,           old_year,
            new_price,          old_price,
            new_submitted,      old_submitted,
            new_description,    old_description,
            new_image_url,      old_image_url
        ) values (
            aow_inventory_audit_seq.nextVal,
            :new.id,            :old.id,
            :new.name,          :old.name,
            :new.brand_id,      :old.brand_id,
            :new.user_id,       :old.user_id,
            :new.country_id,    :old.country_id,
            :new.type_id,       :old.type_id,
            :new.volume,        :old.volume,
            :new.sub_type_id,   :old.sub_type_id,
            :new.year,          :old.year,
            :new.price,         :old.price,
            :new.submitted,     :old.submitted,
            :new.description,   :old.description,
            :new.image_url,     :old.image_url
        );
    end if;
end;
/
/*******************************************************************************
   Create Views
********************************************************************************/

create or replace view aow_inventory_view as (
    select i.id, name, brand, user_id, country, type, sub_type, volume, year, price, submitted, description, image_url
        from aow_inventory i
            join aow_brand b
                on b.id = i.brand_id
            join aow_country c
                on c.id = i.country_id
            join aow_type t
                on t.id = i.type_id
            join aow_sub_type st
                on st.id = i.sub_type_id
);

/*******************************************************************************
   Populate Tables
********************************************************************************/

insert into aow_user (id, username, password, email, role, active, cancelled) values (1, 'admin', 'admin', 'admin@admin.net', 0, 1, 0);

insert into aow_country (id, country) values (1, 'United States of America');
insert into aow_country (id, country) values (2, 'France');
insert into aow_country (id, country) values (3, 'Britain');
insert into aow_country (id, country) values (4, 'Israel');
insert into aow_country (id, country) values (5, 'Africa');
insert into aow_country (id, country) values (6, 'Japan');

insert into aow_brand (id, brand) values (1, 'Barefoot');

insert into aow_type (id, type) values (1, 'White');

insert into aow_sub_type (id, type_id, sub_type) values (1, 1, 'Moscato');

insert into aow_inventory (id, name, brand_id, user_id, country_id, type_id, sub_type_id, volume, year, price, submitted, description) 
    values (1, 'Barefoot Moscato', 1, 1, 1, 1, 1, 1.5, 2017, 8.99, sysdate, 'It''s good Wine Bront!');

-- Jenn Rocks!