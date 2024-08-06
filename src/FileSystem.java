import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {

    Inode root;

    public FileSystem() {
        //initialise the file system, create the root inode
        root = new Inode(0, "");
    }

    public List<String> ls(String path) {
        String[] paths = path.split("/");
        //navigate from root
        Inode inode = root;
        for(int i = 1; i < paths.length; i++){ //start from index 1 because 0 is empty string
            inode = inode.map.get(paths[i]);
        }

        List<String> ans = new ArrayList<>();
        if(inode.flag == 0){
            //this is a directory
            ans.addAll(inode.map.keySet());
        }else{
            //this is a file
            ans.add(inode.name);
        }

        return ans;
    }

    public void mkdir(String path) {
        if(path.equals("/")) return;
        String[] paths = path.split("/");
        //create from root
        Inode inode = root;
        for(int i = 1; i < paths.length; i++){ //start from index 1 because 0 is empty string
            String dirName = paths[i];
            if(!inode.map.containsKey(dirName)){
                Inode newDir = new Inode(0, dirName);
                inode.map.put(dirName, newDir);
                inode = newDir;
            }else{
                inode = inode.map.get(dirName);
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        //navigate from root
        Inode inode = root;
        int i = 1; //start from index 1 because 0 is empty string
        for(; i < paths.length - 1; i++){  //stop at the last dir which contains this file
            inode = inode.map.get(paths[i]);
        }

        //now inode is the dir which contains this file
        String fileName = paths[i];
        Inode fileInode;
        if(!inode.map.containsKey(fileName)){
            fileInode = new Inode(1, fileName);
            inode.map.put(fileName, fileInode);
        }else{
            fileInode = inode.map.get(fileName);
        }
        fileInode.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        //navigate from root
        Inode inode = root;
        for(int i = 1; i < paths.length; i++){ //start from index 1 because 0 is empty string
            inode = inode.map.get(paths[i]);
        }

        return inode.content.toString();
    }
}

class Inode{
    int flag; //0: directory, 1: file
    String name;
    Map<String, Inode> map;
    StringBuilder content;

    public Inode(int flag, String name){
        this.name = name;
        this.flag = flag;
        if(flag == 0){
            //this is a directory
            map = new TreeMap<>();
        }else {
            //this is a file
            content = new StringBuilder();
        }
    }
}
