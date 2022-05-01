package sfgpetclinic2.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sfgpetclinic2.model.Owner;
import sfgpetclinic2.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMVC;

    @BeforeEach
    void setUp() {
        owners= new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMVC = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMVC.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("owners/index")).
                andExpect(model().attribute("owners",hasSize(2)));
    }

    @Test
    void findOwners() {
    }
}