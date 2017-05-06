import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@WebServlet("/")
public class DashboardData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardData() {
		// TODO Auto-generated constructor stub
    	   super();
    }
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
		String exact_year = request.getParameter("y");
		String asc_desc = request.getParameter("r");
		
		System.out.println("Exact number : "+exact_year+" radio = "+asc_desc);
		
		ArrayList arrayList_year = new ArrayList();
		ArrayList arrayList_totalproject = new ArrayList();
		ArrayList arrayList_totalcost = new ArrayList();
		
		
		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;database=mycompanydatabase;user=sa;password=Conestoga1";

		// Declare the JDBC objects.
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		Statement statement = con.createStatement();
            		//String selectSQL = "SELECT * countryData WHERE sale_date between convert(datetime, ?, 101) AND convert(datetime, ?, 101)";
            		
            		if(!start_date.equals("") && !end_date.equals("") || !(asc_desc == null)){
            			
            			if(asc_desc == null){
            				start_date = start_date.substring(start_date.length() - 4);
                			end_date = end_date.substring(end_date.length() - 4);
                			
                			
                			int startDate =  Integer.parseInt(start_date);
                			int endDate = Integer.parseInt(end_date);
                			String selectSQL = "SELECT * from yearlydata WHERE yearnumber >= ? AND yearnumber <= ?";
                			preparedStatement = con.prepareStatement(selectSQL);
                    		preparedStatement.setInt(1, startDate);
                    		preparedStatement.setInt(2, endDate);
                    		rs = preparedStatement.executeQuery();
                				
            			}
            			else if(asc_desc.equals("asc")){
            				if(exact_year.equals("All")){
            					String selectSQL = "SELECT * from yearlydata ORDER BY totalproject";
                    			rs = statement.executeQuery(selectSQL);
            				}
            				else{
            					start_date = start_date.substring(start_date.length() - 4);
                    			end_date = end_date.substring(end_date.length() - 4);
                    			
                    			
                    			int startDate =  Integer.parseInt(start_date);
                    			int endDate = Integer.parseInt(end_date);
                    			String selectSQL = "SELECT * from yearlydata WHERE yearnumber >= ? AND yearnumber <= ? ORDER BY totalproject";
                    			preparedStatement = con.prepareStatement(selectSQL);
                        		preparedStatement.setInt(1, startDate);
                        		preparedStatement.setInt(2, endDate);
                        		rs = preparedStatement.executeQuery();
            				}
            				
            			}
            			else if(asc_desc.equals("desc")){
            				if(exact_year.equals("All")){
            					String selectSQL = "SELECT * from yearlydata ORDER BY totalproject DESC";
                    			rs = statement.executeQuery(selectSQL);
            				}
            				else{
            					start_date = start_date.substring(start_date.length() - 4);
                    			end_date = end_date.substring(end_date.length() - 4);
                    			
                    			
                    			int startDate =  Integer.parseInt(start_date);
                    			int endDate = Integer.parseInt(end_date);
                    			String selectSQL = "SELECT * from yearlydata WHERE yearnumber >= ? AND yearnumber <= ? ORDER BY totalproject DESC";
                    			preparedStatement = con.prepareStatement(selectSQL);
                        		preparedStatement.setInt(1, startDate);
                        		preparedStatement.setInt(2, endDate);
                        		rs = preparedStatement.executeQuery();
            				}
            				
            			}
            			
            			
            			
            		}
            		else if(!exact_year.equals("")){
            			
            			if(exact_year.equals("All")){
            				System.out.println("here3");
            				String selectSQL = "SELECT * from yearlydata";
                			rs = statement.executeQuery(selectSQL);
                			
            			}
            			else{
            				System.out.println("here4");
            				String selectSQL = "SELECT * from yearlydata WHERE yearnumber = ?";
                			preparedStatement = con.prepareStatement(selectSQL);
                    		preparedStatement.setString(1, exact_year);
                    		rs = preparedStatement.executeQuery();
                				
            			}
            			
            		}
            		
            		else{

            			
            			String selectSQL = "SELECT * from yearlydata";
            			rs = statement.executeQuery(selectSQL);
            		}
            	
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
            			
            			arrayList_year.add(rs.getString(1));
            			arrayList_totalproject.add(rs.getString(2));
            			arrayList_totalcost.add(rs.getString(3));
            			
            		}
            		
            		
            		System.out.println(arrayList_year);
            		request.setAttribute("years", arrayList_year);
            		request.setAttribute("total", arrayList_totalproject);
            		request.getRequestDispatcher("/index.jsp").forward(request,response);
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (preparedStatement != null) try { preparedStatement.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
	}
}
