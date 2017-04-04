package abstractList;

/**
 * Created by nedav on 04/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);

        list.traverse(list.getRoot());

        String stringData =  "5 7 3 9 8 2";

        String[] data = stringData.split(" ");
        for (String s  : data){
            list.addItem(new Node (s));
        }


        list.traverse(list.getRoot());
        //list.removeItem("5");
    }

}
