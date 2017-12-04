public class Barcode implements Comparable<Barcode>{
  private String zip;

  public Barcode(String code){
    if(code.length() != 5){
	    throw new IllegalArgumentException();
    }
    for(int i = 0;i < 5;i++){
	    if(!Character.isDigit(code.charAt(i))){
        throw new IllegalArgumentException();
	    }
    }
    zip = code;
  }

  public String getZip(){
    return zip;
  }
    
  public static String toCode(String zip){
    if(zip.length() != 5){
	    throw new IllegalArgumentException();
    }
    for(int i = 0;i < 5;i++){
	    if(!Character.isDigit(zip.charAt(i))){
        throw new IllegalArgumentException();
	    }
    }
    String[] code = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    String total = "|";
    for(int i = 0; i < 5;i++){
	    total += code[Character.getNumericValue(zip.charAt(i))];
    }
    total += code[Barcode.checkSum(zip)] + "|";
    return total;
  }

  public static String toZip(String code){
    if(code.length() != 32 || code.charAt(0) != '|' || code.charAt(31) != '|'){
      throw new IllegalArgumentException();
    }
    String total = "";
    String current = "";
    boolean found = false;
    String[] bars = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    for(int j = 1;j < 31;j = j+5){
      current = code.substring(j,j+5);
      for(int i = 0;i < 10;i++){
        if(current.equals(bars[i])){
          total += i;
          found = true;
        }
      }
      if(!found){
        throw new IllegalArgumentException();
      }
      found = false;
    }
    if(Character.getNumericValue(total.charAt(5)) != Barcode.checkSum(total.substring(0,5))){
      throw new IllegalArgumentException();
    }
    return total.substring(0,5);
  }
    

  public String getCode(){
    return Barcode.toCode(zip);
  }

  public String toString(){
    return getCode() + "   (" + getZip() + ")";
  }

  public int compareTo(Barcode other){
    return getZip().compareTo(other.getZip());
  }

  public boolean equals(Barcode other){
    return getZip().equals(other.getZip());
  }

  private static int checkSum(String zip){
    int total = 0;
    for(int i = 0;i < 5; i++){
      total += Character.getNumericValue(zip.charAt(i));
    }
    return total % 10;
  }

}
