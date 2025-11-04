package org.example.api_restaurante.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "factura")
public class FacturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    private float total;
    private Long idMesa;
    private Long usuario;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "factura",cascade = CascadeType.ALL)
    private List<LineaFacturaModel> lineasFactura;

}
