package com.travelcard.core;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;
import com.travelcard.datagenerator.util.RandomStations;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;

public class StationList {
	
	
	private static JFreeChart createChart(PieDataset dataset) {

		JFreeChart chart = ChartFactory.createPieChart(Constants.REPORT_STATION_STATISTICS, 
				dataset,
				false,
				true,
				false
		);

		chart.setBackgroundPaint(
				new GradientPaint(new Point(0, 0), new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

		TextTitle t = chart.getTitle();
		t.setHorizontalAlignment(HorizontalAlignment.LEFT);
		t.setPaint(new Color(240, 240, 240));
		t.setFont(new Font("Arial", Font.BOLD, 26));

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setBackgroundPaint(null);
		plot.setInteriorGap(0.04);
		plot.setOutlineVisible(false);

		plot.setSectionPaint("Others", createGradientPaint(new Color(200, 200, 255), Color.BLUE));
		plot.setSectionPaint("Samsung", createGradientPaint(new Color(255, 200, 200), Color.RED));
		plot.setSectionPaint("Apple", createGradientPaint(new Color(200, 255, 200), Color.GREEN));
		plot.setSectionPaint("Nokia", createGradientPaint(new Color(200, 255, 200), Color.YELLOW));
		// plot.setDefaultSectionOutlinePaint(Color.WHITE);
		plot.setSectionOutlinesVisible(true);
		// plot.setDefaultSectionOutlineStroke(new BasicStroke(2.0f));

		// customise the section label appearance
		plot.setLabelFont(new Font("Courier New", Font.BOLD, 20));
		plot.setLabelLinkPaint(Color.WHITE);
		plot.setLabelLinkStroke(new BasicStroke(2.0f));
		plot.setLabelOutlineStroke(null);
		plot.setLabelPaint(Color.WHITE);
		plot.setLabelBackgroundPaint(null);

		TextTitle source = new TextTitle("Source: http://www.bbc.co.uk/news/business-15489523",
				new Font("Courier New", Font.PLAIN, 12));
		source.setPaint(Color.WHITE);
		source.setPosition(RectangleEdge.BOTTOM);
		source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(source);
		return chart;

	}

	
	private static RadialGradientPaint createGradientPaint(Color c1, Color c2) {
		Point2D center = new Point2D.Float(0, 0);
		float radius = 200;
		float[] dist = { 0.0f, 1.0f };
		return new RadialGradientPaint(center, radius, dist, new Color[] { c1, c2 });
	}
	
	
	
	

	private List<Station> availableStations;

	
	public StationList() {
		availableStations = new ArrayList<Station>();
		RandomStations gen = new RandomStations();
		availableStations = gen.generate(10);
	}
	
	
	
	

	public void generateStationStatisticsReport() {
		PDFDocument pdfDoc = new PDFDocument();
		pdfDoc.setTitle("Station Statistics Report");
		pdfDoc.setAuthor("Travel Card System");
		Page page = pdfDoc.createPage(new Rectangle(612, 468));
		PDFGraphics2D g2 = page.getGraphics2D();
		JFreeChart chart = createChart(createDatasetStationStatistics());
		chart.setPadding(new RectangleInsets(4, 8, 2, 2));
		ChartPanel panel = new ChartPanel(chart, false);
		panel.setMouseWheelEnabled(true);
		panel.setPreferredSize(new Dimension(600, 300));
		chart.draw(g2, new Rectangle(0, 0, 612, 468));
		pdfDoc.writeToFile(new File(Constants.REPORT_STATION_STATISTICS));

	}

	
	
	
	
	public List<Station> getUserIDs() {
		return availableStations;
	}

	
	
	
	
	public boolean reportExists(String reportName) {
		File tmpDir = new File(reportName);
		return tmpDir.exists();
	}

	
	
	
	
	public void setStationIDs(List<Station> stations) {
		this.availableStations = stations;
	}

	
	
	
	
	private PieDataset createDatasetStationStatistics() {
		int sumCheckIn = 0;
		int sumCheckOut = 0;
		for (Station s : availableStations) {
			sumCheckIn += s.getCountCIn();
			sumCheckOut += s.getCountCOut();
		}
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("checkIn", sumCheckIn);
		dataset.setValue("checkOut", sumCheckOut);

		return dataset;
	}
}
