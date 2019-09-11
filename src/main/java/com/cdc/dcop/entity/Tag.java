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
public class Tag implements Serializable {
	
	private static final long serialVersionUID = 861341592627391140L;
	
	@Id
	@GeneratedValue
	@Column(name="CVE_TAG")
	private Long id;

	@Column(name="NOM_NOMBRE")
	private String name;
}
