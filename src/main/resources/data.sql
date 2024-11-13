
INSERT INTO BRAND (ID, NAME) VALUES
	(1, 'ZARA');
	
INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
  (1, parsedatetime('14-06-2020 00:00:00', 'dd-MM-yyyy HH:mm:ss'), parsedatetime('31-12-2020 23:59:59', 'dd-MM-yyyy HH:mm:ss'), 1, 35455, 0, 35.50, 'EUR'), 
  (1, parsedatetime('14-06-2020 15:00:00', 'dd-MM-yyyy HH:mm:ss'), parsedatetime('14-06-2020 18:30:00', 'dd-MM-yyyy HH:mm:ss'), 2, 35455, 1, 25.45, 'EUR'),
  (1, parsedatetime('15-06-2020 00:00:00', 'dd-MM-yyyy HH:mm:ss'), parsedatetime('15-06-2020 11:00:00', 'dd-MM-yyyy HH:mm:ss'), 3, 35455, 1, 30.50, 'EUR'),
  (1, parsedatetime('15-06-2020 16:00:00', 'dd-MM-yyyy HH:mm:ss'), parsedatetime('31-12-2020 23:59:59', 'dd-MM-yyyy HH:mm:ss'), 4, 35455, 1, 38.95, 'EUR');