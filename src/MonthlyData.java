

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonthlyData
 */
@WebServlet("/MonthlyData")
public class MonthlyData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthlyData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/monthlychart.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String month_data = request.getParameter("m");
		String web_selected = request.getParameter("web");
		String mob_selected = request.getParameter("mob");
		String desk_selected = request.getParameter("desk");
		String other_selected = request.getParameter("other");
		
		ArrayList arrayList_months = new ArrayList();
		ArrayList arrayList_web = new ArrayList();
		ArrayList arrayList_mobile = new ArrayList();
		ArrayList arrayList_desktop = new ArrayList();
		ArrayList arrayList_other = new ArrayList();
		
		
		Connection con = null;
		ResultSet rs = null;
		String connectionUrl = "jdbc:sqlserver://localhost:1433;database=mycompanydatabase;user=sa;password=Conestoga1";
		PreparedStatement preparedStatement = null;
		
		
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connectionUrl);
    		
    		Statement statement = con.createStatement();
		
    		if(month_data.equals("All")){
    			String selectSQL = "SELECT * from monthlydata";
    			rs = statement.executeQuery(selectSQL);
    		}
    		else{
    			String selectSQL = "SELECT * from monthlydata WHERE monthName='"+month_data+"'";
    			rs = statement.executeQuery(selectSQL);
    		}
		
		
		while (rs.next()) {
			
			arrayList_months.add("\""+rs.getString(1)+"\"");
			if(web_selected == null && mob_selected == null && desk_selected == null && other_selected == null){
				
			}
			
			if(web_selected != null && mob_selected != null && desk_selected != null && other_selected != null){
				arrayList_web.add(rs.getString(2));
				arrayList_mobile.add(rs.getString(3));
				arrayList_desktop.add(rs.getString(4));
				arrayList_other.add(rs.getString(5));
			}
			else if(web_selected != null && mob_selected != null && desk_selected != null){
				arrayList_web.add(rs.getString(2));
				arrayList_mobile.add(rs.getString(3));
				arrayList_desktop.add(rs.getString(4));
			}
			else if(web_selected != null && mob_selected != null && other_selected != null){
				arrayList_web.add(rs.getString(2));
				arrayList_mobile.add(rs.getString(3));
				arrayList_other.add(rs.getString(5));
			}
			else if(web_selected != null && desk_selected != null && other_selected != null){
				arrayList_web.add(rs.getString(2));
				arrayList_desktop.add(rs.getString(4));
				arrayList_other.add(rs.getString(5));
			}
			else if(web_selected != null && mob_selected != null){
				arrayList_web.add(rs.getString(2));
				arrayList_mobile.add(rs.getString(3));
			
			}
			else if(web_selected != null && desk_selected != null){
				arrayList_web.add(rs.getString(2));
				arrayList_desktop.add(rs.getString(4));
			
			}
			else if(web_selected != null && other_selected != null){
				arrayList_web.add(rs.getString(2));
				arrayList_other.add(rs.getString(5));
			
			}
			else if(mob_selected != null && other_selected != null){
			
				arrayList_mobile.add(rs.getString(3));
				arrayList_desktop.add(rs.getString(4));
				arrayList_other.add(rs.getString(5));
			}
			else if(desk_selected != null && other_selected != null){
				
				
				arrayList_desktop.add(rs.getString(4));
				arrayList_other.add(rs.getString(5));
			}
			
			
			else if(web_selected != null){
				arrayList_web.add(rs.getString(2));
			}
			else if(mob_selected != null){
				arrayList_mobile.add(rs.getString(3));
			}
			else if(desk_selected != null){
				arrayList_desktop.add(rs.getString(4));
			}
			else if(other_selected != null){
				arrayList_other.add(rs.getString(5));
			}
			
			
			
			
			
		}
		
		System.out.println(arrayList_web);
		System.out.println(arrayList_months);
		
		request.setAttribute("mon", arrayList_months);
		request.setAttribute("web", arrayList_web);

		request.setAttribute("mob", arrayList_mobile);
		request.setAttribute("desk", arrayList_desktop);

		request.setAttribute("other", arrayList_other);
		request.getRequestDispatcher("/monthlychart.jsp").forward(request,response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
