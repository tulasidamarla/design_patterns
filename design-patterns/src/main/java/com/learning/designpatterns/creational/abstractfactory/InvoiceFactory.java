package com.learning.designpatterns.creational.abstractfactory;

public class InvoiceFactory implements ContentFactory{
    @Override
  public Document createDocument(String type) {
    if (type.equals("INVOICE")) {
      return new InvoiceDocument();
    } else {
      throw new IllegalArgumentException("Invalid document type");
    }
  }

  @Override
  public Chart createChart(String type) {
    if (type.equals("PIE")) {  // Assuming invoices use pie charts
      return new PieChart();
    } else {
      throw new IllegalArgumentException("Invalid chart type");
    }
  }
}
