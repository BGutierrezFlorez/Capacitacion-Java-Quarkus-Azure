import React from "react";
import ReactDOM from "react-dom/client"
import App from "./App";
import "./index.css";

// crear el root de React y renderizar la App
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);