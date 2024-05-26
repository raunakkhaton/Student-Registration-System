package com.rounak.hw1.service;

import com.rounak.hw1.model.dto.FeePaymentDto;
import com.rounak.hw1.model.request.AddFeePaymentRequest;
import com.rounak.hw1.model.request.ModifyFeePaymentRequest;

import java.util.List;

public interface FeePaymentService {
    List<FeePaymentDto> getFeePayment();

    FeePaymentDto addFeePayment(AddFeePaymentRequest addFeePaymentRequest);

    FeePaymentDto updateFeePayment(Integer id, ModifyFeePaymentRequest modifyFeePaymentRequest);

    void deleteFeePayment(Integer id);
}
