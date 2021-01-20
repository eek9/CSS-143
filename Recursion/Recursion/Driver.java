/**
 *
 * @author Eunhee Kim
 * @version October 7, 2019
 */
public class Driver {

    public static void main(String[] args) throws Exception {

        String targetFile = "ClassesAndPrivacy.zip";
        String pathToSearch = "C:\\Users\\eunhe\\OneDrive\\Documents\\Autumn2019\\CSS 143";
        FindFile finder = new FindFile(10);
        try {
            finder.directorySearch(targetFile, pathToSearch);
        } catch(Exception e) {
            System.out.println("exception is caught");
        }
        System.out.println(finder.getCount());
        System.out.println(finder.getFiles());

    }
}
