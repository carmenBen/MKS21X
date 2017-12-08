import java.util.Arrays;
public class Sorts{

    public static String name(){
        return "10.Benitez.Carmen";
    }

  public static boolean isSorted(int[]ary){
    for(int i = 0; i < ary.length - 1 ; i++){
      if(ary[i] > ary[i+1]){
        return false;
      }
    }
    return true;
  }


  public static void bogoSort(int[] ary){
    while(!isSorted(ary)){
      for(int i = 0 ; i < ary.length; i++){
        int temp = ary[i];
        int newSpot = (int)(Math.random()*ary.length);
        ary[i] = ary[newSpot];
        ary[newSpot] = temp;
      }
    }
  }

  public static void selectionSort(int[] ary){
    for(int i = 0;i < ary.length - 1;i++){
      int current = i;
      for(int j = i;j < ary.length;j++){
        if(ary[j] < ary[current]){
          current = j;
        }
      }
      if(current != i){
        swap(ary,current,i);
      }
    }
  }
    

  public static void insertionSort(int[] ary){
    for(int i = 1;i < ary.length;i++){
      for(int j = 0;j < i;j++){
        if(ary[i] < ary[j]){
          int temp = ary[i];
          for(int k = i;k > j;k--){
            ary[k] = ary[k - 1];
          }
          ary[j] = temp;
        }
      }
    }
  }

    public static void bubbleSort(int[] ary){
	int count = 0;
	for(int i = 0;i < ary.length - 1;i++){
	    count = 0;
	    for(int j = 0;j < ary.length - (i + 1);j++){
		if(ary[j] > ary[j+1]){
		    swap(ary,j,j+1);
		    count++;
		}
	    }
	    if(count == 0){
		break;
	    }
	}
    }

  private static void swap(int[]ary,int a, int b){
    int c =ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }

  public static void main(String[]artie){
    int[] randish = new int[15];
    for(int i = 0 ; i < randish.length; i++){
      randish[i] =(int)(Math.random()*100);
    }

    System.out.println(Arrays.toString(randish));
    //      bogoSort(randish);
    // selectionSort(randish);
    //insertionSort(randish);
    bubbleSort(randish);
    System.out.println(Arrays.toString(randish));

  }
}
