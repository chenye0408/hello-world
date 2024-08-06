
public class Solution {

    public static void main(String[] args) {
        String s = Long.toBinaryString(5043814047661138229L);
        System.out.println(Integer.parseInt(s.substring(s.length() - 10), 2));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            if(i >= 0){
                int j = i;
                while(i >= 0 && s.charAt(i) != ' '){
                    i--;
                }
                sb.append(s, i + 1, j + 1).append(' ');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}