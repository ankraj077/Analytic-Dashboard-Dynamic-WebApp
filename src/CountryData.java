

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
@WebServlet("/CountryData")
public class CountryData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/countrydata.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String other_selected = request.getParameter("other");
		ArrayList arrayListcountryName = new ArrayList();
		ArrayList arrayListProject = new ArrayList();
		ArrayList arrayListCost = new ArrayList();
		
		int projectCunter = 0;
		Connection con = null;
		ResultSet rs = null;
		String connectionUrl = "jdbc:sqlserver://localhost:1433;database=mycompanydatabase;user=sa;password=Conestoga1";
		PreparedStatement preparedStatement = null;
		
		try{
			ArrayList mainArrayList = new ArrayList();
			
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connectionUrl);
    		
    			PreparedStatement preparedStat = con.prepareStatement("SELECT * from countryData");  
    			//preparedStat.setString(1,"");  
    			  
    			rs = preparedStat.executeQuery();  
		
    			while (rs.next()) {
			
    					JSONObject jsonObject = new JSONObject();
    					jsonObject.put("name", rs.getString(1));
    					jsonObject.put("y", Integer.parseInt(rs.getString(2)));
    					
    					mainArrayList.add(jsonObject);
    					arrayListcountryName.add(rs.getString(1));
    					arrayListProject.add(rs.getString(2));
    					arrayListCost.add(rs.getString(3));
    					
    					projectCunter += Integer.parseInt(rs.getString(2));
    			}
				
    			System.out.println(mainArrayList);
			System.out.println(arrayListcountryName);
			System.out.println(arrayListProject);
			System.out.println(arrayListCost);
		
		
		

		//request.setAttribute("desk", arrayList_desktop);

		request.setAttribute("pCounter", projectCunter);
		request.setAttribute("mainArray", mainArrayList);
		//request.setAttribute("other", arrayList_other);
		request.getRequestDispatcher("/countrydata.jsp").forward(request,response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
