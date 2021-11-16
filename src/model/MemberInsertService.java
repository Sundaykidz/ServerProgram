package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;
import dao.StudentDao;
import dto.Student;

public class MemberInsertService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		double point = Double.parseDouble(request.getParameter("point"));
		
		
		
		Member member = new Member();
		member.setNo(no);
		member.setName(name);
		member.setId(id);
		member.setGrade(grade);
		member.setPoint(point);
		
		int result = MemberDao.getInstance().insertMember(member);
		
	
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('등록 성공')");
			out.println("location.href='/BATCH/memberList.do'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('등록 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}