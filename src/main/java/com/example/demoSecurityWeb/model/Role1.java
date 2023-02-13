package com.example.demoSecurityWeb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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

//    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role1ToPermission1",
            joinColumns = @JoinColumn(name = "role1_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "permission1_id", referencedColumnName = "ID"))
    private List<Permission1> permission1s;
}
