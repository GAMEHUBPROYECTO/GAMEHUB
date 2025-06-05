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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController implements Initializable {

    @FXML
    private Pane login_users;
    @FXML
    private Pane login_admins;
    @FXML
    private Button btn_admins;
    @FXML
    private Button btn_users;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_signup;
    @FXML
    private Button btn_login_admin;
    @FXML
    private Button btn_signup_admin;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtAdminName;
    @FXML
    private PasswordField txtPasswordAdmin;
    @FXML
    private PasswordField txtPasswordUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void run_signup(String type) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SignUP.fxml"));
            Parent root = loader.load();

            SignUPController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);

            stage.setOnShown(event -> controller.setVisible(type));

            stage.setOnCloseRequest((WindowEvent value) -> {
                controller.run_login(type);
            });

            stage.show();

            Stage miStage = (Stage) this.btn_login.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setVisible(String type) {
        if (type.equals("Admin")) {
            login_admins.setVisible(true);
            login_users.setVisible(false);
        } else {
            login_users.setVisible(true);
            login_admins.setVisible(false);            
        }
    }

    @FXML
    private void event(ActionEvent event) {

        login_admins.setVisible(!login_admins.isVisible());
        login_users.setVisible(!login_users.isVisible());
    }

    @FXML
    private void events_login(ActionEvent event) {

        if (event.getSource() == btn_signup) {
            run_signup("User");
        } else if (event.getSource() == btn_signup_admin) {
            run_signup("Admin");
        }
    }

}
