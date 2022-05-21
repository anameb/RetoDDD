package domain.src.main.java.co.com.sofkau.hotel.administracion;

import co.com.sofka.domain.generic.Entity;
import domain.src.main.java.co.com.sofkau.hotel.administracion.valuesAdmi.EmpleadoId;
import domain.src.main.java.co.com.sofkau.hotel.values.Nombre;
import domain.src.main.java.co.com.sofkau.hotel.values.Telefono;

public class Empleado extends Entity<EmpleadoId> {
   protected Nombre nombre;
   protected Telefono telefono;

    public Empleado(EmpleadoId entityId) {
        super(entityId);
    }

    public Empleado(EmpleadoId empleadoId, Nombre nombre, Telefono telefono) {
        super(empleadoId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void cambiarTelefono (Telefono telefono) {

        this.telefono = telefono;
    }
}
