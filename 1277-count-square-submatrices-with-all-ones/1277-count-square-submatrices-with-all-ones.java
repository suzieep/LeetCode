//2:55
//3:28
//3:44
class Solution {

    public int countSquares(int[][] matrix) {
        int result = 0;
        for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==1){
                   result += 1;
                   int side = 1;
                   while(isSquare(i,j,matrix,side++)){
                       result +=1;
                   }
               }   
            }
        }
        return result;
    }
    
    private boolean isSquare(int i, int j, int[][] matrix, int side){
        boolean result = true;
        for(int k=0;k<=side;k++){
            if(i+k<matrix.length && i+side <matrix.length
               && j+side<matrix[0].length && j+k<matrix[0].length){
                if(matrix[i+k][j+side] * matrix[i+side][j+k]==0){
                    result = false;
                }
            } else {
                result = false;
            }
        }

        return result;
    }
}