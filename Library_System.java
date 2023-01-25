import java.util.Scanner;

class Library {
    private int numBook, x = 0;
    private int j = 0;
    public String[][] issue = new String[50][2];
    public int[] iprice = new int[50];
    private final String[][] Books = new String[50][2];
    private final int[] Price = new int[50];
    Scanner sc = new Scanner(System.in);
    private int k;

    void Dis() {
        System.out.println("\n\t\t\t **Choice**  ");
        System.out.println("\t\t\t1.  Main Menu ");
        System.out.println("\t\t\t2.  Issue Book ");
        System.out.println("\t\t\t3.  Return Book ");
        System.out.println("\t\t\t4.  Available Books ");
        System.out.print("\t\t\t Enter Choice  : ");
        int choice = sc.nextInt();
        if (choice == 1) {
            LibDisplay();
        } else if (choice == 2) {
            issueBook();
        } else if (choice == 3) {
            returnBooks();
        } else if (choice == 4) {
            showAvailableBook();
        } else {
            System.out.println("\n  \t\tEnter Valid Choice : ");
        }
    }

    void LibDisplay() {
        System.out.println("*************************Library Management*************************");
        System.out.println("\n\t\t\t MAIN MENU      \n");
        System.out.println("\t\t\t1. Add Books       ");
        System.out.println("\t\t\t2. Issue Book      ");
        System.out.println("\t\t\t3. Return Book      ");
        System.out.println("\t\t\t4. Show Available Books      ");
        System.out.println("\t\t\t5. Issued BOOKS   ");
        System.out.println("\t\t\t6. Exit      ");
        System.out.print("\n\t\t\t Enetr Choice : ");
        int choice = sc.nextInt();
        while (choice != 6) {
            if (choice == 1) {
                addBook();
            } else if (choice == 2) {
                issueBook();
            } else if (choice == 3) {
                returnBooks();
            } else if (choice == 4) {
                showAvailableBook();
            } else if (choice == 5) {
                issuedBook();
            } else {
                System.out.println("\n\t\t\tEnter Valid Choice !!!");
            }
        }
    }

    void addBook() {
        System.out.println("\n*****************************ADD BOOKs******************************");
        System.out.print("\n\t\tEnter Number of books You Want to add : ");
        this.numBook = sc.nextInt();
        this.k = numBook;
        System.out.println(this.x);
        for (int i = this.x - this.j; i < this.numBook + this.x - j; i++) {
            System.out.print("\n\t\t\t  | " + (i + 1) + " Book |");
            System.out.print("\n\t\t\tBook Name   : ");
            this.Books[i][0] = sc.next();
            System.out.print("\t\t\tAuthor Name : ");
            this.Books[i][1] = sc.next();
            System.out.print("\t\t\tPrice      : ");
            this.Price[i] = sc.nextInt();
        }
        this.x = this.x + this.numBook;
        System.out.println("\n\t\t\tBooks Added Succesfully !! ");
        Dis();
    }

    void issueBook() {
        System.out.println("\n*****************************Issuing Books*****************************");
        int n = this.numBook + this.x - this.k - this.j;
        int i = 0;
        while (i != n) {
            System.out.print("\t\t\t | " + (i + 1) + " Book |");
            System.out.println("\n\t\t\t* Name   : " + this.Books[i][0]);
            System.out.println("\t\t\t* Author : " + this.Books[i][1]);
            System.out.println("\t\t\t* Price  : " + this.Price[i] + " Rs\n");
            i++;
        }
        System.out.print("\n\t\tEnter Book Number of the Book That You Want to Choose : ");
        int issue = sc.nextInt();
        int b = issue - 1;
        this.issue[j][0] = Books[b][0];
        this.issue[j][1] = Books[b][1];
        this.iprice[j] = Price[b];
        for (i = b; i < n - 1; i++) {
            Books[i][0] = Books[i + 1][0];
            Books[i][1] = Books[i + 1][1];
            Price[i] = Price[i + 1];
        }
        j++;
        issuedBook();
    }

    void issuedBook() {
        System.out.println("\n****************************Issued BOOK*****************************");
        int a = 1;
        for (int i = 0; i < j; i++) {
            System.out.print("\t\t\t   | " + a + " Book |");
            System.out.println("\n\t\t\t* Name   : " + this.issue[i][0]);
            System.out.println("\t\t\t* Author : " + this.issue[i][1]);
            System.out.println("\t\t\t* Price  : " + this.iprice[i] + " Rs\n");
            a++;
        }
        Dis();
    }

    void returnBooks() {
        System.out.println("\n****************************Return BOOK*****************************");
        int a = 1;
        for (int i = 0; i < j; i++) {
            System.out.print("\t\t\t | " + a + " Book |");
            System.out.println("\n\t\t\t* Name   : " + this.issue[i][0]);
            System.out.println("\t\t\t* Author : " + this.issue[i][1]);
            System.out.println("\t\t\t* Price  : " + this.iprice[i] + " Rs\n");
            a++;
        }
        System.out.print("Which one Book You Want to Return : ");
        int ret = sc.nextInt(); // Return
        int n = this.numBook + this.x - this.k - this.j; // Location where to store in array of
        this.Books[n][0] = this.issue[ret - 1][0];
        this.Books[n][1] = this.issue[ret - 1][1];
        this.Price[n] = this.iprice[ret - 1];
        for (int i = ret - 1; i < j; i++) {
            issue[i][0] = issue[i + 1][0];
            issue[i][1] = issue[i + 1][1];
            iprice[i] = iprice[i + 1];
        }
        j--;
        Dis();
    }

    void showAvailableBook() {
        System.out.println("\n****************************Books Available****************************");
        int n = this.numBook + this.x - this.k - this.j;
        int a = 1;
        int i = 0;
        while (i != n) {
            System.out.print("\t\t\t | " + a + " Book |");
            System.out.println("\n\t\t\t* Name   : " + this.Books[i][0]);
            System.out.println("\t\t\t* Author : " + this.Books[i][1]);
            System.out.println("\t\t\t* Price  : " + this.Price[i] + " Rs\n");
            a++;
            i++;
        }
        Dis();
    }
}

public class Library_System {
    public static void main(String[] args) {
        Library l = new Library();
        l.LibDisplay();
    }
}
