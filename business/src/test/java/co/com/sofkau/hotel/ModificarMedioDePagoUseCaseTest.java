package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.commands.CambiarTelefonoEmpleado;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.events.TelefonoEmpleadoCambiado;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.administracion.valuesAdmi.EmpleadoId;
import co.com.sofkau.hotel.reserva.commands.ModificarMedioDePago;
import co.com.sofkau.hotel.reserva.events.MedioDePagoModificado;
import co.com.sofkau.hotel.reserva.events.ReservaCreada;
import co.com.sofkau.hotel.reserva.valuesReserva.*;
import co.com.sofkau.hotel.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarMedioDePagoUseCaseTest {

    @InjectMocks
    private ModificarMedioDePagoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarMedioDePagoHappyPass(){
        //arrange
        var pagoId = PagoId.of("ddddd");
        var medioDepago = new MedioDePago("Tarjeta");
        var reservaId = ReservaId.of("aaa");
        var command = new ModificarMedioDePago(pagoId,medioDepago,reservaId);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPagoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MedioDePagoModificado)events.get(0);
        Assertions.assertEquals("Tarjeta", event.getMedioDePago().value());
    }

    private List<DomainEvent> history() {
        var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var fechaIngreso = new FechaIngreso(LocalDateTime.now(), LocalDate.now());
        var event = new ReservaCreada(
                fechaIngreso,
                fecha);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}