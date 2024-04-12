

public class Company {
    private Queue<Worker> workers;



    
    public void fired(int department, int num) {
        int count = 0;
        Queue<Worker> tempQueue = new Queue<>();

        while (!workers.isEmpty()) {
            Worker current = workers.remove();
            if (current.getDepartment() == department) {
                count++;
                if (count <= num) {
                    continue; 
                }
            }
            tempQueue.insert(current);
        }

        workers = tempQueue; 
    }

    
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

        workers = tempQueue; 
    }
}
public class Main {
    public static void main(String[] args) {
    
        Company company = new Company();

        
        company.workers.insert(new Worker("Miller", 1, 2010));
        company.workers.insert(new Worker("diller", 2, 2012));
        company.workers.insert(new Worker("niller", 1, 2015));
        company.workers.insert(new Worker("biller", 2, 2013));
        company.workers.insert(new Worker("killer", 3, 2018));

        
        System.out.println("Initial Queue: " + company.workers);

        
        company.fired(1, 1); 
        System.out.println("After firing: " + company.workers);

        
        List<Delete> toDelete = new ArrayList<>();
        toDelete.add(new Delete(2, 1));
        company.delete(toDelete);
        System.out.println("After deletion: " + company.workers);
    }
}
