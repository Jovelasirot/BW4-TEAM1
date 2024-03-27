package bw4_team1;

import DAO.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        UserDAO udao = new UserDAO(em);
        SalesDAO sdao = new SalesDAO(em);
        PassDAO pdao = new PassDAO(em);
        CardDAO cdao = new CardDAO(em);
        TicketDAO tdao = new TicketDAO(em);
        RouteDAO routeDAO = new RouteDAO(em);
        VehicleDAO vdao = new VehicleDAO(em);


        app:
        while (true) {

            System.out.println("------------------------ WELCOME TO OUR TRANSPORT COMPANY'S APP----------------------------------------");
            System.out.println("Choose the user type:");
            System.out.println("1 - User");
            System.out.println("2 - Admin");
            System.out.println("0 - Exit");
            int choice = input.nextInt();


            switch (choice) {

                case 0:
                    System.out.println("Thanks and see you soon :)");
                    input.close();
                    break app;


                case 1:
                    app2:
                    while (true) {
                        System.out.println("Now, select the options below:");
                        System.out.println("1 To check if your card is still valid");
                        System.out.println("2 To check if your ticket has been validated");
                        System.out.println("3 To check if your pass is valid");
                        System.out.println("0 - To go back");
                        int inputUser = input.nextInt();

                        switch (inputUser) {

                            case 0:
                                System.out.println("Going back");
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
                                pdao.findPassesByIssueId(idPass).forEach(System.out::println);
                                break;

                            default:
                                System.out.println("This option is not valid!");

                        }
                        break;
                    }
                    break;


                case 2:
                    app3:
                    while (true) {
                        System.out.println();
                        System.out.println("1 - To check how many times the route has been travelled by a vehicle and the actual time");
                        System.out.println("2 - To check if a vehicle is on maintenance");
                        System.out.println("3 - To check the records of maintenances af a single vehicle");
                        System.out.println("4 - To check the number of tickets validated on a single vehicle in a period of time");
                        System.out.println("5 - To check the number of TICKETS sold by a specific seller in a period of time");
                        System.out.println("6 - To check the number of PASSES sold by a specific seller in a period of time");
                        System.out.println("0 - To go back");
                        int inputAdmin = input.nextInt();
                        switch (inputAdmin) {
                            case 1:
                                System.out.println("Insert the route id");
                                long adminScanRoute = input.nextLong();
                                routeDAO.RouteData(adminScanRoute);
                                break;

                            case 2:
                                System.out.println("Insert the vehicle id");
                                long adInput = input.nextLong();
                                vdao.checkMaintenance(adInput);
                                break;


                            case 3:
                                System.out.println("Insert the vehicle id");
                                long vehicleInput = input.nextLong();
                                vdao.getVehicleMaintenanceHistory(vehicleInput).forEach(System.out::println);
                                break;


                            case 4:
                                System.out.println("Insert the vehicle id");
                                long vScanner = input.nextLong();
                                input.nextLine();
                                System.out.println("Insert the start date (year-month-gg)");
                                String startDate = input.nextLine();
                                LocalDate startDateInput = LocalDate.parse(startDate);
                                System.out.println("Insert the end date");
                                String endDate = input.nextLine();
                                LocalDate endDateInput = LocalDate.parse(endDate);
                                System.out.println(tdao.countValidatedTicketsByVehicleIdAndPeriod(vScanner, startDateInput, endDateInput));

                                break;


                            case 5:
                                System.out.println("Insert the sales id");
                                int salesInput = input.nextInt();
                                input.nextLine();
                                System.out.println("Insert the start date (year-month-gg)");
                                String startDate2 = input.nextLine();
                                LocalDate startDateInput2 = LocalDate.parse(startDate2);
                                System.out.println("Insert the end date");
                                String endDate2 = input.nextLine();
                                LocalDate endDateInput2 = LocalDate.parse(endDate2);
                                System.out.println(tdao.findTicketsComplete(salesInput, startDateInput2, endDateInput2));
                                break;

                            case 6:
                                System.out.println("Insert the seller id");
                                long sellerId = input.nextLong();
                                input.nextLine();
                                System.out.println("Insert the start date (year-month-gg)");
                                String startDate3 = input.nextLine();
                                LocalDate startDateInput3 = LocalDate.parse(startDate3);
                                System.out.println("Insert the end date");
                                String endDate3 = input.nextLine();
                                LocalDate endDateInput3 = LocalDate.parse(endDate3);
                                System.out.println(pdao.countPassesSoldBySellerInPeriod(sellerId, startDateInput3, endDateInput3));
                                break;

                            case 0:
                                System.out.println("Going back");
                                break app3;


                            default:
                                System.out.println("This option is INVALID!");
                        }
                    }
                    break;


            }

        }

        emf.close();
        em.close();
        input.close();
    }


}





















