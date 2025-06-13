package Lists;

import Models.Game;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Stacks_Games {

    private final Stack<Game> games_car_shop;
    private final Stack<Game> games_history;
    private final Stack<Game> games_favorites;
    private final Stack<Game> all_games;

    public Stacks_Games() {
        this.games_car_shop = new Stack<>();
        this.games_history = new Stack<>();
        this.games_favorites = new Stack<>();
        this.all_games = new Stack<>();
    }

    public Stack<Game> getGames_car_shop() {
        return games_car_shop;
    }

    public Stack<Game> getGames_history() {
        return games_history;
    }

    public Stack<Game> getGames_favorites() {
        return games_favorites;
    }

    public Stack<Game> getAll_games() {
        return all_games;
    }

    public void setPushGame(Stack<Game> stack, Game game) {
        if (!stack.contains(game)) {
            stack.push(game);
        } else {
            System.out.println("Ya se registró antes este juego.");
        }
    }

    public Game getGameByNameUserAndName(Stack<Game> stack, String name_user, String name) {
        for (Game game : stack) {
            if (game.getName_user().equals(name_user) && name.equals(game.getName())) {
                return game;
            }
        }
        return null;
    }

    public void setPopGameByNameUserAndName(Stack<Game> stack, String name_user, String name) {
        Game game = getGameByNameUserAndName(stack, name_user, name);
        if (!stack.isEmpty()) {
            if (game != null && stack.remove(game)) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay juegos registrados!");
        }
    }

    public Stack<Game> cloneStack(Stack<Game> stack) {
        return new Stack<Game>() {
            {
                addAll(stack);
            }
        };
    }

    public void saveDataToFileTXT(Stack<Game> stack, String filename) {

        String url = System.getProperty("user.dir") + "\\src\\Files\\" + filename;

        Path path = Paths.get(url);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), false))) {
            Stack<Game> games = stack;

            for (Game game : games) {
                writer.write(game.getName_user() + ",; ");
                writer.write(game.getName() + ",; ");
                writer.write(game.getPrice() + ",; ");
                writer.write(String.join("; ", game.getURL_images()));
                writer.newLine();
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadDataFromFileTXT(Stack<Game> stack, String filename) {

        String url = System.getProperty("user.dir") + "\\src\\Files\\" + filename;

        Path path = Paths.get(url);

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {

            String linea;

            if (!stack.isEmpty()) {
                stack.clear();
            }

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(",; ");

                String name_user = atributos[0];
                String name = atributos[1];
                float price = Float.parseFloat(atributos[2]);
                String description = atributos[3];

                String[] urls = atributos[4].split("; ");
                List<String> URL_images = Arrays.asList(urls);

                Game game = new Game(name_user, name, price, description, URL_images);
                setPushGame(stack, game);
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //games_car_shop
    public void saveDataToFileTXTCar_Shop() {
        saveDataToFileTXT(games_car_shop, "Car_Shop.txt");
    }

    public void loadDataFromFileTXTCar_Shop() {
        loadDataFromFileTXT(games_car_shop, "Car_Shop.txt");
    }

    //games_histories
    public void saveDataToFileTXTHistory() {
        saveDataToFileTXT(games_history, "History.txt");
    }

    public void loadDataFromFileTXTHistory() {
        loadDataFromFileTXT(games_history, "History.txt");
    }

    //games_favorites        
    public void saveDataToFileTXTFavorites() {
        saveDataToFileTXT(games_favorites, "Favorites.txt");
    }

    public void loadDataFromFileTXTFavorites() {
        loadDataFromFileTXT(games_favorites, "Favorites.txt");
    }

    //all_games    
    public void saveDataToFileTXTAll() {
        saveDataToFileTXT(all_games, "Games.txt");
    }

    public void loadDataFromFileTXTAll() {
        loadDataFromFileTXT(all_games, "Games.txt");
    }
}
