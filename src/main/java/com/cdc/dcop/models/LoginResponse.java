package com.cdc.dcop.models;

import lombok.Data;

@Data
public class LoginResponse {

	private int session;
	private Boolean active;
}
