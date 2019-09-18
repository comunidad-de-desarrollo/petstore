package com.cdc.dcop.utils;

import org.springframework.http.HttpStatus;

import com.cdc.utility.model.dto.error.InternalError;
import com.cdc.utility.model.dto.error.InternalException;

public class PetstoreValidation {
	
	/**
	 * Unauthorized.
	 *
	 * @return the internal exception
	 */
	public static InternalException notLogged() {
		InternalException errores = new InternalException();
		InternalError bussinessError = InternalException.obtenerErrorNegocio("401.1", "Error", "The username or password is incorrect",
				null, HttpStatus.UNAUTHORIZED);
		errores.add(bussinessError);

		return errores;
	}
}
