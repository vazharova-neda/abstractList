package abstractList;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nedav on 04/04/2017.
 */
public abstract class ListItem {

     protected ListItem left = null; //left link
     protected ListItem right = null; //right link

    protected  Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    abstract int compareTo(ListItem item);


}
