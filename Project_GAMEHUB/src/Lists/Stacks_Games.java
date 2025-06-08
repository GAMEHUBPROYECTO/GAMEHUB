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

    public Stacks_Games() {
        this.games_car_shop = new Stack<>();
        this.games_history = new Stack<>();
        this.games_favorites = new Stack<>();
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
    
    //games_car_shop
    public void setPushGame(Game game) {
        int pos = games_car_shop.indexOf(game);
        if (pos == -1) {
            games_car_shop.push(game);
        } else {
            System.out.println("Ya se registró antes este juego.");
        }
    }

    public Stack<Game> getGamesNameUser(String name_user) {
        Stack<Game> stack = new Stack<>();
        for (Game aux : games_car_shop) {
            if (aux.getName_user().equals(name_user)) {
                stack.push(aux);
            }
        }
        return stack;
    }

    public Game getGameByNameUserAndName(String name_user, String name) {
        for (Game game : games_car_shop) {
            if (game.getName_user().equals(name_user) && game.getName().equals(name)) {
                return game;
            }
        }
        return null;
    }

    public void setPopGameByNameUserAndName(String name_user, String name) {
        Game game = null;
        if (!games_car_shop.empty()) {
            game = getGameByNameUserAndName(name_user, name);
            if ((game != null) && (games_car_shop.remove(game))) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay juegos registrados!");
        }
    }

    public Stack<Game> getCloneGames() {
        Stack<Game> games = new Stack<>();
        int i;
        Game game = null;
        if (games_car_shop == null) {
            return null;
        } else {
            for (i = 0; i < games_car_shop.size(); i++) {
                game = games_car_shop.get(i);
                games.add(i, game);
            }
            return games;
        }
    }

    public void saveDataToFileTXT() {

        String url = System.getProperty("user.dir") + "\\src\\Files\\Car_Shop.txt";

        Path path = Paths.get(url);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), false))) {
            Stack<Game> games = games_car_shop;

            for (Game game : games) {
                writer.write(game.getName_user() + ",; ");
                writer.write(game.getName() + ",; ");
                writer.write(game.getPrice() + ",; ");
                writer.write(String.join(". ", game.getURL_images()));
                writer.newLine();
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadDataFromFileTXT() {

        String url = System.getProperty("user.dir") + "\\src\\Files\\Car_Shop.txt";

        Path path = Paths.get(url);

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {

            String linea;

            if (!games_car_shop.isEmpty()) {
                games_car_shop.clear();
            }

            while ((linea = reader.readLine()) != null) {
                
                String[] atributos = linea.split(",; ");
                
                String name_user = atributos[0];
                String name = atributos[1];
                float price = Float.parseFloat(atributos[2]);
                
                String[] urls = atributos[3].split(". ");               
                List<String> URL_images = Arrays.asList(urls);
                
                Game game = new Game(name_user, name, price, URL_images);
                setPushGame(game);
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    //games_history    
    public void setPushGameHistory(Game game) {
        int pos = games_history.indexOf(game);
        if (pos == -1) {
            games_history.push(game);
        } else {
            System.out.println("Ya se registró antes este juego.");
        }
    }

    public Stack<Game> getGamesNameUserHistory(String name_user) {
        Stack<Game> stack = new Stack<>();
        for (Game aux : games_history) {
            if (aux.getName_user().equals(name_user)) {
                stack.push(aux);
            }
        }
        return stack;
    }

    public Game getGameByNameUserAndNameHistory(String name_user, String name) {
        for (Game game : games_history) {
            if (game.getName_user().equals(name_user) && game.getName().equals(name)) {
                return game;
            }
        }
        return null;
    }

    public void setPopGameByNameUserAndNameHistory(String name_user, String name) {
        Game game = null;
        if (!games_history.empty()) {
            game = getGameByNameUserAndName(name_user, name);
            if ((game != null) && (games_history.remove(game))) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay juegos registrados!");
        }
    }

    public Stack<Game> getCloneGamesHistory() {
        Stack<Game> games = new Stack<>();
        int i;
        Game game = null;
        if (games_history == null) {
            return null;
        } else {
            for (i = 0; i < games_history.size(); i++) {
                game = games_history.get(i);
                games.add(i, game);
            }
            return games;
        }
    }

    public void saveDataToFileTXTHistory() {

        String url = System.getProperty("user.dir") + "\\src\\Files\\History.txt";

        Path path = Paths.get(url);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), false))) {
            Stack<Game> games = games_history;

            for (Game game : games) {
                writer.write(game.getName_user() + ",; ");
                writer.write(game.getName() + ",; ");
                writer.write(game.getPrice() + ",; ");
                writer.write(String.join(". ", game.getURL_images()));
                writer.newLine();
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadDataFromFileTXTHistory() {

        String url = System.getProperty("user.dir") + "\\src\\Files\\History.txt";

        Path path = Paths.get(url);

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {

            String linea;

            if (!games_history.isEmpty()) {
                games_history.clear();
            }

            while ((linea = reader.readLine()) != null) {
                
                String[] atributos = linea.split(",; ");
                
                String name_user = atributos[0];
                String name = atributos[1];
                float price = Float.parseFloat(atributos[2]);
                
                String[] urls = atributos[3].split(". ");               
                List<String> URL_images = Arrays.asList(urls);
                
                Game game = new Game(name_user, name, price, URL_images);
                setPushGame(game);
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    //games_favorites    
    public void setPushGameFavorites(Game game) {
        int pos = games_favorites.indexOf(game);
        if (pos == -1) {
            games_favorites.push(game);
        } else {
            System.out.println("Ya se registró antes este juego.");
        }
    }

    public Stack<Game> getGamesNameUserFavorites(String name_user) {
        Stack<Game> stack = new Stack<>();
        for (Game aux : games_favorites) {
            if (aux.getName_user().equals(name_user)) {
                stack.push(aux);
            }
        }
        return stack;
    }

    public Game getGameByNameUserAndNameFavorites(String name_user, String name) {
        for (Game game : games_favorites) {
            if (game.getName_user().equals(name_user) && game.getName().equals(name)) {
                return game;
            }
        }
        return null;
    }

    public void setPopGameByNameUserAndNameFavorites(String name_user, String name) {
        Game game = null;
        if (!games_favorites.empty()) {
            game = getGameByNameUserAndName(name_user, name);
            if ((game != null) && (games_favorites.remove(game))) {
                JOptionPane.showMessageDialog(null, "Juego eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El juego no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay juegos registrados!");
        }
    }

    public Stack<Game> getCloneGamesFavorites() {
        Stack<Game> games = new Stack<>();
        int i;
        Game game = null;
        if (games_favorites == null) {
            return null;
        } else {
            for (i = 0; i < games_favorites.size(); i++) {
                game = games_favorites.get(i);
                games.add(i, game);
            }
            return games;
        }
    }

    public void saveDataToFileTXTFavorites() {

        String url = System.getProperty("user.dir") + "\\src\\Files\\Favorites.txt";

        Path path = Paths.get(url);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), false))) {
            Stack<Game> games = games_favorites;

            for (Game game : games) {
                writer.write(game.getName_user() + ",; ");
                writer.write(game.getName() + ",; ");
                writer.write(game.getPrice() + ",; ");
                writer.write(String.join(". ", game.getURL_images()));
                writer.newLine();
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadDataFromFileTXTFavorites() {

        String url = System.getProperty("user.dir") + "\\src\\Files\\Favorites.txt";

        Path path = Paths.get(url);

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {

            String linea;

            if (!games_favorites.isEmpty()) {
                games_favorites.clear();
            }

            while ((linea = reader.readLine()) != null) {
                
                String[] atributos = linea.split(",; ");
                
                String name_user = atributos[0];
                String name = atributos[1];
                float price = Float.parseFloat(atributos[2]);
                
                String[] urls = atributos[3].split(". ");               
                List<String> URL_images = Arrays.asList(urls);
                
                Game game = new Game(name_user, name, price, URL_images);
                setPushGame(game);
            }
        } catch (IOException e) {
            Logger.getLogger(Stacks_Games.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
