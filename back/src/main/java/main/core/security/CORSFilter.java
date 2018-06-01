package main.core.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CORSFilter implements Filter {

    private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String LOGIN = "/login";
    private static final String LOGOUT = "/logout";
    private static final String OPEN = "/open/";

    private Logger LOG = LoggerFactory.getLogger(CORSFilter.class);

    private String client;
    private String serverContextPath;

    public CORSFilter(String client, String serverContextPath) {
        this.client = client;
        this.serverContextPath = serverContextPath;

    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        // NOP
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getRequestURI().startsWith(serverContextPath + LOGIN) || (serverContextPath + LOGOUT).equals(request.getRequestURI())) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format("login|logout :  %s", request.getRequestURI()));
            }
            response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, "Origin, X-Requested-With, Content-Type, Accept");
        } else if (request.getRequestURI().startsWith(serverContextPath + OPEN)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format("open : %s", request.getRequestURI()));
            }
            response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format("other : %s  client %s", request.getRequestURI(), client));
            }
            response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, client);
            response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, PATCH, DELETE, OPTIONS");
            response.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        // NOP
    }
}
