create table if not exist loan
(
    loan_id int not null primary Key,
    mobile_number varcar(12) not null,
    loan_type varcar(30) not null,
    loan_amount varcar(10) not null,
    amount_paid varcar(10) not null,
    outstanding_Amount varcar(10) not null,
    created_at date not null,
    created_by varchar2(20) not null,
    updated_at date default null,
    updated_by varchar2(20) default null
);