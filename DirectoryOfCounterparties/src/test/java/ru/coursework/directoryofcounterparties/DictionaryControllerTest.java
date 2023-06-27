package ru.coursework.directoryofcounterparties;

import com.coursework.directoryofcounterparties.DirectoryOfCounterpartiesApplication;
import com.coursework.directoryofcounterparties.model.Counterparty;
import com.coursework.directoryofcounterparties.service.DictionaryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest(classes = DirectoryOfCounterpartiesApplication.class)
public class DictionaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DictionaryService dictionaryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateCounterparty() throws Exception {
        Counterparty counterparty = new Counterparty();
        counterparty.setName("Created Counterparty 1");
        counterparty.setInn("1234567891");
        counterparty.setKpp("123456789");
        counterparty.setAccountNumber("12345678912345678912");
        counterparty.setBik("048898998");

        Mockito.when(dictionaryService.createCounterparty(Mockito.any(Counterparty.class))).thenReturn(counterparty);

        mockMvc.perform(post("/dictionary/counterparty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(counterparty)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Created Counterparty 1"))
                .andExpect(jsonPath("$.inn").value("1234567891"))
                .andExpect(jsonPath("$.kpp").value("123456789"))
                .andExpect(jsonPath("$.accountNumber").value("12345678912345678912"))
                .andExpect(jsonPath("$.bik").value("048898998"));
    }

    @Test
    public void testUpdateCounterparty1() throws Exception {
        Long id = 1L;
        Counterparty updatedCounterparty = new Counterparty();
        updatedCounterparty.setName("Updated Counterparty 1");
        updatedCounterparty.setInn("987654321");
        updatedCounterparty.setKpp("123456789");

        Mockito.when(dictionaryService.updateCounterparty(Mockito.eq(id), Mockito.any(Counterparty.class)))
                .thenReturn(updatedCounterparty);

        mockMvc.perform(put("/dictionary/counterparty/update/id/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCounterparty)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Updated Counterparty 1"))
                .andExpect(jsonPath("$.inn").value("987654321"))
                .andExpect(jsonPath("$.kpp").value("123456789"));
    }

    @Test
    public void testUpdateCounterparty2() throws Exception {
        String previousName = "Updated Counterparty 1";
        Counterparty updatedCounterparty = new Counterparty();
        updatedCounterparty.setName("Updated Counterparty 2");
        updatedCounterparty.setInn("333333333");
        updatedCounterparty.setKpp("999999999");

        Mockito.when(dictionaryService.updateCounterpartyByName(Mockito.eq(previousName), Mockito.any(Counterparty.class)))
                .thenReturn(updatedCounterparty);

        mockMvc.perform(put("/dictionary/counterparty/update/name/{name}", previousName)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCounterparty)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Updated Counterparty 2"))
                .andExpect(jsonPath("$.inn").value("333333333"))
                .andExpect(jsonPath("$.kpp").value("999999999"));
    }

    @Test
    public void testUpdateCounterparty3() throws Exception {
        String previousName = "Updated Counterparty 2";
        Counterparty updatedCounterparty = new Counterparty();
        updatedCounterparty.setName("Updated Counterparty 3");
        updatedCounterparty.setInn("1");
        updatedCounterparty.setKpp("2");
        updatedCounterparty.setAccountNumber("3");
        updatedCounterparty.setBik("4");

        Mockito.when(dictionaryService.updateCounterpartyByName(Mockito.eq(previousName), Mockito.any(Counterparty.class)))
                .thenReturn(updatedCounterparty);

        mockMvc.perform(put("/dictionary/counterparty/update/name/{name}", previousName)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCounterparty)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Updated Counterparty 3"))
                .andExpect(jsonPath("$.inn").value("1"))
                .andExpect(jsonPath("$.kpp").value("2"))
                .andExpect(jsonPath("$.accountNumber").value("3"))
                .andExpect(jsonPath("$.bik").value("4"));
    }

    @Test
    public void testDeleteCounterpartyById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/dictionary/counterparty/delete/id/{id}", id))
                .andExpect(status().isOk());

        verify(dictionaryService).deleteCounterparty(id);
    }

    @Test
    public void testDeleteCounterpartyByName() throws Exception {
        String name = "Updated Counterparty 2";
        mockMvc.perform(MockMvcRequestBuilders.delete("/dictionary/counterparty/delete/name/{name}", name))
                .andExpect(status().isOk());
        verify(dictionaryService).deleteCounterpartyByName(name);
    }
}
