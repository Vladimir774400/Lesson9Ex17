import java.sql.*;

public class sqlres {
    public static void main(String args[]) {
        Connection conn = null;
        PreparedStatement prsment = null;
        ResultSet res = null;

        try {
            String usname = "rtd";
            String usPassword = "rtd1111";
            String host = "jdbc:postgresql://10.191.2.2:30108/rtd-cart";
            String drayver = "org.postgresql.Driver";
            Class.forName(drayver);
            conn = DriverManager.getConnection(host, usname, usPassword);
            prsment = conn.prepareStatement("SELECT 'number' FROM public.\"T_ORDER\" x\n" +
                    "WHERE client_session_uid = 'ce27ea1c-fec3-432b-8c03-c5a3947f2b2d'");
            res  = prsment.executeQuery();
            while (res.next()){
                System.out.print(res.getString(2) + "  ");
                System.out.print(res.getString(3) + "  ");
                System.out.print(res.getString(4) + "  ");
                System.out.print(res.getString(5) + "  ");
                System.out.print(res.getString(6) + "  ");
                System.out.print(res.getInt(7));

            }
        } catch (Exception n) {
            System.out.println("Другая ошибка, проверьте свой код");
        } finally{ try{
            if (res!=null){
                res.close();
            }
            if (prsment!=null){
                prsment.close();
            }
            if (conn!=null){
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Razyedinenie ne udalos, ili Oshibka pri SQL zaprosa");
        }
        }
    }

}
