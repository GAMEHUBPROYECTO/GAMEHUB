package Controllers;

import Lists.Instancias;
import Lists.Stacks_Games;
import Models.Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GAMEHUBController implements Initializable {

    private final Stacks_Games stacks_games = Instancias.getInstancias().getStacks_games();

    @FXML
    private ImageView imaLogo;
    @FXML
    private Pane Fornite;
    @FXML
    private Pane MultiVersus;
    @FXML
    private Pane FallOut;
    @FXML
    private Pane Valorant;
    @FXML
    private Pane Genshin;
    @FXML
    private Button btn_game1;
    @FXML
    private Button btn_game2;
    @FXML
    private Button btn_game3;
    @FXML
    private Button btn_game4;
    @FXML
    private Button btn_game5;
    @FXML
    private Button btn_game6;
    @FXML
    private Button btn_game7;
    @FXML
    private Button btn_game8;
    @FXML
    private Button btn_game9;
    @FXML
    private Button btn_game10;
    @FXML
    private Button btn_game11;
    @FXML
    private Button btn_game12;
    @FXML
    private Button btn_game13;
    @FXML
    private Button btn_game14;
    @FXML
    private Button btn_game15;
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
    private AnchorPane anchorP;
    @FXML
    private AnchorPane parent;
    @FXML
    private FlowPane flowpane_games;
    @FXML
    private FlowPane flow_relationship;
    @FXML
    private ImageView image_view_game_primary;
    @FXML
    private Button right;
    @FXML
    private Button left;
    @FXML
    private Pane overlay;
    @FXML
    private Pane overlay2;

    FadeTransition fade1 = new FadeTransition(Duration.millis(200), overlay);
    FadeTransition fade01 = new FadeTransition(Duration.millis(200), overlay);
    FadeTransition fade2 = new FadeTransition(Duration.millis(200), overlay2);
    FadeTransition fade02 = new FadeTransition(Duration.millis(200), overlay2);

    private ObservableList<File> images_games;
    private int index = 0;
    private boolean needsReset = false;
    private boolean needsReset_2 = false;

    @FXML
    private Pane container_carousel;
    @FXML
    private ScrollPane container_all_games;
    @FXML
    private ScrollPane container_details_game;
    @FXML
    private VBox miniatures;
    @FXML
    private HBox HBOX_details_game;
    @FXML
    private Pane PanelInfo_Red;
    @FXML
    private Button btn_shop_now;
    @FXML
    private Button btn_add_car;
    @FXML
    private Button btn_add_favorites;
    @FXML
    private Label label_price;
    @FXML
    private ImageView ima_logo_game;
    @FXML
    private Pane Red_Dead;
    @FXML
    private Pane FC_24;
    @FXML
    private Pane Hogwarts_Legacy;
    @FXML
    private Pane Grand_Theft_Auto_V;
    @FXML
    private Pane God_Of_War;
    @FXML
    private Pane Ghost_Runner;
    @FXML
    private Pane Fall_Guys;
    @FXML
    private Pane The_Hunter;
    @FXML
    private Pane F1_24;
    @FXML
    private Pane Spider_Man;
    @FXML
    private Label label_name_game_top;
    @FXML
    private ScrollPane container_car_shop_games;
    @FXML
    private AnchorPane anchorP1;
    @FXML
    private FlowPane flowpane_games_car;
    @FXML
    private Pane card_game_car;
    @FXML
    private Label txt_total;
    @FXML
    private Label txt_sub_total;
    @FXML
    private Button btn_go_shop;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        images_games = FXCollections.observableArrayList();

        anchorP.prefWidthProperty().bind(container_all_games.widthProperty());
        anchorP.prefHeightProperty().bind(container_all_games.heightProperty());
        flowpane_games.prefWidthProperty().bind(anchorP.widthProperty());
        flowpane_games.prefHeightProperty().bind(anchorP.heightProperty());

        container_details_game.vvalueProperty().addListener((obs, oldVal, newVal) -> {
            if (needsReset) {
                Platform.runLater(() -> {
                    container_details_game.setVvalue(0);
                    container_details_game.setHvalue(0);
                });
                needsReset = false;
            }
        });

        container_all_games.vvalueProperty().addListener((obs, oldVal, newVal) -> {
            if (needsReset_2) {
                Platform.runLater(() -> {
                    container_all_games.setVvalue(0);
                    container_all_games.setHvalue(0);
                });
                needsReset_2 = false;
            }
        });

        fade1.setFromValue(0);
        fade1.setToValue(1);
        fade01.setFromValue(1);
        fade01.setToValue(0);
        fade2.setFromValue(0);
        fade2.setToValue(1);
        fade02.setFromValue(1);
        fade02.setToValue(0);

        fade01.setOnFinished(e -> overlay.setVisible(false));
        fade02.setOnFinished(e -> overlay2.setVisible(false));

        container_carousel.setOnMouseEntered(e -> {
            overlay.setVisible(true);
            overlay2.setVisible(true);
            fade1.playFromStart();
            fade2.playFromStart();
            left.setVisible(true);
            right.setVisible(true);
        });

        container_carousel.setOnMouseExited(e -> {
            fade01.playFromStart();
            fade02.playFromStart();
            left.setVisible(false);
            right.setVisible(false);
        });

        overlay.setStyle("-fx-background-color: linear-gradient(to left, rgba(0,0,0,0.5), transparent);");
        overlay2.setStyle("-fx-background-color: linear-gradient(to right, rgba(0,0,0,0.5), transparent);");
    }

    public void requestScrollReset() {
        needsReset = true;
        container_details_game.requestLayout();
    }

    public void requestScrollReset_2() {
        needsReset_2 = true;
        container_all_games.requestLayout();
    }

    private void update_image_primary() {
        try {
            File imagen = images_games.get(index);
            image_view_game_primary.setImage(new Image(new FileInputStream(imagen)));
        } catch (FileNotFoundException e) {
            Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al tratar de actualizar el carrusel", e);
        }
    }

    public void update_miniatures() {
        try {
            miniatures.getChildren().clear();
            for (int i = 0; i < (images_games.size() - 1); i++) {
                int finalI = i;
                ImageView thumb = new ImageView(new Image(new FileInputStream(images_games.get(i))));
                thumb.setFitWidth(80);
                thumb.setFitHeight(80);
                thumb.setPreserveRatio(true);
                thumb.setStyle("-fx-cursor: hand; -fx-border-radius: 8;");
                thumb.setOnMouseClicked(e -> {
                    if (index != finalI) {
                        int anterior = index;
                        index = finalI;
                        animate_transition(anterior < finalI);
                        update_image_primary();
                    }
                });
                miniatures.getChildren().add(thumb);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al tratar de cargar miniaturas", ex);
        }
    }

    private void animate_transition(boolean moveRight) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(350), image_view_game_primary);
        transition.setInterpolator(Interpolator.EASE_BOTH);
        transition.setFromX(moveRight ? 400 : -400);
        transition.setToX(0);

        FadeTransition fade = new FadeTransition(Duration.millis(250), image_view_game_primary);
        fade.setFromValue(0.7);
        fade.setToValue(1.0);

        ParallelTransition parallel = new ParallelTransition(transition, fade);
        parallel.play();
    }

    private void show_image_primary() {
        index = 0;
        Game game = (Game) image_view_game_primary.getUserData();
        images_games.clear();
        for (String url : game.getURL_images()) {
            String url_local = System.getProperty("user.dir") + "\\" + url;
            File file = Paths.get(url_local).toFile();

            if (file != null) {
                images_games.add(file);
            }
        }
        try {
            File file = images_games.get(index);
            image_view_game_primary.setImage(new Image(new FileInputStream(file)));
            update_miniatures();
        } catch (FileNotFoundException e) {
            Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al tratar de actualizar el carrusel", e);
        }

    }

    public void load_user_data() {
        List<Node> children = flow_relationship.getChildren();
        List<Node> children_2 = flowpane_games.getChildren();

        int i = 0;
        for (Node node : children) {
            if (node instanceof Button) {
                Button btn = (Button) node;
                if (btn.getId() != null && btn.getId().startsWith("btn_")) {
                    if (stacks_games.getAll_games().isEmpty()) {
                        return;
                    }
                    btn.setUserData(stacks_games.getAll_games().get(i++));
                }
            }
        }

        List<Game> games = stacks_games.getAll_games();

        for (Node node : children_2) {
            if (node instanceof Pane) {
                Pane pane = (Pane) node;
                if (pane.getId() != null) {
                    ImageView image = (ImageView) pane.lookup(".image-view");

                    if (image != null) {
                        for (Game game : games) {
                            String namePart = game.getName().toLowerCase().replaceAll("[ _]", "");
                            String paneId = pane.getId().toLowerCase().replaceAll("[ _]", "");

                            if (paneId.equals(namePart)) {
                                image.setUserData(game);
                                break;
                            }
                        }
                    }
                }
            }
        }
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
        requestScrollReset_2();
        if (event.getSource().equals(btn_shop)) {
            container_all_games.setVisible(true);
            HBOX_details_game.setVisible(false);
        }
        if (event.getSource().equals(btn_library)) {
        }
        if (event.getSource().equals(btn_favs)) {
        }
        if (event.getSource().equals(btn_history)) {
        }
        if (event.getSource().equals(btn_myShopping)) {
        }
        if (event.getSource().equals(btn_profile)) {
        }
        if (event.getSource().equals(btn_add_car)) {
        }
        if (event.getSource().equals(btn_add_favorites)) {
        }
        if (event.getSource().equals(btn_shop_now)) {
        }
    }

    private void load_game(Game game) {
        label_name_game_top.setText(game.getName());
        try {
            String url_local = System.getProperty("user.dir") + "\\" + game.getURL_images().get(game.getURL_images().size() - 1);
            File imagen = Paths.get(url_local).toFile();
            ima_logo_game.setImage(new Image(new FileInputStream(imagen)));
        } catch (FileNotFoundException e) {
            Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al tratar de actualizar el logo", e);
        }
        if (game.getPrice() == 0.0) {
            label_price.setText("Gratis");
            label_price.setId("gratis");
            btn_shop_now.setText("OBTENER AHORA");
        } else {
            btn_shop_now.setText("COMPRAR AHORA");
            label_price.setId("");
            label_price.setText("COP $" + game.getPrice());
        }

    }

    @FXML
    private void show_game(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();
        requestScrollReset();
        Game game = (Game) imageView.getUserData();
        load_game(game);
        image_view_game_primary.setUserData(game);
        show_image_primary();

        HBOX_details_game.setVisible(true);
        container_all_games.setVisible(false);
    }

    @FXML
    private void show_game_2(ActionEvent event) {

        Button button = (Button) event.getSource();

        Game game = (Game) button.getUserData();
        load_game(game);
        image_view_game_primary.setUserData(game);
        show_image_primary();

        HBOX_details_game.setVisible(true);
        requestScrollReset();
        container_all_games.setVisible(false);
    }

    @FXML
    private void action_carousel(ActionEvent event) {

        if (event.getSource() == left) {
            if (index > 0) {
                index--;
                animate_transition(false);
                update_image_primary();
            }

        } else {
            if (index < images_games.size() - 1) {
                index++;
                animate_transition(true);
                update_image_primary();
            }
        }
    }

    @FXML
    private void add_favorites(ActionEvent event) {
    }

    @FXML
    private void remove_game_card(ActionEvent event) {
    }

}
