package org.example.api_restaurante.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Long usuario;
    private Long mesa;
    private Date fecha;
}
