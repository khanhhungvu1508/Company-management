import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        int data = 0;
        PersonInformation[] candidates = new PersonInformation[10000];
        AccountInformation[] candidatesAccount = new AccountInformation[10000];
        AccountManagement[] candidatesInformation = new AccountManagement[10000];
        listCandidateInformation[][] candidatesList = new listCandidateInformation[10000][10000];
        int[] salaryAccount = new int[10000];
        int[] ordercandidatesList = new int[10000];
        for (int i = 0; i < 10000; i++)     {salaryAccount[i] = 0; ordercandidatesList[i] = 0;}
        while (true)
        {
            System.out.print("Please choose mode to continue (Input 1 if you want to registers new account, 2 for login account, 3 for director): ");
            int mode = scanner.nextInt();
            if (mode == 1)
            {
                // Take information
                String position = ((data + 1) % 10 == 1)? "st candidate": ((data + 1) % 10 == 2)? "nd candidate": ((data + 1) % 10 == 3)? "rd candidate": "th candidate";
                System.out.println("Enter the information of " + (data + 1) + position);
                candidates[data] = new PersonInformation();
                candidates[data].giveInformation();
                boolean successfully = false;
                while (!successfully)
                {
                    while (!(candidates[data].getSubmit()))
                    {
                        System.out.println("Please submit to registers information!");
                        System.out.print("Please click Submit to finish the register: ");   
                        boolean check = scanner.nextBoolean();
                        candidates[data].setSubmit(check);
                    }
                    if (!(candidates[data].checkInformation()))
                    {
                        System.out.println("Please register again once to make sure all of information is true!");
                        candidates[data] = new PersonInformation();
                        candidates[data].giveInformation();
                    }
                    else
                        successfully = true;
                }
                candidates[data].PrintInformation();
                // Take account
                System.out.println("Now " + (data + 1) + position + " candidates take account which is used only for internal company use. Below is the information you must be do:");
                candidatesAccount[data] = new AccountInformation();
                candidatesAccount[data].giveAccount();
                boolean completely = false;
                while (!completely)
                {
                    while (!(candidatesAccount[data].getSubmitaccount()))
                    {
                        System.out.println("Please submit to take account!");
                        System.out.print("Please click Submit to finish take account: ");   
                        boolean check = scanner.nextBoolean();
                        candidatesAccount[data].setSubmitaccount(check);
                    }
                    if (!(candidatesAccount[data].checkAccount()))
                    {
                        System.out.println("Please take account again once to make sure all of information is true!");
                        candidatesAccount[data] = new AccountInformation();
                        candidatesAccount[data].giveAccount();
                    }
                    else
                        completely = true;
                }
                candidatesAccount[data].PrintAccount();
                data++;
            }
            else if (mode == 2)
            {
                Login candidatesLogin = new Login();
                candidatesLogin.giveAccountLogin();
                while (!(candidatesLogin.getSubmitlogin()))
                {
                    System.out.println("Please submit to login!");
                    System.out.print("Please click Submit to finish login: ");   
                    boolean check = scanner.nextBoolean();
                    candidatesLogin.setSubmitlogin(check);
                }
                boolean success = false;
                while (!success)
                {
                    int modeLogin;
                    while (candidatesLogin.checkAccountLogin() != true)
                    {
                        System.out.println("Your account or password format is not correct! Perhap you forget password.");
                        System.out.print("Please choose mode to continue (1 for continue login again, 2 for finding password forget): ");
                        modeLogin = scanner.nextInt();
                        boolean allowContinue = false;
                        while (!allowContinue)
                        {
                            if (modeLogin == 1)
                            {
                                candidatesLogin = new Login();
                                candidatesLogin.giveAccountLogin();
                                while (!(candidatesLogin.getSubmitlogin()))
                                {
                                    System.out.println("Please submit to login!");
                                    System.out.print("Please click Submit to finish login: ");   
                                    boolean check = scanner.nextBoolean();
                                    candidatesLogin.setSubmitlogin(check);
                                }
                                allowContinue = true;
                            }
                            else if (modeLogin == 2)
                            {
                                forgetPassword forgetCandidates = new forgetPassword();
                                forgetCandidates.forgetPasswordInformation();
                                while (!(forgetCandidates.getSubmitforgetPassword()))
                                {
                                    System.out.println("Please submit to give the password you forget!");
                                    System.out.print("Please click Submit to give the password you forget: ");   
                                    boolean checkforget = scanner.nextBoolean();
                                    forgetCandidates.setSubmitforgetPassword(checkforget);
                                }
                                boolean successforget = false;
                                while (!successforget)
                                {
                                    while (!(forgetCandidates.getSubmitforgetPassword()))
                                    {
                                        System.out.println("Please submit to give the password you forget!");
                                        System.out.print("Please click Submit to give the password you forget: ");   
                                        boolean checkforget = scanner.nextBoolean();
                                        forgetCandidates.setSubmitforgetPassword(checkforget);
                                    }
                                    for (int j = 0; j < data; j++)
                                    {
                                        if (forgetCandidates.getAccountFound().equals(candidatesAccount[j].getAccount()) == true)
                                        {
                                            System.out.println("Congratulation on you! Your password you need to find is " + candidatesAccount[j].getPassword());
                                            successforget = true;
                                            break;
                                        }
                                    }
                                    if (successforget == false)
                                    {
                                        System.out.println("Oop! Your account isn't exist. Please check the account again!");
                                        forgetCandidates = new forgetPassword();
                                        forgetCandidates.forgetPasswordInformation();
                                    }
                                }
                                modeLogin = 1;
                            }
                        }
                    }
                    for (int i = 0; i < data; i++)
                    {
                        if (candidatesLogin.getAccountlogin().equals(candidatesAccount[i].getAccount()) == true
                        && candidatesLogin.getPasswordlogin().equals(candidatesAccount[i].getPassword()) == true)
                        {
                            System.out.println("Your account is true!");
                            while (true)
                            {
                                System.out.print("Please choose the mode to continue (1 for see recently information from director, 2 for change password, 3 for log out): ");
                                int modeCandidate = scanner.nextInt();
                                if (modeCandidate == 1)
                                {
                                    System.out.println("Recently information from director of my company: ");
                                    for (int j = 0; j < ordercandidatesList[i]; j++)
                                    {
                                        System.out.println("The " + (j + 1) + " th information is:");
                                        candidatesList[i][j].printInformationCandidates();
                                        System.out.println("------------------------------------------------------------------------");
                                    }
                                }
                                else if (modeCandidate == 2)
                                {
                                    changedPassword changeCandidate = new changedPassword();
                                    System.out.println("Here are the information you declared to changed your current password: ");
                                    changeCandidate.changedPasswordInformation();
                                    while (!(changeCandidate.getSubmitchanged()))
                                    {
                                        System.out.println("Please submit to change your password!");
                                        System.out.print("Please click Submit to finish change your password: ");   
                                        boolean checksubmit = scanner.nextBoolean();
                                        changeCandidate.setSubmitchanged(checksubmit);
                                    }
                                    boolean stop = false;
                                    while(!stop)
                                    {
                                        while (changeCandidate.checkChangedPasswordInformation() != true)
                                        {
                                            changeCandidate = new changedPassword();
                                            changeCandidate.changedPasswordInformation();
                                            while (!(changeCandidate.getSubmitchanged()))
                                            {
                                                System.out.println("Please submit to change your password!");
                                                System.out.print("Please click Submit to finish change your password: ");   
                                                boolean checksubmit = scanner.nextBoolean();
                                                candidatesLogin.setSubmitlogin(checksubmit);
                                            }
                                        }
                                        if (!(changeCandidate.getCurrentAccount().equals(candidatesAccount[i].getAccount()) == true
                                        && changeCandidate.getCurrentPassword().equals(candidatesAccount[i].getPassword()) == true))
                                        {
                                            System.out.println("Your current account or password is incorrect! Please check the account and password one time!");
                                            changeCandidate = new changedPassword();
                                            changeCandidate.changedPasswordInformation();
                                        }
                                        else 
                                            stop = true;
                                    }
                                    changeCandidate.PrintChangedPasswordInformation();
                                    candidatesAccount[i].setPassword(changeCandidate.getNewPassword());
                                }
                                else if (modeCandidate == 3)
                                    break;
                            }
                            success = true;
                            break;
                        }
                    }
                    if (success == false)
                    {
                        System.out.println("Your account or password is not correct! Perhap you forget your password.");
                        System.out.print("Please choose mode to continue (1 for continue login again, 2 for finding password forget): ");
                        modeLogin = scanner.nextInt();
                        boolean allowContinue = false;
                        while (!allowContinue)
                        {
                            if (modeLogin == 1)
                            {
                                candidatesLogin = new Login();
                                candidatesLogin.giveAccountLogin();
                                while (!(candidatesLogin.getSubmitlogin()))
                                {
                                    System.out.println("Please submit to login!");
                                    System.out.print("Please click Submit to finish login: ");   
                                    boolean check = scanner.nextBoolean();
                                    candidatesLogin.setSubmitlogin(check);
                                }
                                allowContinue = true;
                            }
                            else if (modeLogin == 2)
                            {
                                forgetPassword forgetCandidates = new forgetPassword();
                                forgetCandidates.forgetPasswordInformation();
                                while (!(forgetCandidates.getSubmitforgetPassword()))
                                {
                                    System.out.println("Please submit to give the password you forget!");
                                    System.out.print("Please click Submit to give the password you forget: ");   
                                    boolean checkforget = scanner.nextBoolean();
                                    forgetCandidates.setSubmitforgetPassword(checkforget);
                                }
                                boolean successforget = false;
                                while (!successforget)
                                {
                                    while (!(forgetCandidates.getSubmitforgetPassword()))
                                    {
                                        System.out.println("Please submit to give the password you forget!");
                                        System.out.print("Please click Submit to give the password you forget: ");   
                                        boolean checkforget = scanner.nextBoolean();
                                        forgetCandidates.setSubmitforgetPassword(checkforget);
                                    }
                                    for (int j = 0; j < data; j++)
                                    {
                                        if (forgetCandidates.getAccountFound().equals(candidatesAccount[j].getAccount()) == true)
                                        {
                                            System.out.println("Congratulation on you! Your password you need to find is " + candidatesAccount[j].getPassword());
                                            successforget = true;
                                            break;
                                        }
                                    }
                                    if (successforget == false)
                                    {
                                        System.out.println("Oop! Your account isn't exist. Please check the account again!");
                                        forgetCandidates = new forgetPassword();
                                        forgetCandidates.forgetPasswordInformation();
                                    }
                                }
                                modeLogin = 1;
                            }
                        }
                    }
                }
            }
            else if (mode == 3)
            {
                DirectorManagement directorOnly = new DirectorManagement();
                directorOnly.AccountDirectorLogin();
                while (!(directorOnly.getSubmitAccount()))
                {
                    System.out.println("Please submit to login!");
                    System.out.print("Please click Submit to finish login: ");   
                    boolean check = scanner.nextBoolean();
                    directorOnly.setSubmitAccount(check);
                }
                while (directorOnly.checkAccountDirectorLogin() != true)
                {
                    directorOnly = new DirectorManagement();
                    directorOnly.AccountDirectorLogin();
                    while (!(directorOnly.getSubmitAccount()))
                    {
                        System.out.println("Please submit to login!");
                        System.out.print("Please click Submit to finish login: ");   
                        boolean check = scanner.nextBoolean();
                        directorOnly.setSubmitAccount(check);
                    }
                }
                System.out.println("Login successfully!");
                System.out.print("Please input the phone number of candidate: ");
                Scanner phoneNumber = new Scanner(System.in);
                String phoneofCandidates = phoneNumber.nextLine();
                int posofCandidates = -1;
                boolean existPhone = false;
                while (!existPhone)
                {
                    for (int i = 0; i < data; i++)
                    {
                        if (candidates[i].getPhone().equals(phoneofCandidates) == true)
                        {
                            posofCandidates = i;
                            existPhone = true;
                            break;
                        }
                    }
                    if (existPhone == false)
                    {
                        System.out.println("Your phone is not exist! Please check all information one more.");
                        System.out.print("Please input the phone number of candidate: ");
                        phoneofCandidates = phoneNumber.nextLine();
                    }
                }
                while (true)
                {
                    System.out.print("Please choose the mode to continue (1 for update salary of candidates, 2 for announcement the other information, 3 for information of candidate, 4 for log out): ");
                    int modeDirector = scanner.nextInt();
                    if (modeDirector == 1)
                    {
                        candidatesInformation[posofCandidates] = new AccountManagement();
                        candidatesInformation[posofCandidates].setSalary(salaryAccount[posofCandidates]);
                        candidatesInformation[posofCandidates].giveAccountLogin();
                        while (!(candidatesInformation[posofCandidates].getSubmitlist()))
                        {
                            System.out.println("Please submit to update salary!");
                            System.out.print("Please click Submit to finish update salary: ");   
                            boolean check = scanner.nextBoolean();
                            candidatesInformation[posofCandidates].setSubmitlist(check);
                        }
                        while (!(candidatesInformation[posofCandidates].checkAccountLogin()))
                        {
                            candidatesInformation[posofCandidates] = new AccountManagement();
                            candidatesInformation[posofCandidates].setSalary(salaryAccount[posofCandidates]);
                            candidatesInformation[posofCandidates].giveAccountLogin();
                            while (!(candidatesInformation[posofCandidates].getSubmitlist()))
                            {
                                System.out.println("Please submit to update salary!");
                                System.out.print("Please click Submit to finish update salary: ");   
                                boolean check = scanner.nextBoolean();
                                candidatesInformation[posofCandidates].setSubmitlist(check);
                            }
                        }
                        System.out.println("Congratulations! Here are the recent information about your salary:");
                        System.out.println("Name: " + candidates[posofCandidates].getName());
                        candidatesInformation[posofCandidates].PrintInformation();
                        salaryAccount[posofCandidates] = candidatesInformation[posofCandidates].getSalary();
                        String content = "Your recent salary is: " + salaryAccount[posofCandidates];
                        String notes = candidatesInformation[posofCandidates].getReason();
                        candidatesList[posofCandidates][ordercandidatesList[posofCandidates]] = new listCandidateInformation();
                        candidatesList[posofCandidates][ordercandidatesList[posofCandidates]].setContentofCandidate(content);
                        candidatesList[posofCandidates][ordercandidatesList[posofCandidates]].setNote(notes);
                        candidatesList[posofCandidates][ordercandidatesList[posofCandidates]].setSubmitContent(true);
                        ordercandidatesList[posofCandidates]++;
                    }
                    else if (modeDirector == 2)
                    {
                        candidatesList[posofCandidates][ordercandidatesList[posofCandidates]] = new listCandidateInformation();
                        candidatesList[posofCandidates][ordercandidatesList[posofCandidates]].addDirectorInformation();
                        while (!(candidatesList[posofCandidates][ordercandidatesList[posofCandidates]].getSubmitContent()))
                        {
                            System.out.println("Please submit to send newest information!");
                            System.out.print("Please click Submit to finish send newest information: ");   
                            boolean check = scanner.nextBoolean();
                            candidatesList[posofCandidates][ordercandidatesList[posofCandidates]].setSubmitContent(check);
                        }
                        System.out.println("Congratulations! Here are the recent information you want to send:");
                        candidatesList[posofCandidates][ordercandidatesList[posofCandidates]].printInformationCandidates();
                        ordercandidatesList[posofCandidates]++;
                    }
                    else if (modeDirector == 3)
                        candidates[posofCandidates].seeInformation();
                    else if (modeDirector == 4)
                        break;
                }
            }
        }
    }
}

