package guru.springfamework.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerListDTO {

    List<CustomerDTO> customers;
}
