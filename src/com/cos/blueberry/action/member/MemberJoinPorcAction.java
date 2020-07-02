package com.cos.blueberry.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blueberry.action.Action;
import com.cos.blueberry.dao.MemberDao;

public class MemberJoinPorcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.회원가입(username, password, email);
		
		if (result == 1) {
			response.sendRedirect("member/loginForm.jsp");
		} else {
			response.sendRedirect("member/joinForm.jsp");
		}
	}
}

