package com.army;

import com.army.controllers.Medical_info_controller;
import com.army.controllers.Personal_info_controller;
import com.army.controllers.Registration_info_controller;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MainFunctions {
    private final Personal_info_controller pcontroller;
    private final Medical_info_controller mcontroller;
    private final Registration_info_controller rcontroller;
    private final Scanner sc;

    public MainFunctions(Personal_info_controller controller, Medical_info_controller mcontroller, Registration_info_controller rcontroller) {
        this.pcontroller = controller;
        this.mcontroller = mcontroller;
        this.rcontroller = rcontroller;

        sc = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("Welcome to the Army web site! chose option:");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.print("Enter option (1-3): ");
            int option = sc.nextInt();
            if(option==1){
                CreateRegistrationInfo();
            } else if (option==2) {
                ToLogIn();
            }
            else {
                break;
            }
        }
    }
    public void Admin() {
        while(true) {
            System.out.println("=====================================");
            System.out.println("Choose the option:");
            System.out.println("1. Get all candidates");
            System.out.println("2. Get candidate by id");
            System.out.println("3. Create candidate");
            System.out.println("4. Add medical information on candidate by ID");
            System.out.println("5. Get medical information by ID of candidate");
            System.out.println("6. Get all candidates medical information");
            System.out.println("7. Get all candidates registration info");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter your option (1-7)");
                int option = sc.nextInt();
                if (option == 1) {
                    getAllPersonsAdmin();
                } else if (option == 2) {
                    getPersonByIdAdmin();
                } else if (option == 3) {
                    createPersonAdmin();
                } else if (option == 4) {
                    createMedical_infoAdmin();
                } else if (option == 5) {
                    getMedical_infoByIdAdmin();
                } else if (option == 6) {
                    getAllMedical_infoAdmin();
                } else if (option == 7) {
                    getAllRegistrations_Admin();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must ve an Integer!" + e);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void User(String phone, String password){
        int id = rcontroller.ShowId(phone);
        while(true){
            System.out.println("=====================================");
            System.out.println("Choose the option:");
            System.out.println("1. Show personal information");
            System.out.println("2. Add personal information");
            System.out.println("3. Show medical information");
            System.out.println("4. Add medical information");
            System.out.println("0 Exit");
            System.out.println();
            try {
                int option = sc.nextInt();
                if (option == 1) {
                    getPersonByIdUser(id);
                } else if (option == 2) {
                    createPersonUser(id);
                } else if (option == 3) {
                    getMedical_infoByIdUser(id);
                } else if (option == 4) {
                    createMedical_infoUser(id);
                } else {
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Input must ve an Integer!"+e);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public void getAllPersonsAdmin() {
        String answer = pcontroller.getAllpersons();
        System.out.println(answer);
    }
    public void getPersonByIdAdmin() {
        System.out.println("Please enter id of candidate:");
        int id = sc.nextInt();
        String answer = pcontroller.getPerson(id);
        System.out.println(answer);
    }
    public void getPersonByIdUser(int id) {
        String answer = pcontroller.getPerson(id);
        System.out.println(answer);
    }
    public void createPersonUser(int id){
        System.out.println("Please enter candidate's name");
        String name = sc.next();
        System.out.println("Please enter candidate's surname");
        String surname = sc.next();
        System.out.println("Please enter candidate's age(recent)");
        int age = sc.nextInt();
        String answer = pcontroller.createPerson(id,name, surname, age);
        System.out.println(answer);
    }
    public void createPersonAdmin() {
        System.out.println("Please enter candidates id");
        int id = sc.nextInt();
        System.out.println("Please enter candidate's name");
        String name = sc.next();
        System.out.println("Please enter candidate's surname");
        String surname = sc.next();
        System.out.println("Please enter candidate's age(recent)");
        int age = sc.nextInt();
        String answer = pcontroller.createPerson(id,name, surname, age);
        System.out.println(answer);
    }
    public void getAllMedical_infoAdmin() {
        String answer = mcontroller.getAllmedical_info();
        System.out.println(answer);
    }
    public void getAllRegistrations_Admin(){
        String answer = rcontroller.getAllRegistrations();
        System.out.println(answer);
    }
    public void getMedical_infoByIdAdmin() {
        System.out.println("Please enter id of candidate:");
        int id = sc.nextInt();
        String answer = mcontroller.getMedical_info(id);
        System.out.println(answer);
    }
    public void getMedical_infoByIdUser(int id) {
        String answer = mcontroller.getMedical_info(id);
        System.out.println(answer);
    }
    public void createMedical_infoAdmin() {
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
    public void createMedical_infoUser(int id) {
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
            System.out.println("Candidates personal info by this ID not created yet!");
        }
    }
    public void CreateRegistrationInfo(){
        System.out.println("Hello, by this option will be started simple registration process):");
        System.out.println("Firstly, Enter your phone number +7:");
        String phone = sc.next();
        System.out.println("Last step to create password:");
        String first_try = sc.next();
        System.out.println("Please repeat password:");
        String second_try = sc.next();
        if(first_try.equals(second_try)){
            rcontroller.to_register(phone,second_try);
        }
        else{
            System.out.println("Registration process was failed! (Maybe you should enter password carefully)");
        }
    }
    public void ToLogIn(){
        System.out.println("User's phone number:");
        String phone = sc.next();
        System.out.println("User's password:");
        String password = sc.next();
        if(rcontroller.check_to_admin(phone,password)){
            Admin();
        }
        else if(!rcontroller.isRegistationPhone_number(phone)){
            System.out.println("User by this number not registered yet!");
        } else {
            if(rcontroller.Log_in(phone,password)){
                    User(phone,password);
            }
            else{
                System.out.println("Entered wrong Password, try again(");
            }
        }
    }

}
