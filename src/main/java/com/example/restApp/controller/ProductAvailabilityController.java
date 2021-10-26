package com.example.restApp.controller;

import com.example.restApp.Model.Availability;
import com.example.restApp.Model.AvailabilityRequest;
import com.example.restApp.Model.AvailabilityResponse;
import com.example.restApp.Service.ProductAvailabilityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAvailabilityController {

    @Autowired
    private ProductAvailabilityService demandService;
    @PostMapping("/getAvailability")
    public ResponseEntity<AvailabilityResponse> getAvailability(@RequestBody AvailabilityRequest demandInput)
    {
        demandService.initializeDemand();
        demandService.initializeSupply();
        double availability = demandService.getAvailability(demandInput.getProductId());
        if(availability!=0)
        {
            AvailabilityResponse demandResponse=new AvailabilityResponse(demandInput.getProductId(),availability);
            return new ResponseEntity<AvailabilityResponse>(demandResponse, HttpStatus.OK);
        }
        return new ResponseEntity<AvailabilityResponse>(HttpStatus.NO_CONTENT);
    }
}
