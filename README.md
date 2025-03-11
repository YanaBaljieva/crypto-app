# crypto-app

Web application that simulates a cryptocurrency trading platform, allowing users to:

* View real-time prices of the top 20 cryptocurrencies using the Kraken API.
* Maintain a virtual account balance for buying and selling crypto with a history of all transactions made (without actually buying or selling at the exchange).
* Reset their account balance to a starting value.

Technologies used:
* Java Spring Boot
* React JS
* H2 database (still in progress integration with storage)

Functionality:

1. Display Top 20 Crypto Prices
2. Account Balance and Transactions
  * Initialize a virtual account balance with a starting value (e.g., $10,000).
  * Implement a mechanism for users to buy and sell cryptocurrencies
    * Buying
    * Selling
3. Transactions history
4. Reset Button

# How to start

1. Clone the repository
git clone 'https://github.com/YanaBaljieva/crypto-app'

2. Navigate to the frontend directory, open a terminal and type:
npm start

3. Start the backend by opening Intelij and run the DemoApplication.java file
