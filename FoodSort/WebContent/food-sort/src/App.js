import React from 'react';
import logo from './mgm-Logo-1.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          MGM Interview Food Sort
        </p>

        <a
          className="App-link"
          href="#"
          target="_blank"
          rel="noopener noreferrer"
        >
          Create Data
        </a>
        <a
        className="App-link"
        href="#"
        target="_blank"
        rel="noopener noreferrer"
            >
            Delete Data
        </a>
        <a
        className="App-link"
        href="#"
        target="_blank"
        rel="noopener noreferrer"
            >
            Sort Data
        </a>
        <a
        className="App-link"
        href="#"
        target="_blank"
        rel="noopener noreferrer"
            >
            Unsort Data
        </a>
      </header>
    </div>
  );
}

export default App;
