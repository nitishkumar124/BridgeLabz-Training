# Health Clinic Management System

A Java-based console application for managing health clinic operations, including patient registration, doctor scheduling, appointment processing with ACID transaction integrity, billing, and medical history tracking. Built using pure JDBC, HikariCP connection pooling, and MySQL.

---

## Key Features

* **Patient Management**: Register, view, list, update, and deactivate patient records.
* **Doctor & Specialization Management**: Manage medical specialties, register doctors, and map doctors to specific specializations.
* **Appointment Scheduling**: Schedule doctor appointments and view upcoming appointments per doctor.
* **ACID Transaction Management**: Complete appointments using atomic database transactions that process visit status updates, billing creation, and visit history logs in a single unit of work (rolls back automatically if any single step fails).
* **Billing & Payments**: Track pending bills and update payment status (`Paid`, `Pending`, `Refunded`).
* **Medical History Tracking**: Access complete patient visit logs, diagnoses, prescriptions, and historical notes.
* **HikariCP Connection Pooling**: High-performance JDBC connection pooling for production-ready database connection handling.

---

## Tech Stack

* **Language**: Java (JDK 8 or higher)
* **Database**: MySQL Server (8.0+)
* **Database Access**: JDBC API, HikariCP Connection Pool
* **IDE**: Eclipse IDE / IntelliJ IDEA
* **Build Tool**: Maven (Optional / Standard Java Project)

---

## Database Schema Overview

The system operates on the `health_clinic_db` relational database:

* `patients`: Stores patient profiles and active status.
* `doctors`: Stores doctor contact details and availability status.
* `specializations`: Stores medical departments/specialties.
* `doctor_specializations`: Junction table linking doctors to specializations.
* `appointments`: Tracks scheduled, completed, and canceled visits.
* `billing`: Stores invoice records and payment statuses.
* `visit_history`: Stores diagnoses, prescriptions, and clinical notes.
* `audit_log`: Automatically logs critical system changes via database triggers.

---

## Setup & Installation

### 1. Database Setup
Log into MySQL Workbench or MySQL CLI as `root` and execute:

```sql
CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

-- Create database user
CREATE USER IF NOT EXISTS 'clinic_app_user'@'localhost' IDENTIFIED BY 'StrongPassword123!';
GRANT SELECT, INSERT, UPDATE, DELETE ON health_clinic_db.* TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;