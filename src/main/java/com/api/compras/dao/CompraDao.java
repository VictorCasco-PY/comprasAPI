package com.api.compras.dao;

import com.api.compras.beans.CompraBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraDao extends JpaRepository<CompraBean, Long> {
    // Puedes agregar métodos personalizados aquí si necesitas consultas específicas.
}
