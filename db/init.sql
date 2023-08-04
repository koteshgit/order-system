CREATE TABLE order (
    id NUMBER PRIMARY KEY,
    order_status VARCHAR(50) NOT NULL UNIQUE,
	subtotal  number,
	tax NUMBER 
	total NUMBER,
	order_date DATETIME,
	shipping_charge NUMBER
);

CRREATE TABLE ORDERITEM{
	item_id NUMBER PRIMARY KEY,
	item_quantity NUMBER,
	itemName VARCHAR(255)
};

CRREATE TABLE ORDERITEM{
	billId NUMBER PRIMARY KEY,
	billing_address1 VARCHAR(255),
	billing_address2 VARCHAR(255),
	billing_city VARCHAR(255),
	billingState VARCHAR(255),
	billing_zip_code NUMBER
}