package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.AnalysisDAO;
import com.internousdev.ecsite.dto.AnalysisDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AnalysisAction extends ActionSupport{

	private AnalysisDAO analysisDAO = new AnalysisDAO();
	private ArrayList<AnalysisDTO> analysisDTO = new ArrayList<AnalysisDTO>();
	private ArrayList<String> graphdata = new ArrayList<String>();

	public String execute() throws SQLException{
		analysisDTO  = analysisDAO.itamTotalCountInfo();

		for(int i=0;i<analysisDTO.size();i++){

		}

		return SUCCESS;
	}

	public ArrayList<AnalysisDTO> getAnalysisDTO() {
		return analysisDTO;
	}

	public void setAnalysisDTO(ArrayList<AnalysisDTO> analysisDTO) {
		this.analysisDTO = analysisDTO;
	}

}
