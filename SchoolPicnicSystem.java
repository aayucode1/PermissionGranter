import java.util.Scanner;

// Abstract base class representing a generic panel
abstract class Panel {
    abstract void display();
}

// Admin Panel
class AdminPanel extends Panel {
    private String picnicSpot = "Nehru Planetarium";
    private double fees = 500.0;

    @Override
    void display() {
        System.out.println("=== Admin Panel ===");
        System.out.println("Picnic Spot: " + picnicSpot);
        System.out.println("Fees: Rs. " + fees);
    }

    // Method to ask the question
    String askPermissionQuestion() {
        return "Do you want your child to go to the picnic? (1 for Yes, 2 for No)";
    }
}

// Parent Panel
class ParentPanel extends Panel {
    private boolean permissionGranted;

    @Override
    void display() {
        System.out.println("=== Parent Panel ===");
    }

    // Method to capture parent's decision
    public void setPermission(int choice) {
        this.permissionGranted = choice == 1;
    }

    public boolean isPermissionGranted() {
        return this.permissionGranted;
    }
}

// Student Panel
class StudentPanel extends Panel {
    @Override
    void display() {
        System.out.println("=== Student Panel ===");
    }

    public void showPermissionStatus(boolean isGranted) {
        if (isGranted) {
            System.out.println("Yay! You were granted permission to go to the picnic.");
        } else {
            System.out.println("Noo! You weren't granted permission to go to the picnic.");
        }
    }
}

// Main class to handle the panels
public class SchoolPicnicSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdminPanel adminPanel = new AdminPanel();
        ParentPanel parentPanel = new ParentPanel();
        StudentPanel studentPanel = new StudentPanel();

        while (true) {
            System.out.println("Choose Panel:");
            System.out.println("1. Admin Panel");
            System.out.println("2. Parent Panel");
            System.out.println("3. Student Panel");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminPanel.display();
                    String question = adminPanel.askPermissionQuestion();
                    System.out.println(question);
                    break;

                case 2:
                    parentPanel.display();
                    System.out.println("Enter your choice: 1 for Yes, 2 for No");
                    int parentChoice = scanner.nextInt();
                    parentPanel.setPermission(parentChoice);
                    System.out.println("Your response has been recorded.");
                    break;

                case 3:
                    studentPanel.display();
                    studentPanel.showPermissionStatus(parentPanel.isPermissionGranted());
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
