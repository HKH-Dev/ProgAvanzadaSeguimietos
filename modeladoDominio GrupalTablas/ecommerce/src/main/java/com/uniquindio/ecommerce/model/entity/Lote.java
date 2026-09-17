package com.uniquindio.ecommerce.model.entity;

import java.util.Objects;

public class Lote {
    // Identificador final
    private final Long id;

    private final String producto;
    private final double cantidadKg;
    private final double precioBase;
    private final Long campesinoId;

    public Lote(Long id, String producto, double cantidadKg, double precioBase, Long campesinoId) {
        this.id = id;
        this.producto = producto;
        this.cantidadKg = cantidadKg;
        this.precioBase = precioBase;
        this.campesinoId = campesinoId;
    }

    // Solo Getters (Sin Setters)
    public Long getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public double getCantidadKg() {
        return cantidadKg;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Long getCampesinoId() {
        return campesinoId;
    }

    // equals() y hashCode() basados SOLO en la identidad (id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lote lote = (Lote) o;
        return Objects.equals(id, lote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}