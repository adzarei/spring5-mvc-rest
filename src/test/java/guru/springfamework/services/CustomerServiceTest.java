package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    private final Long ID = 1L;
    private final String NAME = "Adrian";
    private final String LASTNAME = "Zapater";
    private final String URL = "/shop/customer/"+Long.valueOf(ID);

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    public void getCustomerById() {

        //Given
        Customer customer = new Customer();
        customer.setFirstname(NAME);
        customer.setLastname(LASTNAME);
        customer.setId(ID);

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer));

        //When
        CustomerDTO customerDTO = customerService.getCustomerById(ID);
        customerDTO.setCustomerUrl(URL);

        //Then
        assertEquals(ID,customerDTO.getId());
        assertEquals(NAME,customerDTO.getFirstname());
        assertEquals(LASTNAME,customerDTO.getLastname());
        assertEquals(URL,customerDTO.getCustomerUrl());

    }

    @Test
    public void getAllCustomers() {
    }
}