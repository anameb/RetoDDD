package domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva;

import co.com.sofka.domain.generic.Identity;

public class HuespedId extends Identity {

    public HuespedId(String id){
        super(id);
    }

    public HuespedId(){
    }

    public static HuespedId of(String id){
        return new HuespedId(id);
    }
}
