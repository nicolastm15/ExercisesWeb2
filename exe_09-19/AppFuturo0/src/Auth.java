
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Auth
 */

/*
 * @WebServlet(name = "MyServlet", urlPatterns = { "/Auth" }, initParams = {
 * 
 * @WebInitParam(name = "nicolas", value = "321"), @WebInitParam(name = "lucas",
 * value = "123"),
 * 
 * @WebInitParam(name = "thiago", value = "456"), })
 */

public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected String getPass(String name) {
		ServletConfig cf = getServletConfig();
		return cf.getInitParameter(name);
	}

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
		HttpSession session = request.getSession();

		if (session.getAttribute("logged") != null) {
			request.getRequestDispatcher("logado.jsp").forward(request, response);
		}

		String username = request.getParameter("nome");
		String pass = getPass(username);

		try {
			if (pass.equals(request.getParameter("senha"))) {
				session.setAttribute("logged", username);
				request.getRequestDispatcher("logado.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("form.jsp").forward(request, response);
			}
			;
		} catch (NullPointerException e) {
			request.getRequestDispatcher("form.jsp").forward(request, response);
		}
	}

}
