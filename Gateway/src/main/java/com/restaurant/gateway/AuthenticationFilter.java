package com.restaurant.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by Martha on 2/28/17.
 */
public class AuthenticationFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String auth_token = Utils.extractCookie(ctx.getRequest(), "access_token");

        if (auth_token != null) ctx.addZuulRequestHeader("Authorization", "Bearer " + auth_token);
        if (ctx.getRequest().getRequestURI().contains("oauth/token")) {
            ctx.addZuulRequestHeader("accept", "application/json");
            byte[] encoded;
            try {
                encoded = Base64.encode("web_app:pass".getBytes("UTF-8"));
                ctx.addZuulRequestHeader("Authorization", "Basic " + new String(encoded));
            } catch (UnsupportedEncodingException e) {
                logger.error("Error occurred in pre filter", e);
            }
        }
        return null;
    }
}
