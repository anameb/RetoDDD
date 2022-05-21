package co.com.sofkau.hotel.cocina.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.valuesCocina.CalificacionId;
import co.com.sofkau.hotel.cocina.valuesCocina.Comentario;

public class ComentarioAlmacenado extends DomainEvent {

    private final CalificacionId calificacionId;

    private final Comentario comentario;

    public ComentarioAlmacenado(CalificacionId calificacionId, Comentario comentario) {
        super("co.com.sofkau.hotel.cocina.events.ComentarioAlmacenado");
        this.calificacionId = calificacionId;
        this.comentario = comentario;
    }

    public CalificacionId getCalificacionId() {
        return calificacionId;
    }

    public Comentario getComentario() {
        return comentario;
    }
}
