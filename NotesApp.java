
import java.io.*;
import java.util.Scanner;

public class NotesApp 
{
    	private static final String FILE_NAME = "notes.txt";

    	public static void main(String[] args) 
	{
        	Scanner scanner = new Scanner(System.in);
        	while (true) 
		{
            		System.out.println("\n===== Notes App =====");
            		System.out.println("1. Write Note");
            		System.out.println("2. Read Notes");
            		System.out.println("3. Exit");
            		System.out.print("Choose an option: ");
            		int choice = scanner.nextInt();
            		scanner.nextLine();

            		switch (choice) 
			{
                		case 1:
                    			System.out.print("Enter your note: ");
                    			String note = scanner.nextLine();
                    			writeNoteToFile(note);
                    			break;
                		case 2:
                    			readNotesFromFile();
                    			break;
                		case 3:
                    			System.out.println("Exiting Notes App...");
                    			return;
                		default:
                    			System.out.println("Invalid choice.");
            		}
        	}
    	}

    	private static void writeNoteToFile(String note) 
	{
        	try (FileWriter writer = new FileWriter(FILE_NAME, true)) 
		{
            		writer.write(note + System.lineSeparator());
            		System.out.println("Note saved successfully.");
        	} 
		catch (IOException e) 
		{
            		System.out.println("Error writing note: " + e.getMessage());
        	}
    	}

    	private static void readNotesFromFile() 
	{
        	try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) 
		{
            		String line;
            		System.out.println("\n--- Your Notes ---");
            		while ((line = reader.readLine()) != null) 
			{
                		System.out.println("- " + line);
            		}
        	} 
		catch (FileNotFoundException e) 
		{
            		System.out.println("No notes found. Start writing some!");
        	} 
		catch (IOException e) 
		{
            		System.out.println("Error reading notes: " + e.getMessage());
        	}
    	}
}
