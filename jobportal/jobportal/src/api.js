import axios from "axios";

const API_BASE_URL = "http://localhost:8080/jobposts";

export const getJobPosts = () => axios.get(`${API_BASE_URL}`);
export const getJobPostById = (id) => axios.get(`${API_BASE_URL}/${id}`);
export const createJobPost = (jobPost) => axios.post(`${API_BASE_URL}`, jobPost);
export const searchJobPosts = (jobTitle) =>
  axios.get(`${API_BASE_URL}/search`, { params: { jobTitle } });
export const createCandidate = (candidate) =>
  axios.post(`${API_BASE_URL}/candidates`, candidate);
export const applyForJob = (jobPostId, candidateId) =>
  axios.post(`${API_BASE_URL}/${jobPostId}/apply/${candidateId}`);
export const getCandidatesByJobPostId = (jobPostId) =>
  axios.get(`${API_BASE_URL}/${jobPostId}/candidates`);
