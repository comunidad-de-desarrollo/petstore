package com.cdc.dcop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.time.LocalDate;

@Data
public class OrderDTO {

    @JsonIgnore
    private Long id;

    private Long petId;

    private Integer quantity;

    private LocalDate shipDate;

    private String status;

    private Boolean complete;
}
