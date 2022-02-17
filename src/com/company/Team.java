package com.company;

import java.util.List;

public class Team {

    private String name;
    private String projektName;
    private List<Mitarbeiter> mitarbeiterList;

    public Team(String name, String projektName, List<Mitarbeiter> mitarbeiterList) {
        this.name = name;
        this.projektName = projektName;
        this.mitarbeiterList = mitarbeiterList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) {
        this.projektName = projektName;
    }

    public List<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;
    }

    public void setMitarbeiterList(List<Mitarbeiter> mitarbeiterList) {
        this.mitarbeiterList = mitarbeiterList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", projektName='" + projektName + '\'' +
                ", mitarbeiterList=" + mitarbeiterList +
                '}';
    }
}
