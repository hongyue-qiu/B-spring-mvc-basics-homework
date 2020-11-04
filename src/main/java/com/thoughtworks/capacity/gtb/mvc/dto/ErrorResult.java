package com.thoughtworks.capacity.gtb.mvc.dto;

import com.thoughtworks.capacity.gtb.mvc.excption.NameNotUniqueException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private String message;
}
