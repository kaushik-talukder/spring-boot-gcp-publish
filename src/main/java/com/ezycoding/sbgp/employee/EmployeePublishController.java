package com.ezycoding.sbgp.employee;


import com.ezycoding.sbgp.PubsubOutboundGateway;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeePublishController {

    @Autowired private PubsubOutboundGateway messagingGateway;
    @Autowired private EmployeeRepository repository;
    @Autowired private Gson gson;

    @PostMapping("/publishMessage")
    public ResponseEntity<Object> publishMessage(@RequestParam("message") String message) {
        List<Employee> emp = repository.findAll();
        messagingGateway.sendToPubsub(gson.toJson(emp));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
