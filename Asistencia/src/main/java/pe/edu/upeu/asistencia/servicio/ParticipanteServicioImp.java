package pe.edu.upeu.asistencia.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.repositorio.ParticipanteIRepositorio;

import java.util.List;

@Service // para injección de dependencias
public class ParticipanteServicioImp implements ParticipanteServicioI { // herencia e implementación

    //List<Estudiante> listaEstudiantes=new ArrayList<>();
    @Autowired
    ParticipanteIRepositorio participanteIRepositorio;

    @Override
    public void save(Participante estudiante) { // Create
        participanteIRepositorio.save(estudiante);
    }

    @Override
    public List<Participante> findAll() { // Read, Report
        return participanteIRepositorio.findAll();
    }

    @Override
    public Participante update(Participante estudiante) { // Update
        return participanteIRepositorio.save(estudiante);
    }

    @Override
    public void delete(String dni) { // Deleted
        participanteIRepositorio.deleteById(dni);
    }

    @Override
    public Participante findById(String dni) { // Search
        return participanteIRepositorio.getById(dni);
    }
}
