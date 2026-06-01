import React, { useEffect, useState } from "react";
import "./List.css";
import API from "../service/api";

const List = () => {
  const [list, setList] = useState({
    heading: "",
    work: "",
  });

  const [todos, setTodos] = useState([]);

  // Todos fetch from backend
  const fetchTodos = async () => {
    try {
      const email = localStorage.getItem("email");

      const response = await API.get(`/todo/${email}`);

      setTodos(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  // Page load hote hi todos lao
  useEffect(() => {
    fetchTodos();
  }, []);

  const handleChange = (e) => {
    setList({
      ...list,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const email = localStorage.getItem("email");

      await API.post(`/todo/add/${email}`, list);

      alert("Todo Added Successfully");

      // latest todos reload
      fetchTodos();

      setList({
        heading: "",
        work: "",
      });
    } catch (error) {
      console.log(error);
      alert("Failed to add todo");
    }
  };

  const handleDone = async (id) => {
    try {
      await API.delete(`/delete/${id}`);

      alert("Todo Deleted Successfully");

      // Todo list reload
      fetchTodos();
    } catch (error) {
      console.log(error);
      alert("Failed to delete todo");
    }
  };

  return (
    <div className="list-container">
      <h1>Add Todo</h1>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Heading"
          name="heading"
          value={list.heading}
          onChange={handleChange}
          required
        />

        <input
          type="text"
          placeholder="Work"
          name="work"
          value={list.work}
          onChange={handleChange}
          required
        />

        <button type="submit">Add Todo</button>
      </form>

      <div className="todo-list">
        {todos.length === 0 ? (
          <h3>No Todos Found</h3>
        ) : (
          todos.map((todo, index) => (
            <div key={todo.id || index} className="todo-card">
              <h3>{todo.heading}</h3>

              <p>{todo.work}</p>

              <button className="done-btn" onClick={() => handleDone(todo.id)}>
                Work Done
              </button>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default List;
