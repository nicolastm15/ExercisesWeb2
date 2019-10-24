package checkbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBox
 */
@WebServlet("/CheckBox")
public class CheckBox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckBox() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer prod = 1;
		List<Integer> t = new ArrayList<Integer>();
		String[] v = request.getParameterValues("cores");

		try {
			for (String el : v) {
				try {
					Integer k = Integer.parseInt(el);
					t.add(k);
				} catch (NumberFormatException e) {

				}
			}
		} finally {
			if (v.length < 2) {
				response.getWriter().append("Menos de duas opçoes foram selecionadas!");
			} else if (!t.isEmpty()) {
				for (Integer el : t) {
					prod *= el;
				}
				response.getWriter().append("O produto dos numeros selecionados é: " + prod);
			} else {
				request.getRequestDispatcher("Alternativo").forward(request, response);
			}
		}

	}

}
