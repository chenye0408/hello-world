//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
//Knuth–Morris–Pratt Algorithm
public class KMP {

    //time complexity: O(n^3)
    public int[] computeLPSNaive(String str){
        int n = str.length();
        int[] lps = new int[n];
        lps[0] = 0;
        //compute lps for sub str[0..i]
        for(int i = 1; i < n; i++){
            //try the length of border from 0 to i - 1
            for(int len = 0; len < i; len++){
                int j = 0;
                boolean match = true;
                for(; j <= len; j++){
                    if(str.charAt(j) != str.charAt(i - len + j)){
                        match = false;
                        break;
                    }
                }
                if(match) lps[i] = j;
            }
        }

        return lps;
    }
}
