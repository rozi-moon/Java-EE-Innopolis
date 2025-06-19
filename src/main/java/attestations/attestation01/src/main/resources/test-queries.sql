select * from users
select * from card
select * from operation o

insert into users (login, password, email, phone_number) value
    ('some_user11', 'password11', 'some_email10@mail.ru', '89995451234')
insert into card (card_number, expire_date, balance, user_id) value
    ('2020145621332011', '2030-05-20', 1000, 1)
insert into operation (operation_type, balance_change, operation_date, card_id) value
    ('INCOME', 1000, '2025-06-15', 11)

update users u set login='new_login', password = 'new_password'
        where id = 11
update card set balance = balance+10000 where id=11
insert into operation (operation_type, balance_change, operation_date, card_id) value
    ('INCOME', 10000, '2025-06-15', 11)

delete from operation where card_id=1
delete from card where user_id=1
delete from users where id=1