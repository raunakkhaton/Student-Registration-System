package com.rounak.hw1.service.impl;

import com.rounak.hw1.mapper.FeeMapper;
import com.rounak.hw1.model.dto.FeeDetailsDto;
import com.rounak.hw1.model.entity.Course;
import com.rounak.hw1.model.entity.FeeDetails;
import com.rounak.hw1.model.request.AddFeeRequest;
import com.rounak.hw1.model.request.ModifyFeeRequest;
import com.rounak.hw1.repository.CourseRepository;
import com.rounak.hw1.repository.FeeDetailsRepository;
import com.rounak.hw1.service.FeeDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class FeeDetailsServiceImpl implements FeeDetailsService {
    private final FeeDetailsRepository feeDetailsRepository;
    private final CourseRepository courseRepository;


    @Override
    public List<FeeDetailsDto> getFeeDetails() {
        List<FeeDetails> feeDetails = feeDetailsRepository.findAll();
        if (feeDetails.size() == 0) {
            return Collections.emptyList();
        }
        List<FeeDetailsDto> feeDetailsDtos = new ArrayList<FeeDetailsDto>();
        for (int i = 0; i < feeDetails.size(); i++) {
            FeeDetails feeDetail = feeDetails.get(i);
            FeeDetailsDto feeDetailsDto = FeeMapper.mapToFeeDetailsDto(feeDetail);
            feeDetailsDtos.add(feeDetailsDto);
        }
        return feeDetailsDtos;
    }

    @Override
    public FeeDetailsDto addFeeDetails(AddFeeRequest addFeeRequest) {
        Course course = courseRepository.findById(addFeeRequest.getCourseId()).orElseThrow(
                () -> new RuntimeException("Course not found"));
        FeeDetails feeDetail = FeeMapper.mapToFeeDetails(addFeeRequest.getAmount(), course);
        feeDetail = feeDetailsRepository.save(feeDetail);
        return FeeMapper.mapToFeeDetailsDto(feeDetail);
    }

    @Override
    public FeeDetailsDto updateFeeDetails(Integer id, ModifyFeeRequest modifyFeeRequest) {
        FeeDetails feeDetails = feeDetailsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Fee details not found"));

        Course course = courseRepository.findById(modifyFeeRequest.getCourseId()).orElseThrow(
                () -> new RuntimeException("Course not found"));

        feeDetails.setCourse(course);
        feeDetails.setAmount(modifyFeeRequest.getAmount());
        FeeDetails updatedFee = feeDetailsRepository.save(feeDetails);
        return FeeMapper.mapToFeeDetailsDto(updatedFee);
    }

    @Override
    public void deleteFeeDetails(Integer id) {
        FeeDetails feeDetails = feeDetailsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found"));
        feeDetailsRepository.delete(feeDetails);
    }


}
