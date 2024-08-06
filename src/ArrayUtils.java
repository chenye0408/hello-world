public class ArrayUtils {

    public static void main(String[] args){
        String s = "[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]";

        int[][] a = parseMatrix(s);
        printMatrix(a);
    }

    //input format: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
    public static int[][] parseMatrix(String s){
        while(s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']'){
            s = s.substring(1, s.length() - 1);
        }

        String[] subArrs = s.split("],\\[");
        int cols = subArrs[0].split(",").length;
        int[][] ret = new int[subArrs.length][cols];
        for(int i = 0; i < subArrs.length; i++){
            String[] nums = subArrs[i].split(",");
            for(int j = 0; j < cols; j++){
                ret[i][j] = Integer.parseInt(nums[j]);
            }
        }

        return ret;
    }

    //input format: [[0], [1,2], [3,6,7]]
    public static int[][] parse2DArray(String s){
        while(s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']'){
            s = s.substring(1, s.length() - 1);
        }

        String[] subArrs = s.split("],\\[");
        int[][] ret = new int[subArrs.length][];
        for(int i = 0; i < subArrs.length; i++){
            int cols = subArrs[i].split(",").length;
            ret[i] = new int[cols];
            String[] nums = subArrs[i].split(",");
            for(int j = 0; j < cols; j++){
                ret[i][j] = Integer.parseInt(nums[j]);
            }
        }

        return ret;
    }

    public static char[][] parseCharMatrix(String s){
        while(s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']'){
            s = s.substring(1, s.length() - 1);
        }

        String[] subArrs = s.split("],\\[");
        int cols = subArrs[0].split(",").length;
        char[][] ret = new char[subArrs.length][cols];
        for(int i = 0; i < subArrs.length; i++){
            String[] nums = subArrs[i].split(",");
            for(int j = 0; j < cols; j++){
                ret[i][j] = nums[j].charAt(0);
            }
        }

        return ret;
    }

    public static void printPairs(int[][] as){
        for(int[] a : as){
            System.out.printf("[%d, %d]", a[0], a[1]);
        }
    }

    public static void printMatrix(int[][] as){
        for(int[] a : as){
            System.out.print("[");
            for(int i = 0; i < a.length; i++){
                System.out.printf("%d", a[i]);
                if(i != a.length - 1) System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
