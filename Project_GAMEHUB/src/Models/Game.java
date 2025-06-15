package Models;

import java.time.LocalDateTime;
import java.util.List;

public class Game {

    private LocalDateTime date_purchase;
    private String name_user;
    private String name;
    private float price;
    private String description;
    private List<String> URL_images;

    public Game(String name_user, String name, float price, String description, List<String> URL_images) {
        this.date_purchase = null;
        this.name_user = name_user;
        this.name = name;
        this.price = price;
        this.description = description;
        this.URL_images = URL_images;
    }

    public Game(String name, float price, List<String> URL_images) {
        this.name_user = null;
        this.name = name;
        this.price = price;
        this.URL_images = URL_images;
    }

    public LocalDateTime getDate_purchase() {
        return date_purchase;
    }

    public void setDate_purchase(LocalDateTime date_purchase) {
        this.date_purchase = date_purchase;
    }
    
    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getURL_images() {
        return URL_images;
    }

    public void setURL_images(List<String> URL_images) {
        this.URL_images = URL_images;
    }
}
