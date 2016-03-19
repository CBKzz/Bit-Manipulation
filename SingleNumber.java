public class Solution {
/*
Given an array of integers, every element appears three times except for one. Find that single one.
*/    
    public int singleNumber(int[] nums) {
        int result=0;
        for(int len=0;len<32;len++){
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=(nums[i]>>len)&1;
            }
            result|=(sum%3)<<len;
        }
        return result;
    }
/*
Given an array of integers, every element appears twice except for one. Find that single one.
*/
//using the xor. A number XOR itself is zero,and zero XOR a number is still that number
    public int singleNumber(int[] nums) {
        int a=nums[0];
        for(int i=1;i<nums.length;i++){
            a^=nums[i];
        }
        return a;
    }

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
*/
    public int[] singleNumber(int[] nums) {
        int a=nums[0];
        for(int i=1;i<nums.length;i++){
            a^=nums[i];
        }
	//we use this to get 00000100000, in which 1 is the first 1 in a
        int lowbit=a&(-a);
        int[] result=new int[2];
        for(int i:nums){
            if( (i& lowbit)==0) result[0]^=i;
            else result[1]^=i;
        }
        return result;
    }

}

