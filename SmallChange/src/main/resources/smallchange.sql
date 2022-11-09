DROP TABLE SC_ACCOUNT;
DROP TABLE SC_CLIENT_IDENTIFICATION;
DROP TABLE SC_PRICE;
DROP TABLE SC_TRADE_HISTORY;
DROP TABLE SC_PREFERENCES;
DROP TABLE SC_HOLDING;
DROP TABLE SC_INSTRUMENT;
DROP TABLE SC_CLIENT;

CREATE TABLE SC_CLIENT (    
    "client_id" varchar(200),
    "first_name" VARCHAR2(100 BYTE),
    "last_name" VARCHAR2(100 BYTE),
    "dob" Date,
    "email" VARCHAR2(100 BYTE),
    "password" VARCHAR2(100 BYTE),
    "country" VARCHAR2(100 BYTE),
    "postal_code" VARCHAR2(100 BYTE)
);

CREATE TABLE SC_ACCOUNT (    
    "client_id" varchar(200),
    "account_number" VARCHAR2(100 BYTE),
    "max_accounts" NUMBER
);

CREATE TABLE SC_CLIENT_IDENTIFICATION (
    "client_id" VARCHAR(200),
    "type" VARCHAR2(200),
    "value" VARCHAR(200)
);

CREATE TABLE SC_PRICE (
    "instrument_id" VARCHAR2(100 BYTE),
    "bid_price" NUMBER(7,2),
    "ask_price" NUMBER(7,2),
    "timestamp" DATE
);

CREATE TABLE SC_PREFERENCES (    
    "client_id" varchar(200),
    "investment_purpose" VARCHAR2(100 BYTE),
    "risk_tolerance" VARCHAR2(100 BYTE),
    "income_category" VARCHAR2(100 BYTE),
    "length_of_investment" VARCHAR2(100 BYTE)
);

CREATE TABLE SC_INSTRUMENT (
    "instrument_id" VARCHAR2(100 BYTE),
    "instrument_description" VARCHAR2(100 BYTE),
    "external_id" VARCHAR2(100 BYTE),
    "external_id_type" VARCHAR2(100 BYTE),
    "min_quantity" NUMBER(6,0),
    "max_quantity" NUMBER(6,0),
    "category_id" VARCHAR2(100 BYTE)
);

CREATE TABLE SC_TRADE_HISTORY (
    "client_id" varchar(200) ,
    "cash_value" number,
    "direction" varchar(5),
    "trade_id" varchar(200) primary key,
    "instrument_id"  varchar(200),
    "quantity" number,
    "execution_price" number,
	"trade_timestamp" TIMESTAMP
);

CREATE TABLE SC_HOLDING (
    "instrument_id" VARCHAR2(100 BYTE),
    "client_id"   varchar(200) ,
    "direction"   varchar(200) ,
    "no_of_shares" DECIMAL
);

ALTER TABLE SC_CLIENT ADD CONSTRAINT SC_CLIENT_PK PRIMARY KEY ("client_id");
ALTER TABLE SC_PRICE ADD CONSTRAINT SC_PRICE_PK PRIMARY KEY ("instument_id","timestamp");
ALTER TABLE SC_CLIENT_IDENTIFICATION ADD CONSTRAINT SC_CLIENT_IDENTIFICATION_FK FOREIGN KEY ("client_id") REFERENCES SC_Client ("client_id") ENABLE;
ALTER TABLE SC_ACCOUNT ADD CONSTRAINT SC_ACCOUNT_FK FOREIGN KEY ("client_id") REFERENCES SC_CLIENT ("client_id") ENABLE;
ALTER TABLE SC_INSTRUMENT ADD CONSTRAINT SC_INSTRUMENT_PK PRIMARY KEY ("instrument_id");
ALTER TABLE SC_HOLDING ADD CONSTRAINT SC_HOLDING_FK FOREIGN KEY ("instrument_id") REFERENCES SC_INSTRUMENT ("instrument_id") ENABLE;
ALTER TABLE SC_PREFERENCES ADD CONSTRAINT SC_PREFERENCES_FK FOREIGN KEY ("client_id") REFERENCES SC_CLIENT ("client_id") ENABLE;
ALTER TABLE SC_TRADE_HISTORY ADD CONSTRAINT SC_TRADE_HISTORY_FK FOREIGN KEY ("client_id") REFERENCES SC_CLIENT ("client_id") ENABLE;
ALTER TABLE SC_PRICE ADD CONSTRAINT SC_PRICE_FK FOREIGN KEY ("instrument_id") REFERENCES SC_INSTRUMENT ("instrument_id") ENABLE;

INSERT INTO SC_CLIENT ("client_id", "first_name", "last_name", "dob", "email", "password", "country", "postal_code") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515', 'ZTI', '1', to_date('2001-MAR-03', 'YYYY-MON-DD'), 'zti@gmail.com', 'Testing123*','IN', '18181818');
INSERT INTO SC_CLIENT_IDENTIFICATION ("client_id", "type", "value") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515', 'Passport', '10101010');
INSERT INTO SC_INSTRUMENT("instrument_id","instrument_description","external_id","external_id_type","min_quantity","max_quantity","category_id") VALUES ('T67897','USA, Note 2.5 31jan2021 2Y','9128285X4','CUSIP',100,1000,'GOVT');
INSERT INTO SC_PRICE ("instrument_id","bid_price","ask_price","timestamp") VALUES ('T67897',0.99828125,0.998125,TO_DATE('2022-01-22', 'yyyy-mm-dd'));
INSERT INTO SC_ACCOUNT ("client_id", "account_number", "max_accounts") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515', 'abcd-efgh', 4);
INSERT INTO SC_HOLDING ("client_id", "instrument_id", "direction", "no_of_shares") values ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515','T67897','B','1');
INSERT INTO SC_PREFERENCES("client_id", "investment_purpose", "risk_tolerance", "income_category", "length_of_investment") VALUES ('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515','Savings', 'Average', '20000-60000', '5-7years');
INSERT INTO SC_TRADE_HISTORY ("client_id","cash_value","direction","trade_id","instrument_id","quantity","execution_price","trade_timestamp") VALUES('ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515',500,'B','T123456','T67897',1,300,null);

create or replace PROCEDURE proc_delete_instrument_delete_holding (
	parm_instrument_to_delete IN VARCHAR2
)
IS
BEGIN

    DELETE FROM SC_PRICE WHERE "instrument_id"=parm_instrument_to_delete;
	DELETE FROM SC_HOLDING WHERE "instrument_id"=parm_instrument_to_delete;
    DELETE FROM SC_INSTRUMENT WHERE "instrument_id"=parm_instrument_to_delete;

END;


COMMIT;