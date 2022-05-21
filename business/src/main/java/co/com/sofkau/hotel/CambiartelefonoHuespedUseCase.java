package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.reserva.Reserva;
import co.com.sofkau.hotel.reserva.commands.CambiarTelefonoHuesped;

public class CambiartelefonoHuespedUseCase extends UseCase<RequestCommand <CambiarTelefonoHuesped>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoHuesped> cambiarTelefonoHuespedRequestCommand) {
        var command = cambiarTelefonoHuespedRequestCommand.getCommand();
        var reserva = Reserva.from(command.getReservaId(),repository().getEventsBy(command.getReservaId().value()));
        reserva.CambiarTelefonoHuesped(command.getHuespedId(), command.getTelefono());
        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
