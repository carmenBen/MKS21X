public class ReferenceBook extends LibraryBook{
  private String collection;

  public ReferenceBook(String auth, String titl, String isbn, String cNum,String collect){
    super(auth,titl,isbn,cNum);
    collection = collect;
  }
    
  public String getCollection(){
    return collection;
  }

  public void setCollection(String collect){
    collection = collect;
  }

  public String toString(){
    return getTitle() + ", " + getAuthor() + ", " + getISBN() + ", " + getCallNumber() + ", " + collection;
  }

  public void checkout(String patron, String due){
    System.out.println("Can't check out a reference book");
  }

  public void returned(){
    System.out.println("Reference book could not have been checked out -- return impossible");
  }

  public String circulationStatus(){
    return "non-circulating reference book";
  }
}
