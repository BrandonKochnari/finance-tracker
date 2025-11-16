package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import interface_adapter.graph.GraphController;
import interface_adapter.graph.GraphState;
import interface_adapter.graph.GraphViewModel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;
import java.util.List;

public class GraphPanel extends JPanel implements ActionListener, PropertyChangeListener {
    private ChartPanel leftGraphContainer;
    private JPanel rightGraphContainer;

    private GraphViewModel gvm;
    private GraphController gc = null;

    private DefaultPieDataset<String> pieDataset;
    private DefaultCategoryDataset barDataset;

    public GraphPanel(GraphViewModel gvm) {
        // Main panel layout: split into two halves
        setLayout(new GridLayout(1, 2));
        this.gvm = gvm;

        JFreeChart barChart = createBarChart();
        XYPlot plot = barChart.getXYPlot();
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        leftGraphContainer = new ChartPanel(barChart);
        add(leftGraphContainer);

        // range selector buttons
        JPanel rangeSelectorContainer = new JPanel();
        rangeSelectorContainer.setLayout(new BoxLayout(rangeSelectorContainer, BoxLayout.X_AXIS));
        JButton dayButton = new JButton("Day");
        JButton monthButton = new JButton("Month");
        JButton yearButton = new JButton("Year");
        rangeSelectorContainer.add(dayButton);
        rangeSelectorContainer.add(monthButton);
        rangeSelectorContainer.add(yearButton);
        leftGraphContainer.add(rangeSelectorContainer);

        /* add listeners for range buttons */
        JButton[] rangeButtons = { dayButton, monthButton, yearButton };

        for (JButton button : rangeButtons) {
            final JButton b = button;
            button.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(b)) {
                                final GraphState currentState = gvm.getState();
                                gc.execute(
                                        b.getText(),
                                        currentState.getSelectedType());
                            }
                        }
                    });
        }

        /* pie graph container */
        JFreeChart pieChart = createPieChart();
        rightGraphContainer = new ChartPanel(pieChart);
        add(rightGraphContainer);

        // type selector buttons
        JPanel typeSelectorContainer = new JPanel();
        typeSelectorContainer.setLayout(new BoxLayout(typeSelectorContainer, BoxLayout.X_AXIS));
        JButton incomeButton = new JButton("Income");
        JButton expenseButton = new JButton("Expense");
        typeSelectorContainer.add(incomeButton);
        typeSelectorContainer.add(expenseButton);
        rightGraphContainer.add(typeSelectorContainer);
        /* add listeners for type buttons */
        JButton[] typeButtons = { incomeButton, expenseButton };

        for (JButton button : typeButtons) {
            final JButton b = button;
            button.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(b)) {
                                final GraphState currentState = gvm.getState();
                                gc.execute(
                                        currentState.getSelectedRange(),
                                        b.getName());
                            }
                        }
                    });
        }
    }

    private JFreeChart createPieChart() {

        pieDataset = new DefaultPieDataset<>();

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Breakdown",
                pieDataset,
                true,
                true,
                false);

        return pieChart;
    }

    private JFreeChart createBarChart() {
        barDataset = new DefaultCategoryDataset();
        JFreeChart barChart = ChartFactory.createBarChart(
                "",
                "",
                "Amount",
                barDataset);

        return barChart;
    }

    public void setGraphController(GraphController gc) {
        this.gc = gc;
    }

    /**
     * react to a bottom click
     * 
     * @param evt event
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("clicked " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GraphState state = (GraphState) evt.getNewValue();
        updateGraph(state);
    }

    private void updateGraph(GraphState state) {
        // clear previous values
        barDataset.clear();
        pieDataset.clear();

        // update bar dataset (use bar map)
        Map<Integer, Float> bar = state.getBar();
        if (bar != null) {
            for (Map.Entry<Integer, Float> entry : bar.entrySet()) {
                Integer colKey = entry.getKey();
                Float val = entry.getValue();
                if (colKey != null && val != null) {
                    barDataset.addValue(val, state.getSelectedType(), colKey);
                }
            }
        }

        // update pie dataset
        Map<String, Double> data = state.getPie();
        // add each category to pie chart
        if (data != null) {
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    pieDataset.setValue(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
