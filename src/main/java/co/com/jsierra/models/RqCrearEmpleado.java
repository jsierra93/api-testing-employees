package co.com.jsierra.models;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RqCrearEmpleado {
    private Empleado data;
}
