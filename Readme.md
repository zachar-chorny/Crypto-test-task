# Crypto project
## Introduction
This application pulls the current price of BTC, ETH and XRP cryptocurrencies every minute, information about the time, the name of the currency and its price is currently stored in the database.
## BreakPoints
This application has 4 breakpoints:

GET /cryptocurrencies/min-price - Accepts the name of the cryptocurrency as a RequestParam. Displays the minimum price of the specified cryptocurrency received during the operation of the application.

GET /cryptocurrencies/max-price - Accepts the name of the cryptocurrency as a RequestParam. Displays the maximum price of the specified cryptocurrency received during the operation of the application.

GET /cryptocurrencies/page - Accepts a page number and page size as a RequestParam. Displays data from the database on the specified page.

GET /cryptocurrencies/csv - Doesn't accept anything. When you go to this breakpoint, a small report on the current records in the database is saved in csv, which will be created in the resources folder

## How to start the application
1.Fork this project on GitHub

2.In the application.properties file, you must enter data about your database. In the course of writing this test, I used a database in the cloud, so there is no data there.

3.Run the application

