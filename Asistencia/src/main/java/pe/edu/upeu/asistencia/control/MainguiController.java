package pe.edu.upeu.asistencia.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

@Controller
public class MainguiController {

    @FXML
    private BorderPane bp;
    @FXML
    MenuBar menuBar;
    @FXML
    TabPane tabPane;
    @FXML
    MenuItem menuItem1, menuItemC;
    @Autowired
    ApplicationContext context;

    @FXML
    public void initialize() {
        MenuItemListener mIL = new MenuItemListener(); //instancia de la clase interna MIL
        menuItem1.setOnAction(mIL::handle); // asiganción como manejadora del evento OnAction
        menuItemC.setOnAction(mIL::handle); // en los menús[mI1 y mIC]
    }

    class MenuItemListener { // clase interna para manejar eventos
        Map<String, String[]> menuConfig = Map.of( //POBLAR
                "menuItem1", new String[]{"/fxml/main_participante.fxml", "Reg.Participante", "T"}, "menuItemC", new String[]{"/fxml/login.fxml", "Salir", "C"});

        public void handle(ActionEvent e) { // de javafx
            String id = ((MenuItem) e.getSource()).getId();
            if (menuConfig.containsKey(id)) {
                String[] items = menuConfig.get(id);
                if (items[2].equals("C")) { // si es C close
                    Platform.exit();
                    System.exit(0);
                } else { // caso contrario si es other letter TabPane
                    abrirTabPaneFXML(items[0], items[1]);
                }
            }
        }

        private void abrirTabPaneFXML(String fxmlPath, String tittle) { //método con parámetros
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
                fxmlLoader.setControllerFactory(context::getBean);
                Parent root = fxmlLoader.load();
                ScrollPane scrollPane = new ScrollPane(root);
                scrollPane.setFitToWidth(true);
                scrollPane.setFitToHeight(true);

                Tab newtab = new Tab(tittle, scrollPane);
                tabPane.getTabs().clear();
                tabPane.getTabs().add(newtab);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class MenuListener {
        public void handle(Event e) { // de javafx

        }
    }
}
