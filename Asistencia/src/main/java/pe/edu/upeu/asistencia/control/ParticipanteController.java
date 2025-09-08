package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.servicio.ParticipanteServicioI;

@Controller
public class ParticipanteController {
    @FXML
    private TextField txtNombres, txtDni, txtApellidos;
    @FXML
    private ComboBox<Carrera> cbxCarrera;
    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML
    private TableView<Participante> tableView;
    ObservableList<Participante> listaParticipantes;

    @FXML
    private TableColumn<Participante, String> dniColumn, nombresColumn, apellidosColumn, carreraColumn, tipoPartColumn;

    @Autowired
    ParticipanteServicioI ps;

    @FXML
    public void initialize() { //mostrar en el cbx
        cbxCarrera.getItems().setAll(Carrera.values());
        cbxTipoParticipante.getItems().setAll(TipoParticipante.values());
        definirColumnas();
        listarParticipantes();
    }


    public void limpiarFormulario(){
        txtNombres.setText("");
        txtDni.setText("");
        txtApellidos.setText("");
        cbxCarrera.setValue(null);
        cbxTipoParticipante.setValue(null);
    }

    @FXML
    public void registrarParticipante(){
        Participante p = new Participante();
        p.setDni(new SimpleStringProperty(txtDni.getText()));
        p.setNombre(new SimpleStringProperty(txtNombres.getText()));
        p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        ps.save(p);
        listarParticipantes();

        limpiarFormulario();
    }

    public void definirColumnas() { //método para establecer columnas
        dniColumn = new TableColumn("DNI");
        nombresColumn = new TableColumn("Nombre");
        apellidosColumn = new TableColumn("Apellidos");
        carreraColumn = new TableColumn("Carrera");
        tipoPartColumn = new TableColumn("Tipo Participante");
        tableView.getColumns().addAll(dniColumn, nombresColumn, apellidosColumn, carreraColumn, tipoPartColumn);
    }

    public void listarParticipantes(){
        dniColumn.setCellValueFactory(cellData -> cellData.getValue().getDni());
        nombresColumn.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        apellidosColumn.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
        carreraColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        tipoPartColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoParticipante().toString()));

        listaParticipantes = FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaParticipantes);
    }
}
