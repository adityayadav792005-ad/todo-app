import React, { useState } from "react";
import "./Register.css";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import API from "../service/api";

const Register = () => {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await API.post("/user", user);

      if (response.data === "Registration Successful") {
        alert(response.data);

        setUser({
          name: "",
          email: "",
          password: "",
        });

        navigate("/");
      } else {
        alert(response.data);
      }
    } catch (error) {
      console.log(error);
      alert("Something went wrong");
    }
  };

  return (
    <div className="register-container">
      <form onSubmit={handleSubmit}>
        <h1>Todo App</h1>

        <h3>Register</h3>

        <div className="input-box">
          <input
            type="text"
            placeholder="Enter Name"
            name="name"
            value={user.name}
            onChange={handleChange}
          />

          <input
            type="email"
            placeholder="Enter Email"
            name="email"
            value={user.email}
            onChange={handleChange}
          />

          <input
            type="password"
            placeholder="Enter Password"
            name="password"
            value={user.password}
            onChange={handleChange}
          />
        </div>

        <button type="submit">Sign Up</button>

        <p>
          have an account?
          <Link to="/">Sign In</Link>
        </p>
      </form>
    </div>
  );
};

export default Register;
