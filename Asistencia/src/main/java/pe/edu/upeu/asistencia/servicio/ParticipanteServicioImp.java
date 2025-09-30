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
        super.save(estudiante);
    }

    @Override
    public List<Participante> findAll() { // Read, Report
        return super.findAll();
    }

    @Override
    public Participante update(Participante estudiante) { // Update
        return super.update(estudiante);
    }

    @Override
    public void delete(String dni) { // Deleted
        super.delete(dni);
    }

    @Override
    public Participante findById(int index) { // Search
        return listaParticipantes.get(index);
    }
}
