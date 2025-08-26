package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.Estudiante;

import java.util.List;

public interface EstudianteServicioI {
    // métodos CRUD
    void saveEntidad(Estudiante estudiante); //C
    List<Estudiante> findAllEntidades(); //R
    void updateEntidad(Estudiante estudiante, int index); //U
    void deleteEntidad(int index); //D
    Estudiante findEntidad(int index); // SEARCH

}
