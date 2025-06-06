package Controllers;

import Lists.Instancias;
import Lists.List_Double_Admins;
import Lists.List_Double_Clients;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUPController implements Initializable {

    private List_Double_Admins listAdmins = Instancias.getInstancias().getListAdmins();
    private List_Double_Clients listClients = Instancias.getInstancias().getListClients();

    @FXML
    private Pane signup_users;
    @FXML
    private Pane signup_admins;
    @FXML
    private Button btn_signup_user;
    @FXML
    private Button btn_signup_admin;
    @FXML
    private TextField txtClientName;
    @FXML
    private TextField txtAdminName;
    @FXML
    private PasswordField txtPassword_Client;
    @FXML
    private PasswordField txtPasswordC_Client;
    @FXML
    private PasswordField txtPassword_Admin;
    @FXML
    private PasswordField txPasswordC_Admin;

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
        if (event.getSource() == btn_signup_admin) {
            addAdmin(txtAdminName, txtPassword_Admin);
        }
        
        if (event.getSource() == btn_signup_user) {
            addClient(txtClientName, txtPassword_Client);
        }
    }

    public void addAdmin(TextField txtAdminName, PasswordField txtPassword_Admin) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Informacion");
        a.setTitle("Mensaje");

        if (!txtAdminName.getText().isEmpty()) {
            if (!txtPassword_Admin.getText().isEmpty()) {

                if (txtPassword_Admin.getText().equals(txPasswordC_Admin.getText())) {

                    listAdmins.addAmin(txtAdminName, txtPassword_Admin);
                    listAdmins.saveDataToFileTXT();
                    run_login("Admin");
                } else {
                    a.setContentText("La contraseña debe coincidir.");
                    a.showAndWait();
                    txPasswordC_Admin.setText("");
                    txPasswordC_Admin.requestFocus();
                }
            } else {
                a.setContentText("Antes de registrar ingrese una contraseña.");
                a.showAndWait();
            }
        } else {
            a.setContentText("Antes de registrar ingrese un nombre.");
            a.showAndWait();
        }
    }
    
    public void addClient(TextField txtClientName, PasswordField txtPassword_Client) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Informacion");
        a.setTitle("Mensaje");

        if (!txtClientName.getText().isEmpty()) {
            if (!txtPassword_Client.getText().isEmpty()) {

                if (txtPassword_Client.getText().equals(txtPasswordC_Client.getText())) {

                    listClients.addClients(txtClientName, txtPassword_Client);
                    listClients.saveDataToFileTXT();
                    run_login("Client");
                } else {
                    a.setContentText("La contraseña debe coincidir.");
                    a.showAndWait();
                    txtPasswordC_Client.setText("");
                    txtPasswordC_Client.requestFocus();
                }
            } else {
                a.setContentText("Antes de registrar ingrese una contraseña.");
                a.showAndWait();
            }
        } else {
            a.setContentText("Antes de registrar ingrese un nombre.");
            a.showAndWait();
        }
    }
}
