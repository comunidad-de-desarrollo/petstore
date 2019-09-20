package com.cdc.dcop.controller;

import com.cdc.dcop.dto.PetDTO;
import com.cdc.dcop.services.PetService;
import com.cdc.utility.controller.BaseController;
import com.cdc.utility.model.dto.request.GenericResponse;
import com.cdc.utility.model.dto.request.SuccessMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Everything about your Pets"})
@RestController
@RequestMapping(path = "pet/")
public class PetController {

    @Autowired
    private PetService petService;

    // Buscar Mascota por id
    @ApiOperation("Find pet by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse<PetDTO> findById(@PathVariable Long id) {
        PetDTO petDTO = petService.findById(id);
        SuccessMessage s = new SuccessMessage("OK", "founded");
        return BaseController.getResponse(true, null, s, petDTO, HttpStatus.OK);
    }

}
