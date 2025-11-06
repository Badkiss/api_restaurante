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
@Table(name = "producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    private String nombre;
    private float precio;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "producto",cascade = CascadeType.ALL)
    private List<RecetaModel> recetas;
}
