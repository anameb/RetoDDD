package domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<Integer> {

    private final Integer value;

    public Cantidad(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }

    public Cantidad() { this.value = null;
    }
}
