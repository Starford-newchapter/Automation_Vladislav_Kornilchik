package Home_Work_19_MySql;

import org.testng.Assert;
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

    @Test(priority = 1,enabled = true)
    public void insert_test_1() throws Exception {
     Assert.assertEquals(insert("INSERT INTO VladCars (Id, Model, Color, Price, Count)\n" +
                "VALUES (1, 'Opel', 'Brown', '2000', '700');"),1);
     Assert.assertEquals((select("SELECT * FROM testqa11.VladCars;").size()),5);
     Assert.assertEquals((select("SELECT * FROM testqa11.VladCars;").get(0).get(1)),"Opel");
    }

    @Test(priority = 2,enabled = true)
    public void insert_test_2() throws Exception {
        Assert.assertEquals(insert("INSERT INTO VladCars (Id, Model, Color, Price, Count)\n" +
                "VALUES (6, 'Matiz', 'Black', '600', '900');"),1);
       Assert.assertEquals(select("SELECT * FROM testqa11.VladCars;").size(),6);
       Assert.assertEquals(select("SELECT * FROM testqa11.VladCars;").get(5).get(1),"Matiz");
    }

    @Test(priority = 3,enabled = true)
    public void  select_test_1() throws Exception {
        Assert.assertEquals(select("SELECT Model FROM testqa11.VladCars WHERE Count<500;").size(),2);
    }

    @Test(priority = 4,enabled = true)
    public void  select_test_2() throws Exception {
        Assert.assertEquals(select("SELECT Model FROM testqa11.VladCars WHERE Price<=1000;").size(),3);
    }

    @Test(priority = 5,enabled = true)
    public void  update_test_1() throws Exception {
        Assert.assertEquals(update("UPDATE testqa11.VladCars SET Count=40 WHERE Color='White';"),2);
    }

    @Test(priority = 6,enabled = true)
    public void  update_test_2() throws Exception {
       Assert.assertEquals(update("UPDATE testqa11.VladCars SET Price=8000 WHERE Count<50;"),2);
    }

    @Test(priority = 7,enabled = true)
    public void  delete_test_1() throws Exception {
        Assert.assertEquals(delete("DELETE FROM  testqa11.VladCars WHERE Id=1;"),1);
        Assert.assertEquals(select("SELECT * FROM testqa11.VladCars;").size(),5);
    }

    @Test(priority = 8,enabled = true)
    public void  delete_test_2() throws Exception {
        Assert.assertEquals(delete("DELETE FROM  testqa11.VladCars WHERE Id=6;"),1);
        Assert.assertEquals(select("SELECT * FROM testqa11.VladCars;").size(),4);
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
