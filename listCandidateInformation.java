import java.util.Scanner;
import java.util.regex.*;
 
public class listCandidateInformation extends PersonInformation
{
    private String contentofCandidate;
    private String note;
    private boolean submitContent;
    Scanner list = new Scanner(System.in);
    
    // Default constructor when not declared anything
    public listCandidateInformation() 
    {
        super();
        this.contentofCandidate = "???";
        this.note = "???"; 
        this.submitContent = false;
    }
    
    // The information will be sent to management system when declared anything
    public listCandidateInformation (String contentofCandidate, String note, boolean submitContent)
    {
        super();
        this.contentofCandidate = contentofCandidate;
        this.note = note;
        this.submitContent = submitContent;
    }
    
    public String   getContentofCandidate()                             {return contentofCandidate;}
    public String   getNote()                                           {return note;}
    public boolean  getSubmitContent()                                  {return submitContent;}
    public void     setContentofCandidate (String contentofCandidate)   {this.contentofCandidate = contentofCandidate;}
    public void     setNote (String note)                               {this.note = note;}
    public void     setSubmitContent(boolean submitContent)             {this.submitContent = submitContent;}
    
    public void addDirectorInformation()
    {
        System.out.print("Please input the content you want send: ");               contentofCandidate = list.nextLine();
        System.out.print("Note: ");                                                 note = list.nextLine();
        System.out.print("Please click Submit to finish (Input true or false): ");  submitContent = list.nextBoolean();
    }
    
    public void printInformationCandidates()
    {
        System.out.println("Content: " + this.contentofCandidate);
        System.out.println("Note: " + this.note);
    }
}