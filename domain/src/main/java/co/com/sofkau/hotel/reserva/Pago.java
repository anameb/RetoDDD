package domain.src.main.java.co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.Entity;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.MedioDePago;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.PagoId;
import domain.src.main.java.co.com.sofkau.hotel.values.Total;

public class Pago extends Entity<PagoId> {
    protected MedioDePago medioDePago;
    protected Total total;

    public Pago(PagoId pagoId, MedioDePago medioDePago, Total total) {
        super(pagoId);
        this.medioDePago = medioDePago;
        this.total = total;
    }



    public void modificarMedioDePago(MedioDePago medioDePago){
        this.medioDePago = medioDePago;
    }
}
