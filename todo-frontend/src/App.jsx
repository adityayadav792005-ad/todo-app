import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Register from "./component/Register";
import Login from "./component/Login";
import List from "./component/List";

const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/list" element={<List />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
