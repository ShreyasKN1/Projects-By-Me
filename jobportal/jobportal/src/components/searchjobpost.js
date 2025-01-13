import React, { useState } from "react";
import { searchJobPosts } from "../api";

const SearchJobPost = () => {
  const [jobTitle, setJobTitle] = useState("");
  const [results, setResults] = useState([]);

  const handleSearch = () => {
    searchJobPosts(jobTitle)
      .then((response) => setResults(response.data))
      .catch((error) => console.error(error));
  };

  return (
    <div>
      <h2>Search Job Posts</h2>
      <input
        type="text"
        value={jobTitle}
        onChange={(e) => setJobTitle(e.target.value)}
        placeholder="Enter job title"
      />
      <button onClick={handleSearch}>Search</button>
      <ul>
        {results.map((job) => (
          <li key={job.id}>{job.jobTitle}</li>
        ))}
      </ul>
    </div>
  );
};

export default SearchJobPost;
