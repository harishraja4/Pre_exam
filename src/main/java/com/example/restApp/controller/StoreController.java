package com.example.restApp.controller;

import com.example.restApp.Model.Availability;
import com.example.restApp.Model.Capacity;
import com.example.restApp.Model.StoreRequest;
import com.example.restApp.Model.StoreResponse;
import com.example.restApp.Service.StoreService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class StoreController {
    @Autowired
    StoreService storeService;

    public ResponseEntity<StoreResponse> getProductAvailability(@RequestBody StoreRequest storeRequest)
    {
        storeService.initializeAvailability();
        storeService.initializeCapacity();
        CompletableFuture<Availability> availabilityCompletableFuture=storeService.getAvailability(storeRequest.getStoreNo());
        CompletableFuture<Capacity> capacityCompletableFuture=storeService.getCapacity(storeRequest.getStoreNo());
        String status=storeService.getStatus(storeRequest);
        if(status !=null)
        {
            StoreResponse storeResponse=new StoreResponse(storeRequest.getStoreNo(),storeRequest.getProductId(),storeRequest.getReqQty(),storeRequest.getReqDate(),status);
            return new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.OK);
        }
        else
            return new ResponseEntity<StoreResponse>(HttpStatus.NO_CONTENT);
    }

}
