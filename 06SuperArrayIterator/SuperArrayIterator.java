import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private int current, end;
    private SuperArray data;

    public SuperArrayIterator(SuperArray info){
	data = info;
	current = 0;
	end = info.size() - 1;
    }
    
    public String next(){
	current++;
	return data.get(current - 1);
    }

    public boolean hasNext(){
	return current < end;
    }
}
