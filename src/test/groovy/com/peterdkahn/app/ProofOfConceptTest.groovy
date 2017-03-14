package com.peterdkahn.app

import com.petedkahn.app.Application
import com.peterdkahn.rest.FileInfo
import io.restassured.RestAssured
import org.apache.http.HttpStatus
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.context.WebApplicationContext
import static io.restassured.RestAssured.*
import static io.restassured.matcher.RestAssuredMatchers.*
import static org.hamcrest.Matchers.*

/**
 * Proof of Concept unit test to validate how to approach this situation
 * Created by pkahn on 3/14/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")  // TODO: switch with build variable
class ProofOfConceptTest {

    @Autowired
    private WebApplicationContext webServerAppContext

    @Value("8080")  // TODO: switch with build variable
    private int serverPort
    private FileInfo file1
    private FileInfo file2

    @Before
    void setUp() {
        file1 = new FileInfo()
        file2 = new FileInfo()
        file1.setName("foo")
        file1.setPath("/")
        file2.setName("bar")
        file2.setPath("/sub")
        RestAssured.port = serverPort
    }

    /**
     * Simple case to validate ability to test anything via these frameworks
     */
    @Test
    void checkCannedFiles(){
        when().get("/file?name=foo")
        .then()
            .statusCode(HttpStatus.SC_OK)
        .body("path", equalTo("/"))

    }
}
