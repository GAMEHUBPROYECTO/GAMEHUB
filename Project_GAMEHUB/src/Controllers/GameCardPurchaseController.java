package Controllers;

import Lists.Instancias;
import Lists.Stacks_Games;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class GameCardPurchaseController implements Initializable {

    private final Stacks_Games stacks_games = Instancias.getInstancias().getStacks_games();
    private FlowPane flowpane_go_shop;
    private GAMEHUBController main_controller;

    @FXML
    private ImageView ima_game;
    @FXML
    private Label txt_name;
    @FXML
    private Label txt_price;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public Label getTxt_name() {
        return txt_name;
    }

    public Label getTxt_price() {
        return txt_price;
    }

    public ImageView getIma_game() {
        return ima_game;
    }

    public void setFlowpane_go_shop(FlowPane flowpane_go_shop) {
        this.flowpane_go_shop = flowpane_go_shop;
    }

    public void setMain_controller(GAMEHUBController main_controller) {
        this.main_controller = main_controller;
    }
}
