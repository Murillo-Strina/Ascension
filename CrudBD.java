import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudBD {
    public void incluirReg(Hero uD) {
        String sqlInsert = "INSERT INTO SCORE(player_name, level) VALUES (?,?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, uD.getName());
            stmt.setInt(2, uD.getLevel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Hero> buscarTodos() {
        ArrayList<Hero> aL = new ArrayList<>();
        String sqlSelect = "SELECT * FROM SCORE";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Hero uD = new Hero("", "");
                uD.setName(rs.getString("player_name"));
                uD.setLevel(rs.getInt("level"));
                aL.add(uD);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return aL;
    }
}