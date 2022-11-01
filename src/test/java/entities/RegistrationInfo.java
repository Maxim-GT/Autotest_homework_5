package entities;

import lombok.Data;

@Data
public class RegistrationInfo {
    private final String name;
    private final String phone;
    private final String city;

    public RegistrationInfo(String name, String phone, String city) {
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCity() {
        return this.city;
    }
}

