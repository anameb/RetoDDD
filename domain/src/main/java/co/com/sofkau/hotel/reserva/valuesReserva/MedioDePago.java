package co.com.sofkau.hotel.reserva.valuesReserva;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MedioDePago implements ValueObject<String> {

    private final String value;

    public MedioDePago(String value){
        this.value = Objects.requireNonNull(value);
    }

    public MedioDePago() {

        value = "efectivo";
    }

    @Override
    public String value() {
        return value;
    }

}
