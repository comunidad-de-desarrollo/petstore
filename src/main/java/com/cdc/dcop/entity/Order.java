package com.cdc.dcop.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COPT_ORDEN")
public class Order implements Serializable {

	private static final long serialVersionUID = -8925629198146835353L;

	@Id
	@GeneratedValue
	@Column(name="CVE_ORDEN")
	private Long id;
	
	@Column(name="CVE_MASCOTA")
	private Long petId;

	@Column(name="CAN_CANTIDAD")
	private Integer quantity;

	@Column(name="STP_ENVIO")
	private LocalDate shipDate;

	@Column(name="REF_STATUS")
	private String status;

	@Column(name="COMPLETADO")
	private Boolean complete;
}
