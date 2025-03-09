import { useState } from 'react';
import reactLogo from './assets/react.svg';
import viteLogo from '/vite.svg';
import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import EmployeeComponent from './components/EmployeeComponent';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ListEmployeeComponent />} />

        <Route path="/employees" element={<ListEmployeeComponent />} />

        <Route path="/add-employee" element={<EmployeeComponent/>} />

        <Route path="/edit-employee/:id" element={<EmployeeComponent/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
