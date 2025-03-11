import React, { useState, useEffect } from 'react';
import { fetchTransactions } from '../api';

const TransactionHistory = () => {
    const [transactions, setTransactions] = useState([]);

    useEffect(() => {
        const loadTransactions = async () => {
            const data = await fetchTransactions();
            setTransactions(data);
        };

        loadTransactions();

        const interval = setInterval(loadTransactions, 5000);
        return () => clearInterval(interval);
    }, []);

    return (
        <div>
            <h2>Transaction History</h2>
            {transactions.length === 0 ? (
                <p>No transactions yet.</p>
            ) : (
                <ul style={{ listStyleType: 'none', padding: 0 }}>
                    {transactions.map((tx, index) => (
                        <li key={index} style={{ marginBottom: '10px', borderBottom: '1px solid gray', paddingBottom: '5px' }}>
                            Currency: {tx.symbol}  Amount: {tx.amount}  Price: ${tx.price}  Date: {tx.transactionDate}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default TransactionHistory;
