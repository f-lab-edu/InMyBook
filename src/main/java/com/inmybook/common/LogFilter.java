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
		MDC.put("httpMethod", request.getMethod());
		MDC.put("requestUri", request.getRequestURI());

		long startTime = System.currentTimeMillis();

		try {
			filterChain.doFilter(request, response);
		} finally {
			long duration = System.currentTimeMillis() - startTime;
			MDC.put("elapsedTime", String.valueOf(duration));

			log.info("");

			MDC.clear();
		}
	}
}
