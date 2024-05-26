package com.rounak.hw1.controller;

import com.rounak.hw1.model.dto.FeeDetailsDto;
import com.rounak.hw1.model.entity.FeeDetails;
import com.rounak.hw1.model.request.AddFeeRequest;
import com.rounak.hw1.model.request.ModifyFeeRequest;
import com.rounak.hw1.service.FeeDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/details")
@AllArgsConstructor
public class FeeDetailsController {
    private final FeeDetailsService feeDetailsService;


    @GetMapping
    public ResponseEntity<List<FeeDetailsDto>> getFeeDetails() {
        return new ResponseEntity<>(feeDetailsService.getFeeDetails(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeeDetailsDto> addFeeDetails(@RequestBody AddFeeRequest addFeeRequest) {
        return new ResponseEntity<>(feeDetailsService.addFeeDetails(addFeeRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FeeDetailsDto> updateFeeDetails(@PathVariable("id") Integer id,
                                                          @RequestBody ModifyFeeRequest modifyFeeRequest) {
        FeeDetailsDto feeDetailsDto = feeDetailsService.updateFeeDetails(id, modifyFeeRequest);
        return ResponseEntity.ok(feeDetailsDto);
    }

    @DeleteMapping
    public ResponseEntity<FeeDetailsDto> deleteFeeDetails(@PathVariable("id") Integer id) {
        feeDetailsService.deleteFeeDetails(id);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping
//    public ResponseEntity<FeeDetailsDto> feePayment(Integer id, @RequestBody FeeDetailsDto feeDetailsDto) {
//        return new ResponseEntity<>(feeDetailsService.feePayment(id, feeDetailsDto));
//
//    }


}
