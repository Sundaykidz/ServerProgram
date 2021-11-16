package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;
import dao.StudentDao;
import dto.Student;

public class MemberListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDao dao = MemberDao.getInstance();
		
		List<Member> list = dao.selectAllMeber()		
		request.setAttribute("list", list);		
		// 이동 : views/studentList.jsp로 forward
		return new ModelAndView("views/List.jsp", false);
		
	}

}
