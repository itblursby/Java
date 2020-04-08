import java.util.*;

public class Permutation {
   public static void main(String args[]) {
     int f[] = new int[]{1, 1, 2, 6, 24, 120, 720};
     ArrayList<Integer> candidates = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
   
     for(int i = 0; i < 24; i+=1) {
       ArrayList<Integer> perm = new ArrayList<Integer>();
       ArrayList<Integer> copy = new ArrayList<Integer>(candidates);
     
       int remaining = i;
       int[] h = new int[4];
       
       //System.out.println();
       //System.out.println();
       h[0]=(remaining%4);
       remaining = (remaining-(remaining%4))/4;
       h[1]=(remaining%3);
       remaining = (remaining-(remaining%3))/3;
       h[2]=(remaining%2);
       remaining = (remaining-(remaining%2))/2;
       h[3]=(remaining%1);
       perm.add(copy.get(h[0]));
       copy.remove(h[0]);
       perm.add(copy.get(h[1]));
       copy.remove(h[1]);
       perm.add(copy.get(h[2]));
       copy.remove(h[2]);
       perm.add(copy.get(h[3]));
       copy.remove(h[3]);
       System.out.println(perm);
       
     }
   }
}