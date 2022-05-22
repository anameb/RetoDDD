package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.commands.ModificarServicioExterno;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.events.ServicioExternoModificado;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.administracion.valuesAdmi.ExternoId;
import co.com.sofkau.hotel.administracion.valuesAdmi.Servicio;

import co.com.sofkau.hotel.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarServicioExternoUseCaseTest {

    @InjectMocks
    private ModificarServicioExternoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarServicioExternoHappyPass(){
        //arrange
        var externoId = ExternoId.of("aaa");
        var servicio = new Servicio("ssss");
        var administracionId = AdministracionId.of("aaa");
        var command = new ModificarServicioExterno(externoId,servicio,administracionId);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getExternoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ServicioExternoModificado)events.get(0);
        Assertions.assertEquals("ssss", event.getServicio().value());
    }
    private List<DomainEvent> history() {
        var telefono = new Telefono(12345);
        var administracionId = new AdministracionId("hhhh");
        var event = new AdministracionCreada(
                administracionId,
                telefono);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }




}