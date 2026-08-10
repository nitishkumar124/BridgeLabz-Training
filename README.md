
# Refresher Training

This branch is dedicated to documenting my day-wise learning progress, practice programs, assignments, and notes throughout the training.

---

## Objectives

- Maintain a day-wise record of topics covered.
- Track programs and assignments completed.
- Record date-wise learning progress.
- Organize notes and practice files for future reference.

---

# Training Progress

| Day | Date | Topics Covered | Programs / Assignments | Status |
| :-- | :--- | :------------- | :--------------------- | :----: |
| Day 1 | 31-Jul-2026 | DBMS Fundamentals & RDBMS Basics | Database creation, Table creation, SQL practice, SQL assignments | ✅ Completed |
| Day 2 | 03-Aug-2026 | ER Diagram, Indexing & Normalization | Finalized ER Diagram & normalized patient/doctor/appointment schema | ✅ Completed |
| Day 3 | 04-Aug-2026 | Joins, Stored Procedures & Triggers | Wrote joins, stored procedures, and triggers for Health Clinic schema | ✅ Completed |
| Day 4 | 05-Aug-2026 | JDBC & Health Clinic App Completion | Implemented JDBC CRUD operations & console-based Health Clinic App | ✅ Completed |
| Day 5 | 06-Aug-2026 | Tomcat, Servlets & Spring Introduction | Deployed Servlet on Tomcat & explored Spring IoC container with bean examples | ✅ Completed |
| Day 6 | 07-Aug-2026 | Spring MVC | Built 'My Greetings App' using Spring MVC | ✅ Completed |

---

# Day-wise Topics Covered

## Day 1 – DBMS Fundamentals & RDBMS Basics

**Date:** 31-Jul-2026

### Topics Covered

- Introduction to DBMS
- Features and Advantages of DBMS
- File System vs DBMS
- Introduction to RDBMS
- Database Concepts
- Tables, Rows, and Columns
- Data Types
- Primary Key
- Candidate Key
- Alternate Key
- Composite Key
- Foreign Key (Introduction)
- SQL Overview
- Creating a Database
- Creating Tables
- Inserting Records
- Basic SQL Queries

### Programs / Assignments Completed

- Created a database using SQL.
- Created the `patients` table with appropriate columns.
- Created additional tables:
  - `specializations`
  - `appointments`
- Inserted sample records into each table.
- Practiced `ALTER TABLE` by adding and dropping a column.
- Wrote and executed `UPDATE` and `DELETE` queries.
- Practiced basic SQL statements:
  - `CREATE DATABASE`
  - `USE`
  - `CREATE TABLE`
  - `INSERT`
  - `SELECT`
  - `UPDATE`
  - `DELETE`
  - `ALTER TABLE`
 
## Day 2 – ER Diagram, Indexing & Normalization

**Date:** 03-Aug-2026

### Topics Covered

- ER Diagram design principles (Entities, Relationships, Cardinality)
- Table Indexing (Purpose and Performance Impact)
- Normalization Forms (1NF, 2NF, 3NF, BCNF)

### Programs / Assignments Completed

- Finalized the ER Diagram for the Health Clinic Application.
- Normalized the patient, doctor, and appointment schema up to 3NF/BCNF.
- Implemented relationships and integrity constraints:
  - Multi-valued attributes handling (`patient_phones`)
  - Many-to-Many mapping (`doctor_specializations`)
  - One-to-One relationships (`billing`, `visit_history`)
- Created indexes on essential search columns and composite indexes (`idx_doctor_date`).
- Verified schema integrity using relational JOIN queries.

## Day 3 – Joins, Stored Procedures & Triggers

**Date:** 04-Aug-2026

### Topics Covered

- SQL Joins (INNER, LEFT, RIGHT, FULL OUTER)
- Stored Procedures (Creation, execution, and usage parameters)
- Triggers (Use cases for automated database actions)

### Programs / Assignments Completed

- Formulated relational queries using INNER, LEFT, RIGHT, and FULL OUTER JOINs across patient, doctor, appointment, billing, and visit tables.
- Wrote Stored Procedures to encapsulate core transactional workflows for the Health Clinic Application.
- Created Triggers for automated database actions (e.g., auto-updating visit history or status logs on appointment updates).


## Day 4 – JDBC & Health Clinic App Completion

**Date:** 05-Aug-2026

### Topics Covered

- JDBC - Connecting a Java application to MySQL
- CRUD operations via JDBC
- Connection pooling basics

### Programs / Assignments Completed

- Developed core Health Clinic App modules to:
  - Register patients and manage doctor/specialization details
  - Schedule appointments and track visit histories
  - Handle basic billing workflows persisted via MySQL using JDBC
- Demonstrated the completed interactive, console-based Health Clinic Application.

---

# 📝 Date-wise Progress Updates

| Date | Progress Update |
|------|-----------------|
| 31-Jul-2026 | Completed DBMS Fundamentals and RDBMS Basics. Created databases and tables, inserted sample data, practiced ALTER, UPDATE, and DELETE operations, and completed the Day 1 SQL assignment. |
| 03-Aug-2026 | Covered ER Diagram design, Table Indexing, and Normalization forms (1NF to BCNF). Designed, normalized, and indexed the Health Clinic DB schema with integrity constraints and validation queries. |
| 04-Aug-2026 | Covered SQL Joins, Stored Procedures, and Triggers. Implemented complex multi-table queries, stored procedures, and automated triggers for the Health Clinic database schema. |
| 05-Aug-2026 | Learned JDBC architecture and database integration in Java. Built a console-based Health Clinic Application implementing full CRUD persistence for patients, doctors, appointments, visits, and billing. |
| 06-Aug-2026 | Explored Servlet lifecycle and deployed a Java Servlet on Apache Tomcat. Introduced to Spring Core concepts including Inversion of Control (IoC) and Dependency Injection (DI). |
| 07-Aug-2026 | Learned Spring MVC architecture (`DispatcherServlet`, Controllers, Request Mappings). Developed and deployed 'My Greetings App' using Spring MVC. |

---

# 📂 Repository Structure

```
Refresher-Training/
│
├── README.md
│
├── Day-1/
|   ├── HealthClinicDatabaseSetup
|   └── assignment
|
├── Day-2/
|   └── FullyNormalizedHealthClinicSchema
|
├── Day-3/
|   └── JoinsStoredProceduresTriggers
|
├── Day-4/
|   ├── HealthClinicApp
|   └── README.md
|
├── Day-5/
│   └── FirstServlet
│
├── Day-6/
│   └── MyGreetingsApp

```

---

## 🚀 Current Progress

- **Training Day:** Day 6
- **Status:** ✅ Completed

