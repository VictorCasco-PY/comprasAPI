package com.api.compras.beans;

import com.api.compras.abstracts.AbstractBean;
import java.math.BigDecimal;
import jakarta.persistence.*;


public class DetalleCompra extends AbstractBean {
    @ManyToOne
    @JoinColumn(name = "compra") // Nombre de la columna en la tabla que establece la relación con la compra
    private CompraBean compra; // Relación con la entidad CompraBean
    @Column(name = "nombre_libro")
    private String nombreLibro;
    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "subtotal")
    private BigDecimal subtotal;


}
