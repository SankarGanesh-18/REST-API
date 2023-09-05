import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from './Navbar';
import Details from './components/Details';
import Create from './components/Create';
import Update from './components/Update';
import Main from './components/Main';
// import Main from './Main';
// import File from './File';


function App() {
  return (
    <div>
      <BrowserRouter>
      {/* <Navbar /> Include the Navbar component here */}
      <Routes>
        <Route index path="/"element={<Navbar/>} />
        <Route path="/read" element={<Main/>}/>
        <Route path="/delete" element={<Details/>}/>
        <Route path="/create" element={<Create/>} />
        <Route path="/update" element={<Update/>} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
