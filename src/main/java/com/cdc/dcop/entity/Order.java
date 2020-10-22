package com.cdc.dcop.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
@Table(name = "COT_ORDENES")
public class Order implements Serializable {

	private static final long serialVersionUID = -8925629198146835353L;

    @Id
    @GeneratedValue(generator = "seqOrderId")
    @SequenceGenerator(name = "seqOrderId", sequenceName = "COS_ORDENES", allocationSize = 1)
    @Column(name = "CVE_ORDEN", updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CVE_MASCOTA")
    private Pet pet;

    @Column(name = "CAN_CANTIDAD", nullable = false)
    private Integer quantity;

    @Column(name = "STP_ENVIO", nullable = false)
    private LocalDate shipDate;

    @Column(name = "REF_STATUS", nullable = false)
    private String status;

    @Column(name = "IND_COMPLETADO", nullable = false)
    private Boolean complete;

    @Column(name = "IND_ACTIVO", nullable = false)
    private Boolean active;


    public Order(Long id) {
        this.id = id;
        this.active = true;
    }

    @PrePersist
    public void prePersis() {
        active = true;
    }

}
