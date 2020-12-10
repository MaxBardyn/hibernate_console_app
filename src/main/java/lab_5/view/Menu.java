package lab_5.view;

public class Menu {


    public void displayMenu() {

        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("|       Enter any combination of existing entity and CRUD number :      |");
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                  |                                    |");
        System.out.println("|            entity:               |                CRUD:               |");
        System.out.println("|__________________________________|____________________________________|");
        System.out.println("|   |                              |   |                                |");
        System.out.println("| 1 | user                         | 1 | GET ALL                        |");
        System.out.println("| 2 | artist                       | 2 | GET ONE BY ID                  |");
        System.out.println("| 3 | event                        | 3 | CREATE                         |");
        System.out.println("| 4 | location                     | 4 | UPDATE                         |");
        System.out.println("| 5 | ticket                       | 5 | DELETE                         |");
        System.out.println("| 6 | ticket_office                |   |                                |");
        System.out.println("|___|______________________________|___|________________________________|");

    }
}