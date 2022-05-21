package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.cocina.Cocina;
import co.com.sofkau.hotel.cocina.commands.CrearCocina;

public class CrearCocinaUseCase extends UseCase<RequestCommand<CrearCocina>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCocina> crearCocinaRequestCommand) {
        var command = crearCocinaRequestCommand.getCommand();

        var cocina = new Cocina(
                command.getCocinaId(),
                command.getTipo()
        );

        emit().onResponse(new ResponseEvents(cocina.getUncommittedChanges()));
    }
}
