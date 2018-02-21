/*******************************************************************************
   America On Whine Initial Database Installation and reset Script - Version 1.4
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
    name         varchar2(25)    not null
);
create table aow_country (
    id          number(6)       primary key,
    abbrev      varchar2(2)     unique not null,
    name     varchar2(50)    unique not null
);
create table aow_type (
    id          number(6)       primary key,
    name        varchar2(50)    unique not null
);
create table aow_sub_type (
    id          number(6)       primary key,
    type_id     number(6)       not null references aow_type(id),
    name    varchar2(50)    unique not null
);
create table aow_brand (
    id          number(6)       primary key,
    name       varchar2(50)    unique not null
);
create table aow_inventory (
    id          number(6)       primary key,
    name        varchar2(50)    not null,
    brand_id    number(6)       not null references aow_brand(id),
    user_id     number(6)       not null references aow_user(id),
    country_id  number(6)       not null references aow_country(id),
    sub_type_id number(6)       not null references aow_sub_type(id),
    volume      number(5,2)     not null,
    year        number(4)       not null,
    price       number(8,2)     not null,
    quantity    number(6)       not null,
    submitted   Date            not null,
    status      number(1)       not null,
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
    old_sub_type_id number(6),
    new_sub_type_id number(6),
    new_volume      number(5,2),
    old_volume      number(5,2),
    old_year        number(4),
    new_year        number(4),
    old_price       number(8,2),
    new_price       number(8,2),
    new_quantity    number(6),
    old_quantity    number(6),
    old_submitted   date,
    new_submitted   date,
    old_status      number(1),
    new_status      number(1),
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
            new_sub_type_id,
            new_volume,
            new_year,
            new_price,
            new_quantity,
            new_submitted,
            new_status,
            new_description,
            new_image_url
        ) values (
            aow_inventory_audit_seq.nextVal,
            :new.id,
            :new.name,
            :new.brand_id,
            :new.user_id,
            :new.country_id,
            :new.sub_type_id,
            :new.volume,
            :new.year,
            :new.price,
            :new.quantity,
            :new.submitted,
            :new.status,
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
            new_sub_type_id,    old_sub_type_id,
            new_volume,         old_volume,
            new_year,           old_year,
            new_price,          old_price,
            new_quantity,       old_quantity,
            new_submitted,      old_submitted,
            new_status,         old_status,
            new_description,    old_description,
            new_image_url,      old_image_url
        ) values (
            aow_inventory_audit_seq.nextVal,
            :new.id,            :old.id,
            :new.name,          :old.name,
            :new.brand_id,      :old.brand_id,
            :new.user_id,       :old.user_id,
            :new.country_id,    :old.country_id,
            :new.volume,        :old.volume,
            :new.sub_type_id,   :old.sub_type_id,
            :new.year,          :old.year,
            :new.price,         :old.price,
            :new.quantity,      :old.quantity,
            :new.submitted,     :old.submitted,
            :new.status,        :old.status,
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
    select i.id, i.name, b.name as brand, user_id, c.name as country, st.name as sub_type, 
            volume, year, price, quantity, submitted, status, description, image_url
        from aow_inventory i
            join aow_brand b
                on b.id = i.brand_id
            join aow_country c
                on c.id = i.country_id
            join aow_sub_type st
                on st.id = i.sub_type_id
);

/*******************************************************************************
   Populate Tables
********************************************************************************/

insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AF', 'Afghanistan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AL', 'Albania');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'DZ', 'Algeria');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'DS', 'American Samoa');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AD', 'Andorra');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AO', 'Angola');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AI', 'Anguilla');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AQ', 'Antarctica');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AG', 'Antigua and Barbuda');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AR', 'Argentina');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AM', 'Armenia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AW', 'Aruba');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AU', 'Australia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AT', 'Austria');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AZ', 'Azerbaijan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BS', 'Bahamas');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BH', 'Bahrain');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BD', 'Bangladesh');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BB', 'Barbados');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BY', 'Belarus');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BE', 'Belgium');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BZ', 'Belize');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BJ', 'Benin');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BM', 'Bermuda');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BT', 'Bhutan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BO', 'Bolivia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BA', 'Bosnia and Herzegovina');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BW', 'Botswana');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BV', 'Bouvet Island');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BR', 'Brazil');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IO', 'British Indian Ocean Territory');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BN', 'Brunei Darussalam');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BG', 'Bulgaria');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BF', 'Burkina Faso');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'BI', 'Burundi');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KH', 'Cambodia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CM', 'Cameroon');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CA', 'Canada');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CV', 'Cape Verde');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KY', 'Cayman Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CF', 'Central African Republic');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TD', 'Chad');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CL', 'Chile');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CN', 'China');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CX', 'Christmas Island');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CC', 'Cocos (Keeling) Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CO', 'Colombia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KM', 'Comoros');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CG', 'Congo');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CK', 'Cook Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CR', 'Costa Rica');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'HR', 'Croatia (Hrvatska)');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CU', 'Cuba');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CY', 'Cyprus');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CZ', 'Czech Republic');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'DK', 'Denmark');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'DJ', 'Djibouti');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'DM', 'Dominica');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'DO', 'Dominican Republic');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TP', 'East Timor');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'EC', 'Ecuador');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'EG', 'Egypt');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SV', 'El Salvador');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GQ', 'Equatorial Guinea');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ER', 'Eritrea');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'EE', 'Estonia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ET', 'Ethiopia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'FK', 'Falkland Islands (Malvinas)');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'FO', 'Faroe Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'FJ', 'Fiji');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'FI', 'Finland');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'FR', 'France');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'FX', 'France, Metropolitan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GF', 'French Guiana');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PF', 'French Polynesia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TF', 'French Southern Territories');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GA', 'Gabon');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GM', 'Gambia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GE', 'Georgia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'DE', 'Germany');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GH', 'Ghana');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GI', 'Gibraltar');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GK', 'Guernsey');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GR', 'Greece');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GL', 'Greenland');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GD', 'Grenada');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GP', 'Guadeloupe');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GU', 'Guam');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GT', 'Guatemala');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GN', 'Guinea');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GW', 'Guinea-Bissau');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GY', 'Guyana');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'HT', 'Haiti');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'HM', 'Heard and Mc Donald Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'HN', 'Honduras');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'HK', 'Hong Kong');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'HU', 'Hungary');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IS', 'Iceland');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IN', 'India');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IM', 'Isle of Man');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ID', 'Indonesia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IR', 'Iran (Islamic Republic of)');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IQ', 'Iraq');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IE', 'Ireland');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IL', 'Israel');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'IT', 'Italy');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CI', 'Ivory Coast');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'JE', 'Jersey');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'JM', 'Jamaica');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'JP', 'Japan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'JO', 'Jordan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KZ', 'Kazakhstan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KE', 'Kenya');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KI', 'Kiribati');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KP', 'Korea, Democratic People''s Republic of');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KR', 'Korea, Republic of');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'XK', 'Kosovo');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KW', 'Kuwait');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KG', 'Kyrgyzstan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LA', 'Lao People''s Democratic Republic');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LV', 'Latvia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LB', 'Lebanon');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LS', 'Lesotho');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LR', 'Liberia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LY', 'Libyan Arab Jamahiriya');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LI', 'Liechtenstein');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LT', 'Lithuania');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LU', 'Luxembourg');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MO', 'Macau');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MK', 'Macedonia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MG', 'Madagascar');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MW', 'Malawi');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MY', 'Malaysia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MV', 'Maldives');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ML', 'Mali');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MT', 'Malta');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MH', 'Marshall Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MQ', 'Martinique');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MR', 'Mauritania');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MU', 'Mauritius');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TY', 'Mayotte');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MX', 'Mexico');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'FM', 'Micronesia, Federated States of');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MD', 'Moldova, Republic of');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MC', 'Monaco');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MN', 'Mongolia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ME', 'Montenegro');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MS', 'Montserrat');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MA', 'Morocco');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MZ', 'Mozambique');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MM', 'Myanmar');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NA', 'Namibia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NR', 'Nauru');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NP', 'Nepal');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NL', 'Netherlands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AN', 'Netherlands Antilles');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NC', 'New Caledonia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NZ', 'New Zealand');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NI', 'Nicaragua');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NE', 'Niger');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NG', 'Nigeria');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NU', 'Niue');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NF', 'Norfolk Island');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'MP', 'Northern Mariana Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'NO', 'Norway');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'OM', 'Oman');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PK', 'Pakistan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PW', 'Palau');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PS', 'Palestine');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PA', 'Panama');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PG', 'Papua New Guinea');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PY', 'Paraguay');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PE', 'Peru');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PH', 'Philippines');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PN', 'Pitcairn');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PL', 'Poland');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PT', 'Portugal');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PR', 'Puerto Rico');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'QA', 'Qatar');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'RE', 'Reunion');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'RO', 'Romania');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'RU', 'Russian Federation');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'RW', 'Rwanda');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'KN', 'Saint Kitts and Nevis');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LC', 'Saint Lucia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'VC', 'Saint Vincent and the Grenadines');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'WS', 'Samoa');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SM', 'San Marino');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ST', 'Sao Tome and Principe');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SA', 'Saudi Arabia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SN', 'Senegal');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'RS', 'Serbia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SC', 'Seychelles');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SL', 'Sierra Leone');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SG', 'Singapore');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SK', 'Slovakia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SI', 'Slovenia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SB', 'Solomon Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SO', 'Somalia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ZA', 'South Africa');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GS', 'South Georgia South Sandwich Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ES', 'Spain');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'LK', 'Sri Lanka');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SH', 'St. Helena');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'PM', 'St. Pierre and Miquelon');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SD', 'Sudan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SR', 'Suriname');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SJ', 'Svalbard and Jan Mayen Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SZ', 'Swaziland');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SE', 'Sweden');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'CH', 'Switzerland');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'SY', 'Syrian Arab Republic');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TW', 'Taiwan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TJ', 'Tajikistan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TZ', 'Tanzania, United Republic of');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TH', 'Thailand');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TG', 'Togo');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TK', 'Tokelau');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TO', 'Tonga');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TT', 'Trinidad and Tobago');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TN', 'Tunisia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TR', 'Turkey');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TM', 'Turkmenistan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TC', 'Turks and Caicos Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'TV', 'Tuvalu');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'UG', 'Uganda');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'UA', 'Ukraine');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'AE', 'United Arab Emirates');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'GB', 'United Kingdom');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'US', 'United States');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'UM', 'United States minor outlying islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'UY', 'Uruguay');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'UZ', 'Uzbekistan');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'VU', 'Vanuatu');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'VA', 'Vatican City State');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'VE', 'Venezuela');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'VN', 'Vietnam');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'VG', 'Virgin Islands (British)');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'VI', 'Virgin Islands (U.S.)');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'WF', 'Wallis and Futuna Islands');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'EH', 'Western Sahara');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'YE', 'Yemen');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ZR', 'Zaire');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ZM', 'Zambia');
insert into aow_country (id, abbrev, name) values (aow_country_seq.nextVal, 'ZW', 'Zimbabwe');

