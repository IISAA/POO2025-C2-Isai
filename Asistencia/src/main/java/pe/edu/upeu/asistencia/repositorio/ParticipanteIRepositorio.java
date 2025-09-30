package pe.edu.upeu.asistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.asistencia.modelo.Participante;

//@Repository //para hacer inyeccion de dependencias
public interface ParticipanteIRepositorio extends JpaRepository<Participante, String> { //String por el dato de dni

}
