/**  
 * @Title EntranceFilter.java
 * @Package team.labber.filters
 * @author TODO
 * 2017年3月5日
 * File Name: EntranceFilter.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @ClassName EntranceFilter
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017年3月5日 下午2:47:14, TODO,
 */

public class EntranceFilter implements Filter {
	private static final Logger log = Logger.getLogger(EntranceFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse) response;
		// encoding transfer-process
		hRequest.setCharacterEncoding("UTF-8");
		hResponse.setContentType("text/html;charset=UTF-8");
		hResponse.setCharacterEncoding("UTF-8");

		// Get Customers-side info
		String visitorsIP = request.getRemoteAddr();
		StringBuffer url = hRequest.getRequestURL();
		int index = url.indexOf("STDSelectSys");
		String reqResources = hRequest.getRequestURL().substring(index + 12);

		// Write to the log files
		log.debug("IP(" + visitorsIP + "), Resources(" + reqResources + ");");
		chain.doFilter(request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info(new Date().toString() + " " + EntranceFilter.class
				+ " - initialization OK;");
	}

}
