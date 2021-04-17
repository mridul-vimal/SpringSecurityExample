package com.vimal.spring;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringSecurityTest {

    TestRestTemplate restTemplate;
    @LocalServerPort
    Integer port;
    URI baseUrl;

    @Before
    public void setup() throws URISyntaxException {
        restTemplate = new TestRestTemplate();
        baseUrl = new URI("http://localhost:"+port+"/api/users");
    }

    public HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    @Test
    public void testLoginSuccess(){
        ResponseEntity<String> responseEntity= restTemplate.exchange(baseUrl, HttpMethod.GET,new HttpEntity(createHeaders("admin", "password")),String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testLoginFailure(){
        ResponseEntity<String> responseEntity= restTemplate.exchange(baseUrl, HttpMethod.GET,new HttpEntity(createHeaders("admin", "api")),String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

}
