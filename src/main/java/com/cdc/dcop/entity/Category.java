package com.cdc.dcop.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "COC_CATEGORIA")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 8991262456609739875L;

	@Id
	@GeneratedValue(generator = "seqCategoryId")
	@SequenceGenerator(name = "seqCategoryId", sequenceName = "COS_CATEGORIAS", allocationSize = 1)
	@Column(name = "CVE_CATEGORIA")
	private Long id;

	@Column(name="NOM_CATEGORIA")
	private String name;
}
