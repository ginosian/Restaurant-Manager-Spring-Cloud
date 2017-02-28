package filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sun.jersey.core.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by Martha on 2/26/2017.
 */
public class AuthenticationFIlter extends ZuulFilter {

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
        if(ctx.getRequest().getRequestURI().contains("oauth/token")){
            byte[] encoded;
            try{
                encoded = Base64.encode("client:secret".getBytes("UTF-8"));
                ctx.addZuulRequestHeader("Authorization", "Basic " + new String(encoded));
            } catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
