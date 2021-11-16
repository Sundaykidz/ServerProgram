package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.MemberDeleteService;
import model.MemberDetailService;
import model.MemberInsertService;
import model.MemberListService;
import model.MemberService;
import model.MemberUpdateService;


@WebServlet("*.do")


public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();                     
		String contextPath = request.getContextPath();                  
		String command = requestURI.substring(contextPath.length() + 1);
		
		ModelAndView mav = null;
		MemberService memberService = null;
		switch (command) {
		case "memberList.do":
			memberService = new MemberListService();
			break;
		case "insertForm.do":
			mav = new ModelAndView("views/memberInsert.jsp", false);
			break;
		case "insertMember.do":
			memberService = new MemberInsertService();
			break;
		case "deletemember.do":
			memberService = new MemberDeleteService();
			break;
		case "memberDetail.do":
			memberService = new MemberDetailService();
			break;
		case "updatemember.do":
			memberService = new MemberUpdateService();
			break;
		}
		
		if (memberService != null) {
			try {
				mav = memberService.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
