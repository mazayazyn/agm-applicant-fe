import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import './App.css'
import { MantineProvider } from "@mantine/core";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <MantineProvider
      classNames={{ 
        Pagination: { active: "bg-blue-500" },
        Button: { filled: "bg-blue-500"}
      }}
    >
      <App />
    </MantineProvider>
  </React.StrictMode>
);
