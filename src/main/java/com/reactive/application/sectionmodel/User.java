package com.reactive.application.sectionmodel;

import com.reactive.application.sectionutil.UtilClass;
import lombok.Data;

@Data
public class User {
    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = UtilClass.faker().name().fullName();
    }
}
