import java.util.Scanner;
import java.util.regex.*;
 
public class Login extends AccountInformation
{
    private String accountlogin, passwordlogin;
    private boolean submitlogin;
    Scanner scanner = new Scanner(System.in);
     
    // Default constructor when not declared anything
    public Login() 
    {
        super();
        this.accountlogin = "???";
        this.passwordlogin = "???"; 
        this.submitlogin = false;
    }
    
    // The information will be sent to management system when declared anything
    public Login (String accountlogin, String passwordlogin, boolean submitlogin)
    {
        super();
        this.accountlogin = accountlogin;
        this.passwordlogin = passwordlogin;
        this.submitlogin = submitlogin;
    }
    
    public String   getAccountlogin()                           {return accountlogin;}
    public String   getPasswordlogin()                          {return passwordlogin;}
    public boolean  getSubmitlogin()                            {return submitlogin;}
    public void     setAccountlogin (String accountlogin)       {this.accountlogin = accountlogin;}
    public void     setPasswordlogin (String passwordlogin)     {this.passwordlogin = passwordlogin;}
    public void     setSubmitlogin (boolean submitlogin)        {this.submitlogin = submitlogin;}
    
    public void giveAccountLogin()
    {
        System.out.print("Account: ");                                                          accountlogin = scanner.nextLine();
        System.out.print("Password: ");                                                         passwordlogin = scanner.nextLine();
        System.out.print("Please click Submit to finish login (Input true or false): ");        submitlogin = scanner.nextBoolean();
    }
    
    public boolean checkAccountLogin() 
    {
        if (!(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", passwordlogin)))
            return false;
        return true;
    }
}