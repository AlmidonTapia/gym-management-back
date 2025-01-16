create database gym_management;
use gym_management;


create table tcustomer (
    idCustomer char(36) not null,
	firstName varchar(70) not null,
	surName varchar(40) not null,
	dni char(8),
    phone varchar(16),
    age int,
    gender bool not null,
    state bool not null,
    createdAt datetime not null,
	updatedAt datetime not null,
	primary key(idCustomer)
);


create table ttrainer  (
    idTrainer  char(36) not null,
    firstName varchar(70) not null,
	surName varchar(40) not null,
	dni char(8),
    specialization varchar(70),
    phone varchar(15),
    state bool not null,
    createdAt datetime not null,
	updatedAt datetime not null,
	primary key(idTrainer )
);

create table tuser (
    idUser char(36) not null,
	nameUser varchar(70) not null,
    email varchar(100) unique not null,
    password varchar(255) not null,
    rol varchar(50) not null,
    state bool not null,
    createdAt datetime not null,
	updatedAt datetime not null,
	primary key(idUser)
);

create table tmembership (
    idMembership char(36) not null,
    customer_id char(36) not null,
    start_date  datetime not null,
    expiration_date datetime not null,
    status bool not null,
    createdAt datetime not null,
	updatedAt datetime not null,
	primary key(idMembership),
	foreign key (customer_id) references tcustomer(idCustomer) on delete cascade

);

create table tpayment (
    idPayment  char(36) not null,
    customer_id char(36) not null,
    membership_id char(36) not null,
    amount decimal(10, 2) not null,
    payment_date  datetime not null,
    payment_method varchar(50) not null,
    createdAt datetime not null,
	updatedAt datetime not null,
	primary key(idPayment),
    foreign key (customer_id) references tcustomer(idCustomer) on delete cascade,
    foreign key (membership_id) references tmembership(idMembership) on delete cascade
);

create table tdailyRecord  (
    idDailyRecord char(36) not null,
    customer_id char(36) not null,
    date datetime not null,
    primary key(idDailyRecord),
    foreign key (customer_id) references tcustomer(idCustomer) on delete cascade
);
