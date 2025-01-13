import React, { useState, useEffect } from "react";
import { getJobPosts } from "../api";
import { Link } from "react-router-dom";

const JobPostList = () => {
  const [jobPosts, setJobPosts] = useState([]);

  useEffect(() => {
    getJobPosts()
      .then((response) => setJobPosts(response.data))
      .catch((error) => console.error(error));
  }, []);

  return (
    <div>
      <h2>Job Posts</h2>
      {jobPosts.length === 0 ? (
        <p>No job posts available.</p>
      ) : (
        <ul>
          {jobPosts.map((job) => (
            <li key={job.id}>
              <Link to={`/job-post/${job.id}`}>{job.jobTitle}</Link>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default JobPostList;
