public class Testing {

    public static void main(String[] args){
    	int[][] myInts1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	int[][] myInts2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	int[][] myResult = new int[4][4];
    	int n = 4;
    	for (int i = 0; i < (n/2); i++){
    	    for (int j = 0; j < (n/2); j++){
    	        System.out.println(myInts1[i][j]);
    	    }
    	} 
    }

}