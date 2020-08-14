import java.util.Scanner;
import java.util.regex.*;
 
public class DirectorManagement extends PersonInformation
{
    private String accountDirector, passwordDirector;
    private boolean submitAccount;
    Scanner Information = new Scanner(System.in);
    
    // Default constructor when not declared anything
    public DirectorManagement() 
    {
        super();
        this.accountDirector = "???";
        this.passwordDirector = "???"; 
        this.submitAccount = false;
    }
    
    // The information will be sent to management system when declared anything
    public DirectorManagement (String accountDirector, String passwordDirector, boolean submitAccount)
    {
        super();
        this.accountDirector = accountDirector;
        this.passwordDirector = passwordDirector;
        this.submitAccount = submitAccount;
    }
    
    public String   getAccountDirector()                            {return accountDirector;}
    public String   getPasswordDirector()                           {return passwordDirector;}
    public boolean  getSubmitAccount()                              {return submitAccount;}
    public void     setAccountDirector (String accountDirector)     {this.accountDirector = accountDirector;}
    public void     setPasswordDirector (String passwordDirector)   {this.passwordDirector = passwordDirector;}
    public void     setSubmitAccount (boolean submitAccount)        {this.submitAccount = submitAccount;}
    
    public void AccountDirectorLogin()
    {
        System.out.print("Account: ");                                                          accountDirector = Information.nextLine();
        System.out.print("Password: ");                                                         passwordDirector = Information.nextLine();
        System.out.print("Please click Submit to finish login (Input true or false): ");        submitAccount = Information.nextBoolean();
    }
    
    public boolean checkAccountDirectorLogin() 
    {
        if (!accountDirector.equals("@directorteams@2020"))
        {
            System.out.println("Account or password for director is incorrect. Please login again!");
            return false;
        }
        if (!passwordDirector.equals("directorteams123%2020"))
        {
            System.out.println("Account or password for director is incorrect. Please login again!");
            return false;
        }
        return true;
    }
}