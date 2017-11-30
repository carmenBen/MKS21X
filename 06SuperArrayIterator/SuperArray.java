import java.util.Iterator;


public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
    
    public SuperArray(){
	data = new String[10];
    }

    public SuperArray(int startingCapacity){
	data = new String[startingCapacity];
    }

	public void clear(){
	for(int i = 0;i < size;i++){
	    data[i] = null;
	}
	size = 0;
    }
    
    public int size(){
	return size;
    }

    public boolean isEmpty(){
	if(size == 0){
	    return true;
	}
	return false;
    }

    public boolean add(String element){
	if(data.length == size){
	    this.resize();
	}
	data[size] = element;
	size++;
	return true;
    }

    public String toString(){
	String total = "[";
	for(int i = 0;i < size - 1;i++){
	    total = total + data[i] + ",";
	}
	if(size != 0){
	    total += data[size - 1];
	}
	total += "]";
	return total;
    }

    public String get(int index){
	if(index < 0 || index>= size){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public String set(int index, String element){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	String old = data[index];
	data[index] = element;
	return old;
    }

    private void resize(){
	String[] newData = new String[size * 2 + 1];
	for(int i = 0;i < size;i++){
	    newData[i] = data[i];
	}
	data = newData;
    }

    public boolean contains(String element){
	for(int i = 0;i < size;i++){
	    if(data[i] == element){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String element){
	for(int i = 0;i < size;i++){
	    if(data[i] == element){
		return i;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String element){
	for(int i = size - 1;i >= 0;i--){
	    if(data[i] == element){
		return i;
	    }
	}
	return -1;
    }

    public void add(int index, String element){
	if(!(index < 0) && !(index > size)){
	    if(data.length == size){
		this.resize();
	    }
	    for(int i = size - 1;i >= index;i--){
		data[i+1] = data[i];
	    }
	    size++;
	    data[index] = element;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }
  
    public String remove(int index){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	String remember = data[index];
	for(int i = index + 1;i < size;i++){
	    data[i- 1] = data[i];
	}
	size--;
	return remember;
    }

    public boolean remove(String element){
	int index = this.indexOf(element);
	if(this.remove(index) == element){
	    return true;
	}
	return false;
    }
}
