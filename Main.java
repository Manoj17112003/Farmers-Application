package com.java.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while(true) {

            System.out.println("\n===== Farmer Marketplace =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product Price");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter Farmer Name: ");
                    String farmer = sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String product = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    if(price <= 0 || quantity <= 0) {
                        System.out.println("Invalid Price or Quantity!");
                        break;
                    }

                    Product p = new Product(farmer, product, price, quantity);
                    dao.addProduct(p);
                    break;

                case 2:
                    dao.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    dao.updateProduct(id, newPrice);
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

