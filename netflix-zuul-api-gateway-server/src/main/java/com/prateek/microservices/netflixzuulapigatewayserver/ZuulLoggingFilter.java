package com.prateek.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component		//let spring manage this class
public class ZuulLoggingFilter extends ZuulFilter{
	
	//We are using slf logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request -> {} URI -> {} ",request,request.getRequestURI());
		return null;
	}

	
	/* Whether this filter should be executed */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* Priority of this filter */
	@Override
	public int filterOrder() {
		return 1;
	}

	/* Filter type : pre request, post (before response), error */
	@Override
	public String filterType() {
		return "pre";
	}

}
