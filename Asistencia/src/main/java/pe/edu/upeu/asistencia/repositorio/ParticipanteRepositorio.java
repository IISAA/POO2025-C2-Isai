package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.ArrayList;
import java.util.List;

public abstract class ParticipanteRepositorio {
    public List<Participante> listaParticipantes = new ArrayList<>();

    public List<Participante> findAll() {
        listaParticipantes.add(
                new Participante(new SimpleStringProperty("46583726"),
                        new SimpleStringProperty("Pedro"),
                        new SimpleStringProperty("Suarez Vértiz"),
                        new SimpleBooleanProperty(true), Carrera.SISTEMAS,
                        TipoParticipante.ASISTENTE
                )
        );
        listaParticipantes.add(
                new Participante(new SimpleStringProperty("75649372"),
                        new SimpleStringProperty("Santiago"),
                        new SimpleStringProperty("Ramirez Otazu"),
                        new SimpleBooleanProperty(true), Carrera.SISTEMAS,
                        TipoParticipante.PONENTE
                )
        );
        return listaParticipantes;
    }
}
