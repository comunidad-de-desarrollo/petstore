package com.cdc.dcop.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "COT_MASCOTAS")
public class Pet implements Serializable {

	private static final long serialVersionUID = -3930992985165724739L;

	@Id
	@GeneratedValue(generator = "seqPetId")
	@SequenceGenerator(name = "seqPetId", sequenceName = "COS_MASCOTAS", allocationSize = 1)
	@Column(name = "CVE_MASCOTA", updatable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "CVE_CATEGORIA")
	private Category category;

	@Column(name = "NOM_NOMBRE", nullable = false, length = 250)
	private String name;

	@ElementCollection
	@CollectionTable(
			name="COT_MASCOTA_URLS",
			joinColumns=@JoinColumn(name="CVE_MASCOTA")
	)
	@Column(name="REF_URL")
	private List<String> photoUrls;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "COT_MASCOTA_ETIQUETAS", joinColumns = @JoinColumn(name = "CVE_MASCOTA"),
			inverseJoinColumns = @JoinColumn(name = "CVE_ETIQUETA"))
	private List<Tag> tags;

	@Column(name = "IND_ESTATUS", nullable = false)
	private String status;

}
