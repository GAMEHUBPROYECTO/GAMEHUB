package Controllers;

import Lists.Instancias;
import Lists.List_Double_Admins;
import Lists.List_Double_Clients;
import Lists.Stacks_Games;
import Models.Admin;
import Models.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class LoginController implements Initializable {

    private final List_Double_Admins listAdmins = Instancias.getInstancias().getList_admins();
    private final List_Double_Clients listClients = Instancias.getInstancias().getList_clients();
    private final Stacks_Games stacksGames = Instancias.getInstancias().getStacks_games();
    
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
    @FXML
    private TextFlow txt_error;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listAdmins.loadDataFromFileTXT();
        listClients.loadDataFromFileTXT();
        stacksGames.loadDataFromFileTXTAll();
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

    public void run_GAMEHUB(String type) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/GAMEHUB.fxml"));
            Parent root = loader.load();

            GAMEHUBController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);

            stage.setOnShown((WindowEvent event) -> {
                controller.setVisible(type);        
                controller.load_user_data();
            });                        
            
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
        txt_error.getChildren().clear();
    }

    @FXML
    private void events_login(ActionEvent event) {

        if (event.getSource() == btn_signup) {
            run_signup("User");
        } else if (event.getSource() == btn_signup_admin) {
            run_signup("Admin");
        } else if (event.getSource() == btn_login) {
            login("Client");
        } else if (event.getSource() == btn_login_admin) {
            login("Admin");
        }
    }

    public void initTxtError(List<Text> list_texts) {
        txt_error.getChildren().clear();
        txt_error.getChildren().addAll(list_texts);
    }

    public Text createText(String context, String value) {
        Text text = new Text(context + "\n");
        if (value.equals("")) {
            text.setFill(new Color(226 / 255.0, 61 / 255.0, 48 / 255.0, 1.0));
        } else {
            text.setFill(new Color(54 / 255.0, 128 / 255.0, 49 / 255.0, 1.0));
        }
        text.setFont(Font.font("System", FontWeight.BOLD, 15));
        return text;
    }

    public void login(String type) {
        List<Text> list_texts = new ArrayList<>();

        if (type.equals("Admin")) {
            if (txtAdminName.getText().isEmpty() && txtPasswordAdmin.getText().isEmpty()) {
                list_texts.add(createText("No se puede verificar\nLos campos están vacios.", ""));
            } else if (txtAdminName.getText().isEmpty()) {
                list_texts.add(createText("No se puede verificar\nDebe ingresar un nombre de administrador.", ""));
            } else if (txtPasswordAdmin.getText().isEmpty()) {
                list_texts.add(createText("No se puede verificar\nDebe ingresar una contraseña.", ""));
            } else {

                Admin admin = listAdmins.findByName(txtAdminName.getText());

                if (admin == null) {
                    list_texts.add(createText("El ADMIN NAME no está registrado o es erroneo, verifique", ""));
                    txtAdminName.setText("");
                    txtPasswordAdmin.setText("");
                    txtAdminName.requestFocus();
                }

                if (admin != null && admin.getPassword().equals(txtPasswordAdmin.getText())) {

                    list_texts.add(createText("CREDENCIALES CORRECTAS, ENTRANDOOO...!", "TRUE"));
                    txtAdminName.setText("");
                    txtPasswordAdmin.setText("");

                    Scene scene = btn_login_admin.getScene();
                    scene.setCursor(Cursor.WAIT);

                    PauseTransition pause = new PauseTransition(Duration.seconds(5));
                    pause.setOnFinished(event -> {
                        scene.setCursor(Cursor.DEFAULT);
                        run_GAMEHUB(type);
                    });
                    pause.play();
                } else {
                    list_texts.add(createText("Contraseña incorrecta", ""));
                    txtPasswordAdmin.setText("");
                    txtPasswordAdmin.requestFocus();
                }

            }
        } else {
            if (txtUsername.getText().isEmpty() && txtPasswordUser.getText().isEmpty()) {
                list_texts.add(createText("No se puede verificar\nLos campos están vacios.", ""));
            } else if (txtUsername.getText().isEmpty()) {
                list_texts.add(createText("No se puede verificar\nDebe ingresar un nombre de cliente.", ""));
            } else if (txtPasswordUser.getText().isEmpty()) {
                list_texts.add(createText("No se puede verificar\nDebe ingresar una contraseña.", ""));
            } else {

                Client client = listClients.findByName(txtUsername.getText());

                if (client == null) {
                    list_texts.add(createText("El USEERNAME no está registrado o es erroneo, verifique", ""));
                    txtUsername.setText("");
                    txtPasswordUser.setText("");
                    txtUsername.requestFocus();
                }

                if (client != null && client.getPassword().equals(txtPasswordUser.getText())) {

                    list_texts.add(createText("CREDENCIALES CORRECTAS, ENTRANDOOO...!", "TRUE"));
                    txtUsername.setText("");
                    txtPasswordUser.setText("");

                    Scene scene = btn_login_admin.getScene();
                    scene.setCursor(Cursor.WAIT);

                    PauseTransition pause = new PauseTransition(Duration.seconds(5));
                    pause.setOnFinished(event -> {
                        scene.setCursor(Cursor.DEFAULT);
                        run_GAMEHUB(type);
                    });
                    pause.play();
                } else {
                    list_texts.add(createText("Contraseña incorrecta", ""));
                    txtPasswordUser.setText("");
                    txtPasswordUser.requestFocus();
                }

            }
        }
        initTxtError(list_texts);
    }
}
