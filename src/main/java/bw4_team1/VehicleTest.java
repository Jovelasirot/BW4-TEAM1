package bw4_team1;

import DAO.VehicleDAO;
import entities.Bus;
import entities.Tram;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static entities.Bus.getBusSupplier;
import static entities.Tram.getTramSupplier;

public class VehicleTest {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");

    public static void main(String[] args) {

        EntityManager eM = emf.createEntityManager();

        VehicleDAO vDAO = new VehicleDAO(eM);

        Supplier<Bus> busSupplier = getBusSupplier();
        List<Bus> busList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            busList.add(busSupplier.get());
        }
        busList.forEach(vDAO::save);

        Supplier<Tram> tramSupplier = getTramSupplier();
        List<Tram> tramList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            tramList.add(tramSupplier.get());
        }
        tramList.forEach(vDAO::save);

        emf.close();
        eM.close();
    }
}
