package se.hw.demo.calculator;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import se.hw.demo.calculator.service.CalcService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


//@ActiveProfiles(TEST_PROFILE)
@AutoConfigureMockMvc
@SpringBootTest
//@Import(TestConfig.class)
public class CalcApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CalcService calcService;

	@Test
	public void shouldGetStatus() throws Exception {
		this.mvc.perform(get("/api/v1/status")).andExpect(status().isOk())
		.andExpect(content().string("{\"status\": \"OK\"}"));
	}

	@Test
	public void addShouldReturnOk() throws Exception {
		
		  mvc.perform(get("/api/v1/add?a=3&b=4"))
	        .andExpect(status().isOk());
		 	}
}
