package domain.src.main.java.co.com.sofkau.hotel.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Total implements ValueObject<Integer> {

    private final Integer value;

    public Total(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
