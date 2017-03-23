/**
 * Created by clemenspfister on 23/03/2017.
 */

import java.util.ArrayList;
import java.util.List;

public class TestLists {

    public static void main(String[] args) {


        List<String> stringList = new ArrayList<>();
        stringList.add("One");
        stringList.add("Two");
        System.out.println(stringList.get(1)); // should print "Two", as counting starts at 0

        for (String string : stringList) {
            System.out.println(string);
        }
        stringList.remove(0);
        System.out.println(stringList.size()); // should print "1"


    }

}
