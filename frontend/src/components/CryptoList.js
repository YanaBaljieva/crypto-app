import React, { useState, useEffect } from 'react';
import { fetchCryptoData, buyCrypto, sellCrypto } from '../api';

const CryptoList = () => {
    const [data, setData] = useState({});
    const [amounts, setAmounts] = useState({});
    const [message, setMessage] = useState('');

    useEffect(() => {
        const loadCryptoData = async () => {
            const data = await fetchCryptoData();
            setData(data);
        };
        loadCryptoData();

        const interval = setInterval(loadCryptoData, 5000);
        return () => clearInterval(interval);
    }, []);

    const handleBuy = async (symbol) => {
        if (!amounts[symbol]) {
            setMessage('Please enter a valid amount to buy.');
            return;
        }
        const response = await buyCrypto(symbol, amounts[symbol]);
        setMessage(response);

        setTimeout(() => setMessage(''), 3000);

    };

    const handleSell = async (symbol) => {
        if (!amounts[symbol]) {
            setMessage('Please enter a valid amount to sell.');
            return;
        }
        const response = await sellCrypto(symbol, amounts[symbol]);
        setMessage(response);

        setTimeout(() => setMessage(''), 3000);
    };

    return (
        <div>
            <p style={{ color: 'yellow' }}>{message}</p>
            <ul style={{ listStyleType: 'none', padding: 0 }}>
                {Object.entries(data).map(([symbol, value]) => (
                    <li key={symbol}>
                        <strong>{symbol}:</strong> {JSON.stringify(value)}
                        <input
                            type="number"
                            value={amounts[symbol] || ''}
                            onChange={(e) => setAmounts({ ...amounts, [symbol]: e.target.value })}
                            placeholder="Amount"
                            style={{ marginLeft: '10px', width: '80px' }}
                        />
                        <button onClick={() => handleBuy(symbol)} style={{ marginLeft: '10px' }}>Buy</button>
                        <button onClick={() => handleSell(symbol)} style={{ marginLeft: '5px' }}>Sell</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CryptoList;
