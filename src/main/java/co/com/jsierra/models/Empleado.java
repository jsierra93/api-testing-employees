package co.com.jsierra.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Empleado {

    @JsonIgnore
    private int id;

    @SerializedName(value = "employee_name")
    private String employeeName;

    @SerializedName(value = "employee_salary")
    private int employeeSalary;

    @SerializedName(value = "employee_age")
    private int employeeAge;

    @SerializedName(value = "profile_image")
    private String profileImage;
}
