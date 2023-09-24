create table users(
    id bigint not null primary key,
    username varchar(50) not null,
    password varchar(500) not null,
    email varchar(50) not null,
    role int default 0 not null,
    created_at timestamp with time zone default now() not null,
    updated_at timestamp with time zone default now() not null,
    deleted integer default 0 not null
);

create table problems(
    id serial not null primary key ,
    name varchar(100) not null,
    level varchar(20) not null,
    describe text,
    created_at timestamp with time zone default now() not null,
    updated_at timestamp with time zone default now() not null,
    deleted integer default 0 not null
);

create table submissions(
    id bigint not null primary key ,
    pid bigint not null, -- 问题id
    uid bigint not null, -- 用户id
    language varchar(20) not null ,
    code text not null ,
    created_at timestamp with time zone default now() not null,
    updated_at timestamp with time zone default now() not null,
    deleted integer default 0 not null,
    constraint fk_pid foreign key (pid) references problems(id) on delete cascade,
    constraint fk_uid foreign key (uid) references users(id) on delete cascade
);

create table testcases(
    id bigint not null primary key ,
    pid bigint not null ,
    type int2 not null,
    input text,
    ans text,
    created_at timestamp with time zone default now() not null,
    updated_at timestamp with time zone default now() not null,
    deleted integer default 0 not null,
    constraint fk_pid foreign key (pid) references problems(id) on delete cascade
);

create table verdicts(
    id bigint not null primary key ,
    sid bigint not null ,
    tid bigint not null ,
    status int2 default 0 not null, -- 0 没测试   1 通过   2 答案错误    3 编译错误
    exec_time int default 0 not null,
    created_at timestamp with time zone default now() not null,
    updated_at timestamp with time zone default now() not null,
    deleted integer default 0 not null,
    constraint fk_sid foreign key (sid) references submissions(id) on delete cascade ,
    constraint fk_tid foreign key (tid) references testcases(id) on delete cascade
);