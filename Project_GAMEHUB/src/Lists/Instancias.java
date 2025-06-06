package Lists;

public class Instancias {

    private static Instancias instancias;
    private final List_Double_Admins listAdmins;
    private final List_Double_Clients listClients;

    public Instancias() {
        this.listAdmins = new List_Double_Admins();
        this.listClients = new List_Double_Clients();
    }

    public static Instancias getInstancias() {
        if (instancias == null) {
            instancias = new Instancias();
        }
        return instancias;
    }

    public List_Double_Admins getListAdmins() {
        return listAdmins;
    }

    public List_Double_Clients getListClients() {
        return listClients;
    }   
}
