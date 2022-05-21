package co.com.sofkau.hotel.administracion.valuesAdmi;

import co.com.sofka.domain.generic.Identity;

public class AdministracionId extends Identity {
    public AdministracionId(String id) { super(id);}

    public static AdministracionId of(String id) {

        return new AdministracionId(id);
    }

}
