package com.cdc.dcop.utils;

import com.cdc.utility.model.dto.error.InternalError;
import com.cdc.utility.model.dto.error.InternalException;
import org.springframework.http.HttpStatus;

public class PetstoreValidation {

    /**
     * Returns not found error.
     *
     * @return the internal exception
     */
    public static InternalException notFound(String title, String message) {
        InternalException errores = new InternalException();
        InternalError bussinessError = InternalException.obtenerErrorNegocio("404", title, message,
                null, HttpStatus.NOT_FOUND);
        errores.add(bussinessError);
        return errores;
    }
}
