package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.List;

public interface ParticipanteServicioI {
    // métodos CRUD
    void save(Participante estudiante); //C
    List<Participante> findAll(); //R
    void update(Participante estudiante, int index); //U
    void delete(int index); //D
    Participante findById(int index); // SEARCH

}
