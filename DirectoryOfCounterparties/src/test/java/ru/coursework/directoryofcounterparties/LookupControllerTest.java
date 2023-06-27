package ru.coursework.directoryofcounterparties;

import com.coursework.directoryofcounterparties.DirectoryOfCounterpartiesApplication;
import com.coursework.directoryofcounterparties.model.Counterparty;
import com.coursework.directoryofcounterparties.service.LookupService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(classes = DirectoryOfCounterpartiesApplication.class)
public class LookupControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LookupService lookupService;

    @Test
    public void testGetCounterpartyByName() throws Exception {
        Counterparty counterparty = new Counterparty();
        counterparty.setName("Counterparty2");
        counterparty.setInn("7736316133");
        counterparty.setKpp("771401001");
        counterparty.setAccountNumber("11877000084074545454");
        counterparty.setBik("048898997");

        Mockito.when(lookupService.getCounterpartyByName(anyString())).thenReturn(counterparty);

        mockMvc.perform(get("/lookup/counterpartyByName")
                        .param("name", "Counterparty2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Counterparty2"))
                .andExpect(jsonPath("$.inn").value("7736316133"))
                .andExpect(jsonPath("$.kpp").value("771401001"))
                .andExpect(jsonPath("$.accountNumber").value("11877000084074545454"))
                .andExpect(jsonPath("$.bik").value("048898997"));
    }

    @Test
    public void testGetCounterpartyByBikAndAccountNumber() throws Exception {
        Counterparty counterparty = new Counterparty();
        counterparty.setName("2GIS");
        counterparty.setInn("5405276278");
        counterparty.setKpp("997750001");
        counterparty.setAccountNumber("40702810744050005734");
        counterparty.setBik("045004641");

        Mockito.when(lookupService.getCounterpartyByBikAndAccountNumber(anyString(), anyString())).thenReturn(counterparty);

        mockMvc.perform(get("/lookup/counterpartyByBikAndAccountNumber")
                        .param("bik", "045004641")
                        .param("accountNumber", "40702810744050005734")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("2GIS"))
                .andExpect(jsonPath("$.inn").value("5405276278"))
                .andExpect(jsonPath("$.kpp").value("997750001"))
                .andExpect(jsonPath("$.accountNumber").value("40702810744050005734"))
                .andExpect(jsonPath("$.bik").value("045004641"));
    }

}
