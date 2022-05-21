package co.com.sofkau.hotel.cocina.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.valuesCocina.MenuId;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Nombre;

import java.util.UUID;

public class MenuAgregado extends DomainEvent {

    private final MenuId menuId;

    private final Nombre nombre;

    private final Descripcion descripcion;

    public MenuAgregado(MenuId menuId, Nombre nombre, Descripcion descripcion) {
        super("co.com.sofkau.hotel.cocina.events.MenuCreada");
        this.menuId = menuId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
