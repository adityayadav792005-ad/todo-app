import React, { useState } from "react";
import "./Login.css";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import API from "../service/api";

const Login = () => {
  const navigate = useNavigate();
  const [login, setLogin] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setLogin({
      ...login,
      [e.target.name]: e.target.value,
    });
  };
  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await API.post("/login", login);
      if (response.data === "login successfully") {
        alert(response.data);
        localStorage.setItem("email", login.email);

        setLogin({
          email: "",
          password: "",
        });
        navigate("/list");
      } else {
        alert(response.data);
      }
    } catch (error) {
      console.log(error);
      alert("Something Wrong");
    }
  };

  return (
    <div className="register-container">
      <form onSubmit={handleLogin}>
        <h1>Todo App</h1>

        <h3>Login</h3>

        <div className="input-box">
          <input
            type="email"
            placeholder="Enter Email"
            name="email"
            value={login.email}
            onChange={handleChange}
          />

          <input
            type="password"
            placeholder="Enter Password"
            name="password"
            value={login.password}
            onChange={handleChange}
          />
        </div>

        <button type="submit">sign in</button>

        <p>
          Don't have an account?
          <Link to="/register">Sign Up</Link>
        </p>
      </form>
    </div>
  );
};

export default Login;
