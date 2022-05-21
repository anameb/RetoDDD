package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.hotel.reserva.Reserva;
import co.com.sofkau.hotel.reserva.commands.CrearReserva;

public class CrearReservaUseCase extends UseCase<RequestCommand<CrearReserva>, ResponseEvents> {

@Override
public void executeUseCase(RequestCommand<CrearReserva> crearReservaRequestCommand) {
        var command = crearReservaRequestCommand.getCommand();

        var reserva = new Reserva(
            command.getReservaId(),
            command.getFechaIngreso(),
            command.getFecha()
        );

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
        }
        }
