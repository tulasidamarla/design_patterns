package com.learning.designpatterns.creational.abstractfactory;

public class ReportFactory implements ContentFactory{
    @Override
  public Document createDocument(String type) {
    if (type.equals("REPORT")) {
      return new ReportDocument();
    } else {
      throw new IllegalArgumentException("Invalid document type");
    }
  }

  @Override
  public Chart createChart(String type) {
    if (type.equals("BAR")) {
      return new BarChart();
    } else {
      throw new IllegalArgumentException("Invalid chart type");
    }
  }
}
