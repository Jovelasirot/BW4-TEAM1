package bw4_team1;

import DAO.*;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

import static entities.Bus.getBusSupplier;
import static entities.MaintenanceRecord.getMaintenanceRecords;
import static entities.Pass.gePassSupplier;
import static entities.Route.getRouteSupplier;
import static entities.Ticket.getTicketSupplier;
import static entities.Tram.getTramSupplier;
import static entities.User.getUserSupplierNameSurname;
import static entities.VendingMachine.getVendingMachineSupplier;
import static entities.VerifiedSupplier.getVerifiedSupplierSupplier;

public class DataBaseFiller {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");

    public static void main(String[] args) {
        EntityManager eM = emf.createEntityManager();

        UserDAO uDAO = new UserDAO(eM);
        CardDAO cDAO = new CardDAO(eM);
        SalesDAO sDAO = new SalesDAO(eM);
        PassDAO pDAO = new PassDAO(eM);
        VehicleDAO vDAO = new VehicleDAO(eM);
        RouteDAO rDAO = new RouteDAO(eM);
        MaintenanceRecordDAO mrDAO = new MaintenanceRecordDAO(eM);
        TicketDAO tDAO = new TicketDAO(eM);

        handleUserAction(uDAO, cDAO, sDAO, pDAO, vDAO, rDAO, mrDAO, tDAO);
    }

    public static void handleUserAction(UserDAO uDAO, CardDAO cDAO, SalesDAO sDAO, PassDAO pDAO, VehicleDAO vDAO, RouteDAO rDAO, MaintenanceRecordDAO mrDAO, TicketDAO tDAO) {
        Scanner sc = new Scanner(System.in);
        int handleAction;

        do {
            try {

                System.out.println();
                System.out.println("What do you want to do?");
                System.out.println("Press them in order");
                System.out.println("1 - Create users");
                System.out.println("2 - Create cards");
                System.out.println("3 - Create sales");
                System.out.println("4 - Create pass");
                System.out.println("5 - Create vehicles");
                System.out.println("6 - Create routes");
                System.out.println("7 - Create maintenance records");
                System.out.println("8 - Create ticket");
                System.out.println("0 - Terminate the program.");

                handleAction = sc.nextInt();
                sc.nextLine();

                switch (handleAction) {
                    case 1:
                        usersCreator(uDAO);
                        break;

                    case 2:
                        cardsCreator(cDAO, uDAO);
                        break;

                    case 3:
                        salesCreator(sDAO);
                        break;

                    case 4:
                        passCreator(pDAO);
                        break;

                    case 5:
                        vehiclesCreator(vDAO);
                        break;

                    case 6:
                        routesCreator(rDAO);
                        break;

                    case 7:
                        maintenanceRecordsCreator(mrDAO);
                        break;

                    case 8:
                        ticketsCreator(tDAO);
                        break;

                    case 0:
                        System.out.println("Terminating program =͟͟͞͞ =͟͟͞͞ ﾍ ( ´ Д `)ﾉ");
                        break;

                    default:
                        System.out.println("Invalid action. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, type a number.");
                System.out.println("-------------");
                handleAction = -1;
                sc.nextLine();

            }
        } while (handleAction != 0);
        sc.close();
    }

    public static void usersCreator(UserDAO uDAO) {
        Supplier<User> userSupplier = getUserSupplierNameSurname();
        for (int i = 0; i < 40; i++) {
            uDAO.save(userSupplier.get());
        }
    }

    public static void cardsCreator(CardDAO cDAO, UserDAO uDAO) {
        Random rdm = new Random();
        for (long i = 0; i < 30; i++) {
            cDAO.save(new Card(LocalDate.now().minusDays(rdm.nextInt(730)), uDAO.findById(i)));

        }

    }

    public static void passCreator(PassDAO pDAO) {
        Supplier<Pass> passSupplier = gePassSupplier(emf);
        for (int i = 0; i < 40; i++) {
            pDAO.save(passSupplier.get());
        }
    }

    public static void salesCreator(SalesDAO sDAO) {
        Supplier<VendingMachine> vendingMachineSupplier = getVendingMachineSupplier();
        for (int i = 0; i < 15; i++) {
            sDAO.save(vendingMachineSupplier.get());
        }
        Supplier<VerifiedSupplier> verifiedSupplierSupplier = getVerifiedSupplierSupplier();
        for (int i = 0; i < 15; i++) {
            sDAO.save(verifiedSupplierSupplier.get());
        }
    }

    public static void vehiclesCreator(VehicleDAO vDAO) {
        Supplier<Bus> busSupplier = getBusSupplier();
        for (int i = 0; i < 30; i++) {
            vDAO.save(busSupplier.get());
        }

        Supplier<Tram> tramSupplier = getTramSupplier();
        for (int i = 0; i < 30; i++) {
            vDAO.save(tramSupplier.get());
        }
    }

    public static void routesCreator(RouteDAO rDAO) {
        Supplier<Route> routeSupplier = getRouteSupplier(emf);
        for (int i = 0; i < 60; i++) {
            rDAO.save(routeSupplier.get());
        }
    }

    public static void maintenanceRecordsCreator(MaintenanceRecordDAO mrDAO) {
        Supplier<List<MaintenanceRecord>> maintenanceRecordSupplier = getMaintenanceRecords(emf);
        List<MaintenanceRecord> maintenanceRecords = maintenanceRecordSupplier.get();
        maintenanceRecords.forEach(mrDAO::save);
    }

    public static void ticketsCreator(TicketDAO tDAO) {
        List<Ticket> ticketList = new ArrayList<>();
        Supplier<List<Ticket>> ticketSupplier = getTicketSupplier(emf);
        ticketList.addAll(ticketSupplier.get());
        ticketList.forEach(tDAO::save);
    }
}