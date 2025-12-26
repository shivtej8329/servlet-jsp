package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String user = (String) session.getAttribute("user");

		if (user != null) {
			req.getRequestDispatcher("/WEB-INF/view/home.jsp");
		} else {
			req.getRequestDispatcher("WEB-INF/view/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (username.equals("shivtej") && password.equals("12345")) {
			HttpSession session = req.getSession();
			session.setAttribute("user", username);

			req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
		} else {

			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		}

	}
}
