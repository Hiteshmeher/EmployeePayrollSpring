package com.bridgelabz.employeepayrollappspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;

}