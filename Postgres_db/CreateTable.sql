CREATE TABLE company (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE department (
    id SERIAL PRIMARY KEY,
    //varchar uses as much as space needed - no memory wastage.
    name VARCHAR(50) NOT NULL,
    company_id BIGINT NOT NULL,
 // to delete the complete departments if deleting a company.
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);


CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    // numeric stores 10 digits and 2 decimal digits instead of float for precision and accuracy
    salary NUMERIC(10,2) NOT NULL,
    level VARCHAR(50) NOT NULL,
    department_id BIGINT,
    // delete the employees in the department if deleting a particular dept.
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE CASCADE
);
