import java.sql.*;
import cs.jdbc.driver.CompositeConnection;

public class CompositeJDBC 
{
    private static final String DATASOURCE = "Student_Info";
    private static final String HOST       = "cs08.cs.sjsu.edu";     
    private static final String USERNAME   = "voidstarstar";
    private static final String PASSWORD   = "S13voidstarstar";
    private static final String DOMAIN     = "composite";
    private static final int    PORT       = 9401;  
    
    private Connection connect() 
        throws ClassNotFoundException, SQLException
    {
        Class.forName("cs.jdbc.driver.CompositeDriver");
        String url = "jdbc:compositesw:dbapi@" + HOST + ":" + PORT + 
                     "?domain=" + DOMAIN + "&dataSource=" + DATASOURCE;
        Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
        CompositeConnection compConn = (CompositeConnection) conn;
        compConn.clearAllDataSourceCredentials();
        compConn.setDataSourceCredentials(DATASOURCE, USERNAME, PASSWORD);
        return conn;
    }
    
    private void printHeaders(ResultSetMetaData rsmd, int colCount)
        throws SQLException
    {
        int lengths[] = new int[colCount + 1];
        
        for (int i = 1; i <= colCount; i++) {
            String colName = rsmd.getColumnName(i);
            lengths[i] = colName.length();
            System.out.print(colName + "\t");
        }
        System.out.println();
        
        for (int i = 1; i <= colCount; i++) {
            String dashes = "----------------".substring(0, lengths[i]);
            System.out.print(dashes + "\t");
        }
        System.out.println();
    }
    
    private void query(Connection conn) 
        throws SQLException
    {
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        
        try {
            stmt = conn.createStatement();
            stmt.execute("SELECT * FROM Student_Info");

            rs = stmt.getResultSet();
            rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            printHeaders(rsmd, colCount);

            while (rs.next()) {
                for (int i = 1; i <= colCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }
        finally {
            if (rs   != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
    
    public static void main(String args[]) 
    {
        Connection conn;
        CompositeJDBC composite = new CompositeJDBC();
        
        try {
            conn = composite.connect();
            composite.query(conn);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}