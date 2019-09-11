package com.cdc.dcop.entity;

import lombok.Data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COPT_USUARIOS")
public class User implements Serializable {

	private static final long serialVersionUID = 8512520820418639813L;

	@Id
    @SequenceGenerator(name = "COP_USUARIOS_SEQ", sequenceName = "COP_USUARIOS_SEQ", allocationSize = 1)
	@Column(name="CVE_USUARIO")
	private Long id;

	@Column(name="REF_USUARIO")
	private String username;

	@Column(name="NOM_NOMBRE")
	private String firstName;

	@Column(name="NOM_APELLIDO")
	private String lastName;

	@Column(name="REF_CORREO")
	private String email;

	@Column(name="REF_CONTRASENIA")
	private String password;

	@Column(name="NUM_TELEFONO")
	private String phone;

	@Column(name="CVE_ESTATUS")
	private Integer userStatus;
}
