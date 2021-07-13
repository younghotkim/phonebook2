package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PhoneVo;


@WebServlet("/pbc")
public class PhoneController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("컨트롤러");
		
		//파라미터 action 값을 읽어온다
		String action = request.getParameter("action");
		System.out.println(action);
		
		if ("list".equals(action)) {
			
			//리스트업무
			System.out.println("리스트");
			
			PhoneDao phoneDao = new PhoneDao();
			
			List<PhoneVo> personList = phoneDao.getPersonList();
			
			System.out.println("=======CONTROLLER=======");
			System.out.println(personList);
			
			//데이터 넣기 --> request 어트리뷰트에 데이터를 넣어준다.
			
			request.setAttribute("pList", personList);
			
			/* 자료형 파악용
			request.setAttribute("name", "김영하");
			request.setAttribute("age", 31);
			*/
			
			//일일히 html 코드를 작성해야해서 너무 복잡함
			//html 작업 --> JSP에게 시킨다 --> forward 한다
			
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			//rd.forward(request, response);
			
			WebUtil.forward(request, response, "/WEB-INF/list.jsp");
			
		}else if("wform".equals(action)) {
			
			System.out.println("글쓰기폼");
			
			//writeForm.jsp --> 데이터x
			
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			//rd.forward(request, response);
			WebUtil.forward(request, response, "/WEB-INF/writeForm.jsp");
			
		}else if("insert".equals(action)) {
			
			System.out.println("저장");
			
			//dao --> 저장
			//파라미터를 꺼낸다 name, hp, company
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			//vo로 묶어준다
			PhoneVo phoneVo = new PhoneVo(name, hp, company);
			System.out.println(phoneVo);
			
			//dao personInsert(vo)
			
			PhoneDao phoneDao = new PhoneDao();
			
			int count = phoneDao.personInsert(phoneVo);
			
			if (count > 0) {
				
				System.out.println("추가완료");
				//리다이렉트 리스트 (action=list)
				//response.sendRedirect("/phonebook2/pbc?action=list");
				
				WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");
				
			} else {
				
				System.out.println("추가실패");
				
			}		
			
		}else if("delete".equals(action)) {
			
			System.out.println("삭제");
			
			PhoneDao phoneDao = new PhoneDao();
			
			//파라미터(personId) 꺼내기
			int personId = Integer.parseInt(request.getParameter("personId"));
			System.out.println(personId);
			
			//삭제하기
			int count = phoneDao.personDelete(personId);
			
			if (count > 0) {
				
				System.out.println("삭제완료");
				//리다이렉트 리스트 (action=list)
				//response.sendRedirect("/phonebook2/pbc?action=list");
				WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");
				
			} else {
				
				System.out.println("삭제실패");
				
			}
			
		}else if("update".equals(action)) {
			
			System.out.println("수정");
			
			PhoneDao phoneDao = new PhoneDao();
			//파라미터(personId, name, hp, company) 꺼내기
			int personId = Integer.parseInt(request.getParameter("personId"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PhoneVo phoneVo = new PhoneVo(personId, name, hp, company);
			System.out.println(phoneVo);
			
			int count = phoneDao.personUpdate(phoneVo);
			
			if (count > 0) {
				
				System.out.println("수정완료");
				
				//response.sendRedirect("/phonebook2/pbc?action=list");
				
				WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");
				
			} else {
				
				System.out.println("수정실패");
			
			}
				
		}else if ("uform".equals(action)) {
			
			System.out.println("수정폼");
			
			PhoneDao phoneDao = new PhoneDao();
			
			int personId = Integer.parseInt(request.getParameter("personId"));
			//personId를 꺼내서
			
			PhoneVo phoneVo = phoneDao.getPerson(personId);
					
			request.setAttribute("phoneVo", phoneVo);
			//어트리뷰트, 포워드
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateForm.jsp");
			//rd.forward(request, response);
			
			WebUtil.forward(request, response, "/WEB-INF/updateForm.jsp");
			
		}

		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
