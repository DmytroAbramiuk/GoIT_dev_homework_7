package org.example.http;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        int statusCode;
        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Enter HTTP status code: ");
            statusCode = sc.nextInt();
            try {
                new HttpStatusImageDownloader().downloadStatusImage(statusCode);
            } catch (Exception e) {
                System.out.println("There is not image for HTTP status " + statusCode);
            }
        } catch (Exception e) {
            System.out.println("Please enter valid number");
        }
    }
}
