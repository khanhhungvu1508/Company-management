import java.util.*;
import java.util.regex.*;
 
public class forgetPassword extends PersonInformation
{
    private String accountFound, otpcode, repeatotpcode;
    private boolean submitforgetPassword;
    private int leftLimit = 48, rightLimit = 122, targetStringLength = 6;
    Scanner forgetpass = new Scanner(System.in);
    
    // Default constructor when not declared anything
    public forgetPassword() 
    {
        super();
        this.accountFound = "???";
        this.otpcode = "???"; 
        this.repeatotpcode = "???";
        this.submitforgetPassword = false;
    }
    
    // The information will be sent to management system when declared anything
    public forgetPassword (String accountFound, String otpcode, String repeatotpcode, boolean submitforgetPassword)
    {
        super();
        this.accountFound = accountFound;
        this.otpcode = otpcode; 
        this.repeatotpcode = repeatotpcode;
        this.submitforgetPassword = submitforgetPassword;
    }
    
    public String   getAccountFound()                                       {return accountFound;}
    public String   getOTPcode()                                            {return otpcode;}
    public String   getRepeatOTPcode()                                      {return repeatotpcode;}
    public boolean  getSubmitforgetPassword()                               {return submitforgetPassword;}
    public void     setAccountFound (String accountFound)                   {this.accountFound = accountFound;}
    public void     setOTPcode (String otpcode)                             {this.otpcode = otpcode;}
    public void     setRepeatOTPcode (String repeatotpcode)                 {this.repeatotpcode = repeatotpcode;}
    public void     setSubmitforgetPassword (boolean submitforgetPassword)  {this.submitforgetPassword = submitforgetPassword;}
    
    public void forgetPasswordInformation()
    {
        System.out.print("Your account: ");                                                                 accountFound = forgetpass.nextLine();
        System.out.println("The OTPcode will be sent in your phone. Please open your phone to know the OTP code");
        System.out.print("*In your phone message: Your OTP to take the password you forget is: ");
        Random random = new Random();
        otpcode = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.print(otpcode + "\n");
        System.out.print("Please input the OTP code: ");                                                    repeatotpcode = forgetpass.nextLine();
        System.out.print("Please click Submit to give the password you forget (Input true or false): ");    submitforgetPassword = forgetpass.nextBoolean();
    }
    
    public boolean checkforgetPasswordInformation() 
    {
        if (repeatotpcode.equals(otpcode) == false)
        {
            System.out.println("Your OTP don't the OTP code in your phone! It's invalid. Please check the OTP one time!");
            return false;
        }
        return true;
    }
    
}