import java.util.Scanner;
import java.util.regex.*;
 
public class AccountManagement extends PersonInformation
{
    private static int salary;
    private int add, substract;
    private String reason;
    private boolean submitlist;
    Scanner manageNum = new Scanner(System.in);
    Scanner manageNote = new Scanner(System.in);
    
    // Default constructor when not declared anything
    public AccountManagement() 
    {
        super();
        this.salary = 0;
        this.add = 0; 
        this.substract = 0;
        this.reason = "???";
        this.submitlist = false;
    }
    
    // The information will be sent to management system when declared anything
    public AccountManagement (int salary, int add, int substract, String reason, boolean submitlist)
    {
        super();
        this.salary = salary;
        this.add = add;
        this.substract = substract;
        this.reason = "???";
        this.submitlist = false;
    }
    
    public int      getSalary()                                 {return salary + add - substract;}
    public int      getAdd()                                    {return add;}
    public int      getSubstract()                              {return substract;}
    public String   getReason()                                 {return reason;}
    public boolean  getSubmitlist()                             {return submitlist;}
    public void     setSalary (int salary)                      {this.salary = salary;}
    public void     setAdd (int add)                            {this.add = add;}
    public void     setSubstract (int substract)                {this.substract = substract;}
    public void     setReason (String reason)                   {this.reason = reason;}
    public void     setSubmitlist (boolean submitlist)          {this.submitlist = submitlist;}
    
    public void giveAccountLogin()
    {
        System.out.println("Here is the recent salary: " + salary); 
        System.out.print("The amount of money added: ");                                        add = manageNum.nextInt();
        System.out.print("The amount of money substracted: ");                                  substract = manageNum.nextInt();
        System.out.print("Note: ");                                                             reason = manageNote.nextLine();
        System.out.print("Please click Submit to finish information (Input true or false): ");  submitlist = manageNum.nextBoolean();
    }
    
    public boolean checkAccountLogin() 
    {
        if (add < 0)
        {
            System.out.println("The amount of money added is not valid. Please check it again!");
            return false;
        }
        if (substract < 0)
        {
            System.out.println("The amount of money substracted is not valid. Please check it again!");
            return false;
        }
        return true;
    }
    
    public void PrintInformation()
    {
        System.out.println("Recent salary: " + getSalary());
        System.out.println("Note: " + this.reason);
    }
}