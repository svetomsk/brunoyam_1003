import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int nodeValue) {
        value = nodeValue;
    }
}

class BinaryTree {
    Node root;
    int size;

    public void add(int element) {
        if (root == null) { // дерево пустое
            root = new Node(element);
        } else { // дерево непустое
            Node current = root; // начинаем всегда с корня дерева
            while (true) {
                if (current.value == element) {
                    return;
                }
                if (current.value > element) { // в левое поддерево
                    if (current.left == null) {
                        current.left = new Node(element);
                        return;
                    } else {
                        current = current.left; // переход в левую вершину
                    }
                } else { // в правое поддерево
                    if (current.right == null) {
                        current.right = new Node(element);
                        return;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public List<Integer> getValues() {
        List<Integer> nodeValues = new ArrayList<>();
        walk(root, nodeValues);
        return nodeValues;
    }

    private void walk(Node current, List<Integer> values) {
//        System.out.println("Enter " + current.value);
        values.add(current.value);
        if (current.left != null) {
            // рекурсия
            walk(current.left, values); // переход в левую вершину
        }
        if (current.right != null) {
            walk(current.right, values);
        }
//        System.out.println("Exit " + current.value);
    }

    // реализовать с помощью рекурсии
    public boolean isExists(int element) {
        return false;
    }

    /****************/
    // найти следующее по величине число в дереве
    public void findNext(int element) {

    }

    public void remove(int element) {

    }

}

public class BinarySearchTree {
    public static void main(String[] args) {
        BinaryTree searchTree = new BinaryTree();
//        searchTree.add(10);
//        searchTree.add(7);
//        searchTree.add(12);
//        searchTree.add(8);
//        searchTree.add(6);
//        searchTree.add(11);

        searchTree.add(12);
        searchTree.add(11);
        searchTree.add(10);
        searchTree.add(8);
        searchTree.add(7);

        System.out.println(searchTree.getValues());
    }
}
