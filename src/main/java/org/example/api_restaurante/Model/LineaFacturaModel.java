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
@Table(name = "linea_factura")
public class LineaFacturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    private int cantidad;
    private float precioTotal;
    private Long producto;
  //  private Long factura;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "factura")
    private FacturaModel factura;

}
