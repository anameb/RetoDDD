package co.com.sofkau.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.hotel.administracion.commands.CrearAdministracion;
import co.com.sofkau.hotel.administracion.events.AdministracionCreada;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CrearAdminitracionUseCaseTest {

    private CrearAdminitracionUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearAdminitracionUseCase();
    }

    @Test
    void crearAdministracionHappyPass(){
        //arrange
        var administracionId = AdministracionId.of("xxxx");
        var telefono = new Telefono(12345);
        var command = new CrearAdministracion(administracionId, telefono);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var administracionCreada = (AdministracionCreada)events.get(0);
        Assertions.assertEquals("xxxx", administracionCreada.aggregateRootId());
        Assertions.assertEquals(12345, administracionCreada.getTelefono().value());



    }
}