import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;

    /**Initialize the grid to the size specified

     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols,String fileName){
	data = new char[rows][cols];
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
    

	//fills wordsToAdd list
	try{
	    File f = new File(fileName);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String line = in.nextLine();
		wordsToAdd.add(line);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}

	//creates seed and returns it
	int seed = (int)(Math.random()*100000);
	System.out.println("Seed: "+ seed);
	randgen = new Random(seed);

	//creates empty grid
	for(int i = 0;i < rows;i++){
	    for(int j = 0;j < cols;j++){
		data[i][j] = '_';
	    }
	}

	//add words to word search
	addAllWords();
    }

    //wordserch with seed given
    public WordSearch( int rows, int cols, String fileName, int randSeed){
	data = new char[rows][cols];
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();


	//fills wordsToAdd list
	try{
	    File f = new File(fileName);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String line = in.nextLine();
		wordsToAdd.add(line);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}

	//creates random number based off seed
	int seed = randSeed;
	randgen = new Random(seed);

	//creates empty grid
	for(int i = 0;i < rows;i++){
	    for(int j = 0;j < cols;j++){
		data[i][j] = '_';
	    }
	}

	//fills grid
	addAllWords();
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for(int i = 0;i < data.length;i++){
	    for(int j = 0;j < data[i].length;j++){
		data[i][j] = '_';
	    }
	}
    }

    //fills wordsearch by replacing '_' with random letters
    public void fill(){
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	for(int i = 0;i < data.length;i++){
	    for(int j = 0;j < data[i].length;j++){
		if(data[i][j] == '_'){
		    data[i][j] = alphabet.charAt(Math.abs(randgen.nextInt() % 26));
		}
	    }
	}
    }

    //returns list of words included in word search
    public String wordList(){
	String total = "";
	for(int i = 0;i < wordsAdded.size();i++){
	    total += wordsAdded.get(i) + "\n";
	}
	return total;
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String total = "";
	for(int i = 0;i < data.length;i++){
	    for(int j = 0;j < data[i].length ;j++){
		total += data[i][j] + " ";
	    }
	    total += "\n";
	}
	return total;
    }

    private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement){
	r = Math.abs(r);
	c = Math.abs(c);
	int row = r;
	int col = c;
	if(rowIncrement == 0 && colIncrement == 0){
	    return false;
	}

	//check if the word fits
	if((rowIncrement == 1 && row + word.length() >  data.length) || (rowIncrement == -1 && row - word.length() < 0) || (colIncrement == 1 && col + word.length() > data[0].length) || (colIncrement == -1 && col - word.length() < 0)){
	    return false;
	}

	//check if overlaps with words illegally
	for(int i = 0;i < word.length();i++){
	    if(data[row][col] != '_' && data[row][col] != word.charAt(i)){
		return false;
	    }
	    row += rowIncrement;
	    col += colIncrement;
	}
    
	row = r;
	col = c;
	//inserts word letters
	for(int i = 0;i < word.length();i++){
	    data[row][col] = word.charAt(i);
	    row += rowIncrement;
	    col += colIncrement;
	}
	return true;
    }

    private boolean addAllWords(){
	for(int i = 0;i < 10000;i++){
	    if(wordsToAdd.isEmpty()){
		return true;
	    }
	    //picks a word to try and add
	    int index = Math.abs(randgen.nextInt() % wordsToAdd.size());
	    //attempts to add word
	    if(addWord(randgen.nextInt() % data.length,randgen.nextInt() % data[0].length,wordsToAdd.get(index),1 - Math.abs(randgen.nextInt() % 3),1 - Math.abs(randgen.nextInt() % 3))){
		wordsAdded.add(wordsToAdd.get(index));
		wordsToAdd.remove(index);
	    }
	}
	return true;
    }

    public static void main(String[] args){
	String instructions = "Hi! To play please enter the number of rows and columns the Wordsearch should have, followed by a file name. If you have a seed enter it after. Finally, include a 'key' if you would like to print the answers. The format should be: java WordSearch rows cols fileName seed key.";

	// checks at least 3 args
	if(args.length < 3){
	    System.out.println(instructions);
	}

	//creates word searches with provided info if possible, returns instructions if invalid entry datatype.
	else{
	    //check cols != 0 and rows != 0
	    if(Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <=0){
		System.out.println(instructions);
	    }
	    else if(args.length == 3){
		try{
		    WordSearch test = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
		    test.fill();
		    System.out.println(test);
		    System.out.println(test.wordList());
		}catch(NumberFormatException e){
		    System.out.println(instructions);
		}
	    }
	    else if(args.length == 4 || (args.length == 5 && !args[4].equals("key"))){
		try{
		    WordSearch test = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
		    test.fill();
		    System.out.println(test);
		    System.out.println(test.wordList());
		}catch(NumberFormatException e){
		    System.out.println(instructions);
		}
	    }
	    else if(args.length == 5){
		try{
		    WordSearch test = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
		    System.out.println(test);
		    System.out.println(test.wordList());
		}catch(NumberFormatException e){
		    System.out.println(instructions);
		}        
	    }
	}
    }
}
