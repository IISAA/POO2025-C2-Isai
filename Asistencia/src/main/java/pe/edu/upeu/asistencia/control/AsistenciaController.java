package pe.edu.upeu.asistencia.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class AsistenciaController {
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
}
