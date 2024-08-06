import java.util.List;

class Node {
    public int val;
    //for linked list
    public Node next;

    //for tree
    public Node left;
    public Node right;

    //for graph
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};