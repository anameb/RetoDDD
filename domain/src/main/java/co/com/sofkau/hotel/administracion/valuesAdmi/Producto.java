package co.com.sofkau.hotel.administracion.valuesAdmi;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Producto implements ValueObject<String> {
    private final String value;

    public Producto(String value) {

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}

