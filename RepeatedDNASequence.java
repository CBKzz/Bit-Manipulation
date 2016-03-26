/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

//I think the methond without bit manipulation is better...

public class Solution {
    /*public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited=new HashSet<>();
        Set<String> store=new HashSet<>();
        List<String> result =new ArrayList<>();
        if(s==null||s.length()<=10) return result;
        for(int i=0;i<=s.length()-10;i++){
            String ss=s.substring(i,i+10);
            if(!visited.add(ss)) store.add(ss);
        }
        result.addAll(store);
        return result;
    }*/
    public List<String> findRepeatedDnaSequences(String s) {
    if(s == null || s.length()==0) return new ArrayList<String>();
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    map.put('A',0);
    map.put('C',1);
    map.put('G',2);
    map.put('T',3);
    HashSet<Integer> set = new HashSet<Integer>();
    HashSet<String> twice = new HashSet<String>();
    // Encode String to number
    for(int i=0;i<s.length()-9;i++){
        int code = 0;
        for(int j=i;j<i+10;j++){
            code <<= 2;
            code |= map.get(s.charAt(j));
        }
        if(set.contains(code)){
            set.add(code);
            twice.add(s.substring(i,i+10));
        }else{
            set.add(code);
        }
    }
    return new ArrayList<String>(twice);
}
}
