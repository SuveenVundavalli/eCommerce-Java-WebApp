create table My_Cart
(
	id int(20) primary key auto_increment,
	user_id varchar2(20) references user(id),
	product_name varchar2(20) references product(name),
	price number,
	status char default 'N',
	date_added date default sysdate(),
	quantity number default 1
);

create table user
(
	id varchar2(20) primary key,
	name varchar2(40) not null,
	password varchar2(40) not null,
	contact varchar2(40) not null,
	role varchar2(40) default "ROLE_USER" not null
);

create table category
(
	id varchar2(20) primary key,
	name varchar2(40) not null,
	description varchar2(100) not null
);


create table supplier
(
	id varchar2(20) primary key,
	name varchar2(40) not null,
	description varchar2(100) not null
);

create table product
(
	id varchar2(20) primary key,
	name varchar2(40) not null,
	description varchar2(50) not null,
	price number not null,
	category_id varchar2(20) references TCategory(id) on delete cascade,
	supplier_id varchar2(20) references TSupplier(id) on delete cascade,
);

create table contact
(
	id int primary key auto_increment, 
	name varchar2(40) not null,
	email varchar2(40) not null,
	contact varchar2(40) not null,
	message varchar2(255) not null,
	date_added date default sysdate()

);