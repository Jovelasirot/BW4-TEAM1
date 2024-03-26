package bw4_team1;

import DAO.*;
import entities.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        UserDAO udao= new UserDAO(em);
        SalesDAO sdao= new SalesDAO(em);
        PassDAO pdao= new PassDAO(em);
        CardDAO cdao = new CardDAO(em);




        app:
        while (true){
            int answer;

            System.out.println("-------------------------WELCOME TO OUR TRANSPORT COMPANY'S APP---------------------------");
            System.out.println("Hi there, follow the steps below to access the app:");
            System.out.println("Please press 1 if you're a user, otherwise press 2 if you're an admin.");
            answer = scanner.nextInt();


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





            switch (answer) {

                case 0:
                    System.out.println("Thanks and see you soon :)");
                    scanner.close();
                    break app;


                case 1:
                    System.out.println("Please insert your ID");
                    long id= scanner.nextLong();
                    System.out.println("Now, select the options below:");
                    System.out.println("1 To check if your card is still valid");
//                    System.out.println("2 To check if your ticket is valid");
//                    System.out.println("3 To check if your pass is valid");
                    int userInput= scanner.nextInt();

                    switch(userInput){
                        case 1:
                            System.out.println(cdao.ValidityByUserId(id));
                            break;

//                        case 2:
//                            System.out.println();
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






        


        emf.close();
        em.close();
    }
}
