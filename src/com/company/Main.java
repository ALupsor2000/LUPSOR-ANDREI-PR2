package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Mitarbeiter> repoMitarbeiterList = new ArrayList<>();
    static List<Team> repoTeamList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String comm = "s";
        while (!comm.equals("0")) {
            System.out.println(
                    "1. Create Mitarbeiter" + '\n' +
                            "2. Show Mitarbeiters" + '\n' +
                            "3. Update Mitarbeiter" + '\n' +
                            "4. Delete Mitarbeiter" + '\n' +
                            "5. Create Team" + '\n' +
                            "6. Show Teams" + '\n' +
                            "7. Update Team" + '\n' +
                            "8. Delete Team" + '\n' +
                            "9. Filter Team nach Mitarbeiter" + '\n' +
                            "0. Exit");

            comm = sc.next();

            switch (comm) {
                case "1" -> addMitarbeiter();
                case "2" -> getMitarbeiters();
                case "3" -> updateMitarbeiter();
                case "4" -> deleteMitarbeiter();
                case "5" -> addTeam();
                case "6" -> getTeams();
                case "7" -> updateTeam();
                case "8" -> deleteTeam();
                case "9" -> filterTeam();
            }
        }
    }

    public static void addMitarbeiter(){
        System.out.println("Enter id of new Mitarbeiter");
        int id = sc.nextInt();
        System.out.println("Enter name of new Mitarbeiter:");
        String name = sc.next();
        System.out.println("Enter lohn of new Mitarbeiter");
        int lohn = sc.nextInt();

        repoMitarbeiterList.add(new Mitarbeiter(id, name, lohn));
    }

    public static void getMitarbeiters(){
        if(repoMitarbeiterList.isEmpty()){
            System.out.println("No existing Mitarbeiter");
        }
        else{
            for(Mitarbeiter m : repoMitarbeiterList){
                System.out.println(m);
            }
        }
    }

    public static void updateMitarbeiter(){
        System.out.println("Enter id of Mitarbeiter you want to update:");
        int id = sc.nextInt();
        System.out.println("Enter new name of Mitarbeiter:");
        String name = sc.next();
        System.out.println("Enter new lohn of Mitarbeiter:");
        int lohn = sc.nextInt();
    }
}
