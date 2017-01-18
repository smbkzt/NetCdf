package com.eazydev;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import ucar.ma2.Array;

import java.awt.*;

public class JFreeChartClass extends ApplicationFrame {

    public JFreeChartClass(String applicationTitle, String chartTitle, Array array) {
        super(applicationTitle);
        org.jfree.chart.JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "Time",
                "Value",
                createDataset(array),
                PlotOrientation.VERTICAL,
                true, true, false
        );
        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        final XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    private XYDataset createDataset(Array array) {
        final XYSeries dataFromFile = new XYSeries("Precipitation");
        for (int i=0; i<array.getSize(); i++){
            dataFromFile.add(i, array.getDouble(i));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(dataFromFile);
        return dataset;
    }
}