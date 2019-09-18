package com.cdc.dcop.controller;

import com.cdc.dcop.services.OrderService;
import com.cdc.utility.controller.BaseController;
import com.cdc.utility.model.dto.request.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Access to Petstore orders"})
@RestController
@RequestMapping(path = "store/")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //11
    @ApiOperation("Delete purchase order by ID")
    @DeleteMapping(path = "/order/{orderId}")
    public GenericResponse<String> delete(@Valid @PathVariable Long orderId) {
        boolean deleted = orderService.deleteById(orderId);
        if (deleted) {
            return BaseController.getResponse(true, null, null, "Eliminación exitosa", HttpStatus.OK);
        }
        return BaseController.getResponse(true, null, null, "Order not found", HttpStatus.NOT_FOUND);

    }

}
