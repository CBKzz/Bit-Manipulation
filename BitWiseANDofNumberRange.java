/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

*/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n) return n;
        int t=m;
        int count=~0;
        int dif=n-m;
        int flag=1;
        int flagg=1;
        int temp=0;
        while(m!=0){
            count<<=1;
            if((m&1)==1) {
                temp+=flag;
            }
            if(flagg-temp>=dif) {
                break;
            }    
            m>>=1;
            flag*=2;
            flagg+=flag;
        }
        return (t&count);
    }
}
