public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String auth, String titl, String isbn, String cNum,String collect){
	super(auth,titl,isbn,cNum);
	colelction = collect;
    }
}
