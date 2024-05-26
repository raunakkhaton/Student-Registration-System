package com.rounak.hw1.model.dto;

import com.rounak.hw1.model.entity.FeeDetails;
import com.rounak.hw1.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeePaymentDto {
    private StudentDto student;
    private FeeDetailsDto feeDetails;
    private Date paymentDate;
}
