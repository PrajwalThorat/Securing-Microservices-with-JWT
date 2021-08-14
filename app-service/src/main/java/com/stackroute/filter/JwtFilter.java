package com.stackroute.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* This class implements the custom filter by extending org.springframework.web.filter.GenericFilterBean.
 * Override the doFilter method with ServletRequest, ServletResponse and FilterChain.
 * This is used to authorize the API access for the application.
 */
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } else if ((authHeader==null || !authHeader.startsWith("Bearer "))){
            throw new ServletException("Missing ");
            /*
             * Check if authHeader is null or does not start with "Bearer " then throw Exception
             */

            /*
             * Extract token from authHeader
             */

            /*
             * Obtain Claims by parsing the token with the signing key value "secret"
             */

            /*
             * Set Claims object obtained in previous step with key "claims" as request attribute
             */

            /*
             * Set user id passed as request parameter with key "user" as request attribute
             */

        }
        String token=authHeader.substring(7);
        Claims claim= Jwts.parser().setSigningKey("secret").parseClaimsJwt(token)
                .getBody();
        request.setAttribute("claims", claim);
        filterChain.doFilter(request, response);
    }
}

