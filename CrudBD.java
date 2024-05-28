import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.util.ArrayList;

public class CrudBD
{   public void incluirReg(Hero uD)
    {   String   sqlInsert = "INSERT INTO SCORE(player_name, level) VALUES (?,?)";
        Connection  conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try
        {   stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, uD.getName());
            stmt.setInt(2, uD.getLevel());
        }
        catch(SQLException e)
        {   try
            {   conn.rollback();
            }
            catch(SQLException ex)
            {   System.out.println("Erro ao incluir os dados" + ex.toString());
            }
        }
        finally
        {   ConnFactory.closeConn(conn, stmt);
        }
    }   
    
    
    public  ArrayList<Hero> buscarTodos()
    {   ArrayList<Hero> aL = new ArrayList<>();
        String   sqlSelect = "SELECT * FROM SCORE";
        Connection  conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs;
        try
        {   stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while(rs.next())
            {   Hero uD = new Hero("","");
                uD.setName(rs.getString("PLAYER_NAME"));
                uD.setLevel(rs.getInt("LEVEL"));
                aL.add(uD);
            }
        }
        catch(SQLException ex)
        {   System.out.println("Erro ao buscar todos os dados" + ex.toString());
        }
        finally
        {   ConnFactory.closeConn(conn, stmt);
        }   
        return aL;
    }
}
