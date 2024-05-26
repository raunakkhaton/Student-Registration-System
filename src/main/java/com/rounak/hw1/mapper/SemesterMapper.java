package com.rounak.hw1.mapper;

import com.rounak.hw1.model.dto.SemesterDto;
import com.rounak.hw1.model.entity.Semester;
import com.rounak.hw1.model.request.AddSemesterRequest;

public class SemesterMapper {
    public static Semester mapToSemester(AddSemesterRequest addSemesterRequest){
        Semester semester = new Semester();
        semester.setSemesterName(addSemesterRequest.getSemesterName());
        semester.setCourseId(addSemesterRequest.getCourseId());
        semester.setCourseName(addSemesterRequest.getCourseName());
        semester.setBranchName(addSemesterRequest.getBranchName());
    return semester;
    }

    public static SemesterDto mapToSemesterDto(Semester semester){
        SemesterDto semesterDto = new SemesterDto();
        semester.setSemesterName(semester.getSemesterName());
        semester.setCourseId(semester.getCourseId());
        semester.setCourseName(semester.getCourseName());
        semester.setBranchName(semester.getBranchName());
        return semesterDto;
    }
}
