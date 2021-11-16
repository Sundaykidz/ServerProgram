package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;
import dao.StudentDao;
import dto.Student;

public class MemberUpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터
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
		
		int result = MemberDao.getInstance().updateMember(member);
		
		// 응답 처리
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공')");
			out.println("location.href='/BATCH/memberDetail.do?no=" + no + "'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		return null;
		
	}

}