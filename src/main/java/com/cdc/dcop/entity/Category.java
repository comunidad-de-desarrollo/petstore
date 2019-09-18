package com.cdc.dcop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COPT_CATEGORIA")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 8991262456609739875L;

	@Id
	@GeneratedValue
	@Column(name="CVE_CATEGORIA")
	private Long id;

	@Column(name="NOM_CATEGORIA")
	private String name;
}
