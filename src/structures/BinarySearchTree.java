package structures;

import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int nodeValue) {
        value = nodeValue;
    }

    public boolean isLeaf() {
        return left == null && right == null;
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
        if (root == null) {
            return false;
        }
        return checkExistance(root, element);
    }

    private boolean checkExistance(Node current, int element) {
        if (current.value == element) {
            return true;
        }
        boolean result = false;
        if (current.left != null) {
            result = result || checkExistance(current.left, element);
        }
        if (current.right != null) {
            result = result || checkExistance(current.right, element);
        }
        return result;
    }

    /****************/
    // найти следующее по величине число в дереве
    public Node findNext(int element) {
        Node current = root;
        Node result = null;
        while (current != null) {
            if (current.value > element) {
                result = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }

    private Node min(Node element) {
        Node current = element;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void remove(int element) {
        root = removeRecursively(root, element);
    }

    private Node removeRecursively(Node current, int element) {
        if (current == null) {
            return current;
        }
        if (element < current.value) {
            current.left = removeRecursively(current.left, element);
        } else if (element > current.value) {
            current.right = removeRecursively(current.right, element);
        } else if (current.left != null && current.right != null) {
            Node minInRightPart = min(current.right);
            current.value = minInRightPart.value;
            current.right = removeRecursively(current.right, current.value);
        } else {
            if (current.left != null) {
                current = current.left;
            } else if (current.right != null) {
                current = current.right;
            } else {
                current = null;
            }
        }
        return current;
    }

}

public class BinarySearchTree {
    public static void main(String[] args) {
        BinaryTree searchTree = new BinaryTree();

        searchTree.add(10);
        searchTree.add(12);
        searchTree.add(11);
        searchTree.add(8);
        searchTree.add(7);
        System.out.println(searchTree.isExists(11));
        System.out.println(searchTree.isExists(8));
        System.out.println(searchTree.isExists(9));
        System.out.println(searchTree.findNext(12));
        System.out.println(searchTree.findNext(10).value);
        System.out.println(searchTree.findNext(1).value);

        System.out.println(searchTree.getValues());
        searchTree.remove(12);
        System.out.println(searchTree.getValues());
        System.out.println(searchTree.isExists(7));
        searchTree.remove(7);
        System.out.println(searchTree.getValues());
        System.out.println(searchTree.isExists(7));
    }
}
