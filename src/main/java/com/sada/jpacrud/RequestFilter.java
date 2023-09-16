/**
 * 
 */
package com.sada.jpacrud;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sada.jpacrud.exception.CustomAccessDeniedHandler;
import com.sada.jpacrud.exception.ErrorDetails;
import com.sada.jpacrud.service.UserRoleService;
import com.sada.jpacrud.util.Authority;
import com.sada.jpacrud.util.JwtUtil;


/**
 * @author sadanand chavan
 *
 * Nov 13, 2022 1:59:02 PM
 */
@Component
public class RequestFilter extends OncePerRequestFilter {

	Logger logger   = LoggerFactory.getLogger(RequestFilter.class);

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRoleService service;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		try {
			Enumeration<String> headerNames = request.getHeaderNames();

			if (headerNames != null) {
				while (headerNames.hasMoreElements()) {
					String key = (String) headerNames.nextElement();
					//logger.info("Request received in filter Header name : ["+key+"] value: [" + request.getHeader(key)+"]");
				}
			}
			String authorizationHeader = request.getHeader("Authorization");

			logger.info("Filter called  header="+authorizationHeader);

			/*
			logger.info("Request filter token =[" +request.getHeader("Token") + "] origin = [ "+request.getHeader("origin") +" ]accept =[" +request.getHeader("accept") + "] content-type=[ "+request.getHeader("content-type") +"]");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization, data, X-Requested-With, remember-me");
			response.setStatus(200);
			 */

			String url =null;
			if ((request instanceof HttpServletRequest)){
				url = request.getRequestURL().toString();
				logger.info("Request filter received request from ipaddress=[" + request.getRemoteAddr() + "] for api url=[" + url + "]");
			}else {
				throw new Exception();
			}

			String token = null;
			String userName = null;

			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				token = authorizationHeader.substring(7);
				logger.info("tokenr="+token);
				userName = jwtUtil.extractUsername(token);
				logger.info("userName = "+userName);
			}

			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails userDetails = service.loadUserByUsername(userName);

				if(userDetails==null ){
					//logger.info("Invalid user details  = "+userName);
					throw new Exception();
				}
				Set <Authority> authorities  = (Set<Authority>) userDetails.getAuthorities();
				Iterator<Authority> namesIterator = authorities.iterator();
				Authority auth = namesIterator.next();
				//logger.info("Roll found = "+auth.getAuthority()+"]");
				String SPURL ="/api/v1/sp/";
				String USERURL ="/api/v1/user/";
				String role =auth.getAuthority();
				
				logger.info("Request api url=[" + url + "] Role =["+role+"]");
				
				if(!url.contains(SPURL) && "SP".equals(role) || !url.contains(USERURL) && "USER".equals(role)){
					logger.error("Invalid access of resource");
					throw new Exception();
				}

				if (jwtUtil.validateToken(token, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

					/*
					UsernamePasswordAuthenticationToken authentication = jwtUtil.getAuthenticationToken(authToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
	                logger.info("authenticated user " + username + ", setting security context");
	                SecurityContextHolder.getContext().setAuthentication(authentication);

					 */
				}
			}
			filterChain.doFilter(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("Exception " +e.getMessage());
			setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, response, e);
			ErrorDetails errorDetails = new ErrorDetails(new Date(),  String.valueOf(response.getStatus()) , HttpStatus.INTERNAL_SERVER_ERROR.toString(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
			ResponseEntity.ok().body(errorDetails);
		}


	}
	/**
	 * @param internalServerError
	 * @param response
	 * @param e
	 */
	private void setErrorResponse(HttpStatus internalServerError, HttpServletResponse response, Exception e) {
		// TODO Auto-generated method stub

	}





}

