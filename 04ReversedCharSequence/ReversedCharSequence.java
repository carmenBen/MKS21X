public class ReversedCharSequence implements CharSequence{
    private String data;
    
    public static void main(String[] args){
	String test = "abcdefg";
	ReversedCharSequence result = new ReversedCharSequence(test);
	System.out.println(result);
	System.out.println(result.charAt(0));
	System.out.println(result.length());
       	System.out.println(result.subSequence(0,3));	
    }

    public ReversedCharSequence(String text){
	int len = text.length();
	data = "";
	for(int i = len;i > 0;i--){
	    data += text.substring(i - 1,i);
	}
    }

    public int length(){
	return data.length();
    }

    public char charAt(int index){
	return data.charAt(index);
    }

    public String toString(){
	return data;
    }
    
    public CharSequence subSequence(int start,int end){
	return data.substring(start,end);
    }
}
