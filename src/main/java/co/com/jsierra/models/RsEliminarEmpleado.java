package co.com.jsierra.models;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RsEliminarEmpleado {
    private String status;
    private String data;
    private String message;

}
