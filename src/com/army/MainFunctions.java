package com.army;

import com.army.controllers.Medical_info_controller;
import com.army.controllers.Personal_info_controller;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MainFunctions {
    private final Personal_info_controller pcontroller;
    private final Medical_info_controller mcontroller;
    private final Scanner sc;

    public MainFunctions(Personal_info_controller controller, Medical_info_controller mcontroller) {
        this.pcontroller = controller;
        this.mcontroller = mcontroller;
        sc = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Soldier candidates list");
            System.out.println("Select option:");
            System.out.println("1. Get all candidates");
            System.out.println("2. Get candidate by id");
            System.out.println("3. Create candidate");
            System.out.println("4. Add medical information on candidate by ID");
            System.out.println("5. Get medical information by ID of candidate");
            System.out.println("6. Get all candidates medical information");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = sc.nextInt();
                if (option == 1) {
                    getAllPersonsMenu();
                } else if (option == 2) {
                    getPersonByIdMenu();
                } else if (option == 3) {
                    createUserMenu();
                } else if (option == 4){
                    createMedical_infoMenu();
                } else if (option == 5){
                    getMedical_infoByIdMenu();
                } else if (option == 6){
                    getAllMedical_infoMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                sc.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("====================");
        }
    }
    public void getAllPersonsMenu() {
        String answer = pcontroller.getAllpersons();
        System.out.println(answer);
    }
    public void getPersonByIdMenu() {
        System.out.println("Please enter id of candidate:");
        int id = sc.nextInt();
        String answer = pcontroller.getPerson(id);
        System.out.println(answer);
    }
    public void createUserMenu() {
        System.out.println("Please enter candidate's name");
        String name = sc.next();
        System.out.println("Please enter candidate's surname");
        String surname = sc.next();
        System.out.println("Please enter candidate's age(recent)");
        int age = sc.nextInt();
        String answer = pcontroller.createPerson(name, surname, age);
        System.out.println(answer);
    }
    public void getAllMedical_infoMenu() {
        String answer = mcontroller.getAllmedical_info();
        System.out.println(answer);
    }
    public void getMedical_infoByIdMenu() {
        System.out.println("Please enter id of candidate:");
        int id = sc.nextInt();
        String answer = mcontroller.getMedical_info(id);
        System.out.println(answer);
    }
    public void createMedical_infoMenu() {
        System.out.println("Please enter candidate's ID");
        int id = sc.nextInt();
        if(pcontroller.isPersonID(id)) {
            System.out.println("Please enter candidate's Height");
            double height = sc.nextDouble();
            System.out.println("Please enter candidate's Weight");
            double weight = sc.nextDouble();
            System.out.println("Please enter candidate's Vision level(-15.0 - 15.0");
            double vision = sc.nextDouble();
            String answer = mcontroller.createMedical_info(id, height, weight, vision);
            System.out.println(answer);
        }
        else{
            System.out.println("Candidate by this ID not created yet!");
        }
    }

}
