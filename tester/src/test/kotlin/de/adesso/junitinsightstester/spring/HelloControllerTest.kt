package de.adesso.junitinsightstester.spring

import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Tests for the HelloController
 */
@ExtendWith(SpringExtension::class)
//@JUnitInsights
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Fancy example test")
class HelloControllerTest {

    companion object {
        var logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    @DisplayName("First test method")
    fun getHello() {
        logger.info("### Test 1 started ###")
        mvc.perform(
            MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")))
    }

    @Test
    @DisplayName("Second test method")
    fun getAnotherHello() {
        logger.info("### Test 2 started ###")
        mvc.perform(
            MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")))
    }
}
