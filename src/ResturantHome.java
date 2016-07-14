

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Resturant;
import model.Review;
import model.UserHelp;
import model.DBUtil;

import model.Customer;
import model.DBResturant;

/**
 * Servlet implementation class ResturantHome
 */
@WebServlet("/ResturantHome")
public class ResturantHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResturantHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		doPost(request, response);
				
	}
			
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Customeremail = request.getParameter("email");
		//String password = request.getParameter("password");
		//String action = request.getParameter("action");
		//UserHelp.isValidUser(Customeremail);
		HttpSession session = request.getSession();
		Customer user = null;
		
		
		
		
		user = UserHelp.getUserByEmail(Customeremail);
		if (user!= null)
		{
			
			request.setAttribute("message", Customeremail);
			
					
	    }
		else{
			System.out.println("Incorrect");
		}
		session.setAttribute("user", user);
// posts on list of rest
			
		 
		List<Resturant> posts = null;
			
		posts = DBResturant.getAllPost();
	
		session.setAttribute("posts", posts);
		String nextURL = "/ResturantList.jsp";
		request.getRequestDispatcher(nextURL).forward(request,response);	
		
	}

}
