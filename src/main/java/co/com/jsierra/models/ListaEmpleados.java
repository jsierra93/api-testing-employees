package co.com.jsierra.models;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ListaEmpleados {
    private String status;
    private List<Empleado> data;
    private String message;

}
