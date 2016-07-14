

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBResturant;
import model.Resturant;

/**
 * Servlet implementation class ResturantList
 */
@WebServlet("/ResturantList")
public class ResturantList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResturantList() {
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
		
		System.out.println("in list");
		String resturantid=request.getParameter("resturantid");
		System.out.println(resturantid);
		HttpSession session = request.getSession();
		
		
		if(resturantid!=null)
		{
			 List<Resturant> posts = null;
				
			posts = DBResturant.reviewofresturantID(resturantid);
		System.out.println(posts.size());
			session.setAttribute("posts", posts);
			
		String nextURL = "/Review.jsp";
		request.getRequestDispatcher(nextURL).forward(request,response);
		}
		
	}

}






