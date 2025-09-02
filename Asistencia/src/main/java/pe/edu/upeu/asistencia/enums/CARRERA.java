package pe.edu.upeu.asistencia.enums;

public enum CARRERA {
    Sistemas(FACULTAD.FIA),
    Civil(FACULTAD.FIA),
    Arquitectura(FACULTAD.FIA),
    General(FACULTAD.GENERAL),

    Administracion(FACULTAD.FCE),
    Contabilidad(FACULTAD.FCS),

    Enfermeria(FACULTAD.FCS),
    Psicologia(FACULTAD.FCS),

    Linguistica(FACULTAD.FACIHED);


    private FACULTAD facultad;

    CARRERA(FACULTAD facultad){
        this.facultad = facultad;
    }
    public FACULTAD getFacultad() {return facultad;}
}
