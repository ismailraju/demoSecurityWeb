package com.example.demoSecurityWeb.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;



import java.util.List;

@Entity
@Table(name = "user1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty(message = "Please provide an username")
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
//    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @Column(name = "password")
    private String password;


    @Column(name = "first_name")
//    @NotEmpty(message = "Please provide your first name")
    private String firstName;

    @Column(name = "last_name")
//    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "confirmation_token")
    private String confirmationToken;


//    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user1_to_role1",
            joinColumns = @JoinColumn(name = "user1_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "role1_id", referencedColumnName = "ID"))
    private List<Role1> role1s;

}
