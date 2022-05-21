package co.com.sofkau.hotel.administracion;


import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.hotel.administracion.valuesAdmi.Producto;
import co.com.sofkau.hotel.administracion.valuesAdmi.ProveedorId;
import co.com.sofkau.hotel.values.Nombre;

public class Proveedor extends Entity<ProveedorId> {
    protected Producto producto;

    public Proveedor(ProveedorId proveedorId, Producto producto) {
        super(proveedorId);
        this.producto = producto;
    }

    public void agregarProducto(Producto producto){
            this.producto = producto;
    }

    public Producto producto (){
        return producto;
    }
}
