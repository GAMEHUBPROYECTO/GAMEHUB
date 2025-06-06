package Lists;

import Models.Client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class List_Double_Clients {
    
    private Client cabeza;

    public List_Double_Clients() {
        this.cabeza = null;
    }

    public Client getCabeza() {
        return cabeza;
    }

    public void setCabeza(Client cabeza) {
        this.cabeza = cabeza;
    }        
     
    public Client findByName(String name) {
        if (cabeza == null) {
            return null;
        }

        Client actual = cabeza;
        
        do {
            if (actual.getName_client().equals(name)) {
                return actual;
            }
            actual = actual.getSig();
        } while (actual != cabeza);
        return null;
    }

    public void addClients(TextField txtClientName, TextField txtPassword_Client) {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        Client client = findByName(txtClientName.getText());

        try {
            if (client != null) {
                alert.setTitle("Importante...!");
                alert.setContentText("Ya existe un administrador con este Nombre");
                alert.showAndWait();
                txtClientName.clear();
                txtClientName.requestFocus();
                return;
            }

            Client nuevo = new Client(txtClientName.getText(), txtPassword_Client.getText());

            if (getCabeza() == null) {
                nuevo.setSig(nuevo);
                nuevo.setAnt(nuevo);
                setCabeza(nuevo);
            } else {
                Client ultimo = getCabeza().getAnt();

                nuevo.setSig(getCabeza());
                nuevo.setAnt(ultimo);
                ultimo.setSig(nuevo);
                getCabeza().setAnt(nuevo);
                setCabeza(nuevo);
            }

            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setContentText("Registro realizado con éxito.\n¡Ya haces parte de nuestros clientes!");
            alert.showAndWait();

            txtClientName.clear();
            txtPassword_Client.clear();

        } catch (NumberFormatException e) {
            Logger.getLogger(List_Double_Admins.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void saveDataToFileTXT() {

        String direccion = System.getProperty("user.dir") + "\\src\\Files\\Clients.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Client actual = cabeza;

            do {
                writer.write(actual.getName_client()+ ", ");
                writer.write(actual.getPassword());
                
                writer.newLine();

                actual = actual.getSig();
            } while (actual != cabeza);          
        } catch (IOException e) {
            Logger.getLogger(List_Double_Admins.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadDataFromFileTXT() {

        String direccion = System.getProperty("user.dir") + "\\src\\Files\\Clients.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;

            cabeza = null;

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String name_client = atributos[0];
                String password = atributos[1];

                Client nuevo = new Client(name_client, password);

                if (getCabeza() == null) {
                    nuevo.setSig(nuevo);
                    nuevo.setAnt(nuevo);
                    setCabeza(nuevo);
                } else {
                    Client ultimo = getCabeza().getAnt();

                    nuevo.setSig(getCabeza());
                    nuevo.setAnt(ultimo);
                    ultimo.setSig(nuevo);
                    getCabeza().setAnt(nuevo);
                    setCabeza(nuevo);
                }
            }           
        } catch (IOException e) {
            Logger.getLogger(List_Double_Clients.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
