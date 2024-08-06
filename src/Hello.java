import java.util.Collections;

public class Hello {

    public static void main(String[] args) throws Exception {
        FileSystem fs = new FileSystem();
        fs.ls("/");
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        fs.ls("/");
        System.out.println(fs.readContentFromFile("/a/b/c/d"));

        fs.mkdir("/cy");
        fs.mkdir("/bb");
        System.out.println(fs.ls("/"));

        fs.mkdir("/a/gg");
        fs.mkdir("/a/ee");
        System.out.println(fs.ls("/a"));

        fs.addContentToFile("/a/b/c/d", " world");
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
    }
}
