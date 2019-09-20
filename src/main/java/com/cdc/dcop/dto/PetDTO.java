package com.cdc.dcop.dto;

import lombok.Data;

@Data
public class PetDTO {

    private Long id;

    private Long category;

    private String name;

    private String photoUrls;

    private String tags;

    private String status;

}
