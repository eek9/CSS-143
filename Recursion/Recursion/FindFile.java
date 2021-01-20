import java.io.File;
/**
 * The FindFile class will have a target file that is to be found in a given
 * path, which will return the location of where it is found.
 * The methods in this class will consist of a constructor,
 * directorySearch, getCount, and a getFiles method.
 *
 * @author Eunhee Kim
 * @version October 7, 2019
 */
public class FindFile {

    private int maxFiles;
    private int count;
    private String[] Files;

    /**This constructor accepts the maximum number of files to find.
     *
     * @param maxFiles integer maximum number of files used to find the target
     */
    public FindFile(int maxFiles) {
        this.maxFiles = maxFiles;
        this.count = 0;
        this.Files =new String[maxFiles];
    }


    /**this method will calculate where to look for the target in the directory
     * name through recursively looking through each one to check and see if it
     * makes a match to the name of the target. The parameters are the target file
     * name to look for and the directory to start in
     *
     * @param target String of the name of the target file to be found
     * @param dirName String name of the directory to be found from
     */
    public void directorySearch(String target, String dirName) {
        //creating an object of the File class with the file coming from
        //the passing parameter in place of dirName
        File f = new File(dirName);
        //making sure if the dirName is a directory or not and passing an exception
        //this is the base case
        if(!(f.isDirectory())) {
            throw new IllegalArgumentException("Invalid Directory");
        }
        //making a String array of the File object
        String[] fileList = f.list();
        //if the array is not empty it will enter a loop where it checks to see
        //if the target is found as it goes down the array of files and will count
        //how many times it has occured
        if(fileList!=null) {
            for(int i=0; i<fileList.length; i++) {
                if(fileList[i].equals(target)) {
                    count++;
                }
                //exception when the count exceeds the amount of maximum files
                if(count==maxFiles) {
                    throw new IllegalArgumentException("Maximum files");
                } else {
                    //if the file is not found within one loop, then it will continue
                    //on to the next repitition of recursive method to find a search
                    //on for the next
                    File aFile = new File(dirName+"\\" + fileList[i]);
                    if(aFile.isDirectory()) {
                        //this is the recursive method that will continue on searching
                        //within the directory until the name of the target appears
                        directorySearch(target, aFile.getAbsolutePath());
                    }
                }
            }
        }
    }

    /**This accessor returns the number of matching files found
     *
     * @return an integer of the amount of occurrences the target file has been found
     */
    public int getCount() {
        return this.count;
    }

    /**This getter returns the array of file locations, up to maxFiles in size.
     *
     * @return a String array in the names of files where the target appears
     */
    public String[] getFiles() {
        return this.Files;
    }
}
