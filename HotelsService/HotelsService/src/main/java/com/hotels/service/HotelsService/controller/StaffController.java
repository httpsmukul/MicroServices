package com.hotels.service.HotelsService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {


    @GetMapping
    public ResponseEntity<List<String>> getStaff(){
        List<String> staff = Arrays.asList("RAM","SHAYAM","ROHAN");
        return ResponseEntity.ok().body(staff);
    }

}
