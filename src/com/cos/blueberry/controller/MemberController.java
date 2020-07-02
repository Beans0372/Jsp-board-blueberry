package com.cos.blueberry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blueberry.action.Action;
import com.cos.blueberry.action.member.MemberJoinFormAction;
import com.cos.blueberry.action.member.MemberJoinPorcAction;
import com.cos.blueberry.action.member.MemberLoginFormAction;
import com.cos.blueberry.action.member.MemberLoginProcAction;
import com.cos.blueberry.action.member.MemberLogoutAction;
import com.cos.blueberry.action.member.MemberUpdateFormAction;
import com.cos.blueberry.action.member.MemberUpdateProcAction;


@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		action.execute(request, response);
	}

	private Action router(String cmd) {
		if (cmd.equals("joinForm")) {
			return new MemberJoinFormAction();
		} else if(cmd.equals("joinProc")) {
			return new MemberJoinPorcAction();
		} else if(cmd.equals("loginForm")) {
			return new MemberLoginFormAction();
		} else if (cmd.equals("loginProc")) {
			return new MemberLoginProcAction();
		}else if (cmd.equals("updateForm")) {
			return new MemberUpdateFormAction();
		}else if (cmd.equals("updateProc")) {
			return new MemberUpdateProcAction();
		}else if (cmd.equals("logout")) {
			return new MemberLogoutAction();
		}
		return null;
	}
}

