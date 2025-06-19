insert into users (login, password, email, phone_number)
values  ('some_user1', 'password1', 'some_email1@mail.ru', '89991234561'),
        ('some_user2', 'password2', 'some_email2@mail.ru', '89991234562'),
        ('some_user3', 'password3', 'some_email3@mail.ru', '89991234563'),
        ('some_user4', 'password4', 'some_email4@mail.ru', '89991234564'),
        ('some_user5', 'password5', 'some_email5@mail.ru', '89991234565'),
        ('some_user6', 'password6', 'some_email6@mail.ru', '89991234566'),
        ('some_user7', 'password7', 'some_email7@mail.ru', '89991234567'),
        ('some_user8', 'password8', 'some_email8@mail.ru', '89991234568'),
        ('some_user9', 'password9', 'some_email9@mail.ru', '89991234569'),
        ('some_user10', 'password10', 'some_email10@mail.ru', '89991234560')

insert into card (card_number, expire_date, balance, user_id) values
        ('2020145621332001', '2029-10-20', 1000, 1),
        ('2020145621332002', '2026-12-25', 500, 2),
        ('2020145621332003', '2025-11-24', 35100, 3),
        ('2020145621332004', '2028-04-23', 100000, 4),
        ('2020145621332005', '2027-10-27', 10000, 5),
        ('2020145621332006', '2026-06-07', 100, 6),
        ('2020145621332007', '2027-05-11', 1256, 7),
        ('2020145621332008', '2026-12-16', 10, 8),
        ('2020145621332009', '2029-11-30', 1045, 9),
        ('2020145621332000', '2028-02-28', 2243, 10)

insert into operation (operation_type, balance_change, operation_date, card_id) values
        ('INCOME', 1000, '2025-06-02', 1),
        ('INCOME', 500, '2025-06-02', 2),
        ('INCOME', 35100, '2025-06-02', 3),
        ('INCOME', 100000, '2025-06-02', 4),
        ('INCOME', 10000, '2025-06-02', 5),
        ('INCOME', 100, '2025-06-02', 6),
        ('INCOME', 1256, '2025-06-02', 7),
        ('INCOME', 10, '2025-06-02', 8),
        ('INCOME', 1045, '2025-06-02', 9),
        ('INCOME', 2243, '2025-06-02', 10)