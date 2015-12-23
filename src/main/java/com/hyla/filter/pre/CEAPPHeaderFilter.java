package com.hyla.filter.pre;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hyla.utils.CommonUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author prasingh
 *
 */
@Component
public class CEAPPHeaderFilter extends ZuulFilter{

	@Value("${ceapp.username}")
	String CEAPPUsername;

	@Value("${ceapp.password}")
	String CEAPPPassword;

	@Override
	public boolean shouldFilter() {
		return "CE-APP".equals(RequestContext.getCurrentContext().getRequest().getHeader("application-name"));
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		requestContext.addZuulRequestHeader("Authorization", CommonUtils.getAuthHeader(CEAPPUsername, CEAPPPassword));
		requestContext.addZuulRequestHeader("Accept", "application/json");
		requestContext.addZuulRequestHeader("Content-Type", "application/json");
		return null;
	}

	@Override
	public String filterType() {
		 return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
}