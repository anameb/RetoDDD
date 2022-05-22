package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.commands.AgregarMenu;
import co.com.sofkau.hotel.cocina.commands.AlmacenarComentario;
import co.com.sofkau.hotel.cocina.events.CocinaCreada;
import co.com.sofkau.hotel.cocina.events.ComentarioAlmacenado;
import co.com.sofkau.hotel.cocina.valuesCocina.CalificacionId;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.cocina.valuesCocina.Comentario;
import co.com.sofkau.hotel.cocina.valuesCocina.Tipo;
import co.com.sofkau.hotel.reserva.commands.AgragarHabitacion;
import co.com.sofkau.hotel.reserva.events.HabitacionAgregada;
import co.com.sofkau.hotel.reserva.valuesReserva.HabitacionId;
import co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Total;
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
class AlmacenarComentarioUseCaseTest {

    @InjectMocks
    private AlmacenarComentarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void almacenarComentarioHappyPass(){
        //arrange
        var calificacionId = CalificacionId.of("rrr");
        var comentario = new Comentario("Aprendiendo");
        var cocinaId = CocinaId.of("aaa");
        var command = new AlmacenarComentario(calificacionId,comentario,cocinaId);

        when(repository.getEventsBy("aaa")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCalificacionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ComentarioAlmacenado)events.get(0);
        Assertions.assertEquals("Aprendiendo", event.getComentario().value());
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