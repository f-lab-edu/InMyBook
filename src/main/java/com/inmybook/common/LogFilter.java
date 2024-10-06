package com.inmybook.common;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		final String requestId = UUID.randomUUID().toString();
		final String userId = UUID.randomUUID().toString(); // 임시
		MDC.put("requestId", requestId);
		MDC.put("userId", userId);

		long startTime = System.currentTimeMillis();

		log.info("{} start for request : {}", this.getClass().getSimpleName(), request.getRequestURI());

		try {
			filterChain.doFilter(request, response);
		} finally {
			long duration = System.currentTimeMillis() - startTime;
			log.info("{} completed for request : {} - duration : {}ms", this.getClass().getSimpleName(),
				request.getRequestURI(), duration);
			MDC.clear();
		}
	}
}
