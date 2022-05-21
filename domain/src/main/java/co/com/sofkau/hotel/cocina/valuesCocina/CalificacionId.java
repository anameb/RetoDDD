package domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina;

import co.com.sofka.domain.generic.Identity;

public class CalificacionId extends Identity {
    public CalificacionId(String id){
        super(id);
    }

    public static CalificacionId of(String id) {

        return new CalificacionId(id);
    }

    public CalificacionId() {
    }
}
