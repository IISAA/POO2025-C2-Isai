package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Estudiante;
import pe.edu.upeu.asistencia.repositorio.EstudianteRepositorio;

import java.util.ArrayList;
import java.util.List;

@Service // para injección de dependencias
public class EstudianteServicioImp extends EstudianteRepositorio implements EstudianteServicioI{ // herencia e implementación

    //List<Estudiante> listaEstudiantes=new ArrayList<>();

    @Override
    public void saveEntidad(Estudiante estudiante) { // Create
        listaEstudiantes.add(estudiante);
    }

    @Override
    public List<Estudiante> findAllEntidades() { // Read, Report
        return listaEstudiantes;
    }

    @Override
    public void updateEntidad(Estudiante estudiante, int index) { // Update
        listaEstudiantes.set(index, estudiante);
    }

    @Override
    public void deleteEntidad(int index) { // Deleted
        listaEstudiantes.remove(index);
    }

    @Override
    public Estudiante findEntidad(int index) { // Search
        return listaEstudiantes.get(index);
    }
}
