package co.com.sofkau.hotel.administracion.valuesAdmi;

import co.com.sofka.domain.generic.Identity;

public class ExternoId extends Identity {

    public ExternoId(String id){
        super(id);
    }

    public static ExternoId of(String id) {
        return new ExternoId(id);
    }

    public ExternoId() {
    }
}
