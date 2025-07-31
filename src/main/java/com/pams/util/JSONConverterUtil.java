package com.pams.util;

import java.util.Arrays;

import org.json.JSONArray;

import com.pams.dto.PatientDTO;

public class JSONConverterUtil {
    public static String convertPatientArrayToJSON(PatientDTO[] patients) {
        JSONArray jsonArray = new JSONArray();
        Arrays.stream(patients).forEach(patient -> {
            jsonArray.put(patient.toJSON());
        });
        return jsonArray.toString(2);
    }
}
