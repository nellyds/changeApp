package com.nerdery.coinApp.Controller;

import com.nerdery.coinApp.Service.CoinService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CoinController.class)
@AutoConfigureMockMvc
public class CoinControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CoinService coinService;

    @Test
    public void validCallTest() throws Exception {

        this.mvc.perform(get("/api?dollarValue=1.29"))

                .andExpect(status().isOk())

                .andDo(print());
    }

}
