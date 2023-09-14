drop table if exists attractions;

create table attractions (
    name    varchar(255) unique not null,
    phone   varchar(255)
)

insert into attractions ('Disneyland Park', '(234) 567-8901');
insert into attractions ('Six Flags Park', '(567) 890-1234');
insert into attractions ('Universal Studios Hollywood', '(345) 678-9012');