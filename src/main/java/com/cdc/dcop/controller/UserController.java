package com.cdc.dcop.controller;

import com.cdc.dcop.dto.UserDTO;
import com.cdc.dcop.models.LoginResponse;
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
    
    //13
    @ApiOperation("Creates list of users with given input list")
    @PostMapping("/createWithArray")
    public GenericResponse<List<UserDTO>> createWithArray(@Valid @RequestBody List<UserDTO> userDTOs) {
        /* validación dtos */
        List<UserDTO> response = userService.createAll(userDTOs);
        return BaseController.getResponse(true, null, null, response, HttpStatus.OK);
    }
    //14
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
    public GenericResponse<LoginResponse> login(@RequestParam String username, @RequestParam String password) {
    	LoginResponse response = userService.login(username, password);
        return BaseController.getResponse(true, null, null, response, HttpStatus.OK);

    }
    
  //16
    @ApiOperation("Logs user out of the system")
    @GetMapping("/logout")
    public GenericResponse<Boolean> logout(@RequestParam String session) {
        Boolean loggedOut = userService.logout(session);
        HttpStatus httpStatus = HttpStatus.OK;
        if (!loggedOut) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return BaseController.getResponse(true, null, null, loggedOut, httpStatus);

    }
    
  //17
    @ApiOperation("Search by username")
    @GetMapping("/username")
    public GenericResponse<UserDTO> username(@RequestParam String username) {
    	UserDTO user = userService.username(username);
        HttpStatus httpStatus = HttpStatus.OK;
        if (user == null) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return BaseController.getResponse(true, null, null, user, httpStatus);

    }
    
  //18
    @ApiOperation("Search by username")
    @PostMapping("/username")
    public GenericResponse<Boolean> usernameUpdate(@RequestParam String username, @RequestParam UserDTO user) {
    	boolean updated = userService.updateUser(username, user);
        HttpStatus httpStatus = HttpStatus.OK;
        if (!updated) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return BaseController.getResponse(true, null, null, updated, httpStatus);

    }
    
  //19
    @ApiOperation("Search by username")
    @GetMapping("/delete/username")
    public GenericResponse<Boolean> delete(@RequestParam String username) {
    	boolean deleted = userService.delete(username);
        HttpStatus httpStatus = HttpStatus.OK;
        if (!deleted) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return BaseController.getResponse(true, null, null, deleted, httpStatus);

    }
}
