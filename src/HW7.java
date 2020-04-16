import java.util.ArrayList;

public class HW7 {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();

        queue.addClient("First");
        queue.show();
        queue.addClient("Second");
        queue.show();
        System.out.println(queue.countClients());
        queue.clearQueue();
        queue.show();

        queue.addClient("1");
        queue.addClient("2");

        System.out.println(queue.nextClient());
        System.out.println(queue.nextClient());
        queue.show();
    }
}

class SimpleQueue {
    ArrayList<String> clients;

    public SimpleQueue() {
        // инициализация!!!
        clients = new ArrayList<>();
    }

    public void addClient(String clientInfo) {
        // добавляем информацию в конец очереди
        clients.add(clientInfo);
        show();
    }

    public void show() {
        System.out.println(clients);
    }

    public int countClients() {
        return clients.size();
    }

    public void clearQueue() {
        // стандартная альтернатива
//        clients.clear();
        clients = new ArrayList<>();
    }

    public String nextClient() {
        String result = clients.get(0);
        // удалить элемент из списка
        clients.remove(0);
//        ArrayList<String> shortList = new ArrayList<>();
//        for (int i = 1; i < clients.size(); i++) {
//            shortList.add(clients.get(i));
//        }
//        clients = shortList;

        return result;
    }
}