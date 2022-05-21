package co.com.sofkau.hotel.cocina.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Nombre;

public class AgregarMenu extends Command {
    private final CocinaId cocinaId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public AgregarMenu(CocinaId cocinaId, Nombre nombre, Descripcion descripcion) {
        this.cocinaId = cocinaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public CocinaId getCocinaId() {
        return cocinaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
