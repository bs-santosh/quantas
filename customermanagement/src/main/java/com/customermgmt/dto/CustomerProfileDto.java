package com.customermgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
public class CustomerProfileDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private List<AddressDto> addresses;
}
