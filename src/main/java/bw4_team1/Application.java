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
        RouteDAO routeDAO = new RouteDAO(em);





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
                    System.out.println("2 To check if your ticket has been validated");
                    System.out.println("3 To check if your pass is valid");
                    System.out.println("0 - To go back");
                    int inputUser = input.nextInt();
                    app2:
                    while (true) {


                        switch (inputUser) {

                            case 0:
                                System.out.println("Thanks and see you soon");
                                break app2;
                            case 1:
                                System.out.println("Insert your ID:");
                                long id = input.nextLong();
                                System.out.println(cdao.ValidityByUserId(id));
                                break;

                            case 2:
                                System.out.println("Insert your ticket number");
                                int idTicket = input.nextInt();
                                System.out.println(tdao.TicketValidation(idTicket));
                                break;

                            case 3:
                                System.out.println("Insert your pass number");
                                long idPass = input.nextLong();
                                System.out.println(pdao.findPassesByIssueId(idPass));
                                break;

                            default:
                                System.out.println("This option is not valid!");

                        }
                        break;
                    }


                case 2:
                    System.out.println("1 - To check how many times the route has been travelled by a vehicle and the actual time");
                    System.out.println("2 - To check if a vehicle is on maintenance");
                    System.out.println("3 - To check the records of maintenances af a single vehicle");
                    System.out.println("4 - To check the number of tickets validated on a single vehicle");
                    System.out.println("5 - To check the number of tickets validated in a period of time");
                    System.out.println("6- To check the number of tickets sold by a specific seller");
                    System.out.println("7 - To check the number of tickets sold in a specific time period");
                    System.out.println("0 - To go back");
                    int inputAdmin = input.nextInt();
                    switch (inputAdmin) {
                        case 1:
                            System.out.println("Insert the vehicle id");
                            int adminScanVehicle = input.nextInt();
                            System.out.println("Insert the route id");
                            int adminScanRoute = input.nextInt();
                            routeDAO.RouteData(adminScanVehicle,adminScanRoute);
                            break;

                        case 2:
                            System.out.println("Insert the vehicle id");
                            int adInput = input.nextInt();
                            


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

        emf.close();
        em.close();
        input.close();
    }



    }





















