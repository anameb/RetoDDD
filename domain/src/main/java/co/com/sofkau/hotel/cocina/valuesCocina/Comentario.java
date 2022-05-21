package domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Comentario implements ValueObject<String> {
    private final String value;

    public Comentario(String value){

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}