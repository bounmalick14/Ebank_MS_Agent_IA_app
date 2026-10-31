package net.malick.ebankservice.model;

import lombok.*;

@Getter @Setter @ToString @Builder @NoArgsConstructor @AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
}
