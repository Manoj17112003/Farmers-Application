package com.java.app;

import java.sql.*;

public class ProductDAO {

    public void addProduct(Product p) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO products(farmer_name, product_name, price, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, p.farmerName);
            ps.setString(2, p.productName);
            ps.setDouble(3, p.price);
            ps.setInt(4, p.quantity);

            ps.executeUpdate();
            System.out.println("Product Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewProducts() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM products";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                System.out.println("--------------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Farmer: " + rs.getString("farmer_name"));
                System.out.println("Product: " + rs.getString("product_name"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int id, double price) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE products SET price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Product Updated Successfully!");
            else
                System.out.println("Product Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM products WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Product Deleted Successfully!");
            else
                System.out.println("Product Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
