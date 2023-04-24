package Manager;
import java.util.Scanner;

public class PassHashtable {

    private int tableSize;
    private int size; 
    private LinkedEntry[] table;

    public PassHashtable(int s) 
    {
        size = 0;
        tableSize = s;
        table = new LinkedEntry[tableSize];
        for (int i = 0; i < tableSize; i++)
            table[i] = null;
    } 

    public int getSize()
    {
        return size;
    }

    public void makeEmpty()
    {
        for (int i = 0; i < tableSize; i++)
            table[i] = null;
    }


    public PassEntry get(String key) 
    {
        int hash = (myhash( key ) % tableSize);
        if (table[hash] == null)
            return null;

        else 
        {
            LinkedEntry entry = table[hash];

            while (entry != null && !entry.getKey().equals(key))
                entry = entry.getNext();

            if (entry == null)

                return null;

            else

                return entry.getValue();
        }
    }

    public void insert(String key, PassEntry value) 
    {
        int hash = (myhash( key ) % tableSize);
        if (table[hash] == null)
            table[hash] = new LinkedEntry(key, value);

        else 
        {
            LinkedEntry entry = table[hash];
            while (entry.getNext() != null && !entry.getKey().equals(key))
                entry = entry.getNext();

            if (entry.getKey().equals(key))
                entry.setValue(value);

            else

                entry.setNext(new LinkedEntry(key, value));
        }
        size++;
    }

 
    public void remove(String key) 
    {
        int hash = (myhash( key ) % tableSize);
        if (table[hash] != null) 
        {
            LinkedEntry prevEntry = null;
            LinkedEntry entry = table[hash];

            while (entry.getNext() != null && !entry.getKey().equals(key)) 
            {
                prevEntry = entry;
                entry = entry.getNext();
            }

            if (entry.getKey().equals(key)) 
            {
                if (prevEntry == null)
                    table[hash] = entry.getNext();

                else
                    prevEntry.setNext(entry.getNext());

                size--;

            }

        }

    }

    private int myhash(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= tableSize;
        if (hashVal < 0)

            hashVal += tableSize;

        return hashVal;
    }

    public void printHashTable()
    {
        for (int i = 0; i < tableSize; i++)
        {
            LinkedEntry entry = table[i];

            while (entry != null)
            {
                System.out.println("Title: " + entry.getKey());
                entry.getValue().printEntry();
                entry = entry.getNext();
                System.out.println("");
            }            

        }
    }

        public void printKeys()
    {
        for (int i = 0; i < tableSize; i++)
        {
            LinkedEntry entry = table[i];

            while (entry != null)
            {
                System.out.println("Title: " + entry.getKey());
                entry = entry.getNext();

            }            

        }

    }

    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        PassHashtable tab = new PassHashtable(100);
        System.out.println("Welcome to the password manager. Let's store your first username and password pair.\n");
        System.out.println("Are you ready to begin a new entry? (Y/N)");
        String answer = scan.nextLine(); 

        if(answer.equalsIgnoreCase("Y"))
        {
            PassEntry UserEntry = new PassEntry();
            System.out.println("Please enter a title for the entry, such as the name of the website for which the login will be used:");
            String title = scan.nextLine();
            System.out.println("Please enter the username: ");
            UserEntry.setUser(scan.nextLine());
            System.out.println("Please enter the password: ");
            UserEntry.setPass(scan.nextLine());
            tab.insert(title, UserEntry);
            System.out.println("\nYour entry has been stored.");
            
        } 
        else
        {
            return;
        }

        int choice = 0;

        while(choice != 5)
        {

        System.out.println("\nHow would you like to proceed? Enter the corresponding number: \n");
        System.out.println("1. Make another entry.");
        System.out.println("2. Retrieve a password.");
        System.out.println("3. Delete an entry.");
        System.out.println("4. View all entries.");
        System.out.println("5. Exit the password manager.\n");


        choice = scan.nextInt();  
        scan.nextLine();  // consume the newline character left in the buffer
        

        switch (choice)

        {

        case 1 : 

            PassEntry UserEntry = new PassEntry();
            System.out.println("Please enter a title for the entry, such as the name of the respective website: ");
            String title = scan.nextLine();
            System.out.println("Please enter the username: ");
            UserEntry.setUser(scan.nextLine());
            System.out.println("Please enter the password: ");
            UserEntry.setPass(scan.nextLine());
            tab.insert(title, UserEntry);
            System.out.println("\nYour entry has been stored.");

            break; 
            
        case 2 : 

            System.out.println("Please enter the title of the entry you'd like to retrieve:");
            String search = scan.nextLine();
            System.out.println(search + ": ");
            tab.get(search).printEntry();
            

            break;

        case 3 :

            System.out.println("Please enter the title of the entry you'd like to delete:");
            String delete = scan.nextLine();
            tab.remove(delete);
            System.out.println("Entry filed under " + delete + " has been removed.");

            break;

        case 4 :

            System.out.println("Here are all your entries:");
            tab.printHashTable();

            break;

        case 5 :

            System.out.println("Closing the password manager.");

            break;

        default : 

            System.out.println("Wrong Entry \n ");

            break;   

        }

    }


    }

}