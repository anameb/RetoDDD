package co.com.sofkau.hotel.cocina.valuesCocina;

import co.com.sofka.domain.generic.Identity;

public class CocinaId extends Identity {
    public CocinaId(String id){
        super(id);
    }

    public static CocinaId of(String id) {

        return new CocinaId(id);
    }

    public CocinaId() {
    }
}
