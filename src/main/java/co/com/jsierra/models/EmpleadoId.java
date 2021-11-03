package co.com.jsierra.models;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class EmpleadoId {
    private String status;
    private Empleado data;
    private String message;

}
