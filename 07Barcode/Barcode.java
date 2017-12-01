public class Barcode implements Comparable<Barcode>{
  private String zip;

  public Barcode(String code){
    zip = code;
  }

  public String getZip(){
    return zip;
  }

  public String getBar(){
    String total = "|";
    for(int i = 0; i < 5;i++){
      total += convertToBar(getZip().charAt(i));
    }
    total += convertToBar(checkSum()) + "|";
    return total;
  }

  public String toString(){
    return getBar() + "   " + getZip();
  }

  public int compareTo(Barcode other){
    return getZip().compareTo(other.getZip());
  }

  public boolean equals(Barcode other){
    return getZip().equals(other.getZip());
  }

  private char checkSum(){
    int total = 0;
    for(int i = 0;i < 5; i++){
      total += Character.getNumericValue(getZip().charAt(i));
    }
    return (char)('0' + (total % 10));
  }

  private String convertToBar(char a){
    String[] code = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    return code[Character.getNumericValue(a)];
  }
}
