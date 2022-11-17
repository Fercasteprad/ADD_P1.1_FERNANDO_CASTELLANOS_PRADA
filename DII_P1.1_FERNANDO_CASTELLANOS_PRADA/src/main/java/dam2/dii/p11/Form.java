package dam2.dii.p11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String valor_nombre = request.getParameter("nombre");
		String valor_pass = request.getParameter("pass");
		String valor_pass2 = request.getParameter("pass2");
		
		Usuario user = new Usuario (valor_nombre,valor_pass,valor_pass2);
		
		if (user.getPass().equalsIgnoreCase(user.getPass2())) {
			request.setAttribute("usuario", user);
			request.getRequestDispatcher("/saludo.jsp").forward(request, response);
		}
		else {
			//JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", 1);
			request.getRequestDispatcher("/incorrecto.jsp").forward(request, response);
		}
		
	}

}
