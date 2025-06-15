package Controllers;

import Lists.Instancias;
import Lists.List_Double_Admins;
import Lists.List_Double_Clients;
import Lists.Stacks_Games;
import Models.Admin;
import Models.Client;
import Models.Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GAMEHUBController implements Initializable {
    
    private final Stacks_Games stacks_games = Instancias.getInstancias().getStacks_games();
    private final List_Double_Admins list_admins = Instancias.getInstancias().getList_admins();
    private final List_Double_Clients list_client = Instancias.getInstancias().getList_clients();
    
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
    private Timeline timeline;
    private boolean needsReset = false;
    private boolean needsReset_2 = false;
    private boolean needsReset_3 = false;
    private boolean needsReset_4 = false;
    private boolean needsReset_5 = false;
    private Object UserLoged = null;
    
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
    private Label txt_total;
    @FXML
    private Label txt_sub_total;
    @FXML
    private Button btn_go_shop;
    @FXML
    private TextArea txt_description_short;
    @FXML
    private Text txt_name_game;
    @FXML
    private Text txt_requires_system;
    @FXML
    private AnchorPane container_history_purchase;
    @FXML
    private TableView<Game> table_histoy_purchase;
    @FXML
    private TableColumn<Game, String> colum_1;
    @FXML
    private TableColumn<Game, String> colum_2;
    @FXML
    private TableColumn<Game, Float> colum_3;
    @FXML
    private TableColumn<Game, LocalDateTime> colum_4;
    @FXML
    private ScrollPane container_game_favorites;
    @FXML
    private AnchorPane anchorP_favorites;
    @FXML
    private FlowPane flowpane_games_favorites;
    @FXML
    private Button btn_go_car_shop;
    @FXML
    private Button btn_filter_all_favorites;
    @FXML
    private Button btn_filter_free_favorites;
    @FXML
    private Button btn_filter_buy_favorites;
    @FXML
    private ImageView logo_random;
    @FXML
    private TextArea txt_random;
    @FXML
    private ImageView image_random;
    @FXML
    private AnchorPane panel_shooping_game;
    @FXML
    private Button close_page;
    @FXML
    private FlowPane flowpane_go_shop;
    @FXML
    private Pane data_target;
    @FXML
    private Pane data_nequi;
    @FXML
    private Pane data_daviplata;
    @FXML
    private Button btn_target;
    @FXML
    private Button btn_nequi;
    @FXML
    private Button btn_daviplata;
    @FXML
    private Label txt_precio_buy;
    @FXML
    private Label txt_total_buy;
    @FXML
    private Button btn_buy;
    @FXML
    private TextField txt_target_method;
    @FXML
    private TextField txt_date_target;
    @FXML
    private TextField txt_ccv;
    @FXML
    private TextField txt_nequi_method;
    @FXML
    private TextField txt_number_nequi;
    @FXML
    private TextField txt_pss_dinamic;
    @FXML
    private TextField txt_customer_name;
    @FXML
    private TextField txt_number_daviplata;
    @FXML
    private TextField txt_pass_dinamic;
    @FXML
    private AnchorPane pane_random;
    @FXML
    private ScrollPane container_game_library;
    @FXML
    private AnchorPane anchorP_library;
    @FXML
    private FlowPane flowpane_games_library;
    @FXML
    private Pane panel_logaut;
    @FXML
    private TextField txt_user_name;
    @FXML
    private Button btn_cancel;
    @FXML
    private Button btn_acept;
    @FXML
    private PasswordField txt_user_pass;
    @FXML
    private Pane panel_menu_left;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        images_games = FXCollections.observableArrayList();
        
        colum_1.setCellValueFactory(new PropertyValueFactory<>("name_user"));
        colum_2.setCellValueFactory(new PropertyValueFactory<>("name"));
        colum_3.setCellValueFactory(new PropertyValueFactory<>("price"));
        colum_3.setCellFactory(colum -> new FormattedTableCell<>("%,.2f"));
        colum_4.setCellValueFactory(new PropertyValueFactory<>("date_purchase"));
        
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
        
        container_car_shop_games.vvalueProperty().addListener((obs, oldVal, newVal) -> {
            if (needsReset_3) {
                Platform.runLater(() -> {
                    container_car_shop_games.setVvalue(0);
                    container_car_shop_games.setHvalue(0);
                });
                needsReset_3 = false;
            }
        });
        
        container_game_favorites.vvalueProperty().addListener((obs, oldVal, newVal) -> {
            if (needsReset_4) {
                Platform.runLater(() -> {
                    container_game_favorites.setVvalue(0);
                    container_game_favorites.setHvalue(0);
                });
                needsReset_4 = false;
            }
        });
        
        container_game_library.vvalueProperty().addListener((obs, oldVal, newVal) -> {
            if (needsReset_5) {
                Platform.runLater(() -> {
                    container_game_library.setVvalue(0);
                    container_game_library.setHvalue(0);
                });
                needsReset_5 = false;
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
        
        Platform.runLater(() -> {
            pane_random.setUserData(stacks_games.getAll_games().get(0));
            load_library_games();
            startImageRotation(stacks_games.getAll_games());
        });
    }
    
    public void startImageRotation(Stack<Game> games) {
        if (games == null || games.isEmpty()) {
            return;
        }
        Random random = new Random();
        
        timeline = new Timeline(new KeyFrame(Duration.seconds(6), event -> {
            int i = random.nextInt(games.size());
            Game randomGame = games.get(i);
            
            try {
                String imagePath = System.getProperty("user.dir") + File.separator + randomGame.getURL_images().get(0);
                File imageFile = new File(imagePath);
                String imagePathLogo = System.getProperty("user.dir") + "\\" + randomGame.getURL_images().get(3);
                File imageFileLogo = Paths.get(imagePathLogo).toFile();
                if (imageFile.exists() && imageFileLogo.exists()) {
                    Image image = new Image(new FileInputStream(imageFile));
                    Image imageLogo = new Image(new FileInputStream(imageFileLogo));
                    logo_random.setImage(imageLogo);
                    image_random.setImage(image);
                    txt_random.setText(randomGame.getDescription());
                    AnchorPane parent = (AnchorPane) image_random.getParent();
                    parent.setUserData(randomGame);
                } else {
                    System.err.println("Imagen no encontrada image: " + imagePath);
                    System.err.println("Imagen no encontrada logo: " + imagePathLogo);
                }
            } catch (FileNotFoundException e) {
                Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al tratar de cargar imagen aleatoria", e);
            }
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    public class FormattedTableCell<S, T> extends TableCell<S, T> {
        
        private final String format;
        
        public FormattedTableCell(String format) {
            this.format = format;
        }

        /**
         *
         * @param item
         * @param empty
         */
        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            
            if (item == null || empty) {
                setText(null);
            } else {
                setText(String.format(format, item));
            }
        }
    }
    
    public void setUserLoged(Object UserLoged) {
        this.UserLoged = UserLoged;
    }
    
    public void requestScrollReset() {
        needsReset = true;
        container_details_game.requestLayout();
    }
    
    public void requestScrollReset_2() {
        needsReset_2 = true;
        container_all_games.setVvalue(0);
        container_all_games.requestLayout();
    }
    
    public void requestScrollReset_3() {
        needsReset_3 = true;
        container_car_shop_games.setVvalue(0);
        container_car_shop_games.requestLayout();
    }
    
    public void requestScrollReset_4() {
        needsReset_4 = true;
        container_game_favorites.setVvalue(0);
        container_game_favorites.requestLayout();
    }
    
    public void requestScrollReset_5() {
        needsReset_5 = true;
        container_game_library.setVvalue(0);
        container_game_library.requestLayout();
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
            for (int i = 0; i < (images_games.size() - 2); i++) {
                int finalI = i;
                ImageView thumb = new ImageView(new Image(new FileInputStream(images_games.get(i))));
                thumb.setFitWidth(80);
                thumb.setFitHeight(80);
                thumb.setPreserveRatio(true);
                thumb.setStyle("-fx-cursor: hand; -fx-background-radius: 8;");
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
    
    private void add_game_favorites() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Aviso de confirmación", ButtonType.OK);
        Game game = (Game) image_view_game_primary.getUserData();
        
        if (UserLoged != null) {
            if (UserLoged instanceof Admin) {
                Admin admin = (Admin) UserLoged;
                game.setName_user(admin.getName_admin());
            } else if (UserLoged instanceof Client) {
                Client client = (Client) UserLoged;
                game.setName(client.getName_client());
            }
            
            Game search = stacks_games.getGameByNameUserAndName(stacks_games.getGames_favorites(), game.getName_user(), game.getName());
            if (search == null) {
                stacks_games.getGames_favorites().add(game);
                stacks_games.saveDataToFileTXT(stacks_games.getGames_favorites(), "Favorites.txt");
                load_favorites_container("");
                alert.setContentText("Juego agregado a favoritos de forma exitosa.");
            } else {
                alert.setContentText("Este juego ya existe en favoritos.");
            }
            alert.show();
        }
    }
    
    public void load_favorites_container(String value) {
        Platform.runLater(() -> {
            String name_user;
            if (UserLoged instanceof Admin) {
                Admin admin = (Admin) UserLoged;
                name_user = admin.getName_admin();
            } else {
                Client client = (Client) UserLoged;
                name_user = client.getName_client();
            }
            flowpane_games_favorites.getChildren().clear();
            for (Game game : stacks_games.getGames_favorites()) {
                if (game.getName_user().equals(name_user)) {
                    if (!value.equals("")) {
                        if (value.equals("free")) {
                            if (game.getPrice() != 0.0) {
                                continue;
                            }
                        } else if (value.equals("cost")) {
                            if (game.getPrice() == 0.0) {
                                continue;
                            }
                        }
                    }
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/game_card_fav.fxml"));
                        Pane gameCard = loader.load();
                        GameCardFavController controller = loader.getController();
                        controller.setFlowpane_games_favorites(flowpane_games_favorites);
                        controller.setMain_controller(this);
                        
                        for (Node node : gameCard.getChildren()) {
                            if (node instanceof ImageView) {
                                String urlLocal = System.getProperty("user.dir") + "\\" + game.getURL_images().get(4);
                                File file = Paths.get(urlLocal).toFile();
                                Image ima = new Image(new FileInputStream(file));
                                ((ImageView) node).setImage(ima);
                            }
                            if (node instanceof Label) {
                                Label label_name = (Label) node;
                                
                                if (label_name.getId().startsWith("label_name_game_car")) {
                                    label_name.setText(game.getName());
                                } else if (label_name.getId().startsWith("label_price_game_car")) {
                                    if (game.getPrice() == 0.0) {
                                        label_name.setText("Gratis");
                                        label_name.setId("gratis");
                                    } else {
                                        label_name.setId("");
                                        label_name.setText("COP $" + String.format("%,.2f", game.getPrice()));
                                    }
                                }
                            }
                        }
                        
                        gameCard.setUserData(game);
                        flowpane_games_favorites.getChildren().add(gameCard);
                    } catch (IOException e) {
                        Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al cargar componente de juego.", e);
                    }
                }
            }
        });
    }
    
    private void load_library_games() {
        Platform.runLater(() -> {
            String name_user;
            if (UserLoged instanceof Admin) {
                Admin admin = (Admin) UserLoged;
                name_user = admin.getName_admin();
            } else {
                Client client = (Client) UserLoged;
                name_user = client.getName_client();
            }
            flowpane_games_library.getChildren().clear();
            for (Game game : stacks_games.getGames_history()) {
                if (game.getName_user().equals(name_user)) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/game_card_library.fxml"));
                        Pane gameCard = loader.load();
                        GameCardLibraryController controller = loader.getController();
                        
                        for (Node node : gameCard.getChildren()) {
                            if (node == controller.getIma_game()) {
                                String urlLocal = System.getProperty("user.dir") + "\\" + game.getURL_images().get(4);
                                File file = Paths.get(urlLocal).toFile();
                                Image ima = new Image(new FileInputStream(file));
                                ((ImageView) node).setImage(ima);
                            }
                            if (node == controller.getTxt_name()) {
                                Label label_name = (Label) node;
                                label_name.setText(game.getName());
                            }
                        }
                        
                        gameCard.setUserData(game);
                        flowpane_games_library.getChildren().add(gameCard);
                    } catch (IOException e) {
                        Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al cargar componente de juego.", e);
                    }
                }
            }
        });
    }
    
    private void add_game_car() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Aviso de confirmación", ButtonType.OK);
        Game game = (Game) image_view_game_primary.getUserData();
        
        if (UserLoged != null) {
            if (UserLoged instanceof Admin) {
                Admin admin = (Admin) UserLoged;
                game.setName_user(admin.getName_admin());
            } else if (UserLoged instanceof Client) {
                Client client = (Client) UserLoged;
                game.setName(client.getName_client());
            }
            
            Game search = stacks_games.getGameByNameUserAndName(stacks_games.getGames_car_shop(), game.getName_user(), game.getName());
            if (search == null) {
                stacks_games.getGames_car_shop().add(game);
                stacks_games.saveDataToFileTXT(stacks_games.getGames_car_shop(), "Car_Shop.txt");
                load_car_shop();
                alert.setContentText("Juego agregado al carrito de compras de forma exitosa.");
            } else {
                alert.setContentText("Este juego ya existe en el carrito.");
            }
            alert.show();
        }
    }
    
    public void load_car_shop() {
        Platform.runLater(() -> {
            String name_user;
            if (UserLoged instanceof Admin) {
                Admin admin = (Admin) UserLoged;
                name_user = admin.getName_admin();
            } else {
                Client client = (Client) UserLoged;
                name_user = client.getName_client();
            }
            flowpane_games_car.getChildren().clear();
            float total = 0;
            for (Game game : stacks_games.getGames_car_shop()) {
                if (game.getName_user().equals(name_user)) {
                    try {
                        total += game.getPrice();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/game_card.fxml"));
                        Pane gameCard = loader.load();
                        GameCardController controller = loader.getController();
                        controller.setFlowpane_games_car(flowpane_games_car);
                        controller.setMain_controller(this);
                        for (Node node : gameCard.getChildren()) {
                            if (node instanceof ImageView) {
                                String urlLocal = System.getProperty("user.dir") + "\\" + game.getURL_images().get(4);
                                File file = Paths.get(urlLocal).toFile();
                                Image ima = new Image(new FileInputStream(file));
                                ((ImageView) node).setImage(ima);
                            }
                            if (node instanceof Label) {
                                Label label_name = (Label) node;
                                
                                if (label_name.getId().startsWith("label_name_game_car")) {
                                    label_name.setText(game.getName());
                                } else if (label_name.getId().startsWith("label_price_game_car")) {
                                    if (game.getPrice() == 0.0) {
                                        label_name.setText("Gratis");
                                        label_name.setId("gratis");
                                    } else {
                                        label_name.setId("");
                                        label_name.setText("COP $" + String.format("%,.2f", game.getPrice()));
                                    }
                                }
                            }
                        }
                        
                        gameCard.setUserData(game);
                        flowpane_games_car.getChildren().add(gameCard);
                    } catch (IOException e) {
                        Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al cargar componente de juego.", e);
                    }
                }
            }
            String sub_total = String.format("%,.2f", total);
            txt_total.setText("COP $" + sub_total);
            txt_sub_total.setText("COP $" + sub_total);
        });
    }
    
    private void load_game(Game game) {
        label_name_game_top.setText(game.getName());
        txt_description_short.setText(game.getDescription());
        txt_name_game.setText(game.getName());
        txt_requires_system.setText("Requisitos del sistema de " + game.getName());
        try {
            String url_local = System.getProperty("user.dir") + "\\" + game.getURL_images().get(game.getURL_images().size() - 2);
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
    
    private void buy_all() {
        float total = 0;
        boolean isBuy = false;
        for (Node node : flowpane_go_shop.getChildren()) {
            Pane pane = (Pane) node;
            if (pane.getUserData() != null) {
                
                Game game = (Game) pane.getUserData();
                total += game.getPrice();
                LocalDateTime date_purchase = LocalDateTime.now();
                if (stacks_games.getGames_car_shop().contains(game)) {
                    stacks_games.getGames_car_shop().remove(game);
                    stacks_games.saveDataToFileTXTCar_Shop();
                    load_car_shop();
                }
                game.setDate_purchase(date_purchase);
                stacks_games.getGames_history().add(game);
                stacks_games.saveDataToFileTXTHistory();
                update_table();
                isBuy = true;
            }
        }
        if (isBuy) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Información de compra.", ButtonType.OK);
            if (total != 0.0) {
                alert.setContentText("Compra realizada con exito, el total fue de " + total);
            } else {
                alert.setContentText("Obtuvo sus juegos con exito. FREE");
            }
            alert.showAndWait();
            load_library_games();
            panel_shooping_game.setVisible(false);
            container_all_games.setVisible(true);
        }
    }
    
    private void load_game_buys() {
        Platform.runLater(() -> {
            String name_user;
            if (UserLoged instanceof Admin) {
                Admin admin = (Admin) UserLoged;
                name_user = admin.getName_admin();
            } else {
                Client client = (Client) UserLoged;
                name_user = client.getName_client();
            }
            flowpane_go_shop.getChildren().clear();
            float total = 0;
            for (Game game : stacks_games.getGames_car_shop()) {
                if (game.getName_user().equals(name_user)) {
                    try {
                        total += game.getPrice();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/game_card_purchase.fxml"));
                        Pane gameCard = loader.load();
                        GameCardPurchaseController controller = loader.getController();
                        
                        for (Node node : gameCard.getChildren()) {
                            if (node == controller.getIma_game()) {
                                String urlLocal = System.getProperty("user.dir") + "\\" + game.getURL_images().get(4);
                                File file = Paths.get(urlLocal).toFile();
                                Image ima = new Image(new FileInputStream(file));
                                ((ImageView) node).setImage(ima);
                            }
                            if (node instanceof Label) {
                                Label label_name = (Label) node;
                                
                                if (label_name == controller.getTxt_name()) {
                                    label_name.setText(game.getName());
                                } else if (label_name == controller.getTxt_price()) {
                                    if (game.getPrice() == 0.0) {
                                        label_name.setText("Gratis");
                                        label_name.setId("gratis");
                                    } else {
                                        label_name.setId("");
                                        label_name.setText("COP $" + String.format("%,.2f", game.getPrice()));
                                    }
                                }
                            }
                        }
                        
                        gameCard.setUserData(game);
                        flowpane_go_shop.getChildren().add(gameCard);
                    } catch (IOException e) {
                        Logger.getLogger(GAMEHUBController.class.getName()).log(Level.SEVERE, "Error al cargar componente de juego.", e);
                    }
                }
            }
            String sub_total = String.format("%,.2f", total);
            txt_precio_buy.setText(" $" + sub_total);
            txt_total_buy.setText(" $" + sub_total);
        });
    }
    
    @FXML
    private void ActionEvent(ActionEvent event) {
        requestScrollReset_2();
        requestScrollReset_3();
        requestScrollReset_4();
        requestScrollReset_5();
        HBOX_details_game.setVisible(false);
        container_all_games.setVisible(false);
        container_car_shop_games.setVisible(false);
        container_history_purchase.setVisible(false);
        container_game_favorites.setVisible(false);
        container_game_library.setVisible(false);
        panel_shooping_game.setVisible(false);
        panel_logaut.setVisible(false);
        panel_menu_left.setVisible(true);
        
        if (event.getSource().equals(btn_shop)) {
            container_all_games.setVisible(true);
        }
        if (event.getSource().equals(btn_library)) {
            container_game_library.setVisible(true);
        }
        if (event.getSource().equals(btn_favs)) {
            load_favorites_container("");
            container_game_favorites.setVisible(true);
        }
        if (event.getSource().equals(btn_history)) {
            update_table();
            container_history_purchase.setVisible(true);
        }
        if (event.getSource().equals(btn_myShopping)) {
            load_car_shop();
            container_car_shop_games.setVisible(true);
        }
        if (event.getSource().equals(btn_profile)) {
            panel_logaut.setVisible(true);
            panel_menu_left.setVisible(false);
        }
        if (event.getSource().equals(btn_add_car)) {
            add_game_car();
            container_car_shop_games.setVisible(true);
        }
        if (event.getSource().equals(btn_add_favorites)) {
            add_game_favorites();
            container_game_favorites.setVisible(true);
        }
        if (event.getSource().equals(btn_shop_now)) {
            panel_shooping_game.setVisible(true);
            load_game_buys();
        }
        if (event.getSource().equals(btn_go_shop)) {
            panel_shooping_game.setVisible(true);
            load_game_buys();
        }
    }
    
    @FXML
    private void show_game(MouseEvent event) {
        requestScrollReset();
        ImageView imageView = (ImageView) event.getSource();
        Game game = (Game) imageView.getUserData();
        load_game(game);
        image_view_game_primary.setUserData(game);
        show_image_primary();
        
        HBOX_details_game.setVisible(true);
        container_all_games.setVisible(false);
    }
    
    @FXML
    private void show_game_2(ActionEvent event) {
        requestScrollReset();
        Button button = (Button) event.getSource();
        
        Game game = (Game) button.getUserData();
        load_game(game);
        image_view_game_primary.setUserData(game);
        show_image_primary();
        
        HBOX_details_game.setVisible(true);
        container_all_games.setVisible(false);
    }
    
    @FXML
    private void show_game_anchorPane(MouseEvent event) {
        requestScrollReset();
        AnchorPane pane = (AnchorPane) event.getSource();
        Game game = (Game) pane.getUserData();
        load_game(game);
        image_view_game_primary.setUserData(game);
        show_image_primary();
        
        HBOX_details_game.setVisible(true);
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
            if (index < 2) {
                index++;
                animate_transition(true);
                update_image_primary();
            }
        }
    }
    
    @FXML
    private void show_panels_purchase(ActionEvent event) {
        if (event.getSource() == close_page) {
            requestScrollReset();
            container_all_games.setVisible(true);
            panel_shooping_game.setVisible(false);
        }
        if (event.getSource() == btn_target) {
            data_target.setVisible(true);
            data_nequi.setVisible(false);
            data_daviplata.setVisible(false);
        }
        if (event.getSource() == btn_nequi) {
            data_nequi.setVisible(true);
            data_target.setVisible(false);
            data_daviplata.setVisible(false);
        }
        if (event.getSource() == btn_daviplata) {
            data_daviplata.setVisible(true);
            data_target.setVisible(false);
            data_nequi.setVisible(false);
        }
        if (event.getSource() == btn_buy) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Aviso.", ButtonType.OK);
            boolean isBuy = false;
            if (data_target.isVisible()) {
                if (txt_target_method.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes un numero de tarjeta.");
                    alert.show();
                } else if (txt_date_target.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes una fecha de vencimiento.");
                    alert.show();
                } else if (txt_ccv.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes un codigo CCV.");
                    alert.show();
                } else {
                    if (flowpane_go_shop.getChildren().get(0) != null) {
                        isBuy = true;
                    } else {
                        alert.setContentText("Asegurese de tener, juegos para comprar, antes de hacer el proceso de pago.");
                        alert.show();
                    }
                }
            }
            if (data_nequi.isVisible()) {
                if (txt_nequi_method.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes un titular de cuenta.");
                    alert.show();
                } else if (txt_number_nequi.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes un numero de cuenta.");
                    alert.show();
                } else if (txt_pss_dinamic.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes una clave dinamica.");
                    alert.show();
                } else {
                    if (flowpane_go_shop.getChildren().get(0) != null) {
                        isBuy = true;
                    } else {
                        alert.setContentText("Asegurese de tener, juegos para comprar, antes de hacer el proceso de pago.");
                        alert.show();
                    }
                }
            }
            if (data_daviplata.isVisible()) {
                if (txt_customer_name.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes un nombre de titular.");
                    alert.show();
                } else if (txt_number_daviplata.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes un numero de cuenta.");
                    alert.show();
                } else if (txt_pass_dinamic.getText().isEmpty()) {
                    alert.setContentText("Debe ingresar antes una calve dinamica.");
                    alert.show();
                } else {
                    if (flowpane_go_shop.getChildren().get(0) != null) {
                        isBuy = true;
                    } else {
                        alert.setContentText("Asegurese de tener, juegos para comprar, antes de hacer el proceso de pago.");
                        alert.show();
                    }
                }
            }
            
            if (!data_target.isVisible() && !data_nequi.isVisible() && !data_daviplata.isVisible()) {
                alert.setContentText("Antes debe llenar alguno de los apartados de pago <Tarjeta> <Nequi> <Daviplata>.");
                alert.show();
                return;
            }
            if (isBuy) {
                buy_all();
            }
            txt_target_method.clear();
            txt_date_target.clear();
            txt_ccv.clear();
            txt_nequi_method.clear();
            txt_number_nequi.clear();
            txt_pss_dinamic.clear();
            txt_customer_name.clear();
            txt_number_daviplata.clear();
            txt_pass_dinamic.clear();
        }
    }
    
    @FXML
    private void fliers_action(ActionEvent event) {
        if (event.getSource() == btn_filter_all_favorites) {
            load_favorites_container("");
        }
        if (event.getSource() == btn_filter_free_favorites) {
            load_favorites_container("free");
        }
        if (event.getSource() == btn_filter_buy_favorites) {
            load_favorites_container("cost");
        }
    }
    
    @FXML
    private void events_logaut(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "LOGAUT.", ButtonType.OK);
        
        if (event.getSource() == btn_acept) {
            if (txt_user_name.getText().isEmpty()) {
                alert.setContentText("Antes de verificar debe ingresar un nombre de usuario");
                alert.show();
                return;
            }
            if (txt_user_pass.getText().isEmpty()) {
                alert.setContentText("Antes de verificar debe ingresar una contraseña");
                alert.show();
                return;
            }
            
            Admin admin = null;
            Client client = null;
            
            if (UserLoged instanceof Admin) {
                admin = list_admins.findByName(txt_user_name.getText());
            } else if (UserLoged instanceof Client) {
                client = list_client.findByName(txt_user_name.getText());
            }
            
            if (admin == null && client == null) {
                alert.setContentText("El usuario no está registrado o es erróneo, verifique.");
                alert.show();
                txt_user_name.clear();
                txt_user_pass.clear();
                txt_user_name.requestFocus();
                return;
            }
            
            if (admin != null) {
                if (admin.getPassword().equals(txt_user_pass.getText())) {
                    alert.setContentText("CREDENCIALES CORRECTAS, SALIENDO...!");
                    alert.showAndWait();
                    txt_user_name.clear();
                    txt_user_pass.clear();
                    run_login("Admin");
                } else {
                    alert.setContentText("Contraseña incorrecta");
                    alert.show();
                    txt_user_pass.clear();
                    txt_user_pass.requestFocus();
                }
            } else if (client != null) {
                if (client.getPassword().equals(txt_user_pass.getText())) {
                    alert.setContentText("CREDENCIALES CORRECTAS, SALIENDO...!");
                    alert.showAndWait();
                    txt_user_name.clear();
                    txt_user_pass.clear();
                    run_login("Client");
                } else {
                    alert.setContentText("Contraseña incorrecta");
                    alert.show();
                    txt_user_pass.clear();
                    txt_user_pass.requestFocus();
                }
            }
        }
        
        if (event.getSource() == btn_cancel) {
            requestScrollReset();
            txt_user_name.clear();
            txt_user_pass.clear();
            panel_logaut.setVisible(false);
            container_all_games.setVisible(true);
            panel_menu_left.setVisible(true);
            txt_user_name.clear();
            txt_user_pass.clear();
        }
    }
    
    public void update_table() {
        table_histoy_purchase.getItems().clear();
        
        if (!stacks_games.getGames_history().isEmpty()) {
            
            for (Game game : stacks_games.getGames_history()) {
                table_histoy_purchase.getItems().add(game);
            }
        }
    }
}
