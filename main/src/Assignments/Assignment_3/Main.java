package Assignments.Assignment_3;
public class Main {
    public static void main(String[] args) {
        SingleLinkedListTest sll = new SingleLinkedListTest();
        sll.insertLinkedList(1,0);
        sll.insertLinkedList(2,1);
        sll.insertLinkedList(3,2);
        sll.insertLinkedList(4,3);
        sll.traverseLinkedList();
        sll.searchNode(5);

        System.out.println("\n\n==========   Delete node at index 2 ==========");

        int location = 2;
        if (sll.deleteNode(location)) {
            System.out.println("Deletion successful at index " + location);
            System.out.print("Updated List: ");
            sll.traverseLinkedList();
        }

        System.out.println("========== Delete head (index 0) ==========");
        if (sll.deleteNode(0)) {
            System.out.println("Head deleted");
            System.out.print("Updated List: ");
            sll.traverseLinkedList();
        }

        System.out.println("========== Invalid Deletion at (index 5)==========");
        if (sll.deleteNode(5)) {
            System.out.println("Head deleted");
            System.out.print("Updated List: ");
            sll.traverseLinkedList();
           
        }

        System.out.println();

        



    }
}
