package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Carrera {
    SISTEMAS(Facultad.FIA, "Sistemas"),
    CIVIL(Facultad.FIA, "Civil"),
    ARQUITECTURA(Facultad.FIA, "Arquitectura"),
    GENERAL(Facultad.GENERAL, "General"),

    ADMINISTRACION(Facultad.FCE, "Administración"),
    CONTABILIDAD(Facultad.FCS, "Contabilidad"),

    ENFERMERIA(Facultad.FCS, "Enfermería"),
    PSICOLOGIA(Facultad.FCS, "Psicología"),

    LINGUISTICA(Facultad.FACIHED, "Linguística");

    private Facultad facultad;
    private String descripcion;

}
