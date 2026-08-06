package com.clinic.dao;

import com.clinic.dto.Specialization;
import java.util.List;

public interface SpecializationDAO {
    int insertSpecialization(Specialization specialization);
    List<Specialization> getAllSpecializations();
    Specialization getSpecializationById(int id);
}