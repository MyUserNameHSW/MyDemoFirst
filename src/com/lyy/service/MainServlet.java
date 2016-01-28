package com.lyy.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lyy.action.Product;
import com.lyy.daoimp.CheckDao;
import com.lyy.daoimp.CheckStore;
import com.lyy.daoimp.GetCount;
import com.lyy.daoimp.GetFileName;
import com.lyy.daoimp.GetS;
import com.lyy.daoimp.ListPage;
import com.lyy.daoimp.PDelete;
import com.lyy.daoimp.PInsert;
import com.lyy.daoimp.PUpdate;
import com.lyy.daoimp.Register;
import com.lyy.daoimp.RegisterInsert;
import com.lyy.daoimp.SelectPage;
import com.lyy.daoimp.ShowPage;
import com.lyy.util.MD5Tool;

/**
 * Servlet implementation class MainServlet
 */
// 使用@WebServlet配置UploadServlet的访问路径
// @WebServlet(name="MainServlet",urlPatterns="/MainServlet")
// 使用注解@MultipartConfig将一个Servlet标识为支持文件上传
@MultipartConfig // 标识Servlet支持文件上传
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String result = request.getParameter("action");
		if (result.equals("1")) {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			code = MD5Tool.MD5(code);
			CheckDao checkDao = new CheckDao();
			boolean flag = checkDao.login(name, code);
			if (flag) {
				// request.setAttribute("action", 3);
				request.getSession().setAttribute("name", name);
				request.getRequestDispatcher("/MainServlet?action=3").forward(request, response);
				// response.sendRedirect("/GreenGarden/MainServlet?action=3");
				// return;
			} else {
				request.setAttribute("msg", "登录失败");
				request.getRequestDispatcher("jsp/ManagerLogin.jsp").forward(request, response);
				// response.sendRedirect("jsp/ManagerLogin.jsp");
				return;
			}
		} else if (result.equals("2")) {
			String name = request.getParameter("rname");
			String code = request.getParameter("rcode");
			String s_id = request.getParameter("store");
			int S_id = Integer.parseInt(s_id);
			code = MD5Tool.MD5(code);
			Register register = new Register();
			CheckStore checkStore = new CheckStore();
			RegisterInsert registerInsert = new RegisterInsert();
			boolean flag = register.getRegister(name);
			boolean flag2 = checkStore.checkStore(S_id);
			if (flag) {
				if (flag2) {
					request.setAttribute("isregister", "注册成功");
					registerInsert.registerInsert(name, code, S_id);
					request.getRequestDispatcher("jsp/ManagerLogin.jsp").forward(request, response);
				} else {
					request.setAttribute("stores", "注册失败，商家已存在");
					request.getRequestDispatcher("jsp/Register.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("notregister", "注册失败，用户名已存在");
				request.getRequestDispatcher("jsp/Register.jsp").forward(request, response);
			}
		} else if (result.equals("3")) {
			GetS getS = new GetS();
			String name = (String) request.getSession().getAttribute("name");
			String pageNums = request.getParameter("pageNum");
			// System.out.println(pageNums);
			if (pageNums == null || pageNums.equals("")) {
				pageNums = "1";
			}
			int pageNum = Integer.parseInt(pageNums);
			// String likename = "";
			int S_id = getS.getS(name);
			GetCount getCount = new GetCount();
			int count = getCount.getCount(S_id);
			ShowPage showPage = new ShowPage();
			List<Product> list = showPage.show(S_id, pageNum);
			// int count = showPage.count;
			// System.out.println("count--->"+count);
			request.setAttribute("array", list);
			request.setAttribute("name", name);
			request.setAttribute("sum", count);
			request.setAttribute("xxx", "3");
			request.getRequestDispatcher("/jsp/ShowPage.jsp").forward(request, response);
		} else if (result.equals("4")) {
			//String savePath = request.getServletContext().getRealPath("/img");
			String savePath = "d:/aaa";
			String virtualPath = "/upload";
			Part part = request.getPart("img");
			String img = null;
			String header;
				header = part.getHeader("content-disposition");
				String fileName = GetFileName.getFileName(header);
				part.write(savePath + File.separator + fileName);
				img = virtualPath + "/" + fileName;			
				
			String sname = (String) request.getSession().getAttribute("name");
			String name = request.getParameter("names");
			String depict = request.getParameter("depict");
			String type = request.getParameter("type");
			String price1 = request.getParameter("price");
			double price = Double.valueOf(price1);
			// String img = request.getParameter("img");
			String phone = request.getParameter("phone");
			String PS2_id1 = request.getParameter("PS2_id");
			int PS2_id = Integer.parseInt(PS2_id1);
			PInsert pInsert = new PInsert();
			pInsert.pinsert(sname, name, depict, type, price, img, phone, PS2_id);
			response.sendRedirect("/GreenGarden/MainServlet?action=3");
			return;
		} else if (result.equals("5")) {
			String id = request.getParameter("P_id");
			int P_id = Integer.parseInt(id);
			PDelete pDelete = new PDelete();
			pDelete.pDelete(P_id);
			response.sendRedirect("/GreenGarden/MainServlet?action=3");
			return;
		} else if (result.equals("6")) {
			String img =null;
			//ServletContext sctx = getServletContext();
			String savePath = "d:\\aaa";
			String virtualPath="/upload";
//			String savePath = request.getServletContext().getRealPath("/img");
			Part part = request.getPart("uimg");
		        try{
				String header = part.getHeader("content-disposition");
				String fileName = GetFileName.getFileName(header);
				part.write(savePath + File.separator + fileName);
				img = virtualPath + "\\" + fileName;
		        }catch(Exception e){
		        	img = request.getParameter("imgs"); 	
		        }

		        
            
			String uP_id = request.getParameter("P_id");
			int P_id = Integer.parseInt(uP_id);
			String name = request.getParameter("uname");
			String depict = request.getParameter("udepict");
			String type = request.getParameter("utype");
			String price1 = request.getParameter("uprice");
			double price = Double.valueOf(price1);
			// String img = request.getParameter("uimg");
			String phone = request.getParameter("uphone");
			String PS2_id1 = request.getParameter("uPS2_id");
			int PS2_id = Integer.parseInt(PS2_id1);
			PUpdate pUpdate = new PUpdate();
			pUpdate.pUpdate(name, depict, type, price, img, phone, PS2_id, P_id);
			response.sendRedirect("/GreenGarden/MainServlet?action=3");
			return;
		} else if (result.equals("7")) {
			GetS getS = new GetS();
			String name = (String) request.getSession().getAttribute("name");
			// System.out.println(name);
			String likename = request.getParameter("likename");
			// System.out.println("likename---"+likename);
			String pageNums = request.getParameter("pageNum");
			// System.out.println(pageNums);
			if (pageNums == null || pageNums.equals("")) {
				pageNums = "1";
			}
			int pageNum = Integer.parseInt(pageNums);
			int S_id = getS.getS(name);
			GetCount getCount = new GetCount();
			int count = getCount.getSelectCount(S_id, likename);
			// System.out.println("--count"+count);
			// ShowPage showPage = new ShowPage();
			SelectPage selectPage = new SelectPage();
			List<Product> list = selectPage.show(S_id, likename, pageNum);
			// int count = selectPage.count;
			request.setAttribute("sum", count);
			request.setAttribute("array", list);
			request.setAttribute("xxx", "7");
			request.setAttribute("likename", likename);
			request.getRequestDispatcher("/jsp/ShowPage.jsp").forward(request, response);
		} else if (result.equals("8")) {
			request.getSession().invalidate();
			response.sendRedirect("jsp/ManagerLogin.jsp");
			return;
		} else if (result.equals("9")) {
			GetS getS = new GetS();
			String name = (String) request.getSession().getAttribute("name");
			String item = request.getParameter("select1");
			String pageNums = request.getParameter("pageNum");
			if (pageNums == null || pageNums.equals("")) {
				pageNums = "1";
			}
			int pageNum = Integer.parseInt(pageNums);
			// System.out.println(item);
			int S_id = getS.getS(name);
			GetCount getCount = new GetCount();
			int count = getCount.getListCount(S_id, item);
			ListPage listPage = new ListPage();
			List<Product> list = listPage.list1Selete(S_id, item, pageNum);
			// int count = listPage.count;
			request.setAttribute("array", list);
			request.setAttribute("sum", count);
			request.setAttribute("xxx", "9");
			request.setAttribute("item", item);
			request.getRequestDispatcher("/jsp/ShowPage.jsp").forward(request, response);
		}
	}
}
