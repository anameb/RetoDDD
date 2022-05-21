package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.cocina.Cocina;
import co.com.sofkau.hotel.cocina.commands.AgregarMenu;

public class AgregarMenuUseCase extends UseCase<RequestCommand <AgregarMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMenu> agregarMenuRequestCommand) {
        var command = agregarMenuRequestCommand.getCommand();
        var cocina = Cocina.from(command.getCocinaId(), repository().getEventsBy(command.getCocinaId().value()));

        cocina.AgregarMenu(command.getNombre(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(cocina.getUncommittedChanges()));
    }
}
