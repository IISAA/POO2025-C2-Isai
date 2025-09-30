package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.conexion.ConDB;

import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ParticipanteRepositorio {
    public List<Participante> listaParticipantes = null;

    Connection con = ConDB.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

    public List<Participante> findAll() {
        listaParticipantes = new ArrayList<>();
        try {
            pst = con.prepareStatement("SELECT * FROM participantes");
            rs = pst.executeQuery();
            while (rs.next()) {
                Participante p = new Participante();
                p.setDni(new SimpleStringProperty(rs.getString(1)));
                p.setNombre(new SimpleStringProperty(rs.getString(2)));
                p.setApellidos(new SimpleStringProperty(rs.getString(3)));
                p.setEstado(new SimpleBooleanProperty(rs.getBoolean(4)));
                p.setCarrera(Carrera.valueOf(rs.getString(5)));
                p.setTipoParticipante(TipoParticipante.valueOf(rs.getString(6)));

                listaParticipantes.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaParticipantes;
    }

    public void save(Participante p) {
        sql = "INSERT INTO participantes \n" +
                "(dni, nombre, apellidos, estado, carrera, tipo_Participante) \n" +
                "VALUES(?,?,?,?,?,?)";
        int i = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(++i, p.getDni().getValue());
            pst.setString(++i, p.getNombre().getValue());
            pst.setString(++i, p.getApellidos().getValue());
            pst.setBoolean(++i, p.getEstado().getValue());
            pst.setString(++i, p.getCarrera().name());
            pst.setString(++i, p.getTipoParticipante().name());
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Participante update(Participante p) {
        sql = "UPDATE participantes \n" +
                "SET nombre=?, apellidos=?, estado=?, carrera=?, tipo_Participante=? \n" +
                "WHERE dni=?";

        int i = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(++i, p.getNombre().getValue());
            pst.setString(++i, p.getApellidos().getValue());
            pst.setBoolean(++i, p.getEstado().getValue());
            pst.setString(++i, p.getCarrera().name());
            pst.setString(++i, p.getTipoParticipante().name());
            pst.setString(++i, p.getDni().getValue()); // para el where
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public void delete(String dni) {
        sql = "DELETE FROM participantes WHERE dni=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, dni);
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
