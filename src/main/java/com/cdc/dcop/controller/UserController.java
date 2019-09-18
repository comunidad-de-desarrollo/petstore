package com.cdc.dcop.controller;

import com.cdc.dcop.dto.UserDTO;
import com.cdc.dcop.services.UserService;
import com.cdc.utility.controller.BaseController;
import com.cdc.utility.model.dto.request.GenericResponse;
import com.cdc.utility.model.dto.request.SuccessMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"Operations about user"})
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //12
    @ApiOperation("Create user")
    @PostMapping()
    public GenericResponse<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
        /* validación dto, revisar dónde es mejor validar */
        UserDTO response = userService.create(userDTO);
        SuccessMessage s = new SuccessMessage("ACCEPTED", "USER ADDED");
        
        return BaseController.getResponse(true, null, s, response, HttpStatus.CREATED);
        //return BaseController.success(response, "OK", "AGREGADO CORRECTAMENTE");
    }
    
    //13 - 14
    @ApiOperation("Creates list of users with given input list")
    @PostMapping("/createWithList")
    public GenericResponse<List<UserDTO>> createWithList(@Valid @RequestBody List<UserDTO> userDTOs) {
        /* validación dtos */
        List<UserDTO> response = userService.createAll(userDTOs);
        return BaseController.getResponse(true, null, null, response, HttpStatus.OK);
    }

    //15
    @ApiOperation("Logs user into the system")
    @GetMapping("/login")
    public GenericResponse<Boolean> login(@RequestParam String user, @RequestParam String password) {
        Boolean loggedIn = userService.login(user, password);
        HttpStatus httpStatus = HttpStatus.OK;
        if (!loggedIn) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return BaseController.getResponse(true, null, null, loggedIn, httpStatus);

    }
}
