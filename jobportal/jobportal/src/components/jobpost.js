import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { getJobPostById } from "../api";

const JobPostDetail = () => {
  const { id } = useParams();
  const [jobPost, setJobPost] = useState(null);

  useEffect(() => {
    getJobPostById(id)
      .then((response) => setJobPost(response.data))
      .catch((error) => console.error(error));
  }, [id]);

  return (
    <div>
      {jobPost ? (
        <div>
          <h2>{jobPost.jobTitle}</h2>
          <p>{jobPost.description}</p>
          <p>Location: {jobPost.location}</p>
          <p>Company: {jobPost.company}</p>
          <p>Skills Required: {jobPost.skillsRequired}</p>
        </div>
      ) : (
        <p>Loading job post details...</p>
      )}
    </div>
  );
};

export default JobPostDetail;
