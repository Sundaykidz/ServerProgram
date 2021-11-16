package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java.util.jar.pack.Package.Class.Member;

import common.ModelAndView;
import dao.MemberDao;
import dao.StudentDao;
import dto.Student;

public class MemberDetailService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		if (no == 0) no = 99999;

		Member member = MemberDao.getInstance().selectMemberByNo(no);
		

		request.setAttribute("member", member);
		

		return new ModelAndView("views/memberDetail.jsp", false);
		
	}

}
