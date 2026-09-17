package com.uniquindio.ecommerce.model.valueobject;

import com.uniquindio.ecommerce.model.exception.ReglaDominioException;

public record Calibre(String clasificacion, double diametroMinimo, double diametroMaximo) {

    public Calibre {
        if (clasificacion == null || clasificacion.isBlank()) {
            throw new ReglaDominioException("La clasificación del calibre no puede estar vacía.");
        }
        if (diametroMinimo < 0 || diametroMaximo < 0) {
            throw new ReglaDominioException("Los diámetros del calibre no pueden ser negativos.");
        }
        if (diametroMaximo < diametroMinimo) {
            throw new ReglaDominioException("El diámetro máximo no puede ser menor al diámetro mínimo.");
        }
    }
}