package com.meftaul.emm.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {

    @NotNull(message = "Employee can not be null or blank.")
    @NotBlank
    private String employeeId;

    @NotNull
    @NotBlank
    private String firstName;

    private String lastName;

    private String designation;

    private Long paymentSchemeId;
}
