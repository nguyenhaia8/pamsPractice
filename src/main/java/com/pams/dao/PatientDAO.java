package com.pams.dao;

import java.time.LocalDate;
import java.util.UUID;

import com.pams.model.MailingAddress;
import com.pams.model.Patient;

public class PatientDAO {
    private static PatientDAO instance;

    private Patient[] patients = null;

    private PatientDAO() {
    }

    public static synchronized PatientDAO getInstance() {
        if (instance == null) {
            instance = new PatientDAO();
        }
        return instance;
    }

    private void loadData() {
        this.patients = new Patient[] {
            new Patient(
                UUID.randomUUID(),
                "Daniel",
                "Agar",
                "(641) 123-0009",
                "dagar@m.as",
                new MailingAddress("1 N Street", "Fairfield", "IA", "52556-0187"),
                LocalDate.of(1987, 1, 19)),

                new Patient(
                        UUID.randomUUID(),
                        "Ana",
                        "Smith",
                        null,
                        "amsith@te.edu", 
                        null,
                        LocalDate.of(1948, 12, 5)
                ),

                new Patient(
                        UUID.randomUUID(),
                        "Marcus",
                        "Garvey",
                        "(123) 292-0018",
                        null, 
                        new MailingAddress("4 East Avenue", "Cleveland", "OH", "32001-9910"),
                        LocalDate.of(2001, 9, 18)
                ),
                
        };
    }

    public Patient[] getPatients() {
        if (this.patients == null || this.patients.length == 0) {
            this.loadData();
        }
        return this.patients;
    }
}
