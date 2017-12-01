public class Java implements Comparable<Barcode>{
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
      total += getZip().charAt(i).convertToBar();
    }
    total += checkSum().convertToBar() + "|";
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
}
