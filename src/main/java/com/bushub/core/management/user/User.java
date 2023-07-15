package com.bushub.core.management.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "mng", name = "user")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String username;

  @NotNull
  private String firstName;

  private String middleName;

  @NotNull
  private String lastName;

  @NotNull
  private LocalDate birthDate;

  @NotNull
  private String email;

  @NotNull
  @Enumerated(EnumType.STRING)
  private UserRole role;
}