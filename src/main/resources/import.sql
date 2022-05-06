DELETE FROM credit_product;
ALTER SEQUENCE credit_product_generator RESTART;
INSERT INTO credit_product (id, min_term, max_term, max_sum, min_sum, currency) VALUES (nextval('credit_product_generator'), 6, 36, 100000, 500, 'USD');

DELETE FROM user_info;
ALTER SEQUENCE user_info_generator RESTART;
INSERT INTO user_info (id, user_id, name, surname, patronymic, phone_number, company, position, address_company, work_phone) VALUES (nextval('user_info_generator'), 1, 'Ivan', 'Ivanov', 'Ivanovich', 12345678, 'Andersen', 'Developer', 'Minsk', 12346789);

DELETE FROM loan;
ALTER SEQUENCE loan_generator RESTART;
INSERT INTO loan (id, user_id, credit_program, credit_status, sum, term, monthly_payment, interest_rate, date_of_application, date_of_start, date_of_end, credit_account, user_info_id, credit_product_id) VALUES (nextval('loan_generator'), 1, 'CONSUMER_CREDIT', 'ACTIVE', 10000, 24, 1000, 15,  '2022-03-30', '2022-03-30', '2022-03-30', 10, 1, 1);
