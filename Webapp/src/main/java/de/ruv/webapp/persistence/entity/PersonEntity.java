package de.ruv.webapp.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "tbl_personen")
public class PersonEntity {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, length = 30)
    private String vorname;

    @Column(nullable = false, length = 30)
    private String nachname;


}
