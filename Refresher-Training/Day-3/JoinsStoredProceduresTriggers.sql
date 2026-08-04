use health_clinic_db;

SELECT p.first_name AS patient_name, a.appointment_date, d.first_name AS doctor_name
FROM Appointments a
INNER JOIN patients p ON a.patient_id = p.patient_id
INNER JOIN doctors d ON a.doctor_id = d.doctor_id;

SELECT p.first_name, a.appointment_date
FROM Patients p
LEFT JOIN Appointments a ON p.patient_id = a.patient_id;

SELECT p.first_name FROM Patients p
LEFT JOIN Appointments a ON p.patient_id = a.patient_id
WHERE a.appointment_id IS NULL;

SELECT d.first_name AS doctor, a.appointment_date
FROM Appointments a
RIGHT JOIN Doctors d ON a.doctor_id = d.doctor_id;

SELECT p.first_name, a.appointment_date
FROM Patients p
LEFT JOIN Appointments a ON p.patient_id = a.patient_id
UNION
SELECT p.first_name, a.appointment_date
FROM Patients p
RIGHT JOIN Appointments a ON p.patient_id = a.patient_id;
