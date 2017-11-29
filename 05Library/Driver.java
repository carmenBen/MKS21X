public class Driver{
  public static void main(String[] args){
    /*Book test = new Book("JK Rowling","Harry Potter","123456789");
    System.out.println(test);
    System.out.println(test.getAuthor());
    test.setTitle("Goblet of Fire");
    System.out.println(test);*/

    ReferenceBook test = new ReferenceBook("JK Rowling","Harry Potter","123456789","748498484","Stuy Library");
    System.out.println(test);
    test.checkout("hi","111");
  }
}
