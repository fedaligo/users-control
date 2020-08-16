package com.htp.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "users")
public class HibernateUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @Column(name="founded")
    private Timestamp create;

    @Column
    private Timestamp logged;

    @Column
    private String status;

    @Column
    private String mail;

}
