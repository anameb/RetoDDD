package co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.hotel.cocina.valuesCocina.MenuId;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Nombre;

public class Menu extends Entity<MenuId> {

    protected Nombre nombre;
    protected Descripcion descripcion;
    private Menu menu;

    public Menu(MenuId menuId, Nombre nombre, Descripcion descripcion) {
        super(menuId);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void agregarMenu(Menu menu){
        this.menu = menu;
    }
}
