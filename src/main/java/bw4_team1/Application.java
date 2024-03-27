package bw4_team1;

import DAO.*;
import entities.Route;
import entities.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Application {
    static Scanner input = new Scanner(System.in);
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        UserDAO udao = new UserDAO(em);
        SalesDAO sdao = new SalesDAO(em);
        PassDAO pdao = new PassDAO(em);
        CardDAO cdao = new CardDAO(em);
        TicketDAO tdao = new TicketDAO(em);

        emf.close();
        em.close();



        app:
        while (true) {

            System.out.println("------------------------ WELCOME TO OUR TRANSPORT COMPANY'S APP----------------------------------------");
            System.out.println("Choose the user type:");
            System.out.println("1 - User");
            System.out.println("2 - Admin");
            System.out.println("0 - Exit");
            int choice = input.nextInt();


//            System.out.println("Now, select the options below:");
//            System.out.println("1 To check if your card is still valid");
//            System.out.println("2 To check if your ticket/pass is valid");


//            System.out.println("Dear user, please press:");
//            System.out.println("1 To check the bus/tram route");
//            System.out.println("2 To check the time of the route");
//            System.out.println("3 To check if your card is still valid");
//            System.out.println("4 To check if the bus/tram is on maintenance or in service");
//            System.out.println("5 To check where the ticket or the pass was sold from");
//            System.out.println("6 To check if your ticket/pass is valid");
//            System.out.println("0 to exit from the application.");



            switch (choice) {

                case 0:
                    System.out.println("Thanks and see you soon :)");
                    input.close();
                    break app;


                case 1:
                    System.out.println("Now, select the options below:");
                    System.out.println("1 To check if your card is still valid");
                    System.out.println("2 To check if your ticket is valid");
                    System.out.println("3 To check if your pass is valid");
                    int inputUser = input.nextInt();
                    switch (inputUser){
                        case 1:
                            System.out.println("Insert your ID:");
                            long id = input.nextLong();
                            System.out.println(cdao.ValidityByUserId(id));
                            break;

                        case 2:
                            System.out.println("Insert your ticket number");
                            long idTicket = input.nextLong();
                            System.out.println(tdao.);
                            break;

                        case 3:
                            System.out.println("Insert your pass number");
                            long idPass = input.nextLong();
                            System.out.println(pdao.findPassesByIssueId(idPass));
                            break;

                    }

                    int userInput = input.nextInt();

                    switch (userInput) {
                        case 1:
                            System.out.println(cdao.ValidityByUserId(id));
                            break;

//                        case 2:
//                           System.out.println();
                    }
                    break;


                case 2:
                    System.out.println("2 to check ");
                    break;


                case 3:
                    break;


                case 4:
                    break;


                case 5:
                    break;

                case 6:
                    break;


                default:


            }

        }
    }

    }





















