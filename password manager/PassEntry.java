package Manager;

public class PassEntry {
   
    private String user;
    private String pass;
    
    public PassEntry() 
    {
        user = "";
        pass = "";
    }

    public PassEntry(String user, String pass)
    {
        this.user = user;
        this.pass = pass;
    }

    public String getUser()
    {
        return user;
    }

    public String getPass() 
    {
        return pass;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public void setPass(String pass) 
    {
        this.pass = pass;
    }

    public void printEntry() 
    {
        System.out.println("Username: " + user);
        System.out.println("Password: " + pass);
    }

}

