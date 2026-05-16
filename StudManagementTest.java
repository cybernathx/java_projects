import java.util.Scanner;
import java.util.ArrayList;

public class StudManagementTest {

    public static int IntInputValidator(Scanner input) {
        while (true) {

            try{

                int value = input.nextInt();
                input.nextLine();

                return value;

            } catch (Exception e) {
                System.out.print("Invalid entry! Input a number: ");
                input.nextLine();
            }
        }
    }

    public static String StringInputValidator(Scanner input) {
        while (true) {
            String value =  input.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            } else {
                System.out.print("This field cannot be empty! Try again: ");
            }
        }
        
    }
    public static void main(String[] args) {

        
        ArrayList<StudManagement> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int id;
        String names;
        int ages;
        String depts;
        int count, choice, deleteID, searchID;

        while (true) {
            System.out.println("\nWelcome! What do you want to do?\n1.Add Student\n2.View all Students\n3.Search\n4.Delete Student\n5.Exit");
            System.out.print("\nSelect an option: ");
            

            choice = IntInputValidator(input);
            

            if (choice == 1) {
                System.out.print("How many students do you want to add?: ");
                count = IntInputValidator(input);

                for (int i = 0; i < count; i++) {

                    System.out.println("\nStudent" + (i + 1));

                    System.out.print("Input student id: ");
                    id = IntInputValidator(input);
                    

                    System.out.print("Input student name: ");
                    names = StringInputValidator(input);

                    System.out.print("Input student age: ");
                    ages = IntInputValidator(input);
                    

                    System.out.print("Input student department: ");
                    depts = StringInputValidator(input);
                    
                    students.add(new StudManagement(id, names, ages, depts));
                    System.out.println("\nAdded Successfully!");                   
                }
            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("Oops!, Empty record");
                } else {
                    System.out.println("\n----ALL STUDENTS----");
                

                    for (StudManagement s : students) {
                        System.out.println(s);
                        System.out.println();
                    }
                }
            } else if (choice == 3) {
                if (students.isEmpty()) {
                    System.out.println("\n---RECORD IS EMPTY!---");
                } else {
                    System.out.print("Who do you want to search for (by ID): ");

                    searchID = IntInputValidator(input);
                    

                    boolean found = false;
                    for (int i = 0; i < students.size(); i++) {
                        
                        if (searchID == students.get(i).getID()) {
                            System.out.println("\nStudent ID: " + students.get(i).getID());
                            System.out.println("Student Name: " + students.get(i).getName());
                            System.out.println("Student Age: " + students.get(i).getAge());
                            System.out.println("Student Course: " + students.get(i).getCourse());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\n---RECORD NOT FOUND!---");
                    } 
                }
            } else if (choice == 4){
                if (students.isEmpty()) {
                    System.out.println("\n---RECORD IS EMPTY---!");
                } else {
                    System.out.print("\nInput id of student you want to delete: ");

                    deleteID = IntInputValidator(input);
                    

                    boolean found = false;

                    for (int i = 0; i < students.size(); i++) {

                        if (deleteID == students.get(i).getID()) {
                            System.out.println("Are you sure you want to delete " + deleteID + "? (y/n)");
                            String ans = StringInputValidator(input);
                            if (ans.equalsIgnoreCase("y")) {
                                students.remove(i);
                                System.out.println("Deleted Successfully!");
                                found = true;
                                break;
                            } else {
                                break;
                            }
                                    
                        }
                    }

                    if (!found) {
                        System.out.println("---NOT FOUND!---");
                    }
                }
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("\nInvalid option!");
            }
            
        }
        input.close();
    }
}