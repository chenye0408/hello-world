import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<String> getArrayList(String[] ss){
        ArrayList<String> list = new ArrayList<>();
        for(String s : ss){
            list.add(s);
        }
        return list;
    }
}
