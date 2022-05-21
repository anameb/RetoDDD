package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.hotel.cocina.Calificacion;
import co.com.sofkau.hotel.cocina.Menu;
import co.com.sofkau.hotel.cocina.Pedido;
import co.com.sofkau.hotel.cocina.commands.CrearCocina;
import co.com.sofkau.hotel.cocina.events.CocinaCreada;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.cocina.valuesCocina.Tipo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCocinaUseCaseTest {

    private CrearCocinaUseCase useCase;

    @BeforeEach

    public void setup(){ useCase = new CrearCocinaUseCase();}

    @Test
    public void crearCocinaHappyPass(){
        //arrange
        var cocinaId = CocinaId.of("xxxxx");
        var tipo = new Tipo("DDD");
        var command = new CrearCocina(cocinaId,tipo);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var cocinaCreada = (CocinaCreada)events.get(0);
        Assertions.assertEquals("xxxxx", cocinaCreada.aggregateRootId());
        Assertions.assertEquals("DDD", cocinaCreada.getTipo().value());

    }

}