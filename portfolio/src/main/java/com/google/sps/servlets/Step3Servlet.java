package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/step-3")
public class Step3Servlet extends HttpServlet {
    // Makes an arraylist of strings called quotes
    private ArrayList<String> quotes = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create a random class and a random number
        Random rand = new Random();
        int number = rand.nextInt(3);
        
        // Add the strings of quotes
        quotes.add("This is sparta!");
        quotes.add("Run Boy Run!");
        quotes.add("Life is a box of chocolates!");

        // Choose a random string
        String quote = quotes.get(number);

        // Convert into json form
        String json = convertToJson(quote);

        // Response must be set to the json type
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    // Convert the string to json form
    private String convertToJson(String quote) {
        String json = "{";
        json += "\"Quote\": ";
        json += "\"" + quote + "\"";
        json += "}";
        return json;
      }
}
