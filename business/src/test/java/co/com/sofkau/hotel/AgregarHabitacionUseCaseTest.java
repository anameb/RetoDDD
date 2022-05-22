package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.events.ProductoProveedorAgregado;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.reserva.commands.AgragarHabitacion;
import co.com.sofkau.hotel.reserva.events.HabitacionAgregada;
import co.com.sofkau.hotel.reserva.events.ReservaCreada;
import co.com.sofkau.hotel.reserva.valuesReserva.Fecha;
import co.com.sofkau.hotel.reserva.valuesReserva.FechaIngreso;
import co.com.sofkau.hotel.reserva.valuesReserva.HabitacionId;
import co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Telefono;
import co.com.sofkau.hotel.values.Total;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarHabitacionUseCaseTest {
    @InjectMocks
    private AgregarHabitacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarHabitacionHappyPass(){
        //arrange
        var reservaId = ReservaId.of("rrr");
        var descripcion = new Descripcion("Aprendiendo");
        var total  = new Total(5);
        var habitacionId = HabitacionId.of("aaa");
        var command = new AgragarHabitacion(reservaId,descripcion, total, habitacionId);

        when(repository.getEventsBy("rrr")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReservaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (HabitacionAgregada)events.get(0);
        Assertions.assertEquals("Aprendiendo", event.getDescripcion().value());
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