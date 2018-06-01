package main.core.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RESTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, Authentication authentication) throws IOException {
        clearAuthenticationAttributes(request);
        response.getWriter().write("{\"JSESSIONID\":\"" + RequestContextHolder.currentRequestAttributes().getSessionId() + "\"}");
    }
}
