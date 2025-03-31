CREATE DATABASE IF NOT EXISTS university_db;
USE university_db;

CREATE TABLE IF NOT EXISTS students (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        first_name VARCHAR(50),
                                        last_name VARCHAR(50),
                                        middle_name VARCHAR(50),
                                        birth_date DATE,
                                        record_book_number VARCHAR(20)
);