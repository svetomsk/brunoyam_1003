package structures;

class Item { // один элемент списка
    int value; // значение в ячейке
    Item prev; // ссылка на предыдущий
    Item next; // ссылка на следующий

    public Item(int itemValue) {
        value = itemValue;
    }
}


public class MyLinkedList { // список, цепочка элементов structures.Item
    Item head; // изначально null
    Item tail; // изначально null
    int size;

    // добавляет элемент в конец списка
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
        size++;
    }

    // добавляет элемент в начало списка
    public void addFirst(int value) {
        if (head == null) {
            Item current = new Item(value);
            head = tail = current;
        } else {
            Item current = new Item(value);
            current.next = head;
            head.prev = current;
            head = current;
        }
        size++;
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
        if (head != null) {
            head = head.next;
            if (head == null) { // был последний элемент
                tail = null;
            } else { // остался еще как минимум 1
                head.prev.next = null;
                head.prev = null;
            }
            size--;
        }
    }

    // удаляет последний элемент списка
    public void removeLast() {

    }

    // возвращает количество элементов
    public int size() {
//        structures.Item current = head;
//        int count = 0;
//        while(current != null) {
//            count++;
//            current = current.next;
//        }
//        return count;
        return size;
    }
}

class ListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        System.out.println("size = " + list.size());
        list.add(1);
        list.add(2);
        list.addFirst(0);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.print();
        System.out.println("size = " + list.size());
    }

}
