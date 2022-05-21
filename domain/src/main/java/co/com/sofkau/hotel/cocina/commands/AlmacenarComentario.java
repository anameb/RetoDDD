package co.com.sofkau.hotel.cocina.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.cocina.valuesCocina.CalificacionId;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.cocina.valuesCocina.Comentario;

public class AlmacenarComentario  extends Command {

    private final CalificacionId calificacionId;

    private final Comentario comentario;

    private final CocinaId cocinaId;

    public AlmacenarComentario(CalificacionId calificacionId, Comentario comentario, CocinaId cocinaId) {
        this.calificacionId = calificacionId;
        this.comentario = comentario;
        this.cocinaId = cocinaId;
    }

    public CalificacionId getCalificacionId() {
        return calificacionId;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public CocinaId getCocinaId() {
        return cocinaId;
    }
}
