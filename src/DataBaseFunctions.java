import java.sql.*;  

public class DataBaseFunctions {
    public void addData(String rollno, String name, String DOB, Float GPA, String hosteler){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement stmt = con.createStatement();  
            stmt.executeUpdate("INSERT INTO students (rollno, name, dob, gpa, hosteler) VALUES ("+rollno+", '"+name+"', '"+DOB+"', "+GPA+", '"+hosteler+"')");  
            con.close();  

        }
        catch(Exception e){
            System.out.println(e);
        }  
    }

    public void deleteData(String rollno){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement stmt = con.createStatement();  
            stmt.executeUpdate("DELETE FROM students WHERE rollno = "+rollno+"");  
            con.close();  

        }
        catch(Exception e){
            System.out.println(e);
        }  
    }

    public void updateData(String rollno, String name, String DOB, Float GPA, String hosteler){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement stmt = con.createStatement();  
            stmt.executeUpdate("UPDATE students SET name='"+name+"', dob='"+DOB+"', gpa="+GPA+", hosteler='"+hosteler+"' WHERE rollno="+rollno+"");  
            con.close();  

        }
        catch(Exception e){
            System.out.println(e);
        }  
    }

    public String[][] getData(){
        
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            ); 

            ResultSet result = stmt.executeQuery("SELECT * FROM students");
            
            int size= 0;
            if (result != null)   
            {  
                result.beforeFirst();  
                result.last();  
                size = result.getRow();  
            }  

            result.beforeFirst();  

            String[][] resultString = new String[size][5];
            int columnSize = 5;
            int rowSize = size;
            
            int count = 0;
            while(result.next()){
                resultString[count][0] = String.valueOf(result.getInt(1));
                resultString[count][1] = String.valueOf(result.getString(2));
                resultString[count][2] = String.valueOf(result.getString(3));
                resultString[count][3] = String.valueOf(result.getFloat(4));
                resultString[count][4] = String.valueOf(result.getString(5));
                count++;
            }

            for(int i=0; i<rowSize; i++){
                for(int j=0; j<columnSize; j++){
                    System.out.print(resultString[i][j] + " ");
                }
                System.out.println();
            }
            con.close();  
            return resultString;
        }
        catch(Exception e){
            System.out.println("CATCH");
            System.out.println(e);
        }  

        return new String[0][0];
        
    }
}
