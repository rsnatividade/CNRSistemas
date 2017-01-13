package br.com.cnrsistemas.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;

@ManagedBean
@ViewScoped
public class IndexDashboard {

	private MeterGaugeChartModel gaugeModel;
	private LineChartModel lineModel;
	
	@PostConstruct
	public void init(){
		gaugeModel = initGaugeModel();
		gaugeModel.setTitle("Clientes ativos");
		gaugeModel.setGaugeLabel("Clientes");
		
        lineModel = initLineModel();
        lineModel.setTitle("Faturamento");
        lineModel.setLegendPosition("e");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(600);
        yAxis.setMax(2000);
	}
	
	private MeterGaugeChartModel initGaugeModel(){
		List<Number> valores = new ArrayList<Number>();
		valores.add(10);
		valores.add(20);
		valores.add(30);
		valores.add(40);
		
		return new MeterGaugeChartModel(25, valores);
	}

	private LineChartModel initLineModel(){
        LineChartModel model = new LineChartModel();
        
        LineChartSeries faturamento = new LineChartSeries();
        faturamento.setLabel("R$");
 
        faturamento.set(1, 1000);
        faturamento.set(2, 870);
        faturamento.set(3, 1340);
        faturamento.set(4, 1720);
        faturamento.set(5, 980);
        faturamento.set(6, 1830);
		
        model.addSeries(faturamento);
		return model;
	}
	
	public MeterGaugeChartModel getGaugeModel() {
		return gaugeModel;
	}

	public void setGaugeModel(MeterGaugeChartModel gaugeModel) {
		this.gaugeModel = gaugeModel;
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}
	
}
