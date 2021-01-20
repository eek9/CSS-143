import java.util.Scanner;
/**
 * PizzaManager Skeleton File
 * CSS 162, Final Project
 * <p>
 * This class is a starting point for your final project and is incomplete.
 * Note that if there are any inconsistencies between this skeleton and
 * the assignment description, the assignment description controls.
 * <p>
 * Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {
    /*
     *  TODO: Data definitions here.
     */

    ArrayList<Pizza> pizzas = new ArrayList<>();

    /**
     * The console interface is defined in the start method
     * You can exit or extend the code below to accomplish all of
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection = 'q';

        Scanner foo = new Scanner(System.in);

        while (true) {
            displayAllPizzas();
            displayInstructions();

            selection = foo.next().charAt(0);

            //foo.nextChar() doesn't exist, so now what?

            switch (selection) {
                case 'A':
                case 'a':
                    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                    //todo:
                    addRandomPizza();
                    break;
                case 'H':
                case 'h':
                    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                    //todo:
                    for (int i = 0; i < 100; i++) {
                        pizzas.insert(new Pizza(), pizzas.size() - 1);
                    }
                    break;
                case 'E':
                case 'e':
                    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                    //todo:pizza eating code here
                    eatSomePizza(foo);
                    break;
                case 'P':
                case 'p':
                    System.out.println("Sorting pizzas by (P)rice");
                    //todo:
                    sortByPrice();
                    break;
                case 'S':
                case 's':
                    System.out.println("Sorting pizzas by (S)ize");
                    //todo:
                    sortBySize();
                    break;
                case 'C':
                case 'c':
                    System.out.println("Sorting pizzas by (C)alories");
                    //todo
                    sortByCalories();
                    break;
                case 'B':
                case 'b':
                    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                    //todo:
                    int target = foo.nextInt();
                    System.out.println("Found calorie count at index: " + binarySearchByCalories(target));
                    break;
                case 'Q':
                case 'q':
                    System.out.println("(Q)uitting!");
                    //todo:
                    break;
                default:
                    System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**this method will have the user to give an input in fraction form to subtract
     * from the initial amount of pizza in whatever index the user has directed
     * to
     *
     * @param keys the scanner where the user will give inputs
     */
    private void eatSomePizza(Scanner keys) {
        //todo:
        boolean redo = false;
        while(!redo) {
            try {
                if (pizzas.isEmpty()) {
                    throw new PizzaException("Pizza array is empty");
                } else {
                    System.out.println("What fraction of the pizza would you like to eat");
                    String fraction = keys.next();
                    System.out.println("From what index would you like to eat your pizza from");
                    int index = keys.nextInt();
                    Pizza p = pizzas.get(index);
                    String[] eat = fraction.split("/");
                    int num = Integer.parseInt(eat[0]);
                    int den = Integer.parseInt(eat[1]);
                    p.eatSomePizza(new Fraction(num, den));
                    if (p.getRemainingArea() == 0) {
                        pizzas.remove(index);
                    }

                    if(num<0 || den<=0) {
                        throw new PizzaException();
                    }
                    redo = true;
                }
            } catch(Exception e) {
                System.out.println("Invalid input - please try again");
            }
        }

    }

    /**this method will add another pizza object into the arraylist
     * of objects
     *
     * @return nothing
     */
    private void addRandomPizza() {
        //todo:
        pizzas.insert(new Pizza(), pizzas.size());
    }

    /**this method will print out all the pizzas in the arraylist
     *
     * @return nothing
     */
    private void displayAllPizzas() {
        //todo:
        for (int i = 0; i <= pizzas.size() - 1; i++) {
            System.out.println(pizzas.get(i).toString());
        }
    }

    /**this method will use an insertion sort to organize the pizza arraylist
     * by price in increasing order
     *
     * @return nothing
     */
    private void sortByPrice() {
        //todo:
        for (int i = 1; i < pizzas.size(); i++) {
            Pizza currMin = (Pizza) pizzas.get(i);
            int minIndex = i - 1;
            Pizza p = (Pizza) pizzas.get(minIndex);
            while (minIndex >= 0 && currMin.getTotalCost().compareTo(p.getTotalCost()) == -1) {
                pizzas.set(minIndex + 1, p);
                minIndex = minIndex - 1;

                try {
                    p = (Pizza) pizzas.get(minIndex);
                } catch (Exception e) {
                    //does nothing
                }
            }
            pizzas.set(minIndex + 1, currMin);
        }
    }

    /**this method will use a selection sort to organize the pizza arraylist
     * by size in increasing order of remaining area
     *
     * @return nothing
     */
    private void sortBySize() {
        //todo:
        for (int i = 0; i < pizzas.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < pizzas.size(); j++) {
                Pizza currMin = (Pizza) pizzas.get(minIndex);
                if (currMin.compareToBySize(pizzas.get(j)) == 1) {
                    minIndex = j;
                }
            }
            pizzas.swap(i, minIndex);
        }
    }

    /**this method will use a selection sort to organize the pizza arraylist by
     * the amount of calories in increasing order
     *
     * @return nothing
     */
    private void sortByCalories() {
        //todo:
        for (int i = 0; i < pizzas.size() - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < pizzas.size(); j++) {
                Pizza currMin = (Pizza) pizzas.get(minIndex);
                if (currMin.compareToByCalories(pizzas.get(j)) == 1) {
                    minIndex = j;
                }
            }
            pizzas.swap(i, minIndex);
        }
    }

    /**this method will use a binary search to find the target calories in
     * the pizza arraylist and returns the index of where it is found
     *
     * @param cals the integer of amount of calories to find
     * @return int of the index where the amount of calories are found
     */
    private int binarySearchByCalories(int cals) {
        //todo:
        sortByCalories();
        Pizza search = new Pizza();
        search.setCalories(cals);
        int searchIndex = 0;
        int lowIndex = 0;
        int highIndex = pizzas.size() - 1;
        //as long as the lowIndex is less than the highIndex value
        while (lowIndex <= highIndex) {
            //the midIndex is found by splitting the list into half from adding
            //the lowIndex and highIndex, then dividing by 2
            int midIndex = (lowIndex + highIndex) / 2;
            //if the array of midIndex element is equal to the target, then it will return the
            //value of the midIndex
            Pizza temp = (Pizza) pizzas.get(midIndex);
            if (temp.getCalories() == cals) {
                searchIndex++;
                return midIndex;
                //if the target is greater than the array of the midIndex,
                //then the highIndex will shift down one
            } else if (temp.compareToByCalories(search) > 0) {
                searchIndex++;
                highIndex = midIndex - 1;
                //if the target is less than the array of the midIndex,
                //then the lowIndex will shift up one
            } else if (temp.compareToByCalories(search) < 0) {
                searchIndex++;
                lowIndex = midIndex + 1;
            }
        }
        return searchIndex;
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    /**
     *
     */
    private void displayInstructions() {
        System.out.println(instructions);
    }

    /**
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