insert into aow_user (id, username, password, email, role, active, cancelled) values (aow_user_seq.nextVal, 'admin', 'admin', 'admin@admin.net', 0, 1, 0);
insert into aow_user (id, username, password, email, role, active, cancelled) values (aow_user_seq.nextVal, 'retailer', 'retailer', 'retailer@retailer.net', 1, 1, 0);
insert into aow_user (id, username, password, email, role, active, cancelled) values (aow_user_seq.nextVal, 'customer', 'customer', 'customer@customer.net', 2, 1, 0);
insert into aow_user (id, username, password, email, role, active, cancelled) values (aow_user_seq.nextVal, 'retail', 'retail', 'limabeans@outlook.com', 1, 1, 0);
insert into aow_user (id, username, password, email, role, active, cancelled) values (aow_user_seq.nextVal, 'retail2', 'retail2', 'unicorn@hotmail.com', 1, 0, 0);
insert into aow_user (id, username, password, email, role, active, cancelled) values (aow_user_seq.nextVal, 'retail3', 'retail3', 'retailer3@gmail.com', 1, 1, 1);

insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Barefoot');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'The Pinot Project');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Apothic Red');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'LaMarca');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Chandon');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'DeMerlin {&} Charles');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Oyster Bay');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Riunite');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Santa Margheritta');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Matua');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Alyssien');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Tribaut');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'White Girl');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Josh');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Ranga Ranga');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'FlipFlop');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Ponteveze');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Monte Fuscaz');
insert into aow_brand (id, name) values (aow_brand_seq.nextVal, 'Starypoint');

insert into aow_type (id, name) values (aow_type_seq.nextVal, 'White');
insert into aow_type (id, name) values (aow_type_seq.nextVal, 'Red');
insert into aow_type (id, name) values (aow_type_seq.nextVal, 'Rosé');
insert into aow_type (id, name) values (aow_type_seq.nextVal, 'Champagne');

insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 1, 'Sauvignon Blanc');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 1, 'Semillon');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 1, 'Riesling');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 1, 'Moscato');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 1, 'Gewürztraminer');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 1, 'Pinot Grigio');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 2, 'Syrah');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 2, 'Merlot');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 2, 'Cabernet Sauvignon');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 2, 'Malbec');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 2, 'Pinot Noir');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 1, 'Zinfandel');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 2, 'Sangiovese');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 2, 'Barbera');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Syrah Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Grenache Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Cabernet Sauvignon Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Tempranillo Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Provence Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Zinfandel Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Sangiovese Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Tavel Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Pinot Noir Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 3, 'Mourvèdre Rosé');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 4, 'Blanc de Blancs');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 4, 'Blance de Noirs');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 4, 'Brut');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 4, 'Demi-Sec');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 4, 'Extra-Dry');
insert into aow_sub_type (id, type_id, name) values (aow_sub_type_seq.nextVal, 4, 'Rosé Champagne');

insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Blood Red', 3, 2, 112, 8, 2, 2017, 11.01, 20, sysdate, 2, 'An great, deep red that pairs well with anything.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_720.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Deep Red', 2, 2, 62, 7, 1.5, 2018, 13.01, 3, sysdate, 2, 'An amazing, tart red that pairs well with potatoes.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_235.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Delicious Red', 3, 2, 14, 11, .5, 2016, 16.12, 14, sysdate, 2, 'A delicious, sweet red that pairs well with potatoes.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_910.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Heady Champagne', 4, 2, 19, 27, .5, 2016, 13.52, 9, sysdate, 2, 'A great champagne for all occasions.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_1354.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Fresh Champagne', 1, 2, 130, 30, .5, 2018, 15.12, 18, sysdate, 2, 'A delicious rose champagne for all occasions.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_1829.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Rose Champagne', 5, 2, 146, 30, .5, 2018, 8.99, 82, sysdate, 2, 'A scrumptious rose champagne for all occasions.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_2502.jpeg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Rose Wine', 6, 2, 156, 22, 1.5, 2018, 9.99, 12, sysdate, 2, 'A tart rose wine for a good time.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_2516.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Sweet Wine', 7, 2, 162, 1, 2, 2016, 19.99, 83, sysdate, 2, 'A sweet white wine, great with fish.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_3756.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Lively Wine', 8, 2, 162, 11, 2, 2016, 13.99, 5, sysdate, 2, 'A lively red wine, great with everything.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_4217.jpg');  
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Vivacious', 9, 2, 42, 6, 2, 2016, 17.99, 16, sysdate, 2, 'A vivacious white wine, great for weddings.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_4458.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Old Form', 10, 2, 47, 11, 1, 2016, 12.99, 35, sysdate, 2, 'A deep red wine, great for bachelor parties.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_5540.jpg'); 
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Lover wine', 11, 2, 47, 22, 1.25, 2012, 13.32, 28, sysdate, 2, 'A fresh rose wine for the ladies.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_15296.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Ad Victorium', 12, 2, 59, 29, 2.25, 2012, 33.32, 14, sysdate, 2, 'To victory!', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_16480.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Girl Night!', 13, 2, 59, 21, 2, 2018, 15.32, 7, sysdate, 2, 'We will get white girl wasted!', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_20394.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Somber Wine', 14, 2, 78, 9, 2, 2018, 15.32, 9, sysdate, 2, 'For justice.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_20877.jpeg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Fun Wine', 15, 2, 79, 1, 1.5, 2018, 12.47, 12, sysdate, 2, 'Ranga Ranga!', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_21587.jpeg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Beach Wine', 16, 2, 84, 3, .5, 2018, 7.47, 62, sysdate, 2, 'Kick back and drink up!', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_28252.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Sun Wine', 17, 2, 84, 21, .5, 2018, 8.47, 1, sysdate, 2, 'Like the South of France!', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_57577.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Mountain Wine', 18, 2, 100, 14, 2.5, 2013, 17.59, 16, sysdate, 2, 'Comme le montagne.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_58770.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Starry Wine', 19, 2, 102, 14, 2, 2014, 12.23, 6, sysdate, 2, 'Comme les astres.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_59301.png');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Deep Champagne', 12, 2, 104, 29, 2, 1997, 42.23, 9, sysdate, 2, 'Deep.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_60212.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Light White', 8, 2, 11, 3, 2, 1997, 12.23, 46, sysdate, 2, 'Straight from Jersey!.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_61555.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Crisp Rose', 2, 2, 15, 21, 2, 1997, 16.99, 59, sysdate, 2, 'Delicious to the last drop.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_62005.jpg');
insert into aow_inventory (id, name, brand_id, user_id, country_id, sub_type_id, volume, year, price, quantity, submitted, status, description, image_url) 
    values (aow_inventory_seq.nextVal, 'Lovely Champagne', 12, 2, 114, 29, 2, 1997, 42.23, 92, sysdate, 1, 'Deep.', 'https://s3.us-east-2.amazonaws.com/americaonwine/ci_veuve_clicquot_yellow_label_3d99da125d8c84f1.jpeg');



insert into aow_transaction (id, order_number, inventory_id, quantity, user_id, rating, transaction_date, comments) 
    values (aow_transaction_seq.nextVal, 1, 1, 1, 2, 1, sysdate, 'Comments? Your wine sucks!');
insert into aow_transaction (id, order_number, inventory_id, quantity, user_id, rating, transaction_date, comments) 
    values (aow_transaction_seq.nextVal, 1, 2, 1, 2, 3, sysdate, 'Comments? Your wine sucks!');
insert into aow_transaction (id, order_number, inventory_id, quantity, user_id, rating, transaction_date, comments) 
    values (aow_transaction_seq.nextVal, 1, 3, 1, 2, 2, sysdate, 'Comments? Your wine sucks!');

commit; -- Jenn Rocks!