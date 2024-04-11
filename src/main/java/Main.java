

public class Company {
    private Queue<Worker> workers;

    // Constructor

    // Method to fire employees based on department and number
    public void fired(int department, int num) {
        int count = 0;
        Queue<Worker> tempQueue = new Queue<>();

        while (!workers.isEmpty()) {
            Worker current = workers.remove();
            if (current.getDepartment() == department) {
                count++;
                if (count <= num) {
                    continue; // Skip firing this worker
                }
            }
            tempQueue.insert(current);
        }

        workers = tempQueue; // Update the original queue
    }

    // Method to delete workers based on Delete objects
    public void delete(List<Delete> toDelete) {
        Queue<Worker> tempQueue = new Queue<>();

        while (!workers.isEmpty()) {
            Worker current = workers.remove();
            boolean found = false;
            for (Delete d : toDelete) {
                if (current.getDepartment() == d.getDepartment()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                tempQueue.insert(current);
            }
        }

        workers = tempQueue; // Update the original queue
    }
}
public class Main {
    public static void main(String[] args) {
        // Create a Company object
        Company company = new Company();

        // Add some workers to the queue for testing
        company.workers.insert(new Worker("John", 1, 2010));
        company.workers.insert(new Worker("Alice", 2, 2012));
        company.workers.insert(new Worker("Bob", 1, 2015));
        company.workers.insert(new Worker("Emily", 2, 2013));
        company.workers.insert(new Worker("David", 3, 2018));

        // Print the initial state of the queue
        System.out.println("Initial Queue: " + company.workers);

        // Test firing employees based on department and number
        company.fired(1, 1); // Fire one employee from department 1
        System.out.println("After firing: " + company.workers);

        // Test deleting workers based on Delete objects
        List<Delete> toDelete = new ArrayList<>();
        toDelete.add(new Delete(2, 1)); // Delete one employee from department 2
        company.delete(toDelete);
        System.out.println("After deletion: " + company.workers);
    }
}
