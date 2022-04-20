package Home_Work_19_MySql;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Lecture_19 {
    Connection connect;
    Statement statement;

    @BeforeTest
    public void preconditions() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa11?user=testqa11&password=testqa11");
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest(alwaysRun = true)
    public void postconditions() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void insert_test_1() throws Exception {
        System.out.println(insert("INSERT INTO VladCars (Id, Model, Color, Price, Count)\n" +
                "VALUES (5, 'Opel', 'Brown', '2000', '700');"));
        System.out.println(select("SELECT * FROM testqa11.VladCars;"));
    }

    @Test(priority = 2)
    public void insert_test_2() throws Exception {
        System.out.println(insert("INSERT INTO VladCars (Id, Model, Color, Price, Count)\n" +
                "VALUES (6, 'Volvo', 'White', '7000', '900');"));
        System.out.println(select("SELECT * FROM testqa11.VladCars;"));
    }

    @Test(priority = 3)
    public void  select_test_1() throws Exception {
        System.out.println(select("SELECT Model FROM testqa11.VladCars WHERE Count<100;"));
    }

    @Test(priority = 4)
    public void  select_test_2() throws Exception {
        System.out.println(select("SELECT Model FROM testqa11.VladCars WHERE Price<=5000;"));
    }

    @Test(priority = 5)
    public void  update_test_1() throws Exception {
        System.out.println(update("UPDATE testqa11.VladCars SET Count=30 WHERE Color='White';"));
        System.out.println(select("SELECT * FROM testqa11.VladCars;"));
    }

    @Test(priority = 6)
    public void  update_test_2() throws Exception {
        System.out.println(update("UPDATE testqa11.VladCars SET Price=8000 WHERE Count<100;"));
        System.out.println(select("SELECT * FROM testqa11.VladCars;"));
    }

    @Test(priority = 7)
    public void  delete_test_1() throws Exception {
        System.out.println(delete("DELETE FROM  testqa11.VladCars WHERE Model='BMW';"));
        System.out.println(select("SELECT * FROM testqa11.VladCars;"));
    }

    @Test(priority = 8)
    public void  delete_test_2() throws Exception {
        System.out.println(delete("DELETE FROM  testqa11.VladCars WHERE Count<30;"));
        System.out.println(select("SELECT * FROM testqa11.VladCars;"));
    }




    public List<List<String>> select(String query) throws Exception {
        ResultSet resultSet = statement.executeQuery(query);
        List<List<String>> data = new ArrayList<>();
        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (int index = 1; index <= resultSet.getMetaData().getColumnCount(); index++) {
                row.add(resultSet.getString(index));
            }
            data.add(row);
        }
        return data;
    }

    public int update(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insert(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
