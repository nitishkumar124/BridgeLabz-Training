CREATE TABLE specializations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL
);

INSERT INTO specializations (name, description)
VALUES
('Cardiology', 'Diagnosis and treatment of heart diseases'),
('Pediatrics', 'Medical care for infants and children'),
('Orthopedics', 'Treatment of bones and joints');

INSERT INTO appointments (patient_id, doctor_id, appointment_date)
VALUES
(1, 1, '2026-08-05 10:00:00'),
(2, 2, '2026-08-05 11:30:00'),
(1, 2, '2026-08-06 09:00:00');

SELECT * FROM specializations;
SELECT * FROM appointments;

ALTER TABLE doctors
ADD experience_years INT;

DESCRIBE doctors;

ALTER TABLE doctors
DROP COLUMN experience_years;

DESCRIBE doctors;

SELECT * FROM patients;

UPDATE patients
SET phone_number = '9999999999'
WHERE patient_id = 1;

SELECT * FROM patients;

SELECT * FROM appointments;

DELETE FROM appointments
WHERE id = 3;

SELECT * FROM appointments;

CREATE USER 'clinic_app_user'@'localhost'
IDENTIFIED BY 'Clinic@123';

GRANT SELECT, INSERT, UPDATE, DELETE
ON health_clinic_db.*
TO 'clinic_app_user'@'localhost';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'clinic_app_user'@'localhost';
