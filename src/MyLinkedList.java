class Item { // один элемент списка
    int value; // значение в ячейке
    Item prev; // ссылка на предыдущий
    Item next; // ссылка на следующий

    public Item(int itemValue) {
        value = itemValue;
    }
}


public class MyLinkedList { // список, цепочка элементов Item
    Item head;
    Item tail;

    public void add(int value) {
        if (head == null) { // список пустой
            Item current = new Item(value);
            head = current;
            tail = current;
        } else { // список непустой
            Item current = new Item(value);
            tail.next = current;
            current.prev = tail;
            tail = current;
        }
    }

    // добавляет элемент в начало списка
    public void addFirst(int value) {

    }

    public void print() {
        Item current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next; // переход между элементами
        }
    }

    // удаляет первый элемент списка
    public void removeFirst() {

    }

    // удаляет последний элемент списка
    public void removeLast() {

    }

    // возвращает количество элементов
    public void size() {

    }
}

class ListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.print();
    }

}
