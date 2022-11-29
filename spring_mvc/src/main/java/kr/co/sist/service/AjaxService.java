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
		
		String[] temp= {"국산", "수입"};
		
		JSONArray js=new JSONArray();
		for(String val:temp) {
			jsonTemp=new JSONObject();
			jsonTemp.put("country", val);
			
			js.add(jsonTemp);
		}//end for
		
		//데이터를 가진 JSONArray를 JSONObject에 할당
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
				//DB조회 결과를 JSONObject에 할당
				jsonTemp.put("maker", md.getMaker());
				//값을 가진 JSONObject을 JSONArray 할당
				jsonArr.add(jsonTemp);
			}//end for
			
			//모든 조회결과를 가진 JSONArray를 JSONObject를 할당
			jsonObj.put("makerData", jsonArr);
			
		} catch (SQLException e) {
			resultFalg=true;
			e.printStackTrace();
		}//end catch
		jsonObj.put("resultFlag", !resultFalg);
		jsonObj.put("searchKeyword", country);
		//{"searchKeyword":"국산","resultFlag",true, "MakerData",:[{"maker", "현대"},{"maker","기아"},,,}}
		
		return jsonObj.toJSONString();
	}//searchMaker
	
	//maker를 입력받아 model을 조회
	public String searchModel(String maker) {
		JSONObject jsonObj=new JSONObject();
		
		boolean searchFlag=false;
		
		AJAXDao aDAO=new AJAXDao();
		
		try {
			List<ModelDomain> listModel=aDAO.selectModel(maker);
			searchFlag=true;
			
			JSONArray jsonArr=new JSONArray();
			JSONObject jsonTemp=null;
			
			for(ModelDomain md: listModel) {//검색결과를 사용하여 JSONObject 생성
				jsonTemp=new JSONObject();
				jsonTemp.put("model", md.getModel());
				
				//값을 가진 JSONObject을 JSONArray에 할당
				jsonArr.add(jsonTemp);
			}
			//데이터를 가진 JSONArray를 JSONObject 할당
			jsonObj.put("data", jsonArr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		jsonObj.put("resultFlag", searchFlag);
		jsonObj.put("keyword", maker);
		
		//{"resultFalg": true, data:[{"model":"아반테"},{"model":"아반테"},]
		// , "keyword":"현대"}
		return jsonObj.toJSONString();
	}//searchModel
	
	
}
