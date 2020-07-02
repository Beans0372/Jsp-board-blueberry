package com.cos.blueberry.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blueberry.action.Action;
import com.cos.blueberry.dao.PostDao;
import com.cos.blueberry.model.Post;

public class PostUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			response.sendRedirect("member/loginForm.jsp");
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));
		PostDao postDao = new PostDao();

		Post post = postDao.글가져오기(id);
		request.setAttribute("post", post);
		
		RequestDispatcher dis = request.getRequestDispatcher("post/updateForm.jsp");
		dis.forward(request, response);

	}
}

