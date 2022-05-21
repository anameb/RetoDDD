package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.Administracion;
import co.com.sofkau.hotel.administracion.commands.CambiarTelefonoEmpleado;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.events.TelefonoEmpleadoCambiado;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.administracion.valuesAdmi.EmpleadoId;
import co.com.sofkau.hotel.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarTelefonoEmpleadoUseCaseTest {

    @InjectMocks
    private CambiarTelefonoEmpleadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarTelefonoEmpleadoHappyPass(){
        //arrange
        var empleadoId = EmpleadoId.of("ddddd");
        var telefono = new Telefono(56789);
        var adminitracionId = AdministracionId.of("aaa");
        var command = new CambiarTelefonoEmpleado(empleadoId,telefono,adminitracionId);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TelefonoEmpleadoCambiado)events.get(0);
        Assertions.assertEquals(56789, event.getTelefono().value());
    }

    private List<DomainEvent> history() {
        var empleadoId = new EmpleadoId("gggg");
        var telefono = new Telefono(12345);
        var administracionId = new AdministracionId("hhhh");
        var event = new AdministracionCreada(
                administracionId,
                telefono);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}