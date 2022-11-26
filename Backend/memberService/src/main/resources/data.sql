

CREATE TABLE Bills(mid varchar(20), lastPaidDate date, dueAmount int, lateCharge int, dueDate date, pid varchar(20));

INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) VALUES ('M101', '2019-04-01', 10000, 800, '2022-03-01',  'P101');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M102', '2020-04-10', 50500, 6500, '2023-10-10', 'P103');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M103', '2021-10-20', 12000, 0, '2023-06-30', 'P104');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M104', '2020-01-01', 8000, 0, '2022-11-10', 'P102;');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M105', '2021-01-05', 25000, 4000, '2022-09-05', 'P103');