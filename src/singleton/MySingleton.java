package singleton;

public class MySingleton {

    private static class InstanceHolder {
        private static final MySingleton instance = new MySingleton();
    }

    private String name;

    private MySingleton(){

    }

    public static MySingleton getInstance() {
        return InstanceHolder.instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
