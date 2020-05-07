import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class Metody {
    public static void wyswietl(Connection conn) throws SQLException, ClassNotFoundException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databases=CONNECTIS;integratedSecurity=true;";

//        Connection conn = null;
//
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection(url);
//            System.out.println(conn);
//
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(conn);


        Statement statement = conn.createStatement();
        String sqlQuery = "Select * from Employees";
        ResultSet rs = statement.executeQuery(sqlQuery);
        while (rs.next()) {
            System.out.println(rs.getDate("StartJobDate") + " ,Imie: " + rs.getString("LastName") + " ,Nazwisko: " + rs.getString("FirstName") + " ,Addres: " + rs.getString("Address") + " " + rs.getString("City") + " ,Pensja: " + rs.getInt("Salary") + " ,Wiek: " + rs.getInt("Age"));

        }
    }

    public static void dodaj(Connection conn) throws SQLException {
        String imie;
        String nazwisko;
        String ulica;
        String miasto;
        int pensja;
        int wiek;
        String data;
        int Benefit;
        String insert = "Insert INTO Employees (LastName, FirstName, Address, City, Salary, Age, StartJobDate, Benefit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj imie");
        imie = scanner.next();
        System.out.println("podaj nazwisko");
        nazwisko = scanner.next();
        System.out.println("podaj ulice");
        ulica = scanner.next();
        System.out.println("podaj miasto");
        miasto = scanner.next();
        System.out.println("podaj zarobki");
        pensja = scanner.nextInt();
        System.out.println("podaj wiek");
        wiek = scanner.nextInt();
        System.out.println("podaj date przyjecia");
        data = scanner.next();
        System.out.println("podaj benefit (0,1)");
        Benefit = scanner.nextInt();

        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setString(1, imie);
        ps.setString(2, nazwisko);
        ps.setString(3, ulica);
        ps.setString(4, miasto);
        ps.setInt(5, pensja);
        ps.setInt(6, wiek);
        ps.setDate(7, Date.valueOf(data));
        ps.setInt(8, Benefit);

        int rowInsert = ps.executeUpdate();
        if (rowInsert > 0) {
            System.out.println("Success!");

        }
    }

    public static void aktualizuj(Connection conn) throws SQLException {
        int ID;
        String imie;
        String nazwisko;
        String ulica;
        String miasto;
        int pensja;
        int wiek;
        String data;
        int Benefit;
        String update = "UPDATE Employees SET LastName=?, FirstName=?, Address=?, City=?, Salary=?, Age=?, StartJobDate=?, Benefit=? WHERE ID=?";
        System.out.println("Podaj ID uzytownika ktorego chcesz zmienic");
        Scanner scanner = new Scanner(System.in);
        ID = scanner.nextInt();
        System.out.println("podaj imie");
        imie = scanner.next();
        System.out.println("podaj nazwisko");
        nazwisko = scanner.next();
        System.out.println("podaj ulice");
        ulica = scanner.next();
        System.out.println("podaj miasto");
        miasto = scanner.next();
        System.out.println("podaj zarobki");
        pensja = scanner.nextInt();
        System.out.println("podaj wiek");
        wiek = scanner.nextInt();
        System.out.println("podaj date przyjecia");
        data = scanner.next();
        System.out.println("podaj benefit (0,1)");
        Benefit = scanner.nextInt();

        PreparedStatement ps = conn.prepareStatement(update);
        ps.setString(1, imie);
        ps.setString(2, nazwisko);
        ps.setString(3, ulica);
        ps.setString(4, miasto);
        ps.setInt(5, pensja);
        ps.setInt(6, wiek);
        ps.setDate(7, Date.valueOf(data));
        ps.setInt(8, Benefit);
        ps.setInt(9,ID);

        int rowInsert = ps.executeUpdate();
        if (rowInsert > 0) {
            System.out.println("Success!");

        }
    }
        public static void usun(Connection conn) throws SQLException {
        int ID;
            String delete = "DELETE FROM Employees WHERE ID=?";
            System.out.println("Podaj id użytkownika ktorego chcesz usunac");
            Scanner scanner = new Scanner(System.in);
            ID = scanner.nextInt();
            PreparedStatement ps2 = conn.prepareStatement(delete);
            ps2.setInt(1, ID);

            int rowInsert = ps2.executeUpdate();
            if(rowInsert > 0) {
                System.out.println("Success!");
            }
        }

}