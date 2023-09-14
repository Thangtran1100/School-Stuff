drop table if exists faculty;
drop table if exists departments;

-- Create departments table
CREATE TABLE departments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

-- Create faculty table
CREATE TABLE faculty (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    chair BOOLEAN,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

-- Insert initial data into departments table
INSERT INTO departments (name) VALUES ('Computer Science');
INSERT INTO departments (name) VALUES ('Electrical and Computer Engineering');


-- Insert initial data into faculty table
INSERT INTO faculty (name, chair, department_id) VALUES ('Pamula', true, 1);
INSERT INTO faculty (name, chair, department_id) VALUES ('Sun', false, 1);
INSERT INTO faculty (name, chair, department_id) VALUES ('Agarwal', false, 2);