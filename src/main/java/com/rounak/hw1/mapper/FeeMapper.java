package com.rounak.hw1.mapper;

import com.rounak.hw1.model.dto.CourseDto;
import com.rounak.hw1.model.dto.FeeDetailsDto;
import com.rounak.hw1.model.entity.Course;
import com.rounak.hw1.model.entity.FeeDetails;
import com.rounak.hw1.model.request.AddFeeRequest;

public class FeeMapper {
    public static FeeDetails mapToFeeDetails(double amount, Course course) {
        FeeDetails feeDetails = new FeeDetails();
        feeDetails.setCourse(course);
        feeDetails.setAmount(amount);
        return feeDetails;
    }

    public static FeeDetailsDto mapToFeeDetailsDto(FeeDetails feeDetails) {
        FeeDetailsDto feeDetailsDto = new FeeDetailsDto();
        CourseDto courseDto = CourseMapper.mapToCourseDto(feeDetails.getCourse());
        feeDetailsDto.setCourse(courseDto);
        feeDetailsDto.setAmount(feeDetails.getAmount());
        return feeDetailsDto;
    }
}
