package com.hyla.filter.pre;

import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * 
 * @author prasingh
 *
 */
@Component
public class CESearchHeaderFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return "CE-SEARCH".equals(RequestContext.getCurrentContext().getRequest().getHeader("application-name"));
	}

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
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