
import java.io.*;
import java.util.Scanner;

public class StudentFile {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // Step 1: Create the file if it does not exist
        File file = new File("student.txt");
        file.createNewFile();

        // Step 2: Accept details of 3 students
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter details of student " + i);

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Enter course: ");
            String course = sc.nextLine();

            // Step 3: Write details into the file
            bw.write("Name: " + name + ", Age: " + age
                    + ", Course: " + course);
            bw.newLine();
        }

        bw.close();

        // Step 4: Read and display student details
        System.out.println("\nStudent Details:");

        BufferedReader br = new BufferedReader(
                new FileReader(file));

        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();

        // Step 5: Append details of one more student
        System.out.println("\nEnter details of one more student");

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        FileWriter appendWriter = new FileWriter(file, true);
        BufferedWriter appendBuffer = new BufferedWriter(appendWriter);

        appendBuffer.write("Name: " + name + ", Age: " + age
                + ", Course: " + course);
        appendBuffer.newLine();

        appendBuffer.close();

        // Step 6: Display the appended student details
        System.out.println("\nAfter Appending:");

        BufferedReader br2 = new BufferedReader(
                new FileReader(file));

        while ((line = br2.readLine()) != null) {
            System.out.println(line);
        }

        br2.close();
        sc.close();
    }
}

