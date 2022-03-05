package com.rossven.healty;

import java.util.Date;

public class Informations {

    public int id;
    public String name;
    public long diastolic;
    public long Systolic;
    public Date date;

    public Informations(int id, String name, long diastolic, long systolic, Date date) {
        this.id = id;
        this.name = name;
        this.diastolic = diastolic;
        Systolic = systolic;
        this.date = date;
    }

    public Informations(String name, long diastolic, long systolic, Date date) {
        this.name = name;
        this.diastolic = diastolic;
        Systolic = systolic;
        this.date = date;
    }

    public Informations() {
    }
}
