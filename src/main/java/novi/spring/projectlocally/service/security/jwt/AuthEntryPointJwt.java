package novi.spring.projectlocally.service.security.jwt;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(AuthEntryPointJwt.class);

    /**
     * HttpServletResponse.SC_UNAUTHORIZED is the 401 Status code. It indicates that the request requires HTTP
     * authentication.
     * @param request request
     * @param response response
     * @param authException exception
     * @throws IOException exception
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        logger.error("Unauthorized error: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }
}
