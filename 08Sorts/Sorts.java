import java.util.Arrays;
public class Sorts{

    public static String name(){
        return "10.Chen.Mohammad";
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
        System.out.println(Arrays.toString(randish));

    }
}
