import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import JobPostList from "./components/jobpostlist";
import JobPostDetail from "./components/jobpost";
import CandidateForm from "./components/candidate";
import ApplyJobForm from "./components/applyforjob";
import SearchJobPost from "./components/searchjobpost";
import './App.css';

const App = () => {
  return (
    <Router>
      <div className="container">
        <h1>Job Portal</h1>
        <Routes>
          <Route path="/" element={<JobPostList />} />
          <Route path="/job-post/:id" element={<JobPostDetail />} />
          <Route path="/create-candidate" element={<CandidateForm />} />
          <Route path="/apply-job" element={<ApplyJobForm />} />
          <Route path="/search" element={<SearchJobPost />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
