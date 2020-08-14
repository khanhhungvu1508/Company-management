import java.util.Scanner;
import java.util.regex.*;
 
public class AccountInformation extends PersonInformation
{
    private String account, password, repeatpassword;
    private boolean submitaccount;
    Scanner scanner = new Scanner(System.in);
     
    // Default constructor when not declared anything
    public AccountInformation() 
    {
        super();
        this.account = "???";
        this.password = "???"; 
        this.repeatpassword = "???";
        this.submitaccount = false;
    }
    
    // The information will be sent to management system when declared anything
    public AccountInformation (String account, String password, String repeatpassword, boolean submitaccount)
    {
        super();
        this.account = account;
        this.password = password;
        this.repeatpassword = repeatpassword;
        this.submitaccount = submitaccount;
    }
    
    public String   getAccount()                                {return account;}
    public String   getPassword()                               {return password;}
    public String   getRepeatpassword()                         {return repeatpassword;}
    public boolean  getSubmitaccount()                          {return submitaccount;}
    public void     setAccount (String account)                 {this.account = account;}
    public void     setPassword (String password)               {this.password = password;}
    public void     setRepeatpassword (String repeatpassword)   {this.repeatpassword = repeatpassword;}
    public void     setSubmitaccount (boolean submitaccount)    {this.submitaccount = submitaccount;}
    
    public void giveAccount()
    {
        System.out.print("Account: ");                                                              account = scanner.nextLine();
        System.out.print("Password: ");                                                             password = scanner.nextLine();
        System.out.print("Please repeat password one time: ");                                      repeatpassword = scanner.nextLine();
        System.out.print("Please click Submit to finish take account (Input true or false): ");     submitaccount = scanner.nextBoolean();
    }
    
    public boolean checkAccount() 
    {
        if (!(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", password)))
        {
            System.out.println("Your password is not valid. Please check the password one time!");
            return false;
        }
        if (password.equals(repeatpassword) == false)
        {
            System.out.println("Your password repeat is not compatible with the password you wanted. Please check 2 passwords one time!");
            return false;
        }
        return true;
    }
    public void PrintAccount()
    {
        System.out.println("Congratulation on you! You have finished to register account to us!. Now you can use the account for work!");
        System.out.println("Your account: " + this.account);
        System.out.println("Your password: " + this.password);
    }
}