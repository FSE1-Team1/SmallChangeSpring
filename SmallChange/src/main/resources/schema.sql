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




