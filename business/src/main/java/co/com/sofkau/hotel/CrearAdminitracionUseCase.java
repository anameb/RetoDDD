package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.administracion.Administracion;
import co.com.sofkau.hotel.administracion.commands.CrearAdministracion;

public class CrearAdminitracionUseCase extends UseCase<RequestCommand<CrearAdministracion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAdministracion> crearAdministracionRequestCommand) {
        var command = crearAdministracionRequestCommand.getCommand();
        var administracion = new Administracion(
                command.getAdministracionId(),
                command.getTelefono()
        );

        emit().onResponse(new ResponseEvents(administracion.getUncommittedChanges()));
    }
}
