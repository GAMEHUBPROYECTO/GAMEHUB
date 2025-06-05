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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUPController implements Initializable {

    @FXML
    private Pane signup_users;
    @FXML
    private Pane signup_admins;
    @FXML
    private Button btn_signup_user;
    @FXML
    private Button btn_signup_admin;

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

            Stage miStage = (Stage) this.btn_signup_admin.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(SignUPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setVisible(String type) {
        if (type.equals("Admin")) {
            signup_admins.setVisible(true);
            signup_users.setVisible(false);
        } else {
            signup_users.setVisible(true);
            signup_admins.setVisible(false);
        }
    }

    @FXML
    private void events_signup(ActionEvent event) {

    }

}
