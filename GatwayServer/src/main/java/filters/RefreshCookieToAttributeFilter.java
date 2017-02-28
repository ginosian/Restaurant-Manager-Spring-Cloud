package filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martha on 2/26/2017.
 */
public class RefreshCookieToAttributeFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
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
        HttpServletRequest req = ctx.getRequest();
        String refreshToken = extractRefreshToken(req);
        if (refreshToken != null) {
            Map<String, String[]> param = new HashMap<String, String[]>();
            param.put("refresh_token", new String[] { refreshToken });
            param.put("grant_type", new String[] { "refresh_token" });
            ctx.setRequest(new RefreshTokenRequestWrapper(req, param));
        }
        return null;
    }

    private String extractRefreshToken(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("refreshToken")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
