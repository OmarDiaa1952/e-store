/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
/**
 *
 * @author omara
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    
   static final String DB_URL = "jdbc:mysql://localhost:3306/market";
   static final String USER = "root";
   static final String PASS = "1234";
   static boolean e = false;
   static Database d;
   
   private Database(){         
   }
   
   static public Database create(){
        if(!e){          
            d = new Database();
            e = true;
            return d;
       }
        return d;
   }
      
   synchronized void addUser(int id,String usrname, String pword, String Fname, String Lname, String email){
       try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
         String sqlInsert = "insert into customer values ("+id+",\""+Fname+"\",\""+Lname+"\",\""+usrname+"\",\""+email+"\","+pword+",0)";
         int countInserted = stmt.executeUpdate(sqlInsert);
       } catch (SQLException e) {
          e.printStackTrace();
       }    

   }
   
   synchronized void addAdmin(int id,String usrname, String pword, String Fname, String Lname, String email){
       try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
         String sqlInsert = "insert into admin values ("+id+",\""+Fname+"\",\""+Lname+"\",\""+usrname+"\",\""+email+"\","+pword+")";
         int countInserted = stmt.executeUpdate(sqlInsert);
       } catch (SQLException e) {
          e.printStackTrace();
       }    

   }

   
   synchronized int count_users(){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select count(*) as Ccount from customer";
                  ResultSet r = stmt.executeQuery(strSelect);
                  r.next();
                  return r.getInt("Ccount");
            } catch (SQLException e) {
               e.printStackTrace();
            }    
              return 0;
   }
   
    synchronized int count_products(){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select count(*) as Ccount from product";
                  ResultSet r = stmt.executeQuery(strSelect);
                  r.next();
                  return r.getInt("Ccount");
            } catch (SQLException e) {
               e.printStackTrace();
            }    
              return 0;
   }

    synchronized int count_categories(){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select count(*) as Ccount from category";
                  ResultSet r = stmt.executeQuery(strSelect);
                  r.next();
                  return r.getInt("Ccount");
            } catch (SQLException e) {
               e.printStackTrace();
            }    
              return 0;
   }


    synchronized String get_user_firstName(int id){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select Fname from customer where customer_id = "+id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      return r.getString("Fname");
                  }
            } catch (SQLException e) {
               e.printStackTrace();
               return "doesn't exist";
            }    
            return "doesn't exist";
    }
    
 synchronized String get_user_lastName(int id){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select Lname from customer where customer_id = "+id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      return r.getString("Lname");
                  }
            } catch (SQLException e) {
               e.printStackTrace();
               return "doesn't exist";
            }    
            return "doesn't exist";
    }   
    
 synchronized String get_user_balance(int id){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select balance from customer where customer_id = "+id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      return r.getString("balance");
                  }
            } catch (SQLException e) {
               e.printStackTrace();
               return "doesn't exist";
            }    
            return "doesn't exist";
    }
 
  synchronized String get_user_name(int id){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select userName from customer where customer_id = "+id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      return r.getString("userName");
                  }
            } catch (SQLException e) {
               e.printStackTrace();
               return "doesn't exist";
            }    
            return "doesn't exist";
    }

 
 synchronized String get_user_email(int id){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select email from customer where customer_id = "+id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      return r.getString("email");
                  }
            } catch (SQLException e) {
               e.printStackTrace();
               return "doesn't exist";
            }    
            return "doesn't exist";
    }
 
  synchronized int[] get_orderID(int customer_id){
      int a[] = {};
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                String str = "select count(order_id) as Corder from _order group by cust_id having cust_id = "+customer_id;
                ResultSet rs = stmt.executeQuery(str);
                rs.next();
                int n = rs.getInt("Corder");
                a = new int[n];
                int i =0;
                  String strSelect = "select order_id from _order where cust_id = "+customer_id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      a[i++] = r.getInt("order_id");
                  }
                  return a;
            } catch (SQLException e) {
               e.printStackTrace();
               return a;
            }    
    }

  synchronized String get_orderDate(int order_id){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select ordered_at from _order where order_id = "+order_id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      return r.getString("ordered_at");
                  }
            } catch (SQLException e) {
               e.printStackTrace();
               return "doesn't exist";
            }    
            return "doesn't exist";
    }

  synchronized int get_orderTotalAmount(int order_id){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();){
                  String strSelect = "select total_amount from _order where order_id = "+order_id;
                  ResultSet r = stmt.executeQuery(strSelect);
                  while(r.next()){
                      return r.getInt("total_amount");
                  }
            } catch (SQLException e) {
               e.printStackTrace();
               return -1;
            }    
            return -1;
    }

 
    public static void main(String[] args) {
        // TODO code application logic here
        Database db = Database.create();
        //db.addUser(1,"ahmed12", "12345", "ahmed1", "ibrahim", "ahmed@gmail.com");
        //db.addAdmin(1,"ahmed12", "12345", "ahmed1", "ibrahim", "ahmed@gmail.com");
        //System.out.println(db.count_products());
        //System.out.println(db.count_categories());
//        int a[] = db.get_orderID(1);
//        for(int i =0 ; i< a.length; i++){
//            System.out.println(a[i]);
//            System.out.println(db.get_orderDate(a[i]));
//            System.out.println(db.get_orderTotalAmount(a[i]));
//            
//        }
       
    }
    
}
