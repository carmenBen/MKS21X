public class OrderedSuperArray extends SuperArray{

  /*constructor initializes an empty List*/
  public OrderedSuperArray(){
    super();
  }

  public OrderedSuperArray(int capacity){
    super(capacity);
  }

  public OrderedSuperArray(String[] ary){
    super(ary.length);
    for(int i = 0;i < ary.length;i++){
	    add(ary[i]);
    }
  }

  /*call the proper add.*/
  public void add(int index, String value){
    add(value);
  }

  /*Write this method and any
    appropriate helper methods.*/
  public boolean add(String value){
    //add to the correct spot.
    //you may still use super.add(index,value)
    int index = this.indexOf(value);
    super.add(index,value);
    return true;
  }

  public int indexOf(String value){
    int index = 0;
    for(int i = 0;i < this.size();i++){
	    if(this.get(i).compareTo(value) < 0){
        index = i+1;
	    }
    }
    return index;
  }

  public int findIndexOfBinary(String value){
    int start = 0;
    int end = this.size();
    int mid = end / 2;
    int index = 0;
    boolean found = false;
    while(!found)
	    if(end == 0){
        return 0;
	    }
	    else if(value.compareTo(this.get(size() - 1)) > 0){
        return size();
	    }
	    else if(value.compareTo(this.get(mid)) < 0){
        end = mid;
        mid = (start + end) / 2;
      }
	    else if(value.compareTo(this.get(mid)) > 0){
        start = mid;
        mid = (start + end) / 2;
	    }
	    else{
        found = true;
        index = mid;
	    }
    return index;
  }

public int indexOfBinary(String value){
	int start = 0;
	int end = this.size();
	int mid = end / 2;
	int index = 0;
	boolean found = false;
	while(!found){
    if(!contains(value) || end == 0 || value.compareTo(this.get(size() - 1)) > 0 || (value.compareTo(this.get(0)) < 0)){
      return -1;
    }
    else if(value.compareTo(this.get(mid)) < 0){
      end = mid;
      mid = (start + end) / 2;
    }
    else if(value.compareTo(this.get(mid)) > 0){
      start = mid;
      mid = (start + end) / 2;
    }
    else if(value.compareTo(this.get(mid)) == 0){
      found = true;
      index = mid;
    }
    else{
      return -1;
    }
	}
	return index;
}

public int lastIndexOf(String element){
	int indexCheck = indexOfBinary(element);
	int index = indexCheck;
	boolean check = false;
	while(!check){
    if(element.compareTo(this.get(index + 1)) == 0){
      index++;
    }
    else{
      check = true;
    }
	}
	return index;
}

public String set(int index, String element){
  throw new UnsupportedOperationException();
}
}
