import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {

      private int[] id;
      int size =0;

         UF(int n){
          id = new int[n];
             for (int i=0;i < n;i++){
                id[i] =i;
             }
             size =n;

         }



         void union(int p ,int q){
             if(connected(p,q)){
                return;
             }

             int idOfP= id[p];
             int idOfq= id[q];
             for( int i=0;i <id.length;i++){
                 if(id[i] == idOfP){
                     id[i] = idOfq;
                 }

             }
             size--;

         }



         int find(int p){
             return id[p];
         }



         boolean connected(int p,int q){
             return id[p] == id[q];
         }

         int count(){
             return size;
         }




         public static void main(String[] args){

             int N = StdIn.readInt();
             UF uf = new UF(N);
             while(!StdIn.isEmpty()){
                 int p = StdIn.readInt();
                 int q = StdIn.readInt();
                 if(uf.connected(p,q)){
                     continue;
                 }
                 uf.union(p,q);
                 StdOut.println(p +" " +q);

             }
             StdOut.println(uf.count()+" components");
         }
}
