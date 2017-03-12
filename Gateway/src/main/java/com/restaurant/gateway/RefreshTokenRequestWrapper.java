package com.restaurant.gateway;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martha on 2/28/17.
 */
public class RefreshTokenRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> additionalParams;
    private HttpServletRequest request;

    public RefreshTokenRequestWrapper (
            HttpServletRequest request, Map<String, String[]> additionalParams) {
        super(request);
        this.request = request;
        this.additionalParams = additionalParams;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String[]> param = new HashMap<>();
        param.putAll(map);
        param.putAll(additionalParams);
        return param;
    }
}
