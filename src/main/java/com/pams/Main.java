package com.pams;

import com.pams.service.PatientService;
import com.pams.util.JSONConverterUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the Patients-Appointments Management App!");
        System.out.println("Starting the application tasks...");
        System.out.println("Task 1: JSON Array of All Patients Data, sorted by Age in descending order.");
        System.out.println("__________________________________________________________________________");

        var patientService = new PatientService();
        var patients = patientService.getAllPatientsSortedByAgeDesc();
        var jsonPatients = JSONConverterUtil.convertPatientArrayToJSON(patients);
        System.out.println(jsonPatients);

        System.out.println("_______________________Task 1 Done________________________________________");

        System.out.println("\nApplication tasks completed successfully!");
        System.out.println("Exiting the application...Goodbye!");
    }
}