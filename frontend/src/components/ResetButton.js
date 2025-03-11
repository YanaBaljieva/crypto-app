import React, { useState, useEffect } from 'react';
import { resetData, fetchBalance } from '../api';

const ResetButton = ({ clearMessage}) => {
    const [message, setMessage] = useState('');

    const handleReset = async () => {
        setMessage('');
        const response = await resetData();
        setMessage(response);
        clearMessage();

        setTimeout(() => setMessage(''), 3000);
    };


    return (
        <div>
            <button onClick={handleReset} className="crypto-button">Reset</button>
            <p style={{ color: 'yellow' }}>{message}</p>
        </div>
    );
};

export default ResetButton;
