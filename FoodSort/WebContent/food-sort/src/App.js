import React from 'react';
import Actions from './components/Actions.react';
import logo from './mgm-Logo-1.svg';
import './App.css';
import Content from "./components/Content.react";


function App() {

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
        <h1>MGM Interview Food Sort</h1>
        <Actions/>
        <Content/>
    </div>
  );
}

export default App;
