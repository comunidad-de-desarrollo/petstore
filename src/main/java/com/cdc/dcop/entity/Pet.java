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
@Table(name = "COPT_MASCOTA")
public class Pet implements Serializable {

	private static final long serialVersionUID = 4060148759780081521L;
	
	@Id
	@GeneratedValue
	@Column(name="CVE_USUARIO")
	private Long id;

	@Column(name="CVE_CATEGORIA")
	private Long category;

	@Column(name="NOM_NOMBRE")
	private String name;

	@Column(name="CVE_URL")
	private String photoUrls;

	@Column(name="CVE_TAG")
	private String tags;

	@Column(name="IND_ESTATUS")
	private String status;

}
