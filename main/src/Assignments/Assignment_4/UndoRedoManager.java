package Assignments.Assignment_4;
public class UndoRedoManager<T> {

    private Node<T> head;
    private Node<T> current;


    public void addNode(T nodeValue){

        Node<T> node = new Node<>(nodeValue);

         // If no head exists, this is the first and current node
        if (head == null){
            head= current = node;
        }else{
            current.next = null;

            node.previous = current;
            current.next = node;
            current = node;

        }



    }

    public boolean undo(){

        if(current != null && current.previous != null){
            current = current.previous;
            return true;
        }
        System.out.println("no more undo steps");
        return false;
    }

        public boolean redo() {
        if (current != null && current.next != null) {
            current = current.next;  
            return true;
        }
        System.out.println(" No more redo steps.");
        return false;
    }

    public void printNodes() {
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";

        Node<T> temp = head;
  
        while (temp != null) {

            // Highlight the current node 
            if (temp == current) {
                System.out.print(RED  + temp.value + RESET);
            } else {
                System.out.print(temp.value);
            }

        
            if (temp == current)
            break;
            temp = temp.next;

            if (temp != null) 
            System.out.print(" <> ");
        }
        System.out.println();
    }


    
}
