package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.commands.AgragarProductoProveedor;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.events.ProductoProveedorAgregado;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.administracion.valuesAdmi.Producto;
import co.com.sofkau.hotel.administracion.valuesAdmi.ProveedorId;
import co.com.sofkau.hotel.cocina.commands.AgregarMenu;
import co.com.sofkau.hotel.cocina.events.CocinaCreada;
import co.com.sofkau.hotel.cocina.events.MenuAgregado;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.cocina.valuesCocina.Tipo;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Nombre;
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
class AgregarMenuUseCaseTest {

    @InjectMocks
    private AgregarMenuUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarMenuHappyPass(){
        //arrange
        var nombre = new Nombre("rrr");
        var descripcion = new Descripcion("Aprendiendo");
        var cocinaId = CocinaId.of("aaa");
        var command = new AgregarMenu(cocinaId,nombre,descripcion);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCocinaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MenuAgregado)events.get(0);
        Assertions.assertEquals("Aprendiendo", event.getDescripcion().value());
    }
        private List<DomainEvent> history() {
            var tipo = new Tipo("aaa");
            var cocinaId = new CocinaId("aaa");
            var event = new CocinaCreada(
                    cocinaId,
                    tipo);
            event.setAggregateRootId("xxxxx");
            return List.of(event);
    }

}