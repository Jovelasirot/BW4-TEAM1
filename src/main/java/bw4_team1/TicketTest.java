package bw4_team1;

import entities.Ticket;
import enums.Validation;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class TicketTest implements Supplier<Ticket> {
    private Random random = new Random();
    private static final Validation[] VALIDATIONS = Validation.values();

    @Override
    public Ticket get() {
        Date issueDate = new Date();
        Validation validation = VALIDATIONS[random.nextInt(VALIDATIONS.length)];
        long vehicle_id = random.nextLong();


        return new Ticket(issueDate, validation, vehicle_id);
    }
}