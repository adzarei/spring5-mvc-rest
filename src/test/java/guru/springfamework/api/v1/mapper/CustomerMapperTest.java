package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerMapperTest {

    private final Long ID = 1L;
    private final String NAME = "Adrian";
    private final String LASTNAME = "Zapater";
    private final String URL = "/shop/customer/"+Long.valueOf(ID);

    CustomerMapper customerMapper;

    @Before
    public void setUp() throws Exception {
        customerMapper = CustomerMapper.INSTANCE;
    }

    @Test
    public void customerToCustomerDTO() {

        //Given
        Customer customer = new Customer();
        customer.setFirstname(NAME);
        customer.setLastname(LASTNAME);
        customer.setId(ID);


        //When
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //Then
        assertEquals(ID,customerDTO.getId());
        assertEquals(NAME,customerDTO.getFirstname());
        assertEquals(LASTNAME,customerDTO.getLastname());
        assertEquals(URL,customerDTO.getCustomerUrl());


    }
}