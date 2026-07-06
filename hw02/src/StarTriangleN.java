public class StarTriangleN {
   /**
     * Prints a right-aligned triangle of stars ('*') with N lines.
     * The first row contains 1 star, the second 2 stars, and so on. 
     */
   public static void starTriangle(int N) {
      // TODO: Fill in this function
      int i=0;
      int a=0;
      for(i=0; i<N; i++){
         for(a=0; a<N-1-i; a++){
            IO.print(" ");
         }
         for(a=0; a<i; a++){
            IO.print("*");
         }
         IO.println("*");
      }
   }
   
   public static void main(String[] args) {
      starTriangle(7);
   }
}