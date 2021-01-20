import java.util.Arrays;
/**
 * The CharList Class will read a String and record the number of characters
 * that was included.
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class CharList {
    //You may assume no string will grow beyond 100 characters in this lab.
    //An array to store characters.
    //Should we make this data private?
    //yes
    private char[] ch = new char[100];
    //An integer variable used to track the number of characters
    private int n;

    public CharList() {
    }

    //use string to set up internals
    public CharList(String startStr) {
        this.ch = startStr.toCharArray();
        this.n = ch.length;
    }

    //copy c’tor; be sure to check for null input
    public CharList(CharList other) {
        this.ch = other.ch;
    }

    //Could we make this so it dynamically grows to
    //accommodate more than 100 elements?
    public void add(char next) {
        char[] newCh = new char[ch.length +1];
        System.arraycopy(ch, 0, newCh, 0, ch.length);
        ch=newCh;
    }

    public char get(int index) {
        return ch[index];
    }

    //Return a string that is the concatenated result of
    //combining every character in your char array.
    public String toString() {
        return Arrays.toString(ch) + " and has " + n + "chars";
    }

    //if( other == null || ! (other instanceof CharList )) return false;
    //follow this pattern to check for null and verify class types
    //CharList that = (CharList) other; //use this v.s. that from this point on
    //Two strings are the same if they share the same length and the same characters
    public boolean equals(CharList that) {
        if(that == null || this.n != that.n) {
            return false;
        } else {
            return true;
        }
    }
}
