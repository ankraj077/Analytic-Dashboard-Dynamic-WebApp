import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class TechData
 */
@WebServlet("/TechData")
public class TechData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TechData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/techdata.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String radioCate = request.getParameter("r1");

		// String other_selected = request.getParameter("other");
		ArrayList arrayListTechnology = new ArrayList();
		ArrayList arrayListTechProjects = new ArrayList();
		ArrayList arrayListTotalCost = new ArrayList();
		ArrayList arrayCategory = new ArrayList();

		int projectCunter = 0;
		Connection con = null;
		ResultSet rs = null;
		String connectionUrl = "jdbc:sqlserver://localhost:1433;database=mycompanydatabase;user=sa;password=Conestoga1";
		PreparedStatement preparedStatement = null;

		
		

		
		try {
			ArrayList mainArrayListTech = new ArrayList();

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			PreparedStatement preparedStat = con
					.prepareStatement("SELECT * from technology");
			// preparedStat.setString(1,"");

			rs = preparedStat.executeQuery();

			ArrayList tPorject = new ArrayList();

			while (rs.next()) {

				JSONObject jsonObject = new JSONObject();

				jsonObject.put("name", rs.getString(1));

				ArrayList insideValue = new ArrayList();
				insideValue.add(1);
				insideValue.add(3);
				insideValue.add(4);
				jsonObject.put("data", insideValue);

				mainArrayListTech.add(jsonObject);

				arrayListTechnology.add("\"" + rs.getString(1) + "\"");
				arrayListTechProjects.add(rs.getString(2));
				arrayListTotalCost.add(rs.getString(3));
				arrayCategory.add(rs.getString(4));
				projectCunter += Integer.parseInt(rs.getString(2));
				
			}

			ArrayList arrayListThreeCategory = new ArrayList();
			arrayListThreeCategory.add("\"" + "Web" + "\"");
			arrayListThreeCategory.add("\"" + "Mobile" + "\"");
			arrayListThreeCategory.add("\"" + "Desktop" + "\"");

			System.out.println(arrayListTechnology);
			System.out.println(arrayListThreeCategory);
			System.out.println(mainArrayListTech);

			// request.setAttribute("pCounter", projectCunter);
			request.setAttribute("tech", arrayListTechnology);
			request.setAttribute("cate", arrayListThreeCategory);
			request.setAttribute("mainA", mainArrayListTech);
			request.setAttribute("tcost", arrayListTotalCost);

			// request.setAttribute("other", arrayList_other);
			request.getRequestDispatcher("/techdata.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
