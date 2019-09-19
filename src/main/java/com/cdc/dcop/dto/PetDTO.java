package com.cdc.dcop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class PetDTO {

    @JsonIgnore
    private Long id;

    private CategoryDTO category;
    private String name;
    private List<String> photoUrls;
    private List<TagDTO> tags;
    private String status;
}
