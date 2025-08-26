package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.modelo.Estudiante;
import pe.edu.upeu.asistencia.servicio.EstudianteServicioI;

@Controller
public class AsistenciaController {
    //EstudianteServicioI es = new EstudianteServicioImp();

    @Autowired
    EstudianteServicioI estudianteServicioI;

    @FXML
    private Label idMsg;
    @FXML
    private Label idMsg1;
    @FXML
    TextField txtDato;
    @FXML
    TextField txtDato1;

    //@FXML Button btnEnviar;

    @FXML
    void enviar(){
        System.out.println("Enviando asistencia");
        idMsg.setText(txtDato.getText());
        idMsg1.setText(txtDato1.getText());
    }

    @FXML
    public void regEstudiante(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(new SimpleStringProperty(txtDato.getText()));
        estudiante.setEstado(new SimpleBooleanProperty(true));

        estudianteServicioI.saveEntidad(estudiante);

        listarEstudiantes();
    }

    @FXML
    void listarEstudiantes(){
        for(Estudiante e: estudianteServicioI.findAllEntidades()){
            System.out.println(e.getNombre());
        }
    }
}
