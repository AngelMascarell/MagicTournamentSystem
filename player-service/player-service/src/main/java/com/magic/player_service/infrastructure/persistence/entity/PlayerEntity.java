package com.magic.player_service.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {

    @Id
    @GeneratedValue
    @UuidGenerator                       // Genera el UUID automáticamente (nuevo en Hibernate 6)
    @JdbcTypeCode(SqlTypes.CHAR)         // Indica que se almacene como CHAR en lugar de binario
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private UUID id;

    private String name;

    private String email;
}

