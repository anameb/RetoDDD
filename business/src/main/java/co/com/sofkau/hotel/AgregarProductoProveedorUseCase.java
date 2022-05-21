package co.com.sofkau.hotel;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.administracion.Administracion;
import co.com.sofkau.hotel.administracion.Proveedor;
import co.com.sofkau.hotel.administracion.commands.AgragarProductoProveedor;

public class AgregarProductoProveedorUseCase extends UseCase<RequestCommand<AgragarProductoProveedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgragarProductoProveedor> agregarProductoProveedorRequestCommand) {
        var command = agregarProductoProveedorRequestCommand.getCommand();
        var administracion = Administracion.from(
                command.getAdministracionId(), repository().getEventsBy(command.getAdministracionId().value())
        );



        administracion.agragarProductoProveedor(command.getProducto());

        emit().onResponse(new ResponseEvents(administracion.getUncommittedChanges()));

    }
}
