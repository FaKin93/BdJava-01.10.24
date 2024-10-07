package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddElementToTable addElementToTable = new AddElementToTable();
        DeleteElementFromTable deleteElementFromTable = new DeleteElementFromTable();
        RetrieveElementById retrieveElementById = new RetrieveElementById();
        String stop = "";
        String[] del = new String[1];
        String[] add = new String[3];
        String[] view = new String[1];
        String choice = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter what you want to do: ");
            choice = scanner.nextLine();
            switch (choice){
                case "add":
                    Scanner ad = new Scanner(System.in);
                    System.out.println("Enter title author year: ");
                    add = ad.nextLine().split(" ");
                    addElementToTable.main(add);
                    break;
                case "view":
                    Scanner vie = new Scanner(System.in);
                    System.out.println("Enter Id: ");
                    view[0] = vie.nextLine();
                    retrieveElementById.main(view);
                    break;
                case "delete":
                    Scanner de = new Scanner(System.in);
                    System.out.println("Enter Id: ");
                    del[0] = de.nextLine();
                    deleteElementFromTable.main(del);
                    break;
            }


        } while (!choice.equals("stop"));


    }
}
