package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.ui.Model;

import kr.co.sist.dao.AJAXDao;
import kr.co.sist.domain.MakerDomain;
import kr.co.sist.domain.ModelDomain;

public class AjaxService {

	public String country() {
		JSONObject jsonCountry=new JSONObject();
		jsonCountry.put("result", true);
		JSONObject jsonTemp=null;
		
		String[] temp= {"����", "����"};
		
		JSONArray js=new JSONArray();
		for(String val:temp) {
			jsonTemp=new JSONObject();
			jsonTemp.put("country", val);
			
			js.add(jsonTemp);
		}//end for
		
		//�����͸� ���� JSONArray�� JSONObject�� �Ҵ�
		jsonCountry.put("countryData", js);
		
		return jsonCountry.toJSONString();
	}//country
	
	public String searchMaker(String country) {
		JSONObject jsonObj=new JSONObject();
		
		boolean resultFalg=false;
		
		AJAXDao aDAO=new AJAXDao();
		
		try {
			List<MakerDomain> list=aDAO.selectMaker(country);
			JSONObject jsonTemp=null;
			JSONArray jsonArr=new JSONArray();
			
			for(MakerDomain md: list) {
				jsonTemp=new JSONObject();
				//DB��ȸ ����� JSONObject�� �Ҵ�
				jsonTemp.put("maker", md.getMaker());
				//���� ���� JSONObject�� JSONArray �Ҵ�
				jsonArr.add(jsonTemp);
			}//end for
			
			//��� ��ȸ����� ���� JSONArray�� JSONObject�� �Ҵ�
			jsonObj.put("makerData", jsonArr);
			
		} catch (SQLException e) {
			resultFalg=true;
			e.printStackTrace();
		}//end catch
		jsonObj.put("resultFlag", !resultFalg);
		jsonObj.put("searchKeyword", country);
		//{"searchKeyword":"����","resultFlag",true, "MakerData",:[{"maker", "����"},{"maker","���"},,,}}
		
		return jsonObj.toJSONString();
	}//searchMaker
	
	//maker�� �Է¹޾� model�� ��ȸ
	public String searchModel(String maker) {
		JSONObject jsonObj=new JSONObject();
		
		boolean searchFlag=false;
		
		AJAXDao aDAO=new AJAXDao();
		
		try {
			List<ModelDomain> listModel=aDAO.selectModel(maker);
			searchFlag=true;
			
			JSONArray jsonArr=new JSONArray();
			JSONObject jsonTemp=null;
			
			for(ModelDomain md: listModel) {//�˻������ ����Ͽ� JSONObject ����
				jsonTemp=new JSONObject();
				jsonTemp.put("model", md.getModel());
				
				//���� ���� JSONObject�� JSONArray�� �Ҵ�
				jsonArr.add(jsonTemp);
			}
			//�����͸� ���� JSONArray�� JSONObject �Ҵ�
			jsonObj.put("data", jsonArr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		jsonObj.put("resultFlag", searchFlag);
		jsonObj.put("keyword", maker);
		
		//{"resultFalg": true, data:[{"model":"�ƹ���"},{"model":"�ƹ���"},]
		// , "keyword":"����"}
		return jsonObj.toJSONString();
	}//searchModel
	
	
}
