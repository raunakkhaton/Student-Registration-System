package com.rounak.hw1.service;

import com.rounak.hw1.model.dto.FeeDetailsDto;
import com.rounak.hw1.model.request.AddFeeRequest;
import com.rounak.hw1.model.request.ModifyFeeRequest;

import java.util.List;

public interface FeeDetailsService {
    List<FeeDetailsDto> getFeeDetails();
    FeeDetailsDto addFeeDetails(AddFeeRequest addFeeRequest);
    FeeDetailsDto updateFeeDetails(Integer id, ModifyFeeRequest modifyFeeRequest);
    void deleteFeeDetails(Integer id);

}
