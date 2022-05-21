package co.com.sofkau.hotel.administracion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.valuesAdmi.Producto;
import co.com.sofkau.hotel.administracion.valuesAdmi.ProveedorId;

public class ProductoProveedorAgregado extends DomainEvent {

    private final ProveedorId proveedorId;
    private final Producto producto;

    public ProductoProveedorAgregado(ProveedorId proveedorId, Producto producto) {
        super("co.com.sofkau.hotel.administracion.events.ProductoProveedorAgregado");
        this.proveedorId = proveedorId;
        this.producto = producto;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public Producto getProducto() {
        return producto;
    }
}
