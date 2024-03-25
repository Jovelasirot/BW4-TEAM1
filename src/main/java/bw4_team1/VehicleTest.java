package bw4_team1;

import DAO.RouteDAO;
import DAO.VehicleDAO;
import entities.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static entities.Route.getRouteSupplier;

public class VehicleTest {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");

    public static void main(String[] args) {

        EntityManager eM = emf.createEntityManager();

        VehicleDAO vDAO = new VehicleDAO(eM);
        RouteDAO rDAO = new RouteDAO(eM);

        Supplier<Route> routeSupplier = getRouteSupplier(emf);
        List<Route> routeList = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            routeList.add(routeSupplier.get());
        }
        routeList.forEach(rDAO::save);

//        Supplier<Bus> busSupplier = getBusSupplier();
//        List<Bus> busList = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            busList.add(busSupplier.get());
//        }
//        busList.forEach(vDAO::save);
//
//        Supplier<Tram> tramSupplier = getTramSupplier();
//        List<Tram> tramList = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            tramList.add(tramSupplier.get());
//        }
//        tramList.forEach(vDAO::save);


        emf.close();
        eM.close();
    }
}
