package aiss.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.crimeometer.CrimeStatsLLSearch;
import aiss.model.crimeometer.ReportType;
import aiss.model.resources.CrimeometerResource;

public class CrimeStatsController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(CrimeStatsController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrimeStatsController() {
		super();
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String crimeType = request.getParameter("tipoCrimen");
		Double lat = Double.valueOf(request.getParameter("lat"));
		Double lon = Double.valueOf(request.getParameter("lon"));
		Map<String,Integer> res = new HashMap<String,Integer>();
		res.put("trimestre1", 0);
		res.put("trimestre2", 0);
		res.put("trimestre3", 0);
		res.put("trimestre4", 0);
		
		//load crimeometer
		CrimeometerResource coResource = new CrimeometerResource();
		CrimeStatsLLSearch trimestre1 = coResource.getCrimeStatsLL(lat, lon, "2019-01-01T15:53:00.000Z","2019-04-01T15:53:00.000Z");
		CrimeStatsLLSearch trimestre2 = coResource.getCrimeStatsLL(lat, lon, "2019-04-01T15:53:00.000Z","2019-07-01T15:53:00.000Z");
		CrimeStatsLLSearch trimestre3 = coResource.getCrimeStatsLL(lat, lon, "2019-07-01T15:53:00.000Z","2019-10-01T15:53:00.000Z");
		CrimeStatsLLSearch trimestre4 = coResource.getCrimeStatsLL(lat, lon, "2019-10-01T15:53:00.000Z","2020-01-01T15:53:00.000Z");
		
		//filtro
		for(ReportType r: trimestre1.getReportTypes()) {
			if(r.getType().equals(crimeType))
				res.put("trimestre1", r.getCount());
		}
		for(ReportType r: trimestre2.getReportTypes()) {
			if(r.getType().equals(crimeType))
				res.put("trimestre2", r.getCount());
		}
		for(ReportType r: trimestre3.getReportTypes()) {
			if(r.getType().equals(crimeType))
				res.put("trimestre3", r.getCount());
		}
		for(ReportType r: trimestre4.getReportTypes()) {
			if(r.getType().equals(crimeType))
				res.put("trimestre4", r.getCount());
		}
		request.setAttribute("parameterStats", res);
		request.getRequestDispatcher("/parameterStatsView.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
