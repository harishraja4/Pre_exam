package com.example.restApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
public class Availability {
    private String storeNo;
    private String productId;
    private LocalDate date;
    private Double availQty;

}
