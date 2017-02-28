package filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Martha on 2/26/2017.
 */
public class LogFilter extends ZuulFilter{

    private static Logger logger = LoggerFactory.getLogger(LogFilter.class);


    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 1;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info(String.format("%s request %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
}
