package bw4_team1;

import DAO.TicketDAO;
import entities.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");
    public static void main(String[] args) {

        EntityManager eM = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------WELCOME TO OUR TRANSPORT COMPANY'S APP---------------------------");
        System.out.println("Dear user, please press:");
        System.out.println("1 To create your own card if you don't have one yet") ;
        System.out.println("2 to buy a daily ticket or a weekly/monthly pass");
        System.out.println("3 to check the route of the bus/tram");
        System.out.println("0 to exit from the application.");

        answer=scanner.nextInt();

        switch(answer){

            case 0:
                System.out.println("Thanks and see you soon :)");
                scanner.close();



            case 1:
                System.out.println("");
                break;


            case 2:
                break;





            case 3:
                break;




            case 4:
                break;



            default:



        }






        


        emf.close();
        eM.close();
    }
}
