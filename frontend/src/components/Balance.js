import React, { useState, useEffect } from 'react';
import { fetchBalance } from '../api';

const Balance = () => {
    const [balance, setBalance] = useState(0);

    useEffect(() => {
        const loadBalance = async () => {
            const data = await fetchBalance();
            setBalance(data);
        };

       loadBalance();

       const interval = setInterval(loadBalance, 500);
       return () => clearInterval(interval);
    }, []);

    return <h2>Balance: ${balance}</h2>;
};

export default Balance;
