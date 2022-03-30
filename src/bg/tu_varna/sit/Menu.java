package bg.tu_varna.sit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    protected boolean menuStatus = true;
    String helpMsgPath = "./helpmessage.txt";
    String currentlyOpenFile;

    public Menu() {
        try {
            menuSelector();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void menuSelector() throws FileNotFoundException {
        System.out.println("Make your choice");
        Scanner scanner = new Scanner(System.in);
        while(menuStatus) {
            switch (scanner.next().toLowerCase()) {
                case "open":
                    System.out.println("Successfully opened");
                    break;
                case "save":
                    if(currentlyOpenFile != null){
                        System.out.println("Successfully saved " + currentlyOpenFile);
                    } else {
                        System.out.println("There is currently no open file");
                    }
                    break;
                case "saveas":
                    if(currentlyOpenFile != null){
                        System.out.println("Successfully savedd " + currentlyOpenFile);
                        //do stuff
                    } else {
                        System.out.println("There is currently no open file");
                    }
                    break;
                case "help":
                    printHelpMessage();
                    break;
                case "exit":
                    menuStatus = false;
                    System.out.println("Exiting the programme...");
                    break;
                default:
                    System.out.println("Unrecognised input, type \"help\" to see available commands");
                    break;
            }
        }
    }

    private void printHelpMessage() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(helpMsgPath));
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}
