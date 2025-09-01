package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.repositorio.ParticipanteRepositorio;

import java.util.List;

@Service // para injección de dependencias
public class ParticipanteServicioImp extends ParticipanteRepositorio implements ParticipanteServicioI { // herencia e implementación

    //List<Estudiante> listaEstudiantes=new ArrayList<>();

    @Override
    public void save(Participante estudiante) { // Create
        listaParticipantes.add(estudiante);
    }

    @Override
    public List<Participante> findAll() { // Read, Report
        return listaParticipantes;
    }

    @Override
    public void update(Participante estudiante, int index) { // Update
        listaParticipantes.set(index, estudiante);
    }

    @Override
    public void delete(int index) { // Deleted
        listaParticipantes.remove(index);
    }

    @Override
    public Participante findById(int index) { // Search
        return listaParticipantes.get(index);
    }
}
