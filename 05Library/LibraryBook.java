abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String auth, String titl, String isbn, String cNum){
        setAuthor(auth);
	setTitle(titl);
	setISBN(isbn);
	callNumber = cNum;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String cNum){
	callNumber = cNum;
    }

    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public String toString(){
	return getTitle() + ", " + getAuthor() + ", " + getISBN() + ", " + getCallNumber() + ", " + circulationStatus() + "\n";
    }

    public int compareTo(LibraryBook other){
	return getCallNumber().compareTo(other.getCallNumber());
    }
}
