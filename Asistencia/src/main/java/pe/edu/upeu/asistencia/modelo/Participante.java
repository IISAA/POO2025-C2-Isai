package pe.edu.upeu.asistencia.modelo;

import jakarta.persistence.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //para crear la tabla
@Table(name = "participante") //nombrar tabla
public class Participante {
    @Id
    private String dni;

    private String nombre;
    private String apellidos;
    private Boolean estado;
    @Enumerated(EnumType.STRING)
    private Carrera carrera;
    @Enumerated(EnumType.STRING)
    private TipoParticipante tipoParticipante;
}
