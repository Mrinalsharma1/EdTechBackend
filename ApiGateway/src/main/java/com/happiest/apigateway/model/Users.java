package com.happiest.apigateway.model;

import com.happiest.apigateway.audit.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Profile name is required")
    @Size(min = 2, max = 50, message = "Profile name must be between 2 and 50 characters")
    @Column(nullable = false, updatable = false)
    private String profilename;

    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Invalid email format"
    )
    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(nullable = false)
    private String password;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(nullable = true)
    private String phone;

    @Column(name = "password_last_modified")
    private LocalDateTime passwordLastModified = LocalDateTime.now();

    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$", message = "Gender must be MALE, FEMALE or OTHER")
    @Column(updatable = false)
    private String gender;

    @Column(nullable = false)
    private boolean isUserActive;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public void setPassword(String password) {
        this.password = password;
        this.passwordLastModified = LocalDateTime.now();
    }
}
