package Assignments.Assignment_4;
public class Main {

    public static void main(String[] args) {

        UndoRedoManager<Integer> undoRedo = new UndoRedoManager<>();

        undoRedo.addNode(1);
        undoRedo.addNode(2);
        undoRedo.addNode(3);
        undoRedo.addNode(4);

        System.out.println("initial nodes:");
        undoRedo.printNodes();
         System.out.println();

        // Undo once
        undoRedo.undo();
        System.out.println("After 1 undo:");
        undoRedo.printNodes();
        System.out.println();

        // Undo again
        undoRedo.undo();
        System.out.println("After 2 undos:");
        undoRedo.printNodes();
        System.out.println();

        // Redo once
        undoRedo.redo();
        System.out.println("After 1 redo:");
        undoRedo.printNodes();
        System.out.println();

        // Redo again
        undoRedo.redo();
        System.out.println("After 2 redos:");
        undoRedo.printNodes();

    }
    
    
}
