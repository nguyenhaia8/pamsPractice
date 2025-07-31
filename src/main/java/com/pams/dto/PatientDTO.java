package com.pams.dto;

import java.time.LocalDate;

import org.json.JSONObject;

public record PatientDTO(
    String patientId,
    String firstName,
    String lastName,
    String phoneNumber,
    String email,
    LocalDate dateOfBirth,
    Integer age,
    MailingAddressDTO mailingAddress
) {
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("patientId", patientId);
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("phoneNumber", phoneNumber);
        jsonObject.put("email", email);
        jsonObject.put("dateOfBirth", dateOfBirth);
        jsonObject.put("age", age);
        if (mailingAddress != null) {
            jsonObject.put("mailingAddress", mailingAddress.toJSON());
        } else {
            jsonObject.put("mailingAddress", "null");
        }
        return jsonObject;
    }
}
