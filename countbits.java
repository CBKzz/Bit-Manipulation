/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].
*/

public class Solution {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        if(num==0) return result;
        result[0]=0;
        int stop=0;
        int j=stop+1;
        while(j<=num){
            j=stop+1;
            for(int i=0;i<=stop;i++){
                if(j==num+1) break;
                result[j++]=result[i]+1;
            }
            stop=j-1;
        }
        return result;
    }
}
