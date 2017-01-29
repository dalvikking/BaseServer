package com.dalvik.service.authentication.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.dalvik.utils.HttpUtil;

public class AuthenticationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) {

		Map<String, String> params = HttpUtil.getParams(req);
		Map<String, String> headers = HttpUtil.getHeaders(req);

		if (validateRequest(headers, params)) {
			// authenticate token
			if (headers.containsKey(HttpUtil.authHeader) && headers.get(HttpUtil.authHeader) != null) {
				Boolean result = JWTUtil.parseJWT(params.get(HttpUtil.username), headers.get(HttpUtil.authHeader));
				// set response here
				if (result) {
					resp.setStatus(HttpStatus.SC_OK);
				} else {
					resp.setStatus(HttpStatus.SC_UNAUTHORIZED);
				}
			} else { // create token
				// set response here
				String token = JWTUtil.createJWT(params.get(HttpUtil.username), HttpUtil.issuer, HttpUtil.subject,
						System.currentTimeMillis());
				try {
					resp.getWriter().print(token);
					resp.setStatus(HttpStatus.SC_OK);
				} catch (IOException e) {
					resp.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			// set response here
			try {
				resp.getWriter().print("Invalid Request");
				resp.setStatus(HttpStatus.SC_BAD_REQUEST);
			} catch (IOException e) {
				resp.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			}
		}
	}

	private boolean validateRequest(Map<String, String> headers, Map<String, String> params) {
		if (params == null || params.size() == 0) {
			return false;
		}
		return true;
	}

}
