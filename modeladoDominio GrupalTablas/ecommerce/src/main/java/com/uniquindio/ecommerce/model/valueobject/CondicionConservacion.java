package com.uniquindio.ecommerce.model.valueobject;


import com.uniquindio.ecommerce.model.exception.ReglaDominioException;

public record CondicionConservacion(double temperaturaMinima, double temperaturaMaxima, boolean requiereCadenaFrio) {

    public CondicionConservacion {
        if (temperaturaMaxima < temperaturaMinima) {
            throw new ReglaDominioException("La temperatura máxima no puede ser inferior a la mínima para la conservación.");
        }

        // Si requiere cadena de frío, usualmente la temperatura máxima no debería superar un umbral (ejemplo: 8 grados)
        if (requiereCadenaFrio && temperaturaMaxima > 8.0) {
            throw new ReglaDominioException("Si requiere cadena de frío, la temperatura máxima debe asegurar la conservación (<= 8.0 °C).");
        }
    }
}
