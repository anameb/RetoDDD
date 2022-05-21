package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.administracion.Administracion;
import co.com.sofkau.hotel.administracion.commands.CambiarTelefonoEmpleado;

public class CambiarTelefonoEmpleadoUseCase  extends UseCase<RequestCommand <CambiarTelefonoEmpleado>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoEmpleado> cambiarTelefonoEmpleadoRequestCommand) {
        var command = cambiarTelefonoEmpleadoRequestCommand.getCommand();
        var administracion = Administracion.from(
                command.getAdministracionId(),repository().getEventsBy(command.getAdministracionId().value())
        );

        administracion.cambiarTelefonoEmpleado(command.getEmpleadoId(),command.getTelefono()
                );

        emit().onResponse(new ResponseEvents(administracion.getUncommittedChanges()));
    }
}
