package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.cocina.Cocina;
import co.com.sofkau.hotel.cocina.commands.AlmacenarComentario;

public class AlmacenarComentarioUseCase extends UseCase<RequestCommand <AlmacenarComentario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AlmacenarComentario> almacenarComentarioRequestCommand) {
        var command = almacenarComentarioRequestCommand.getCommand();
        var cocina = Cocina.from(command.getCocinaId(), repository().getEventsBy(command.getCocinaId().value()));
        cocina.AlmacenarComentario(command.getCalificacionId(), command.getComentario());
        emit().onResponse(new ResponseEvents(cocina.getUncommittedChanges()));
    }
}
