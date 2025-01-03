INSERT INTO SC_CLIENT ("client_id", "first_name", "last_name", "dob", "email", "password", "country", "postal_code") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515', 'ZTI', '1', to_date('2001-MAR-03', 'YYYY-MON-DD'), 'zti@gmail.com', 'Testing123*','IN', '18181818');
INSERT INTO SC_CLIENT_IDENTIFICATION ("client_id", "type", "value") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515', 'Passport', '10101010');
INSERT INTO SC_INSTRUMENT("instrument_id","instrument_description","external_id","external_id_type","min_quantity","max_quantity","category_id") VALUES ('T67897','USA, Note 2.5 31jan2021 2Y','9128285X4','CUSIP',100,1000,'GOVT');
INSERT INTO SC_PRICE ("instrument_id","bid_price","ask_price","timestamp") VALUES ('T67897',0.99828125,0.998125,TO_DATE('2022-01-22', 'yyyy-mm-dd'));
INSERT INTO SC_ACCOUNT ("client_id", "account_number", "max_accounts") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515', 'abcd-efgh', 4);
INSERT INTO SC_HOLDING ("client_id", "instrument_id", "direction", "no_of_shares") values ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515','T67897','B','1');
INSERT INTO SC_PREFERENCES("client_id", "investment_purpose", "risk_tolerance", "income_category", "length_of_investment") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515','Savings', 'Average', '20000-60000', '5-7years');
INSERT INTO SC_TRADE_HISTORY ("client_id","cash_value","direction","trade_id","instrument_id","quantity","execution_price","trade_timestamp") VALUES('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515',500,'B','T123456','T67897',1,300,null);

commit;