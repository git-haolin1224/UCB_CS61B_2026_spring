public class StarTriangle5 {
   /**
     * Prints a right-aligned triangle of stars ('*') with 5 lines.
     * The first row contains 1 star, the second 2 stars, and so on. 
     */
   public static void starTriangle5() {
      // TODO: Fill in this function
      int i=0;
      int a=0;
      for(i=0; i<5; i++){
         for(a=0; a<4-i; a++){
            IO.print(" ");
         }
         for(a=0; a<i; a++){
            IO.print("*");
         }
         IO.println("*");
      }
   }
   
   public static void main(String[] args) {
      starTriangle5();
   }
}