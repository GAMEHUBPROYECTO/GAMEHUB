package Controllers;

import Lists.Instancias;
import Lists.Stacks_Games;
import Models.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class GameCardController implements Initializable {

    private final Stacks_Games stacks_games = Instancias.getInstancias().getStacks_games();
    private FlowPane flowpane_games_car;
    private GAMEHUBController main_controller;

    @FXML
    private Pane card_game_car;
    @FXML
    private Label label_name_game_car;
    @FXML
    private Label label_price_game_car;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setFlowpane_games_car(FlowPane flowpane_games_car) {
        this.flowpane_games_car = flowpane_games_car;
    }

    public void setMain_controller(GAMEHUBController main_controller) {
        this.main_controller = main_controller;
    }

    @FXML
    private void add_favorites(ActionEvent event) {
        
    }

    @FXML
    private void remove_game_card(ActionEvent event) {
        Button button = (Button) event.getSource();
        Pane pane = (Pane) button.getParent();
        Game game = (Game) pane.getUserData();
        stacks_games.getGames_car_shop().remove(game);
        stacks_games.saveDataToFileTXTCar_Shop();
        flowpane_games_car.getChildren().remove(pane);
        main_controller.load_car_shop();
    }
}
