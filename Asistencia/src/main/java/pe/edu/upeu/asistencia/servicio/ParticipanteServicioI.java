package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.List;

public interface ParticipanteServicioI {
    // métodos CRUD
    void save(Participante estudiante); //C

    List<Participante> findAll(); //R

    Participante update(Participante estudiante); //U

    void delete(String dni); //D

    Participante findById(String dni); // SEARCH

}
