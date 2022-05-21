package domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina;

import co.com.sofka.domain.generic.Identity;

public class MenuId extends Identity {

    public MenuId(String id){
        super(id);
    }

    public static MenuId of(String id) {
        return new MenuId(id);
    }

    public MenuId() {
    }
}
