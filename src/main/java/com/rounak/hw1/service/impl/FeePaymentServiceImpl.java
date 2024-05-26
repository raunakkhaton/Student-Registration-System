package com.rounak.hw1.service.impl;

import com.rounak.hw1.mapper.FeePaymentMapper;
import com.rounak.hw1.model.dto.FeePaymentDto;
import com.rounak.hw1.model.entity.FeeDetails;
import com.rounak.hw1.model.entity.FeePayment;
import com.rounak.hw1.model.entity.Student;
import com.rounak.hw1.model.request.AddFeePaymentRequest;
import com.rounak.hw1.model.request.ModifyFeePaymentRequest;
import com.rounak.hw1.repository.FeeDetailsRepository;
import com.rounak.hw1.repository.FeePaymentRepository;
import com.rounak.hw1.repository.StudentRepository;
import com.rounak.hw1.service.FeePaymentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FeePaymentServiceImpl implements FeePaymentService {

    private final StudentRepository studentRepository;
    private final FeeDetailsRepository feeDetailsRepository;
    private FeePaymentRepository FeePaymentRepository;

    public FeePaymentServiceImpl(FeePaymentRepository feePaymentRepository, StudentRepository studentRepository, FeeDetailsRepository feeDetailsRepository) {
        this.FeePaymentRepository = feePaymentRepository;
        this.studentRepository = studentRepository;
        this.feeDetailsRepository = feeDetailsRepository;
    }

    @Override
    public List<FeePaymentDto> getFeePayment() {
        List<FeePayment> feePayments = FeePaymentRepository.findAll();
        if (feePayments.size() == 0) {
            return Collections.emptyList();
        }

        List<FeePaymentDto> feePaymentDtos = new ArrayList<>();
        for (int i = 0; i < feePayments.size(); i++) {
            FeePayment feePayment = feePayments.get(i);
            FeePaymentDto feePaymentDto = FeePaymentMapper.mapToFeePaymentDto(feePayment);
            feePaymentDtos.add(feePaymentDto);
        }
        return feePaymentDtos;
    }

    @Override
    public FeePaymentDto addFeePayment(AddFeePaymentRequest addFeePaymentRequest) {

        Student student = studentRepository.findById(addFeePaymentRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        FeeDetails feeDetails = feeDetailsRepository.findById(addFeePaymentRequest.getFeeDetailsId())
                .orElseThrow(() -> new RuntimeException("FeeDetails not found"));

        FeePayment feePayment = FeePaymentMapper.mapToFeePayment(student, feeDetails);
        FeePayment savedFeePayment = FeePaymentRepository.save(feePayment);
        return FeePaymentMapper.mapToFeePaymentDto(savedFeePayment);
    }

    @Override
    public FeePaymentDto updateFeePayment(Integer id, ModifyFeePaymentRequest modifyFeePaymentRequest) {
        FeePayment feePayment = FeePaymentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("FeePayment not found")
        );
        Student student = studentRepository.findById(modifyFeePaymentRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        FeeDetails feeDetails = feeDetailsRepository.findById(modifyFeePaymentRequest.getFeeDetailsId())
                .orElseThrow(() -> new RuntimeException("FeeDetails not found"));
        feePayment.setFeeDetails(feeDetails);
        feePayment.setStudent(student);
        FeePayment updatedFeePayment = FeePaymentRepository.save(feePayment);
        return FeePaymentMapper.mapToFeePaymentDto(updatedFeePayment);
    }

    @Override
    public void deleteFeePayment(Integer id) {
        FeePayment feePayment = FeePaymentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("FeePayment not found"));
        FeePaymentRepository.delete(feePayment);
    }
}
