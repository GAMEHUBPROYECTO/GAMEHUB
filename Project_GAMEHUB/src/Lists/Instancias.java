package Lists;

public class Instancias {

    private static Instancias instancias;
    private final List_Double_Admins list_admins;
    private final List_Double_Clients list_clients;
    private final Stacks_Games stacks_games;
    
    public Instancias() {
        this.list_admins = new List_Double_Admins();
        this.list_clients = new List_Double_Clients();
        this.stacks_games = new Stacks_Games();
    }

    public static Instancias getInstancias() {
        if (instancias == null) {
            instancias = new Instancias();
        }
        return instancias;
    }

    public List_Double_Admins getList_admins() {
        return list_admins;
    }

    public List_Double_Clients getList_clients() {
        return list_clients;
    }   

    public Stacks_Games getStacks_games() {
        return stacks_games;
    }        
}
