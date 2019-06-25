package LibraryCatalogue;

import java.util.HashMap;
import java.util.Map;

public class Main {
    
    Map<String,Books> BookCollection = new HashMap<>();
    int CurrentDay=0;
    int lengthofcheckoutperiod = 7;
    Double intiallatefee = 0.50;
    Double feeperlateday = 1.00;
    
    public Main(Map<String,Books> collection, int lenghtofcheckoutperiod,
            Double intiallatefee, Double feeperlateday){
        this.BookCollection = collection;
        this.lengthofcheckoutperiod = lengthofcheckoutperiod;
        this.intiallatefee = intiallatefee;
        this.feeperlateday = feeperlateday;
    }

    public Main(Map<String, Books> bookCollection) {
        this.BookCollection = bookCollection;  
    }
    
    public Map<String,Books> getbookcollection(){
        return this.BookCollection;
    }
    public int getcurrentday(){
        return this.CurrentDay;
    }
    public int getlengthofcheckoutperiod(){
        return this.lengthofcheckoutperiod;
    }
    public Books getbooks(String booktitle){
        return getbookcollection().get(booktitle);
    }
    public double getintiallatefees (){
     return this.intiallatefee;   
    }
    public double getfeeperlateday(){
        return this.feeperlateday;
    }
    
    public void nextday(){
        CurrentDay++;
    }
    public void setday(int day){
        CurrentDay = day;
    }
    
    public void checkoutbook(String title){
        Books book = getbooks(title);
        if(book.getIscheckedout()){
            sorrybookalreadycheckedout(book);
        } else{
            book.setIscheckedout(true, CurrentDay);
            System.out.println("You just checked out"+title+". It is due on day"
                    + (getcurrentday()+getlengthofcheckoutperiod())+".");
        }
    }
    public void returnbook(String title){
        Books book = getbooks(title);
        int dayslate = CurrentDay - (book.getdaycheckedout() + getlengthofcheckoutperiod());
        if(dayslate>0){
            System.out.println("You owe the library $" + (getintiallatefees() + dayslate * getfeeperlateday())+
                    "because your book is "+ dayslate + " days overdue");
        }else{
            System.out.println("Book Returned, ThankYou...!!!");
        }     
        book.setIscheckedout(false, -1);
    }
    public void sorrybookalreadycheckedout(Books book){
        System.out.println("Sorry...!!! "+book.gettitle()+" is already checkedout. "
                + "It should be back on the day" +
                book.getdaycheckedout()+getlengthofcheckoutperiod());
        
    }
    

    public static void main(String[] args) {
         Map<String, Books> bookCollection;
         bookCollection = new HashMap<>();
         Books harry = new Books("Harry Potter",8118,999999);
         bookCollection.put("Harry Potter", harry);
         Main lib = new Main(bookCollection);
         lib.checkoutbook("Harry Potter");
         lib.nextday();
         lib.nextday();
         lib.checkoutbook("Harry Potter");
         lib.setday(17);
         lib.returnbook("harry Potter");
         lib.checkoutbook("Harry Potter");
    }
    
}
