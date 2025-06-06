package Lists;

import Models.Admin;
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

public class List_Double_Admins {

    private Admin cabeza;

    public List_Double_Admins() {
        this.cabeza = null;
    }

    public Admin getCabeza() {
        return cabeza;
    }

    public void setCabeza(Admin cabeza) {
        this.cabeza = cabeza;
    }

    public Admin findByName(String name) {
        if (cabeza == null) {
            return null;
        }

        Admin actual = cabeza;
        
        do {
            if (actual.getName_admin().equals(name)) {
                return actual;
            }
            actual = actual.getSig();
        } while (actual != cabeza);
        return null;
    }

    public void addAmin(TextField txtAdminName, TextField txtPassword_Admin) {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        Admin admin = findByName(txtAdminName.getText());

        try {
            if (admin != null) {
                alert.setTitle("Importante...!");
                alert.setContentText("Ya existe un administrador con este Nombre");
                alert.showAndWait();
                txtAdminName.clear();
                txtAdminName.requestFocus();
                return;
            }

            Admin nuevo = new Admin(txtAdminName.getText(), txtPassword_Admin.getText());

            if (getCabeza() == null) {
                nuevo.setSig(nuevo);
                nuevo.setAnt(nuevo);
                setCabeza(nuevo);
            } else {
                Admin ultimo = getCabeza().getAnt();

                nuevo.setSig(getCabeza());
                nuevo.setAnt(ultimo);
                ultimo.setSig(nuevo);
                getCabeza().setAnt(nuevo);
                setCabeza(nuevo);
            }

            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setContentText("Registro realizado con éxito.\n¡Ya haces parte de nuestros administradores!");
            alert.showAndWait();

            txtAdminName.clear();
            txtPassword_Admin.clear();

        } catch (NumberFormatException e) {
            Logger.getLogger(List_Double_Admins.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void saveDataToFileTXT() {

        String direccion = System.getProperty("user.dir") + "\\src\\Files\\Admins.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Admin actual = cabeza;

            do {
                writer.write(actual.getName_admin()+ ", ");
                writer.write(actual.getPassword());
                
                writer.newLine();

                actual = actual.getSig();
            } while (actual != cabeza);          
        } catch (IOException e) {
            Logger.getLogger(List_Double_Admins.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadDataFromFileTXT() {

        String direccion = System.getProperty("user.dir") + "\\src\\Files\\Admins.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;

            cabeza = null;

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String name_admin = atributos[0];
                String password = atributos[1];

                Admin nuevo = new Admin(name_admin, password);

                if (getCabeza() == null) {
                    nuevo.setSig(nuevo);
                    nuevo.setAnt(nuevo);
                    setCabeza(nuevo);
                } else {
                    Admin ultimo = getCabeza().getAnt();

                    nuevo.setSig(getCabeza());
                    nuevo.setAnt(ultimo);
                    ultimo.setSig(nuevo);
                    getCabeza().setAnt(nuevo);
                    setCabeza(nuevo);
                }
            }           
        } catch (IOException e) {
            Logger.getLogger(List_Double_Admins.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
