package com.example.demoSecurityWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "role1")
public class Role1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 50, name = "role")
    private String role;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role1ToPermission1",
            joinColumns = @JoinColumn(name = "role1_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "permission1_id", referencedColumnName = "ID"))
    private List<Permission1> permission1s;
}
