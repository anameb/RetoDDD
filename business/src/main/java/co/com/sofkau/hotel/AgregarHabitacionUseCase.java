package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.reserva.Reserva;
import co.com.sofkau.hotel.reserva.commands.AgragarHabitacion;

public class AgregarHabitacionUseCase extends UseCase<RequestCommand <AgragarHabitacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgragarHabitacion> agragarHabitacionRequestCommand) {
        var command = agragarHabitacionRequestCommand.getCommand();
        var reserva = Reserva.from(command.getReservaId(),repository().getEventsBy(command.getReservaId().value()));

        reserva.AgragarHabitacion(command.getDescripcion(), command.getTotal());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
