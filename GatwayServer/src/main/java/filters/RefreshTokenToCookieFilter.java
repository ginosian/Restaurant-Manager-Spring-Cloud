package filters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by Martha on 2/26/2017.
 */
public class RefreshTokenToCookieFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(LogFilter.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            InputStream inputStream = ctx.getResponseDataStream();
            String responseBody = IOUtils.toString(inputStream, "UTF-8");
            if (responseBody.contains("refresh_token")) {
                Map<String, Object> responseMap = mapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {});
                String refreshToken = responseMap.get("refresh_token").toString();
                responseMap.remove("refresh_token");
                responseBody = mapper.writeValueAsString(responseMap);

                Cookie cookie = new Cookie("refreshToken", refreshToken);
                cookie.setHttpOnly(true);
                cookie.setSecure(true);
                cookie.setPath(ctx.getRequest().getContextPath() + "/oauth/token");
                cookie.setMaxAge(300); // 5 minutes
                ctx.getResponse().addCookie(cookie);
            }
            ctx.setResponseBody(responseBody);
        } catch (IOException e) {
            logger.error("Error occured in zuul post filter", e);
        }
        return null;
    }

}
