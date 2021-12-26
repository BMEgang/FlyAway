package com.database;

import com.mysql.cj.jdbc.Driver;
import org.StringUtil;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dao {
    public Connection con = null;
    public Statement st = null;

    public Dao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Hu123456");
        System.out.println("connection established with database");
        st = con.createStatement();
    }

    public List<String[]> getAvailableFlights(String f,String t, String d)
    {
        List<String[]> flights= new ArrayList<>();
        String query = "SELECT * FROM flyaway.flights where Fromfly='" + f + "' and Tofly='" + t + "' and Departurefly='" + d + "'";

//        System.out.println(f);
//        System.out.println(t);
//        System.out.println(d);
//        System.out.println(query);
        try {
            ResultSet rs = st.executeQuery(query);

            if (rs.next()){
                String[] flight = new String[3];
                flight[0] = rs.getString("Namefly");
                flight[1] = rs.getString("Timefly");
                flight[2] = rs.getString("Pricefly");
//                System.out.println(flight[0]);
//                System.out.println(flight[1]);
//                System.out.println(flight[2]);
                flights.add(flight);
                return flights;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, String> checkUser(String email, String password)
    {
        HashMap<String, String> user = null;
        String query = "SELECT * FROM flyaway.user where email='" + email + "' and password='" + password + "'";

        try {
            ResultSet rs = st.executeQuery(query);
            if (rs.next())
            {
                user = new HashMap<>();
                user.put("name", rs.getString("name"));
                user.put("email", rs.getString("email"));
                user.put("phone", rs.getString("phone"));
                user.put("adress", rs.getString("adress"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    //cannot work
    public boolean insertUser(HashMap<String, String> user)
    {
        String query = "INSERT INTO flyaway.user (email, password, name, phone, adress) values ('" + user.get("email") + "','" + user.get("password") + "','"+ user.get("name") + "','"+ user.get("phone") + "','"+ user.get("adress") + "')";
        System.out.println(user.get("email"));
        System.out.println(user.get("password"));
        System.out.println(user.get("name"));
        System.out.println(user.get("phone"));
        System.out.println(user.get("adress"));
        System.out.println(query);
        try {
            st.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean checkAdmin(String email, String password)
    {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM flyaway.admin where email='" + email + "' and password='" + password +"'");
            if (rs.next())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean changeAdminPassword(String email, String password)
    {
        String query = "SELECT * FROM flyaway.admin where email='" + email + "'";

        try {
            ResultSet rs = st.executeQuery(query);
            if (!rs.next()){
                return false;
            }
            st.execute("update flyaway.admin set password='" + password + "' where email='"+email+"'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    //cannot work
    public boolean insertFlight(HashMap<String, String> flight) throws SQLException {

        String query1 = "INSERT INTO flyaway.flights (Namefly, Fromfly, Tofly, Departurefly, Timefly, Pricefly) VALUES" + " ('"
                + StringUtil.fixSqlFieldValue(flight.get("Name")) + "'," + " '" + StringUtil.fixSqlFieldValue(flight.get("From")) + "'," + " '"
                + StringUtil.fixSqlFieldValue(flight.get("To")) + "'," + " '" + StringUtil.fixSqlFieldValue(flight.get("Departure")) + "'," + " '"
                + StringUtil.fixSqlFieldValue(flight.get("Time")) + "'," + " '" + StringUtil.fixSqlFieldValue(flight.get("Price")) + "')";

        //String sql="INSERT INTO `flyaway`.`flights` (`name`, `fromf`, `tof`, `datef`, `timef`, `price`) VALUES ('indigo', 'hyd', 'viz', '2021-04-08', '10:00', '2000');";
        //String query1="INSERT into flyaway.flights (name,from,to,date,time,price) values('indigo','hyd','viz','24-02-2022','10:30','2000')";
        System.out.println(query1);
        try {
            //stm.execute();
            st.execute(query1);
            System.out.println("second position");
            return true;
        } catch (SQLException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return false;
    }
}
