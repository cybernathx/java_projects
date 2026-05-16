import java.util.Scanner;
import java.util.ArrayList;

public class StudManagementTest {
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
                

                try {
                    choice = input.nextInt();
                    input.nextLine();
                } catch (Exception e) {
                    System.out.println("\nSelect an integer!");
                    System.out.println();
                    input.nextLine();
                    continue;
                }
                

                if (choice == 1) {
                    System.out.print("How many students do you want to add?: ");
                    try {
                        count = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        System.out.println();
                        input.nextLine();
                        continue;
                    }

                    for (int i = 0; i < count; i++) {

                        System.out.println("\nStudent" + (i + 1));

                        System.out.print("Input student id: ");
                        try{
                            id = input.nextInt();
                            input.nextLine();
                        } catch (Exception e) {
                            System.out.println("Invalid Input!");
                            System.out.println();
                            input.nextLine();
                            continue;
                        }
                        

                        System.out.print("Input student name: ");
                        names = input.nextLine();

                        System.out.print("Input student age: ");
                        try{
                            ages = input.nextInt();
                            input.nextLine();
                        } catch (Exception e) {
                            System.out.println("Invalid Input!");
                            System.out.println();
                            input.nextLine();
                            continue;
                        }
                        

                        System.out.print("Input student department: ");
                        depts = input.nextLine();
                        
                        try {
                            students.add(new StudManagement(id, names, ages, depts));
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        

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
                        searchID = input.nextInt();
                        input.nextLine();

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
                        deleteID = input.nextInt();
                        input.nextLine();

                        boolean found = false;

                        for (int i = 0; i < students.size(); i++) {

                            if (deleteID == students.get(i).getID()) {
                                System.out.println("Are you sure you want to delete " + deleteID + "? (y/n)");
                                String ans = input.nextLine();
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