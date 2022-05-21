package domain.src.main.java.co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.Entity;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.CalificacionId;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.Comentario;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.Puntaje;

public class Calificacion extends Entity<CalificacionId> {

    protected Puntaje puntaje;

    protected Comentario comentario;

    public Calificacion(CalificacionId calificacionId, Puntaje puntaje, Comentario comentario) {
        super(calificacionId);
        this.puntaje = puntaje;
        this.comentario = comentario;
    }

    public void almacenarComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}
