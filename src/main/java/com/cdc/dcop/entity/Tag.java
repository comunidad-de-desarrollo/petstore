package com.cdc.dcop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "COT_ETIQUETAS")
public class Tag implements Serializable {

	private static final long serialVersionUID = -2321336762304469507L;

	@Id
	@GeneratedValue(generator = "seqTagId")
	@SequenceGenerator(name = "seqTagId", sequenceName = "COS_ETIQUETAS", allocationSize = 1)
	@Column(name = "CVE_ETIQUETA", updatable = false)
	private Long id;

	@Column(name = "NOM_NOMBRE", nullable = false, length = 250)
	private String name;

}
