package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GAMEHUBController implements Initializable {
    
    @FXML
    private Button btn_favs;
    @FXML
    private Button btn_history;
    @FXML
    private Button btn_myShopping;
    @FXML
    private Button btn_profile;
    @FXML
    private Button btn_shop;
    @FXML
    private Button btn_library;
    @FXML
    private ImageView imaLogo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void run_login(String type) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Login.fxml"));
            Parent root = loader.load();

            LoginController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);

            stage.setOnShown(event -> controller.setVisible(type));

            stage.show();

            Stage miStage = (Stage) this.btn_favs.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setVisible(String type) {
        if (!type.equals("Admin")) {
            btn_history.setVisible(false);
        }
    }

    @FXML
    private void ActionEvent(ActionEvent event) {
    }
}
