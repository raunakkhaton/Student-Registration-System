package com.rounak.hw1.mapper;

import com.rounak.hw1.model.dto.StudentDto;
import com.rounak.hw1.model.entity.Course;
import com.rounak.hw1.model.entity.Student;
import com.rounak.hw1.model.request.AddStudentRequest;

public class StudentMapper {

public static Student mapToStudent(AddStudentRequest addStudentRequest, Course course) {
//    Student student = new Student(
////            studentdto.getId(),
//            studentdto.getAdmissionNo(),
//            studentdto.getRollNo(),
//            studentdto.getStandard()
//    );
    Student student = new Student();
    student.setAdmissionNo(addStudentRequest.getAdmissionNo());
    student.setRollNo(addStudentRequest.getRollNo());
    student.setStandard(addStudentRequest.getStandard());
    student.setCourse(course);
    return student;
}

public static StudentDto mapToStudentDto(Student student) {
   StudentDto studentdto = new StudentDto();
   studentdto.setAdmissionNo(student.getAdmissionNo());
   studentdto.setRollNo(student.getRollNo());
   studentdto.setStandard(student.getStandard());
   studentdto.setCourseName(student.getCourse().getCourseName());
    return studentdto;
}
}
