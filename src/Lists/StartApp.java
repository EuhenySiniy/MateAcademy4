package academy.mate.task1;

public class StartApp {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        System.out.println(myArrayList.size());
        myArrayList.clear();
        System.out.println(myArrayList.size());
        MyLinkedList myLinkedList = new MyLinkedList();
        MyStack myStack = new MyStack(10);
    }
}
