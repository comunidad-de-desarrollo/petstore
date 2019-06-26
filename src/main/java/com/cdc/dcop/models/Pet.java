package com.cdc.dcop.models;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Pet {
	
	private int id;
	private Category category;
	private String name;
	private ArrayList<String> photoUrls;
	private ArrayList<Tag> tags;
	private String status;

}
