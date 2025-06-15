package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GameCardLibraryController implements Initializable {

    @FXML
    private ImageView ima_game;
    @FXML
    private Label txt_name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public ImageView getIma_game() {
        return ima_game;
    }

    public Label getTxt_name() {
        return txt_name;
    }
        
}
