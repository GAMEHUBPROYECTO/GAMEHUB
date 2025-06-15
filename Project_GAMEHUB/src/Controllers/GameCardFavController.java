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

public class GameCardFavController implements Initializable {

    private final Stacks_Games stacks_games = Instancias.getInstancias().getStacks_games();
    private FlowPane flowpane_games_favorites;
    private GAMEHUBController main_controller;
    
    @FXML
    private Pane card_game_car;
    @FXML
    private Label label_name_game_car;
    @FXML
    private Label label_price_game_car;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
    }    

    public void setFlowpane_games_favorites(FlowPane flowpane_games_favorites) {
        this.flowpane_games_favorites = flowpane_games_favorites;
    }

    public void setMain_controller(GAMEHUBController main_controller) {
        this.main_controller = main_controller;
    }
    
    @FXML
    private void add_car_shop(ActionEvent event) {
        Button button = (Button) event.getSource();
        Pane pane = (Pane) button.getParent();
        Game game = (Game) pane.getUserData();
        stacks_games.getGames_car_shop().add(game);
        stacks_games.saveDataToFileTXTCar_Shop();
        stacks_games.getGames_favorites().remove(game);
        stacks_games.saveDataToFileTXTFavorites();        
        flowpane_games_favorites.getChildren().remove(pane);
        main_controller.load_car_shop();
    }

    @FXML
    private void remove_game_card(ActionEvent event) {
        Button button = (Button) event.getSource();
        Pane pane = (Pane) button.getParent();
        Game game = (Game) pane.getUserData();
        stacks_games.getGames_favorites().remove(game);
        stacks_games.saveDataToFileTXTFavorites();
        flowpane_games_favorites.getChildren().remove(pane);
        main_controller.load_favorites_container("");
    }    
}
