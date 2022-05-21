package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.hotel.reserva.commands.CrearReserva;
import co.com.sofkau.hotel.reserva.events.ReservaCreada;
import co.com.sofkau.hotel.reserva.valuesReserva.Fecha;
import co.com.sofkau.hotel.reserva.valuesReserva.FechaIngreso;
import co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CrearReservaUseCaseTest {

    private CrearReservaUseCase useCase;

    @BeforeEach
    public void setup(){ useCase = new CrearReservaUseCase();}

    @Test
    public void crearReservaHappyPass(){
        //arrange
        var reservaId = ReservaId.of("xxxxx");
        var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var fechaIngreso = new FechaIngreso(LocalDateTime.now(), LocalDate.now());
        var command = new CrearReserva( reservaId, fechaIngreso, fecha);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var reservaCreada = (ReservaCreada)events.get(0);
        Assertions.assertEquals("xxxxx", reservaCreada.aggregateRootId());
        //Assertions.assertEquals((), reservaCreada.getFecha().value());
        //Assertions.assertEquals((), reservaCreada.getFechaIngreso().value());

    }
}