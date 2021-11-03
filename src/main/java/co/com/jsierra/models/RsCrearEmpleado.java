package co.com.jsierra.models;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RsCrearEmpleado {
    private String status;
    private RsDataCrear data;
    private String message;

}
