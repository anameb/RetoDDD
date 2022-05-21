package co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.hotel.reserva.events.HabitacionAgregada;
import co.com.sofkau.hotel.reserva.events.MedioDePagoModificado;
import co.com.sofkau.hotel.reserva.events.ReservaCreada;
import co.com.sofkau.hotel.reserva.events.TelefonoHuespedCambiado;
import co.com.sofkau.hotel.reserva.valuesReserva.*;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Telefono;
import co.com.sofkau.hotel.values.Total;

public class Reserva extends AggregateEvent<ReservaId> {

    protected FechaIngreso fechaIngreso;

    protected Fecha fecha;

    protected Pago pago;

    protected Huesped huesped;

    protected Habitacion habitacion;

    public Reserva(ReservaId reservaId, FechaIngreso fechaIngreso, Fecha fecha) {
        super(reservaId);
        appendChange(new ReservaCreada(fechaIngreso,fecha)).apply();
        subscribe(new ReservaEventChange(this));
    }

    private Reserva(ReservaId reservaId) {
        super(reservaId);
        subscribe(new ReservaEventChange(this));
    }

    public void CambiarTelefonoHuesped(HuespedId huespedId, Telefono telefono){
        appendChange(new TelefonoHuespedCambiado(huespedId, telefono)).apply();
    }

    public void AgragarHabitacion (Descripcion descripcion, Total total){
        var habitacionId = new HabitacionId();
        appendChange(new HabitacionAgregada(habitacionId, descripcion, total)).apply();
    }

    public  void ModificarMedioDePago(PagoId pagoId, MedioDePago medioDePago){
        appendChange(new MedioDePagoModificado(pagoId,medioDePago)).apply();
    }
    public FechaIngreso fechaIngreso (){
        return fechaIngreso;
    }
    public Fecha fecha (){
        return fecha;
    }
    public Pago pago (){
        return pago;
    }
    public Huesped huesped (){
        return huesped;
    }

    public Habitacion habitacion (){
        return habitacion;
    }

}

