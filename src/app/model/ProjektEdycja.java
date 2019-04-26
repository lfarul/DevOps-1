package app.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.util.HibernateUtil;

/**
 * Servlet implementation class ProjektEdycja
 */
@WebServlet("/ProjektEdycja")
public class ProjektEdycja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjektEdycja() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		if (request.getParameter("btn_zapisz") != null) {
			
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

			Projekt projekt = new Projekt();

			projekt.setNazwa("Projekt testowy");
			projekt.setOpis("Opis testowy");
			projekt.setDataczas_utworzenia(LocalDateTime.now());
			projekt.setData_oddania(LocalDate.now());

			entityManager.getTransaction().begin();
			entityManager.persist(projekt);
			entityManager.getTransaction().commit();
			entityManager.close();

			request.setAttribute("projekt", projekt);
		}
		
		if (request.getParameter("btn_usun") != null) {
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
			Projekt projekt = entityManager.getReference(Projekt.class,4);
			entityManager.getTransaction().begin();
			entityManager.remove(projekt);
			entityManager.getTransaction().commit();		
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/projekt_edycja.jsp");
		dispatcher.forward(request, response);
		
	}
}
