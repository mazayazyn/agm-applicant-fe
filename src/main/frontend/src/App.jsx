import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import "./App.css";
import { Home, Dashboard } from "./pages";
import { CreateVacancy, DetailVacancy, EditVacancy } from "@/pages/Vacancy/Index";
import { Error404 } from "./pages/error";

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/u/dashboard" element={<Dashboard />} />
        <Route path="/u/vacancy/create" element={<CreateVacancy />} />
        <Route path="/u/vacancy/:id" element={<DetailVacancy />} />
        <Route path="/u/vacancy/edit/:id" element={<EditVacancy />} />
        <Route path="/404" element={<Error404 />} />
        <Route path="*" element={<Navigate to="/404" replace/>}/>
      </Routes>
    </Router>
  );
}

export default App;
