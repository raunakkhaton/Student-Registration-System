package com.rounak.hw1.service.impl;

import com.rounak.hw1.mapper.SemesterMapper;
import com.rounak.hw1.model.dto.SemesterDto;
import com.rounak.hw1.model.entity.Semester;
import com.rounak.hw1.model.request.AddSemesterRequest;
import com.rounak.hw1.model.request.ModifySemesterRequest;
import com.rounak.hw1.repository.SemesterRepository;
import com.rounak.hw1.service.SemesterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SemesterServiceImpl implements SemesterService {
    private SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public List<SemesterDto> getAllSemesters() {
        List<Semester> semesters = semesterRepository.findAll();
        if (semesters.size() == 0) {
            return Collections.emptyList();
        }
        List<SemesterDto> semesterDtos = new ArrayList<>();
        for (int i = 0; i < semesters.size(); i++) {
            Semester semester = semesters.get(i);
            SemesterDto semesterDto = SemesterMapper.mapToSemesterDto(semester);
            semesterDtos.add(semesterDto);
        }
        return semesterDtos;
    }


    @Override
    public SemesterDto addSemesterInfo(AddSemesterRequest addSemesterRequest) {
        Semester semester = SemesterMapper.mapToSemester(addSemesterRequest);
        semester = semesterRepository.save(semester);
        return SemesterMapper.mapToSemesterDto(semester);


    }

    @Override
    public SemesterDto updateSemester(Integer id, ModifySemesterRequest modifySemesterRequest) {
        Semester semester = semesterRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Semester not found")
        );
        semester.setSemesterName(modifySemesterRequest.getSemesterName());
        semester.setCourseId(modifySemesterRequest.getCourseId());
        semester.setCourseName(modifySemesterRequest.getCourseName());
        semester.setBranchName(modifySemesterRequest.getBranchName());
        Semester updatedSemester = semesterRepository.save(semester);
        return SemesterMapper.mapToSemesterDto(updatedSemester);


    }

    @Override
    public void deleteSemester(Integer id) {
        Semester semester = semesterRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Semester not found")
        );
        semesterRepository.delete(semester);
    }
}
