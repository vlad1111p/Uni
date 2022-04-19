import java.util.Arrays;

public class ToMatrix {


    public static void main(String args[]) {
        while (!StdIn.isEmpty()) {
        int zahl = StdIn.readInt();
        
        
        int ziffer3 = zahl%10;
        int ziffer2 = (zahl%100 - ziffer3)/10;
        int ziffer1 = (zahl - ziffer2 - ziffer3)/100;
    
    int[][][] matrix = {
        { {1,1,1},{1,0,1},{1,0,1},{1,0,1 },{1,1,1}},
        { {0,0,1},{0,0,1},{0,0,1},{0,0,1 },{0,0,1}},
        { {1,1,1},{0,0,1},{1,1,1},{1,0,0 },{1,1,1}},
        { {1,1,1},{0,0,1},{1,1,1},{0,0,1 },{1,1,1}},
        { {1,0,0},{1,0,0},{1,1,1},{0,1,0 },{0,1,0}},
        { {1,1,1},{1,0,0},{1,1,1},{0,0,1 },{1,1,1}},
        { {1,0,0},{1,0,0},{1,1,1},{1,0,1 },{1,1,1}},
        { {1,1,1},{0,0,1},{0,0,1},{0,0,1 },{0,0,1}},
        { {1,1,1},{1,0,1},{1,1,1},{1,0,1 },{1,1,1}},
        { {1,1,1},{1,0,1},{1,1,1},{0,0,1 },{0,0,1}}
            
        };
    
   
   
    for (int j= 0; j<5 ;j++){
        for (int k=0; k<9;k++){
            
            if(k<3)
                if (ziffer1==0) 
                    StdOut.print(0);
                else
                    StdOut.print(matrix[ziffer1][j][k]);
            else if (k<6 && k>=3 )
                if (ziffer1==0 && ziffer2==0)
                    StdOut.print(0);
                else 
                    StdOut.print(matrix[ziffer2][j][k-3]);
            else if (k<8 && k>=6)
                StdOut.print(matrix[ziffer3][j][k-6]);
            else if (k==8)
                StdOut.print(matrix[ziffer3][j][k-6]+"\n");
         
        } 
    }
 }
}
}