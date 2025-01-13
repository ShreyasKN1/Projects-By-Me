CREATE TABLE jobposts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    location VARCHAR(255) NOT NULL,
    company VARCHAR(255) NOT NULL,
    skills_required TEXT NOT NULL,
    candidate_id BIGINT, 
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

CREATE TABLE candidates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    resume_url VARCHAR(255) NOT NULL
);


INSERT INTO candidates (name, email, resume_url) 
VALUES ('John Doe', 'john.doe@example.com', 'http://example.com/resumes/john_doe.pdf');

INSERT INTO candidates (name, email, resume_url) 
VALUES ('Jane Smith', 'jane.smith@example.com', 'http://example.com/resumes/jane_smith.pdf');

-- Insert sample data into jobposts table
INSERT INTO jobposts (job_title, description, location, company, skills_required, is_open, candidate_id) 
VALUES ('Software Engineer', 'Develop and maintain software applications.', 'New York', 'TechCorp', 'Java, Spring, MySQL', TRUE, 1);

INSERT INTO jobposts (job_title, description, location, company, skills_required, is_open, candidate_id) 
VALUES ('Frontend Developer', 'Design and implement user interfaces.', 'San Francisco', 'WebWorks', 'React, JavaScript, CSS', TRUE, 2);
