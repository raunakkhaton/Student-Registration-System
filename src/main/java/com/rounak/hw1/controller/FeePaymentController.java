package com.rounak.hw1.controller;

import com.rounak.hw1.model.dto.FeePaymentDto;
import com.rounak.hw1.model.request.AddFeePaymentRequest;
import com.rounak.hw1.model.request.ModifyFeePaymentRequest;
import com.rounak.hw1.service.FeePaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/feePayment")
@AllArgsConstructor
public class FeePaymentController {
    private final FeePaymentService feePaymentService;


    @GetMapping
    public ResponseEntity<List<FeePaymentDto>> getFeePayment() {
        return new ResponseEntity<>(feePaymentService.getFeePayment(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeePaymentDto> addFeePayment(@RequestBody AddFeePaymentRequest addFeePaymentRequest) {
        return new ResponseEntity<>(feePaymentService.addFeePayment(addFeePaymentRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeePaymentDto> updateFeePayment(@PathVariable("id") Integer id,
                                                          @RequestBody ModifyFeePaymentRequest modifyFeePaymentRequest) {
        FeePaymentDto feePaymentDto = feePaymentService.updateFeePayment(id, modifyFeePaymentRequest);
        return ResponseEntity.ok(feePaymentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeePaymentDto> deleteFeePayment(@PathVariable("id") Integer id) {
        feePaymentService.deleteFeePayment(id);
        return ResponseEntity.noContent().build();
    }














}
