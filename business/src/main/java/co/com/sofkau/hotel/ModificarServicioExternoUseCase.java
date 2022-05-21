package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.administracion.Administracion;
import co.com.sofkau.hotel.administracion.commands.ModificarServicioExterno;

public class ModificarServicioExternoUseCase  extends UseCase<RequestCommand <ModificarServicioExterno>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarServicioExterno> modificarServicioExternoRequestCommand) {
        var command = modificarServicioExternoRequestCommand.getCommand();
        var administracion = Administracion.from(
                command.getAdministracionId(),repository().getEventsBy(command.getAdministracionId().value())
        );
        administracion.ModificarServicioExterno(command.getServicio());

    }
}
