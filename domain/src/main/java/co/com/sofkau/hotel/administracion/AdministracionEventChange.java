package co.com.sofkau.hotel.administracion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.events.ProductoProveedorAgregado;
import co.com.sofkau.hotel.administracion.events.ServicioExternoModificado;
import co.com.sofkau.hotel.administracion.events.TelefonoEmpleadoCambiado;
import co.com.sofkau.hotel.administracion.valuesAdmi.EmpleadoId;
import co.com.sofkau.hotel.administracion.valuesAdmi.Servicio;

import java.util.HashSet;
import java.util.Set;

public class AdministracionEventChange extends EventChange {

    public AdministracionEventChange(Administracion administracion) {
        EmpleadoId entityId = new EmpleadoId("2345");
        apply((AdministracionCreada event) ->{
            administracion.telefono = event.getTelefono();
            administracion.empleado = new Empleado(entityId);
            administracion.proveedors= new HashSet<>();
            administracion.externos= new HashSet<>();
        });

        apply((ProductoProveedorAgregado event) -> {
            var proveedorId = event.getProveedorId();
            var proveedor = new Proveedor(proveedorId, event.getProducto());
            administracion.proveedors.add(proveedor);
        });

        apply((ServicioExternoModificado event) ->{
            var externoId = event.getExternoId();
            var externo = new Externo(externoId, (Set<Servicio>) event.getServicio());
            administracion.externos.add(externo);
        });

        apply((TelefonoEmpleadoCambiado event) ->{
            var telefono = event.getTelefono();
            administracion.empleado.cambiarTelefono(telefono);

        });
    }
}
