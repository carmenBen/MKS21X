public class Driver{
  Barcode test = new Barcode(10019);
  System.out.println(test);
  System.out.println(test.getZip());
  System.out.println(test.getBar());
  System.out.println(test.equals(Barcode("10019")));
  System.out.println(test.compareTo(Barcode("10005")));
}
