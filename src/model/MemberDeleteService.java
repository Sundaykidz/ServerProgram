package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;
import dao.StudentDao;

public class MemberDeleteService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		String no = optNo.orElse("99999");
		
		int result = MemberDao.getInstance().deleteMember(no);
		
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('삭제 성공')");
			out.println("location.href='/BATCH/memberList.do'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
