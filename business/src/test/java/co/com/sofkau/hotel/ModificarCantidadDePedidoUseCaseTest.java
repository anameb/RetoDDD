package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.commands.ModificarCantidadDePedido;
import co.com.sofkau.hotel.cocina.events.CantidadPedidoModificada;
import co.com.sofkau.hotel.cocina.events.CocinaCreada;
import co.com.sofkau.hotel.cocina.valuesCocina.Cantidad;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.cocina.valuesCocina.PedidoId;
import co.com.sofkau.hotel.cocina.valuesCocina.Tipo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarCantidadDePedidoUseCaseTest {

    @InjectMocks
    private ModificarCantidadDePedidoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarCantidadDePedidoHappyPass(){
        //arrange
        var pedidoId = PedidoId.of("ddddd");
        var cantidad = new Cantidad(3);
        var cocinaId = CocinaId.of("aaa");
        var command = new ModificarCantidadDePedido(pedidoId,cantidad,cocinaId);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPedidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CantidadPedidoModificada)events.get(0);
        Assertions.assertEquals(3, event.getCantidad().value());
    }

    private List<DomainEvent> history() {
        var cocinaId = CocinaId.of("cccc");
        var tipo = new Tipo("tttt");
        var event = new CocinaCreada(
                cocinaId,
                tipo);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }




}