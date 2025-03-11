import './App.css';
import React, { useState } from 'react';
import Balance from './components/Balance';
import CryptoList from './components/CryptoList';
import ResetButton from './components/ResetButton';
import TransactionHistory from './components/TransactionHistory';

function App() {
    const [message, setMessage] = useState('');

    return (
        <div className="App">
            <header className="App-header">
                <h1>Welcome to my crypto app</h1>
                <Balance />
                <ResetButton clearMessage={() => setMessage('')} />
                <CryptoList message={message} setMessage={setMessage} />
                <TransactionHistory />
            </header>
        </div>
    );
}

export default App;
