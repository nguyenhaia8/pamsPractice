package com.pams.service;

import java.util.Arrays;
import java.util.Comparator;

import com.pams.dao.PatientDAO;
import com.pams.dto.MailingAddressDTO;
import com.pams.dto.PatientDTO;

public class PatientService {
    private final PatientDAO patientDAO;

    public PatientService() {
        this.patientDAO = PatientDAO.getInstance();
    }

    public PatientDTO[] getAllPatientsSortedByAgeDesc() {
        var patients = this.patientDAO.getPatients();
        return Arrays.stream(patients).map(
            p-> new PatientDTO(
                p.getPatientId().toString(),
                p.getFirstName(),
                p.getLastName(),
                p.getPhoneNumber(),
                p.getEmail(),
                p.getDateOfBirth(),
                p.getAge(),
                p.getMailingAddress() != null ? new MailingAddressDTO(
                    p.getMailingAddress().getStreet(),
                    p.getMailingAddress().getCity(),
                    p.getMailingAddress().getState(),
                    p.getMailingAddress().getZipCode()
                ) : null
            )
        ).sorted(Comparator.comparing(PatientDTO::age, Comparator.reverseOrder()))
        .toArray(PatientDTO[]::new);
    }
}
