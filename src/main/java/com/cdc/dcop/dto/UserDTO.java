package com.cdc.dcop.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private Long userStatus;
}
