package net.malick.ebankservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
}
