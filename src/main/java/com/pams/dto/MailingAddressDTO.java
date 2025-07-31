package com.pams.dto;

import org.json.JSONObject;

public record MailingAddressDTO(
        String street,
        String city,
        String state,
        String zipCode
) {
    public JSONObject toJSON() {
        var addressJSONObject = new JSONObject();
        addressJSONObject.put("street", street);
        addressJSONObject.put("city", city);
        addressJSONObject.put("state", state);
        addressJSONObject.put("zipCode", zipCode);
        return addressJSONObject;
    }
}
