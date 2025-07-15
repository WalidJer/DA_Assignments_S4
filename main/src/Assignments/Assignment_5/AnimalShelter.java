package Assignments.Assignment_5;
import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    private Queue<Animal> dogQueue;
    private Queue<Animal> catQueue;
    private int nextOrderNumber;


    public AnimalShelter() {

        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.nextOrderNumber = 0;
    }

    public void enqueue(String name, String type){
         Animal animal = new Animal(name, type, nextOrderNumber++);
        if (type.equalsIgnoreCase("dog")) {
            dogQueue.add(animal);
        } else if (type.equalsIgnoreCase("cat")) {
            catQueue.add(animal);
        } else {
            System.out.println("Unknown animal type: " + type);
        }

    }

    public Animal dequeueDog(){
        if (!dogQueue.isEmpty()){
            return dogQueue.poll();
        }
        System.out.println("No dogs available!");
        return null;
    }

    public Animal dequeueCat() {
        if (!catQueue.isEmpty()) {
            return catQueue.poll();
        }
        System.out.println("No cats available!");
        return null;
    }

    public Animal dequeueAny(){
        if (dogQueue.isEmpty() && catQueue.isEmpty()){
            System.out.println("No animals in shelter!");
            return null;
        }

        if (dogQueue.isEmpty()) {
            return dequeueCat();
        }
        if (catQueue.isEmpty()) {
            return dequeueDog();
        }

        Animal dog = dogQueue.peek();
        Animal cat = catQueue.peek();

        if (dog.getArrivalOrder() < cat.getArrivalOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public void printDogQueue() {
        System.out.println("DOGS IN SHELTER:");
        if (dogQueue.isEmpty()) {
            System.out.println("[ empty ]");
        } else {
            for (Animal dog : dogQueue) {
                System.out.printf("[ #%d ] %s%n", dog.getArrivalOrder() + 1, dog.getName());
            }
        }
        System.out.println();
    }

    public void printCatQueue() {
        System.out.println("CATS IN SHELTER:");
        if (catQueue.isEmpty()) {
            System.out.println("[ empty ]");
        } else {
            for (Animal cat : catQueue) {
                System.out.printf("[ #%d ] %s%n", cat.getArrivalOrder() + 1, cat.getName());
            }
        }
        System.out.println();
    }

    public void printShelterStatus() {
        System.out.println("=== SHELTER STATUS ===");
        printDogQueue();
        printCatQueue();
        System.out.println("======================\n");
    }

    
}
