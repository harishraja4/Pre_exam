package com.example.restApp.Service;

import com.example.restApp.Model.Availability;
import com.example.restApp.Model.Capacity;
import com.example.restApp.Model.StoreRequest;
import com.example.restApp.Model.StoreResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class StoreService {

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    private  static List<Availability> availabilityList=new ArrayList<>();
    private static List<Capacity> capacityList=new ArrayList<>();
    public void initializeAvailability() {
        availabilityList.add(new Availability("Store001", "Prod1", LocalDate.of(2021,02,19), new Double(1.0)));
        availabilityList.add(new Availability("Store001", "Prod1", LocalDate.of(2021,02,20), new Double(3.0)));
        availabilityList.add(new Availability("Store001", "Prod1", LocalDate.of(2021,02,21), new Double(0)));
    }

    public void initializeCapacity() {
        capacityList.add(new Capacity("Store001", "Prod1", LocalDate.of(2021,02,19), new Double(0)));
        capacityList.add(new Capacity("Store001", "Prod1", LocalDate.of(2021,02,20), new Double(2.0)));
        capacityList.add(new Capacity("Store001", "Prod1", LocalDate.of(2021,02,21), new Double(2.0)));
    }

    @Async
    public CompletableFuture<Availability> getAvailability(String storeNo) {
        Optional<Availability> first = availabilityList.stream().filter(i -> i.getStoreNo().equals(storeNo)).findFirst();
        return CompletableFuture.completedFuture(first.get());
    }

    @Async
    public CompletableFuture<Capacity> getCapacity(String storeNo) {
        Optional<Capacity> first = capacityList.stream().filter(i -> i.getStoreNo().equals(storeNo)).findFirst();
        return CompletableFuture.completedFuture(first.get());
    }

    public String getStatus(StoreRequest storeRequest) {
        double availabilty = availabilityList.stream().filter(i -> i.getDate().equals(storeRequest.getReqDate())).mapToDouble(i -> i.getAvailQty()).sum();
        double capacity = capacityList.stream().filter(i -> i.getDate().equals(storeRequest.getReqDate())).mapToDouble(i -> i.getAvailQty()).sum();
        String status=null;
        if(availabilty>0)
        {
            if(capacity==0)
                return "No Capacity";
            else
                return "Available";
        }
        else
            return status;
    }
}
