package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static List<Mitarbeiter> repoMitarbeiterList = new ArrayList<>();
    static List<Team> repoTeamList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //create some mitarbeiters
        Mitarbeiter m1 = new Mitarbeiter(1, "Andrei", 1200);
        Mitarbeiter m2 = new Mitarbeiter(2, "Darius", 1500);
        Mitarbeiter m3 = new Mitarbeiter(3, "Marius", 1150);
        Mitarbeiter m4 = new Mitarbeiter(4, "Alex", 2000);
        Mitarbeiter m5 = new Mitarbeiter(5, "Elena", 1850);

        //add mitarbeiter to repository
        repoMitarbeiterList.add(m1);
        repoMitarbeiterList.add(m2);
        repoMitarbeiterList.add(m3);
        repoMitarbeiterList.add(m4);
        repoMitarbeiterList.add(m5);

        List<Mitarbeiter> mit1 = new ArrayList<>();
        List<Mitarbeiter> mit2 = new ArrayList<>();

        mit1.add(m1);
        mit1.add(m2);
        mit1.add(m4);
        mit1.add(m5);

        mit2.add(m2);
        mit2.add(m4);
        mit2.add(m5);

        //create teams and store them into repository
        Team t1 = new Team("Alfa", "SAP", mit1);
        Team t2 = new Team("Beta", "BAE", mit2);

        repoTeamList.add(t1);
        repoTeamList.add(t2);

        //creating list of options for user
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

            //for given option calling the respective function
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

    //add new mitarbeiter into repository
    public static void addMitarbeiter(){
        System.out.println("Enter id of new Mitarbeiter");
        int id = sc.nextInt();
        System.out.println("Enter name of new Mitarbeiter:");
        String name = sc.next();
        System.out.println("Enter lohn of new Mitarbeiter:");
        int lohn = sc.nextInt();

        repoMitarbeiterList.add(new Mitarbeiter(id, name, lohn));
    }

    //showing all mitarbeiter fronm repository
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

    //updating mitarbeiter for given id
    public static void updateMitarbeiter(){
        System.out.println("Enter id of Mitarbeiter you want to update:");
        int id = sc.nextInt();
        System.out.println("Enter new name of Mitarbeiter:");
        String name = sc.next();
        System.out.println("Enter new lohn of Mitarbeiter:");
        int lohn = sc.nextInt();
        for(Mitarbeiter m : repoMitarbeiterList){
            if(m.getId() == id){
                m.setName(name);
                m.setLohn(lohn);
            }
        }
    }

    //deleteing mitarbeiter for given id
    public static void deleteMitarbeiter(){
        System.out.println("Enter id of Mitarbeiter you want to delete:");
        int id = sc.nextInt();
        repoMitarbeiterList =repoMitarbeiterList.stream().filter((m) -> !Objects.equals(m.getId(), id)).collect(Collectors.toList());
    }

    //creating new team with list of mitarbeiter
    public static void addTeam(){
        System.out.println("Enter name of new Team:");
        String name = sc.next();
        System.out.println("Enter name of team project:");
        String project = sc.next();
        System.out.println("Enter id of Mitarbeiters separated with comma only(existing id):");
        String id_comma = sc.next();
        String[] id_list = id_comma.split(",");

        List<Mitarbeiter> temp_mitarbeiter = new ArrayList<>();

        for(String str : id_list){
            for(Mitarbeiter m : repoMitarbeiterList){
                if(m.getId() == Integer.parseInt(str)){
                    temp_mitarbeiter.add(m);
                }
            }
        }

        repoTeamList.add(new Team(name, project, temp_mitarbeiter));
    }

    //showing list of teams from repository
    public static void getTeams(){
        if(repoTeamList.isEmpty()){
            System.out.println("No existing teams");
        }
        else{
            for(Team t : repoTeamList){
                System.out.println("Team " + t.getName() + " with project " + t.getProjektName() + " has Mitarbeiters: ");
                for(Mitarbeiter m : t.getMitarbeiterList()){
                    System.out.println("   " + m.toString());
                }
            }
        }
    }

    //uopdating a team after it's name
    public static void updateTeam(){
        System.out.println("Enter name of team you want to update:");
        String name = sc.next();
        System.out.println("Enter new project name:");
        String project =sc.next();
        System.out.println("Enter id of Mitarbeiters separated with comma only(existing id):");
        String id_comma = sc.next();
        String[] id_list = id_comma.split(",");

        List<Mitarbeiter> temp_mitarbeiter = new ArrayList<>();

        for(String str : id_list){
            for(Mitarbeiter m : repoMitarbeiterList){
                if(m.getId() == Integer.parseInt(str)){
                    temp_mitarbeiter.add(m);
                }
            }
        }

        for(Team t : repoTeamList){
            if(t.getName().equals(name)){
                t.setProjektName(project);
                t.setMitarbeiterList(temp_mitarbeiter);
            }
        }
    }

    //deleting team after name
    public static void deleteTeam(){
        System.out.println("Enter name of team you want to delete:");
        String name = sc.next();
        repoTeamList =repoTeamList.stream().filter((t) -> !Objects.equals(t.getName(), name)).collect(Collectors.toList());
    }

    //showing teams that only contains the given name
    public static void filterTeam(){
        System.out.println("Enter name of Mitarbeiter you want to filter team after:");
        String name = sc.next();
        List<Team> filterTeam = new ArrayList<>();
        for(Team t : repoTeamList){
            for(Mitarbeiter m : t.getMitarbeiterList()) {
                if (Objects.equals(m.getName(), name)) {
                    if(!filterTeam.contains(t)){
                        filterTeam.add(t);
                    }
                }
            }
        }
        for(Team t : filterTeam){
            System.out.println("Team " + t.getName() + " with project " + t.getProjektName() + " has Mitarbeiters: ");
            for(Mitarbeiter m : t.getMitarbeiterList()){
                System.out.println("   " + m.toString());
            }
        }
    }
}
