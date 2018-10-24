package guru.springfamework.controller.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    private final Long ID = 1L;
    private final String NAME = "Adrian";
    private final String LASTNAME = "Zapater";
    private final String URL = "/shop/customer/"+Long.valueOf(ID);

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

    }

    @Test
    public void getAllCustomers() throws Exception {

        //Given

        //When/Then

    }

    @Test
    public void getCustomerById() throws Exception {

        //Given
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstname(NAME);
        customer.setLastname(LASTNAME);
        customer.setCustomerUrl(URL);
        customer.setId(ID);

        when(customerService.getCustomerById(anyLong())).thenReturn(customer);

        //When/Then
        mockMvc.perform(get("/api/v1/customers/"+ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",equalTo(ID.intValue())));


    }
}