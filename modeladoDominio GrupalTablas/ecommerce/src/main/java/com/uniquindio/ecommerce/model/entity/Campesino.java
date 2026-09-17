package com.uniquindio.ecommerce.model.entity;

import com.uniquindio.ecommerce.model.exception.ReglaDominioException;

import java.util.Objects;
import java.util.UUID;

public class Campesino {

    private final UUID id;
    private String nombre;
    private boolean autorizado;

    // El constructor asume la creación inicial
    public Campesino(UUID id, String nombre) {
        if (id == null) {
            throw new ReglaDominioException("El identificador del campesino no puede ser nulo.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new ReglaDominioException("El nombre del campesino es obligatorio.");
        }

        this.id = id;
        this.nombre = nombre;
        this.autorizado = false; // Por defecto no está autorizado al registrarse
    }

    // Comportamientos de la entidad (en lugar de setters)

    public void autorizar() {
        this.autorizado = true;
    }

    public void desautorizar() {
        this.autorizado = false;
    }

    public void actualizarNombre(String nuevoNombre) {
        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            throw new ReglaDominioException("El nombre no puede quedar vacío.");
        }
        this.nombre = nuevoNombre;
    }

    // Getters para lectura

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    // Métodos de identidad (equals y hashCode solo por ID)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campesino campesino = (Campesino) o;
        return Objects.equals(id, campesino.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}