import java.util.Scanner;
import java.util.regex.*;
 
public class changedPassword extends PersonInformation
{
    private String currentAccount, currentPassword;
    private String newPassword, repeatnewPassword;
    private boolean submitchanged;
    Scanner changedpass = new Scanner(System.in);
    
    // Default constructor when not declared anything
    public changedPassword() 
    {
        super();
        this.currentAccount = "???";
        this.currentPassword = "???"; 
        this.newPassword = "???";
        this.repeatnewPassword = "???";
        this.submitchanged = false;
    }
    
    // The information will be sent to management system when declared anything
    public changedPassword (String currentAccount, String currentPassword, String newPassword, String repeatnewPassword, boolean submitchanged)
    {
        super();
        this.currentAccount = currentAccount;
        this.currentPassword = currentPassword; 
        this.newPassword = newPassword;
        this.repeatnewPassword = repeatnewPassword;
        this.submitchanged = submitchanged;
    }
    
    public String   getCurrentAccount()                             {return currentAccount;}
    public String   getCurrentPassword()                            {return currentPassword;}
    public String   getNewPassword()                                {return newPassword;}
    public String   getRepeatnewPassword()                          {return repeatnewPassword;}
    public boolean  getSubmitchanged()                              {return submitchanged;}
    public void     setCurrentAccount (String currentAccount)       {this.currentAccount = currentAccount;}
    public void     setCurrentPassword (String currentPassword)     {this.currentPassword = currentPassword;}
    public void     setNewPassword (String newPassword)             {this.newPassword = newPassword;}
    public void     setRepeatnewPassword (String repeatnewPassword) {this.repeatnewPassword = repeatnewPassword;}
    public void     setSubmitchanged (boolean submitchanged)        {this.submitchanged = submitchanged;}
    
    public void changedPasswordInformation()
    {
        System.out.print("Current account: ");                                                      currentAccount = changedpass.nextLine();
        System.out.print("Current password: ");                                                     currentPassword = changedpass.nextLine();
        System.out.print("New password: ");                                                         newPassword = changedpass.nextLine();
        System.out.print("Please repeat new password one time: ");                                  repeatnewPassword = changedpass.nextLine();
        System.out.print("Please click Submit to finish changed password (Input true or false): "); submitchanged = changedpass.nextBoolean();
    }
    
    public boolean checkChangedPasswordInformation() 
    {
        if (!(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", newPassword)))
        {
            System.out.println("Your new password is not valid. Please check the password one time!");
            return false;
        }
        if (newPassword.equals(currentPassword) == true)
        {
            System.out.println("Your new password is same as old password! It's invalid. Please check new password one time!");
            return false;
        }
        if (newPassword.equals(repeatnewPassword) == false)
        {
            System.out.println("Your new password repeat is not compatible with the new password you wanted. Please check 2 new passwords one time!");
            return false;
        }
        return true;
    }
    
    public void PrintChangedPasswordInformation()
    {
        System.out.println("Congratulation on you! Your passwords was changed successfully. Here are the information about your account:");
        System.out.println("Account: " + this.currentAccount);
        System.out.println("New password: " + this.newPassword);
    }
}