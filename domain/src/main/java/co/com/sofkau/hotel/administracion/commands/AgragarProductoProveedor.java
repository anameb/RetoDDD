package co.com.sofkau.hotel.administracion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.administracion.valuesAdmi.Producto;
import co.com.sofkau.hotel.administracion.valuesAdmi.ProveedorId;

public class AgragarProductoProveedor extends Command {

    private final ProveedorId proveedorId;
    private  final Producto producto;
    private final AdministracionId administracionId;

    public AgragarProductoProveedor(ProveedorId proveedorId, Producto producto, AdministracionId administracionId) {
        this.proveedorId = proveedorId;
        this.producto = producto;
        this.administracionId = administracionId;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public Producto getProducto() {
        return producto;
    }

    public AdministracionId getAdministracionId() {
        return administracionId;
    }
}
