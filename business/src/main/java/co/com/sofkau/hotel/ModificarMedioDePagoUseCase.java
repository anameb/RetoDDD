package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.reserva.Reserva;
import co.com.sofkau.hotel.reserva.commands.ModificarMedioDePago;

public class ModificarMedioDePagoUseCase extends UseCase<RequestCommand <ModificarMedioDePago>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarMedioDePago> modificarMedioDePagoRequestCommand) {
        var command = modificarMedioDePagoRequestCommand.getCommand();
        var reserva = Reserva.from(command.getReservaId(),repository().getEventsBy(command.getReservaId().value()));

        reserva.ModificarMedioDePago(command.getPagoId(), command.getMedioDePago());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
