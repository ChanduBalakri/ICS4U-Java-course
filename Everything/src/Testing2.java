
public class Testing2 {


	    public static void main(String[] args){
	    	multiply(5,4);
	       

	    }
	    static int multiply(int m, int n){
	        if (n != 0){
	        	System.out.println(m + multiply(m, n - 1));
	            return m + multiply(m, n - 1);
	        } else {
	        	System.out.println(0);
	            return 0;
	        }
	    }
}
	

