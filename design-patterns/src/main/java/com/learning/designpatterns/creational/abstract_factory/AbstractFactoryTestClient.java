package com.learning.designpatterns.creational.abstract_factory;

import java.util.List;

public class AbstractFactoryTestClient {
    public static void main(String[] args) {
    ContentFactory factory = chooseFactory(); // Get the desired factory (e.g., ReportFactory)

    Document document = factory.createDocument("REPORT"); // Create a report
    document.setTitle("Sales Report");
    document.setContent("Monthly sales data...");
    document.save();

    Chart chart = factory.createChart("BAR"); // Create a bar chart
    chart.setData(List.of(10.0, 15.0, 20.0)); // Assuming data population logic
    chart.generateImage();
  }

  private static ContentFactory chooseFactory() {
    // Logic to determine and return the appropriate concrete factory (e.g., based on user selection)
    return new InvoiceFactory();
  }
}
