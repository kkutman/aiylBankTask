create sequence test_seq start with 50 increment by 1;

create table task
(
    completed   boolean not null,
    id          bigint  not null,
    description varchar(255),
    primary key (id)
)