package com.rounak.hw1.service;

import com.rounak.hw1.model.dto.SemesterDto;
import com.rounak.hw1.model.request.AddSemesterRequest;
import com.rounak.hw1.model.request.ModifySemesterRequest;

import java.util.List;

public interface SemesterService {
    List<SemesterDto> getAllSemesters();
    SemesterDto addSemesterInfo(AddSemesterRequest addSemesterRequest);
    SemesterDto updateSemester(Integer id, ModifySemesterRequest modifySemesterRequest);
    void deleteSemester(Integer id);
}
