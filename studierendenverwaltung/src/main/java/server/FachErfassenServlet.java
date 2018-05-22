package server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FachErfassenServlet extends HttpServlet {

	// Dieses Servlet dient als ein erstes Beispiel

	private static final long serialVersionUID = 1L;
	private int anzahl = 0;
	

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().write("<html><body>Hello <b>World</b></body></html>");
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("user");
		anzahl++;
		StringBuilder sb = baueHtmlSeite(name);
		resp.getWriter().write(sb.toString());
	}
	
	private StringBuilder baueHtmlSeite(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("  <head>");
			sb.append("  <style>");			
			sb.append(HtmlElements.getNavBarCSS());
			sb.append(HtmlElements.getUserTableCSS());
			sb.append(HtmlElements.getChangeCSS());
			sb.append("  </style>");
		sb.append("  </head>");
		sb.append("  <body>");
		
		sb.append(HtmlElements.getNavBar());
		sb.append(HtmlElements.getAddFach());
		sb.append("  </body>");
		sb.append("</html>");
		return sb;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		SimpleDateFormat date=new SimpleDateFormat("HH:mm:ss");
//		String date1=date.format(new Date());
//		
//		Date date2 = java.util.Calendar.getInstance().getTime();
//		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
//		String dateString = dateFormatter.format(date2);
		
		//resp.getWriter().write("<html><body> Es ist <b>"+date1+"</b> am "+ dateString+" </body></html>");

		doPost(req, resp);
	}

}