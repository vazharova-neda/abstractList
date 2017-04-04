package abstractList;

/**
 * Created by nedav on 04/04/2017.
 */
public class MyLinkedList implements NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){ // this means list is empty
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0){  //new item is greater
               if (currentItem.next() != null){
                   currentItem = currentItem.next();
               }else{ //reached the end of the list so insert at end
                   currentItem .setNext(newItem).setPrevious(currentItem);
                   return true;
               }
            }else if(comparison > 0){ //newItem is less insert before
                if (currentItem.previous() != null){
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                    return true;
                }else { //this is the first item
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            }else{
                System.out.println("Item " + newItem.getValue() + " is alredy recorded");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparason = currentItem.compareTo(item);
            if (comparason == 0) { //found the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparason < 0) {
                currentItem = currentItem.next();
            } else {
                //item is not in the list;
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null){
            System.out.println("list is empty");
        }else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }


    }
}
