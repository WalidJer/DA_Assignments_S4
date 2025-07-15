package Assignments.Assignment_5;
public class Main {

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        // Add dogs and cats
        animalShelter.enqueue("dog1", "dog");
        animalShelter.enqueue("cat1", "cat");
        animalShelter.enqueue("dog2", "dog");
        animalShelter.enqueue("cat2", "cat");


        animalShelter.printShelterStatus();

        System.out.println("--- Dequeue Any ---");
        Animal adopted1 = animalShelter.dequeueAny();
        System.out.println("Adopted: " + adopted1.getName());
        animalShelter.printShelterStatus();

        System.out.println("--- Dequeue Cat ---");
        Animal adopted2 = animalShelter.dequeueCat();
        System.out.println("Adopted: " + adopted2.getName());
        animalShelter.printShelterStatus();

        System.out.println("--- Dequeue Dog ---");
        Animal adopted3 = animalShelter.dequeueDog();
        System.out.println("Adopted: " + adopted3.getName());
        animalShelter.printShelterStatus();

        System.out.println("--- Dequeue Any ---");
        Animal adopted4 = animalShelter.dequeueAny();
        System.out.println("Adopted: " + adopted4.getName());
        animalShelter.printShelterStatus();
    }
    
}
