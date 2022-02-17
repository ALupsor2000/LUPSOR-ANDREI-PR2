package com.company;

public class Mitarbeiter {

    private int id;
    private String name;
    private int lohn;

    public Mitarbeiter(int id, String name, int lohn) {
        this.id = id;
        this.name = name;
        this.lohn = lohn;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLohn() {
        return lohn;
    }

    public void setLohn(int lohn) {
        this.lohn = lohn;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "name='" + name + '\'' +
                ", lohn=" + lohn +
                '}';
    }
}
