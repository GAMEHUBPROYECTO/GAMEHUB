package Models;

public class Admin {
        
    private String name_admin;
    private String password;
    private Admin sig, ant;
    
    public Admin(String name_admin, String password) {
        this.name_admin = name_admin;
        this.password = password;
        this.sig = null;
        this.ant = null;
    }

    public String getName_admin() {
        return name_admin;
    }

    public void setName_admin(String name_admin) {
        this.name_admin = name_admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }        

    public Admin getSig() {
        return sig;
    }

    public void setSig(Admin sig) {
        this.sig = sig;
    }

    public Admin getAnt() {
        return ant;
    }

    public void setAnt(Admin ant) {
        this.ant = ant;
    }        
}
