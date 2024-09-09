INSERT INTO notice (title, content, who,views, createDate, updateDate)
VALUES ('USA','content','incu',100,now(),now());
INSERT INTO notice (title, content, who,views, createDate, updateDate)
VALUES (1,'content','incu',11,now(),now());



insert into payments (partner_id, user_id, order_id, payment_amount, payment_date, payment_method, pg_provider_id, status) values (97, 5, 40, 143454, '2024-09-06', '1', 13, '');
insert into payments (partner_id, user_id, order_id, payment_amount, payment_date, payment_method, pg_provider_id, status) values (79, 41, 41, 722142, '2024-09-06', '1', 86, '');
insert into payments (partner_id, user_id, order_id, payment_amount, payment_date, payment_method, pg_provider_id, status) values (42, 76, 42, 378106, '2024-09-06', '2', 40, '');
insert into payments (partner_id, user_id, order_id, payment_amount, payment_date, payment_method, pg_provider_id, status) values (26, 96, 43, 618636, '2024-09-06', '3', 97, '');


update payments
set payment_method = 'PASSPORT'
where 1=1
;


update payments
set status = 'completed'
where 1=1
;