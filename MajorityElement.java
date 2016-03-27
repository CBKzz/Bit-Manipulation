/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    /*
    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int key=nums[i];
            if(map.containsKey(key)) {
                int count=map.get(key);
                if(count==nums.length/2) return key;
                map.put(key,++count);
            }
            else map.put(key,1);
        }return 0;
    }
    */
    public int majorityElement(int[] nums){
        int result=0;
        for(int i=0;i<32;i++){
            int count0=0;
            int count1=0;
            for(int n:nums){
                if((n&(1<<i))==0) count0++;
                else count1++;
            }
            if(count1>count0) result|=1<<i;
        }
        return result;
    }
    
    
    public int majorityElement(int[] nums){
        int count=0;
        int ret=0;
        for(int num:nums){
            if(count==0) ret=num;
            if(num!=ret) count--;
            else count++;
        }
        return ret;
    }
}
