package com.rounak.hw1.mapper;

import com.rounak.hw1.model.dto.FeeDetailsDto;
import com.rounak.hw1.model.dto.FeePaymentDto;
import com.rounak.hw1.model.dto.StudentDto;
import com.rounak.hw1.model.entity.FeeDetails;
import com.rounak.hw1.model.entity.FeePayment;
import com.rounak.hw1.model.entity.Student;

import java.util.Date;

public class FeePaymentMapper {
    public static FeePayment mapToFeePayment(Student student, FeeDetails feeDetails) {
        FeePayment feePayment = new FeePayment();
        feePayment.setFeeDetails(feeDetails);
        feePayment.setStudent(student);
        feePayment.setPaymentDate(new Date());
        return feePayment;
    }

    public static FeePaymentDto mapToFeePaymentDto(FeePayment feePayment) {
        FeePaymentDto feePaymentDto = new FeePaymentDto();
        FeeDetailsDto feeDetailsDto = FeeMapper.mapToFeeDetailsDto(feePayment.getFeeDetails());
        StudentDto studentDto = StudentMapper.mapToStudentDto(feePayment.getStudent());

        feePaymentDto.setFeeDetails(feeDetailsDto);
        feePaymentDto.setStudent(studentDto);
        feePaymentDto.setPaymentDate(feePayment.getPaymentDate());
        return feePaymentDto;
    }
}
