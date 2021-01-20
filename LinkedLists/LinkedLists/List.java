/**The List class will build a List data structure so that
 * our other following classes(Stack and Queue) will be able to inherit
 * from it and borrow some of the methods from this class to use as their
 * own in terms of how to add and remove based on their own structures.
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class List {

    /**This is a Node inner class with a few methods that will be used
     * throughout the List parent class.
     */
    class Node {
        //instances include an Object of the item and Node of a link
        private Object item;
        private Node link;

        public Node() {
            link = null;
            item = null;
        }

        public Node(Object item) {
            this.item = item;
            link = null;
        }

        public Node(Object item, Node link) {
            this.item = item;
            this.link = link;
        }

    }

    //the start of the linked list
    Node head = null;

    /**this method will insert an Object of "next" at the intended index that is
     * recorded in the parameter
     *
     * @param index integer of an index where you want to add the object
     * @param next Object next of what you want added
     * @exception LinkedListException
     */
    public void insert(Object next, int index) throws LinkedListException {
        //makes sure that the object that is being added is not null and will
        //throw a LinkedListException if it does
        if(next == null) {
            throw new LinkedListException("Object is null - LinkedListException");
        }
        //make sure that the index is not a negative number
        if(index<0) {
            throw new LinkedListException("Index is invalid - LinkedListException");
        }
        //make sure that the index is within the size of the list
        if(index>size()) {
            throw new LinkedListException("Index is not within size of List - LinkedListException");
        }
        //if added to an empty list, it changes the head
        if(isEmpty()) {
            head = new Node(next);
        }
        //if the the object is inserted to index 0, it will change the head with
        //the next object
        if(index==0) {
            head = new Node(next, head);
        }
        //if we are adding an object to a populated list, we will assign a Node
        //object of newNode to be used in reorganizing the list after inserting the
        //next object
        if(size()>=2) {
            Node newNode = head;
            for(int i=0; i<index-1; i++) {
                newNode = newNode.link;
            }
            newNode.link = new Node(next, newNode.link);
        }
    }

    /**This method will remove the node from the index that is passed in the
     * parameter
     *
     * @param index integer index of node from what location to remove
     * @return Object of what will be removed from list
     * @exception LinkedListException
     */
    public Object remove(int index) throws LinkedListException {
        Node previous = null;
        Node newNode = head;
        //if list is empty, exception is thrown
        if(isEmpty()) {
            throw new LinkedListException("Empty list - LinkedListException");
        }
        //if list is a negative number, exception is thrown
        if(index<0) {
            throw new LinkedListException("Index is invalid - LinkedListException");
        }
        //if index is not in the size of a list, exception is thrown
        if(index>size()) {
            throw new LinkedListException("Index is not within size of List - LinkedListException");
        }
        //if index is to remove from the beginning of list, reassigning the head
        //to its link
        if(index==0) {
            head = head.link;
        }
        //if deleting from a body or tail of the list, reorganizing the
        //list after removing the object from the index
        if(size()>=2) {
            for(int i=0; i<index-1; i++) {
                newNode = newNode.link;
            }
            previous = newNode;
            newNode = newNode.link;
            previous.link = newNode.link;
        }
        return newNode;
    }

    /**This method will add an object to the end of the list
     *
     * @param next Object next that is to be added to the list
     * @exception LinkedListException
     */
    public void append(Object next) throws LinkedListException {
        //if the object to be added is null, throws exception
        if(next==null) {
            throw new LinkedListException("Object is null - LinkedListException");
        }
        //if list is empty, adds the next object as the head
        if(isEmpty()) {
            head = new Node(next);
        } else {
            //else, reorganizes the whole list by first finding the end of the
            //list with a loop to see if the link is null, and then adds the
            //new node to the very end
            Node newNode = head;
            while (newNode.link != null) {
                newNode = newNode.link;
            }
            newNode.link = new Node(next);
        }
    }

    /**This method deletes the node at the index that is passed in the parameter
     *
     * @param index integer index of location to delete node
     */
    public void delete(int index) {
        //if list is a negative number, exception is thrown
        if(index<0) {
            throw new LinkedListException("Index is invalid - LinkedListException");
        }
        //if index is not in the size of a list, exception is thrown
        if(index>size()) {
            throw new LinkedListException("Index is not within size of List - LinkedListException");
        }
        //if the list is empty, it will keep the head to stay null because there
        //is nothing to delete
        if(isEmpty()) {
            head = null;
        }
        //if there is one node in the list, the head will equal to its link when deleting
        if(size()==1) {
            head = head.link;
        } else {
            //reorganizing the list after removing the object from the location in
            //the index
            Node newNode = head;
            for (int i = 0; i < index - 1; i++) {
                newNode = newNode.link;
            }
            newNode.link = newNode.link.link;
        }
    }

    /**This method will get the size of the list
     *
     * @return integer of the count of elements from list
     */
    public int size() {
        int count = 0;
        Node nodeList = head;
        while(nodeList != null) {
            count ++;
            nodeList = nodeList.link;
        }
        return count;
    }

    /**This method will override the toString method and print out
     * the whole list
     *
     * @return String of list of nodes
     */
    public String toString() {
        //starts off with the beginning bracket to indicate the start of the list
        String list = "[";
        Node newNode = head;
        //loop of adding nodes into the string as long as the next link is not null
        while(newNode!= null) {
            list+=newNode.item;
            if(newNode.link!=null) {
                //distinguishing each node by separating with a comma after assuring
                //that the next link is not null
                list += ",";
            }
            newNode = newNode.link;
        }
        //ending list with the other side of the bracket
        list +="]";
        return list;
    }

    /**This method will check to see if the list is not empty
     *
     * @return boolean value of true if the list is empty and false if it is filled
     */
    public boolean isEmpty() {
        //if the head is not null, it will mean that the list is not empty
        if(head!=null) {
            return false;
        }
        return true;
    }

    /**This method will find the index of an object from a list
     *
     * @param target Object target of what to find in the list
     * @return integer of the index where the target is found
     */
    public int indexOf(Object target) throws LinkedListException {
        //if the target is null, exception thrown
        if(target == null) {
            throw new LinkedListException("Object is null - LinkedListException");
        }
        int index=0;
        Node newNode = head;
        //loop to find if the node from the list equals to the target and keeping
        //track of the index of where it is found
        while(newNode!=null) {
            if(newNode.item.equals(target)) {
                return index;
            } else {
                index++;
                newNode = newNode.link;
            }
        }
        //returns a negative integer, to indicate that the target is not found
        //in the list
        return -1;
    }
    public static void main(String[] args) {
        List empty = new List();
        List one = new List();
        List multiple = new List();

        one.append(5);
        multiple.append(10);
        multiple.append(20);
        multiple.append(30);

        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);
        System.out.println("PASSED TESTS");
        System.out.println();

        one.delete(0);
        multiple.delete(1);
        System.out.println("One (upon delete):"+one);
        System.out.println("Multiple (upon delete):"+ multiple);
        System.out.println("PASSED TESTS");
        System.out.println();

        //one.insert(600, 1);
        multiple.insert(400, 2);
        System.out.println("One (on insert):"+one);
        System.out.println("Multiple(on insert):"+ multiple);
        System.out.println("PASSED TESTS");
        System.out.println();

        List test = new List();
        test.append(40);
        test.append(50);
        test.append(60);
        test.append(70);
        System.out.println("test(initial list):" + test);
        System.out.println("PASSED TEST");
        System.out.println();

        test.remove(3);
        System.out.println("test(after removing index 3):" + test);
        System.out.println("PASSED TEST");
        System.out.println();

        System.out.println("test(finding index of 50):" + test.indexOf(50));
        System.out.println("PASSED TEST");
        System.out.println();

        test.insert(80, 3);
        System.out.println("test(after inserting 80 in index 3):" + test);
        System.out.println("PASSED TEST");



    }

}
