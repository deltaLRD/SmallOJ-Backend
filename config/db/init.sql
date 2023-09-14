create table users(
    id bigint not null primary key,
    username varchar(50) not null,
    password varchar(500) not null,
    email varchar(50) not null,
    deleted integer default 0 not null
);

create table roles (
    uid bigint not null,
    role varchar(50) not null,
    constraint fk_authorities_users foreign key(uid) references users(id)
);
create unique index ix_auth_username on roles (uid,role);