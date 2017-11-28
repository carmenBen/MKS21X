public class Book{
    private String author, title, ISBN;

    public Book(){
	author = "";
	title = "";
	ISBN = "";
    }

    public Book(String auth, String titl, String isbn){
	author = auth;
	title = titl;
	ISBN = isbn;
    }

    public void setAuthor(String auth){
	author = auth;
    }

    public void setTitle(String titl){
	title = titl;
    }

    public void setISBN(String isbn){
	ISBN = isbn;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN + "\n";
    }
}
