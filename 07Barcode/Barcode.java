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
