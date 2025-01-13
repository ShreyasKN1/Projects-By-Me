import React, { useState } from "react";
import { applyForJob } from "../api";

const ApplyJobForm = () => {
  const [jobPostId, setJobPostId] = useState("");
  const [candidateId, setCandidateId] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    applyForJob(jobPostId, candidateId)
      .then(() => alert("Application successful!"))
      .catch((error) => console.error(error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Apply for Job</h2>
      <label>
        Job Post ID:
        <input
          type="text"
          value={jobPostId}
          onChange={(e) => setJobPostId(e.target.value)}
        />
      </label>
      <label>
        Candidate ID:
        <input
          type="text"
          value={candidateId}
          onChange={(e) => setCandidateId(e.target.value)}
        />
      </label>
      <button type="submit">Apply</button>
    </form>
  );
};

export default ApplyJobForm;
