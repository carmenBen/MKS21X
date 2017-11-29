public class CirculatingBook extends LibraryBook{
  private String currentHolder, dueDate;

  public CirculatingBook(String auth, String titl, String isbn, String cNum){
    super(auth,titl,isbn,cNum);
    currentHolder = null;
    dueDate = null;
  }

  public void setCurrentHolder(String name){
    currentHolder = name;
  }

  public String getCurrentHolder(){
    return currentHolder;
  }

  public void setDueDate(String date){
    dueDate = date;
  }

  public String getDueDate(){
    return dueDate;
  }

  public void checkout(String patron, String due){
    setCurrentHolder(patron);
    setDueDate(due);
  }

  public void returned(){
    setCurrentHolder(null);
    setDueDate(null);
  }

  public String circulationStatus(){
    if(currentHolder == null){
      return "book available on shelves";
    }
    return currentHolder + " " + dueDate;
  }

  public String toString(){
    if(currentHolder == null){
      return getTitle() + ", " + getAuthor() + ", " + getISBN() + ", " + getCallNumber();
    }
    return getTitle() + ", " + getAuthor() + ", " + getISBN() + ", " + getCallNumber() + ", " + getCurrentHolder() + ", " + getDueDate();
  }
}
