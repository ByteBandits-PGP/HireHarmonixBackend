package com.bytebandits.hireharmonics.dto.request;

import java.util.List;

public record EmployeeRequestDto(String firstName,
                                 String lastName,
                                 String jobTitle,
                                 String email,
                                 String contactNumber,
                                 List<String> roles) {
}
