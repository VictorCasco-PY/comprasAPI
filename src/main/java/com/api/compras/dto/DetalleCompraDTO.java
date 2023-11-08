package com.api.compras.dto;

import com.api.compras.abstracts.AbstractDto;
import com.api.compras.beans.CompraBean;
import com.api.compras.beans.DetalleCompraBean;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Data
public class DetalleCompraDao extends AbstractDto {
    private CompraBean compra;
    private String nombreLibro;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
