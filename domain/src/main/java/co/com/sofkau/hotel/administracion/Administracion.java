package co.com.sofkau.hotel.administracion;



import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.events.ProductoProveedorAgregado;
import co.com.sofkau.hotel.administracion.events.ServicioExternoModificado;
import co.com.sofkau.hotel.administracion.events.TelefonoEmpleadoCambiado;
import co.com.sofkau.hotel.administracion.valuesAdmi.*;
import co.com.sofkau.hotel.values.Telefono;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class Administracion extends AggregateEvent<AdministracionId> {

    protected Telefono telefono;

    protected Empleado empleado;

    protected Set<Externo> externos;

    protected Set<Proveedor> proveedors;


    public void crearAdministracion(AdministracionId administracionId,Telefono telefono) {
        appendChange(new AdministracionCreada(administracionId, telefono)).apply();
        subscribe(new AdministracionEventChange(this));
    }

    public Administracion(AdministracionId administracionId, Telefono telefono) {
        super(administracionId);
        appendChange(new AdministracionCreada(administracionId, telefono)).apply();
        subscribe(new AdministracionEventChange(this));
    }

    private Administracion(AdministracionId administracionId){
        super(administracionId);
        subscribe(new AdministracionEventChange(this));
    }

    public static Administracion from(AdministracionId administracionId, List<DomainEvent> events) {
        var administracion = new Administracion(administracionId);
        events.forEach(administracion::applyEvent);
        return administracion;
    }

    public void cambiarTelefonoEmpleado(EmpleadoId empleadoId, Telefono telefono) {
        appendChange(new TelefonoEmpleadoCambiado(empleadoId, telefono)).apply();
    }

    public void agragarProductoProveedor(Producto producto) {
        var proveedorId = new ProveedorId();
        appendChange(new ProductoProveedorAgregado(proveedorId, producto)).apply();
    }

    public void ModificarServicioExterno(Servicio servicio) {
        var externoId = new ExternoId();
        appendChange(new ServicioExternoModificado(externoId, servicio)).apply();
    }

    public Telefono telefono() {
        return telefono;
    }

    public List<Proveedor> proveedors(){
        return (List<Proveedor>) proveedors;
    }
}
