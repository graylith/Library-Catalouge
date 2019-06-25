package LibraryCatalogue;

public class Books {
    
    String title;
    int pagecount;
    int ISBN;
    boolean Ischeckedout;
    int daycheckedout = -1;

    Books(String booktitle, int bookpagecount, int bookISBN){
        this.title = booktitle;
        this.pagecount = bookpagecount;
        this.ISBN = bookISBN;
        Ischeckedout = false;
    }
    
    //getters
    public String gettitle(){
        return this.title;
    }
    public int getpagecount(){
        return this.pagecount;
    }
    public int getISBN(){
        return this.ISBN;
    }
    public boolean getIscheckedout(){
        return this.Ischeckedout;
    }
    public int getdaycheckedout(){
        return this.daycheckedout;
    }
    //setters
   //  public void settitle(String newbooktitle){
    //     this.title = newbooktitle;
     //}
    // public void setISBN(int newISBN){
      //   this.ISBN = newISBN;
    // }
     //public void setpagecount(int newpagecount){
       //  this.pagecount = newpagecount;
    // }
     public void setIscheckedout(boolean newIscheckedout, int currentdaycheckout){
         this.Ischeckedout = newIscheckedout;
         setdaycheckedout(currentdaycheckout);
     }
     public void setdaycheckedout(int newdaycheckedout){
         this.daycheckedout = newdaycheckedout;
     }
}