package co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.hotel.reserva.valuesReserva.MedioDePago;
import co.com.sofkau.hotel.reserva.valuesReserva.PagoId;
import co.com.sofkau.hotel.values.Total;

public class Pago extends Entity<PagoId> {
    protected MedioDePago medioDePago;
    protected Total total;

    public Pago(PagoId pagoId, MedioDePago medioDePago, Total total) {
        super(pagoId);
        this.medioDePago = medioDePago;
        this.total = total;
    }

    public Pago(PagoId entityId) {
        super(entityId);
    }

    public void modificarMedioDePago(MedioDePago medioDePago){
        this.medioDePago = medioDePago;
    }
}
