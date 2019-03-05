package com.customermgmt.controller;

import com.customermgmt.dto.CustomerProfileDto;
import com.customermgmt.dto.CustomerProfileResponse;
import com.customermgmt.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerProfileController {
    @Autowired
    CustomerProfileService customerProfileService;

    @GetMapping(name = "/find-customers/{customerId}")
    public CustomerProfileResponse findProfiles(@PathVariable(name = "customerId", required = false) Integer customerId) {
        System.out.println("customerId = " + customerId);
        if (customerId == null) {
            return CustomerProfileResponse.builder()
                    .customerProfileDtos(customerProfileService.findAllCustomerProfiles())
                    .build();
        } else {
            CustomerProfileDto customerProfileDto = customerProfileService.findCustomerProfileById(Long.getLong(customerId.toString()));
            List<CustomerProfileDto> customerProfileDtos = new ArrayList<>();
            customerProfileDtos.add(customerProfileDto);
            return CustomerProfileResponse.builder()
                    .customerProfileDtos(customerProfileDtos)
                    .build();
        }

    }

    @PostMapping(name = "/save-customer")
    public void saveCustomerProfile(@RequestBody CustomerProfileDto customerProfileDto) {
        customerProfileService.saveCustomerProfile(customerProfileDto);
    }

    @PostMapping(name = "/delete-customer")
    public void deleteCustomerProfile(@RequestBody CustomerProfileDto customerProfileDto) {
        customerProfileService.deleteCustomerProfile(customerProfileDto.getId());
    }
}
