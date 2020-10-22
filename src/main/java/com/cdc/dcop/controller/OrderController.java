package com.cdc.dcop.controller;

import com.cdc.dcop.dto.OrderDTO;
import com.cdc.dcop.services.OrderService;
import com.cdc.dcop.validators.OrderValidator;
import com.cdc.utility.controller.BaseController;
import com.cdc.utility.model.dto.error.Errors;
import com.cdc.utility.model.dto.error.InternalError;
import com.cdc.utility.model.dto.error.InternalException;
import com.cdc.utility.model.dto.request.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Api(tags = {"Access to Petstore orders"})
@RestController
@RequestMapping(path = "store")
public class OrderController {

    private static final String PROCESS_SUCCESS = "Todo de manera exitosa";
    private static final String REQUEST_SUCCESS = "Petición exitosa";

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    // TODO: Agregar implementación del método siguiente
    @ApiOperation("Returns pet inventories by status")
    @GetMapping(path = "/inventory")
    @ApiResponse(code = 200, message = "Respuesta exitosa")
    public GenericResponse<String> getInventory() {
        return BaseController.getResponse(true, null, null, "Order not found", HttpStatus.NOT_FOUND);
    }

    @ApiOperation("Place an order for a pet")
    @PostMapping(path = "/order")
    @ApiResponse(code = 200, message = "Respuesta exitosa")
    public GenericResponse saveOrder(@Valid @RequestBody OrderDTO orderDTO) {
        InternalException errors = OrderValidator.validate(orderDTO);
        if (!errors.isEmpty()) {
            return BaseController.error(errors.getErrores());
        }
        OrderDTO order = orderService.saveOrder(orderDTO);
        if (order == null) {
            return BaseController.error(getError(Errors.GENERAL_PETICION_ERRONEA, "Campo", "petId"));
        }
        return BaseController.getResponse(true, null, null, order, HttpStatus.CREATED);

    }

    @ApiOperation("Find purchase order by ID")
    @GetMapping(path = "/order/{orderId}")
    public GenericResponse getOrderById(@Valid @PathVariable Long orderId) {
        OrderDTO order = orderService.getOrderById(orderId);
        if (order == null) {
            return BaseController.getResponse(false, null, null, "Order not found", HttpStatus.NOT_FOUND);
        }
        return BaseController.getResponse(true, null, null, order, HttpStatus.OK);

    }

    @ApiOperation("Delete purchase order by ID")
    @DeleteMapping(path = "/order/{orderId}")
    public GenericResponse<String> delete(@Valid @PathVariable Long orderId) {
        boolean deleted = orderService.deleteById(orderId);
        if (deleted) {
            return BaseController.getResponse(true, null, null, "Eliminación exitosa", HttpStatus.OK);
        }
        return BaseController.getResponse(false, null, null, "Order not found", HttpStatus.NOT_FOUND);

    }

    private static InternalError getError(Errors error, String field, String value) {
        Map<String, Object> detail = new HashMap<>();
        detail.put(field, value);
        return error.getError(detail);
    }

}
