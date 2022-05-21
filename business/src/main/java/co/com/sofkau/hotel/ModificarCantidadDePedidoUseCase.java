package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.cocina.Cocina;
import co.com.sofkau.hotel.cocina.commands.ModificarCantidadDePedido;

public class ModificarCantidadDePedidoUseCase extends UseCase<RequestCommand <ModificarCantidadDePedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarCantidadDePedido> modificarCantidadDePedidoRequestCommand) {
        var command = modificarCantidadDePedidoRequestCommand.getCommand();
        var cocina = Cocina.from(command.getCocinaId(), repository().getEventsBy(command.getCocinaId().value()));
        cocina.ModificarCantidadDePedido(command.getPedidoId(), command.getCantidad());
        emit().onResponse(new ResponseEvents(cocina.getUncommittedChanges()));
    }
}
