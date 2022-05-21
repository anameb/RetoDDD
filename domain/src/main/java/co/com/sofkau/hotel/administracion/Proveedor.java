package domain.src.main.java.co.com.sofkau.hotel.administracion;

import co.com.sofka.domain.generic.Entity;
import domain.src.main.java.co.com.sofkau.hotel.values.Nombre;
import domain.src.main.java.co.com.sofkau.hotel.administracion.valuesAdmi.Producto;
import domain.src.main.java.co.com.sofkau.hotel.administracion.valuesAdmi.ProveedorId;

public class Proveedor extends Entity<ProveedorId> {
    protected Nombre nombre;
    protected Producto producto;

    public Proveedor(ProveedorId proveedorId, Producto producto) {
        super(proveedorId);
        this.producto = producto;
    }

    public void agregarProducto(Producto producto){
            this.producto = producto;
    }
}
