package com.cdc.dcop.utils;

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
