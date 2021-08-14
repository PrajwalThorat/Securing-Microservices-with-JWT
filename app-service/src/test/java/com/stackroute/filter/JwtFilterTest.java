package com.stackroute.filter;

import com.stackroute.util.JwtTokenGeneratorTestUtil;
import com.stackroute.util.TestUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class JwtFilterTest {

    private static final String TEST_URI = "/api/v1/message";
    JwtTokenGeneratorTestUtil jwtTokenGeneratorTestUtil = new JwtTokenGeneratorTestUtil();
    private JwtFilter jwtFilter = new JwtFilter();

    @Test
    public void testDoFilterInternalPositiveScenarioWhenTokenIsInHeader() throws ServletException, IOException {
        Map<String, String> tokenMap = jwtTokenGeneratorTestUtil.generateToken(new TestUser("john@email.com", "john@123"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer " + tokenMap.get("token"));
        request.setRequestURI(TEST_URI);
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        jwtFilter.doFilter(request, response, filterChain);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}