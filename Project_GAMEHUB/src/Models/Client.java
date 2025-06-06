package Models;

public class Client {
    
    private String name_client;
    private String password;
    private Client sig, ant;
    
    public Client(String name_client, String password) {
        this.name_client = name_client;
        this.password = password;
        this.sig = null;
        this.ant = null;        
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   

    public Client getSig() {
        return sig;
    }

    public void setSig(Client sig) {
        this.sig = sig;
    }

    public Client getAnt() {
        return ant;
    }

    public void setAnt(Client ant) {
        this.ant = ant;
    }        
}
