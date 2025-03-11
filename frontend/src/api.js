import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

export const fetchBalance = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/balance`);
        return response.data;
    } catch (error) {
        console.error('Error fetching balance!', error);
        return 0;
    }
};

export const fetchCryptoData = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/crypto`);
        return response.data;
    } catch (error) {
        console.error('Error fetching crypto data!', error);
        return {};
    }
};

export const resetData = async () => {
    try {
        const response = await axios.post(`${BASE_URL}/reset`);
        return response.data;
    } catch (error) {
        console.error('Error resetting data!', error);
        return 'Error resetting data!';
    }
};

export const buyCrypto = async (symbol, amount) => {
    try {
        const response = await axios.post(`${BASE_URL}/buy?symbol=${symbol}&amount=${amount}`);
        return response.data;
    } catch (error) {
        console.error(`Error buying ${symbol}:`, error);
        return 'Transaction failed.';
    }
};

export const sellCrypto = async (symbol, amount) => {
    try {
        const response = await axios.post(`${BASE_URL}/sell?symbol=${symbol}&amount=${amount}`);
        return response.data;
    } catch (error) {
        console.error(`Error selling ${symbol}:`, error);
        return 'Transaction failed.';
    }
};

export const fetchTransactions = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/transactions`);
        return response.data;
    } catch (error) {
        console.error('Error fetching transactions!', error);
        return [];
    }
};
