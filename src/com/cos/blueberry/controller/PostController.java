package com.cos.blueberry.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blueberry.action.Action;
import com.cos.blueberry.action.post.PostDeleteProcAction;
import com.cos.blueberry.action.post.PostDetailAction;
import com.cos.blueberry.action.post.PostListAction;
import com.cos.blueberry.action.post.PostSaveFormAction;
import com.cos.blueberry.action.post.PostSaveProcAction;
import com.cos.blueberry.action.post.PostUpdateFormAction;
import com.cos.blueberry.action.post.PostUpdateProcAction;


@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostController() {
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
		if (cmd.equals("list")) {
			return new PostListAction();
		} else if (cmd.equals("saveForm")) {
			return new PostSaveFormAction();
		} else if (cmd.equals("saveProc")) {
			return new PostSaveProcAction();
		} else if (cmd.equals("detail")) {
			return new PostDetailAction();
		} else if (cmd.equals("updateForm")) {
			return new PostUpdateFormAction();
		} else if (cmd.equals("updateProc")) {
			return new PostUpdateProcAction();
		} else if (cmd.equals("deleteProc")) {
			return new PostDeleteProcAction();
		}
		return null;
	}
}

