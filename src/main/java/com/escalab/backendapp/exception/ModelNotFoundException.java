package com.escalab.backendapp.exception;

public class ModelNotFoundException extends RuntimeException {
	public ModelNotFoundException(String mensaje) {
		super(mensaje);
	}
}
