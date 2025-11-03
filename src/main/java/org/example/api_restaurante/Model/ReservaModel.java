package org.example.api_restaurante.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reserva")
public class ReservaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    private Long usuario;
    private Long mesa;
    private Date fecha;
}
