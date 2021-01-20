/**
 * This class will be the driver where we demonstrate and test the classes
 * and methods that were made for this assignment
 *
 *@author Eunhee Kim
 *@version October 17, 2019
 */

public class ArrayBasedDataStructuresDriver {

    public static void main(String[] args) {
        stackTests();
        queueTests();
        arrayListTests();
    }

    private static void arrayListTests() {
        //todo: make more tests here
        ArrayList a = new ArrayList();

        a.insert('B', 0);
        a.insert('a',0);
        a.insert('t',1);

        System.out.println(a.toString());

        while(a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }

        System.out.println(a.remove(1));

        ArrayList b = new ArrayList();
        b.insert('c', 0);
        b.insert('a', 1);
        b.insert('t', 0);
        System.out.println(b.toString());

        System.out.println(a.equals(b));

        System.out.println(b.remove(1));
        System.out.println(a.size());
        System.out.println(b.get(0));
    }

    private static void queueTests() {
        //todo: make more tests here
        Queue a = new Queue();

        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');

        System.out.println(a.toString());

        while(a.isEmpty() == false) {
            System.out.println(a.dequeue());
        }

        Queue b = new Queue();
        b.enqueue('c');
        b.enqueue('a');
        b.enqueue('t');
        System.out.println(b.toString());

        System.out.println(a.equals(b));

        System.out.println(b.dequeue());
        System.out.println(a.size());

    }

    private static void stackTests() {
        //todo: make more tests here
        Stack a = new Stack();

        a.push('B');
        a.push('a');
        a.push('t');

        System.out.println(a.toString());

        while(a.isEmpty() == false) {
            System.out.println(a.pop());
        }

        Stack b = new Stack();
        b.push('c');
        b.push('a');
        b.push('t');
        System.out.println(b.toString());

        System.out.println(a.equals(b));

        System.out.println(b.pop());
        System.out.println(a.size());
    }


}
