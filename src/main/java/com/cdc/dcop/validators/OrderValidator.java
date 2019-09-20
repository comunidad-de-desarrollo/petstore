package com.cdc.dcop.validators;

import com.cdc.dcop.dto.OrderDTO;
import com.cdc.dcop.enums.OrderStatusEnum;
import com.cdc.utility.model.dto.error.Errors;
import com.cdc.utility.model.dto.error.InternalError;
import com.cdc.utility.model.dto.error.InternalException;
import com.cdc.utility.validation.BaseValidator;
import com.cdc.utility.validation.GenericValidator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class OrderValidator extends BaseValidator {

    public static InternalException validate(OrderDTO orderDTO) {
        InternalException ex = new InternalException();
        if (orderDTO == null) {
            ex.add(getError(Errors.VALIDACION_CAMPO_REQUERIDO, "revision"));
            return ex;
        } else {
            // Field "petId" validations
            ex.add(validaNumerico("petId", orderDTO.getPetId()));

            // Field "quantity" validations
            ex.add(validaNumerico("quantity", orderDTO.getQuantity()));

            // Field "shipDate" validations
            InternalError nullDate = validaNoNullo("shipDate", orderDTO.getShipDate());
            ex.add(nullDate);
            if (nullDate == null) {
                if (LocalDate.now().isBefore(orderDTO.getShipDate())) {
                    Map<String, Object> detalle = new HashMap<>();
                    detalle.put("Campo", "shipDate");
                    ex.add(Errors.VALIDACION_FECHA.getError(detalle));
                }
            }

            // Field "status" validations
            InternalError validStatus = validaTexto("status", orderDTO.getStatus(), GenericValidator.Regex.ALPHANUMERIC_MX, 9, 6, false); // TODO: Actualizar tamaño
            ex.add(validStatus);
            if (validStatus == null) {
                if (!OrderStatusEnum.containsName(orderDTO.getStatus())) {
                    ex.add(getError(Errors.BASEDATOS_CONSULTA_MALFORMDA, "status"));
                }
            }

            // Field "complete" validations
            ex.add(validaNoNullo("complete", orderDTO.getComplete()));

        }
        return ex;
    }
}
