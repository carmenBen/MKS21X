public class Driver{
  public static void main(String[] args){
    Barcode test = new Barcode("10019");
    System.out.println(test);
    System.out.println(test.getZip());
    System.out.println(test.getBar());
    System.out.println(test.equals(new Barcode("10019")));
    System.out.println(test.compareTo(new Barcode("10005")));
  }
}
