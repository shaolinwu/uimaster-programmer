package org.shaolin.vogerp.commonmodel.dao;

import org.junit.Test;
import org.shaolin.uimaster.page.ajax.json.JSONArray;
import org.shaolin.uimaster.page.ajax.json.JSONObject;

public class CommonModelTest {


    @Test
    public void testsearchCEExtension() {
    	System.out.println("a: " + ((int)(Math.random()*5)));
    	if ("".equals(null)) {
    		System.out.println("a: " + ((int)(Math.random()*5)));
    	}
    }

    @Test
    public void testauthenticateUserInfo() throws Exception {
    	JSONObject item = new JSONObject();
    	item.put("name", " ��ҳ");
    	item.put("_chunkname", "org.shaolin.vogerp.commonmodel.diagram.ModularityModel");
    	item.put("_nodename", "OnlineOrderList");
    	item.put("_page", "org.shaolin.vogerp.ecommercial.page.OnlineOrderList");
    	item.put("_framename", "onlineOrderList");
    	
    	JSONObject item1 = new JSONObject();
    	item1.put("name", "����");
    	item1.put("_chunkname", "org.shaolin.vogerp.commonmodel.diagram.ModularityModel");
    	item1.put("_nodename", "OrderManagement");
    	item1.put("_page", "org.shaolin.vogerp.ecommercial.page.OrderManagement");
    	item1.put("_framename", "goldenOrderManager");
    	
    	JSONObject item2 = new JSONObject();
    	item2.put("name", "��Ʒ");
    	item2.put("_chunkname", "org.shaolin.vogerp.commonmodel.diagram.ModularityModel");
    	item2.put("_nodename", "ProductManagement");
    	item2.put("_page", "org.shaolin.vogerp.productmodel.page.ProductManagement");
    	item2.put("_framename", "productManager");
    	item2.put("_framePrefix", "");
    	
    	JSONArray array = new JSONArray();
    	array.put(item);
    	array.put(item1);
    	array.put(item2);
    	String result = array.toString();
    	System.out.println(result);
    }

    @Test
    public void testsearchUserAccount() {
    }

    @Test
    public void testsearchPersonInfo() {
    }

    @Test
    public void testsearchPartyRelationshipInfo() {
    }

    @Test
    public void testsearchRootOrganizationInfo() {
    }

    @Test
    public void testsearchSubOrganizationInfo() {
    }

    @Test
    public void testsearchOrganization() {
    }

    @Test
    public void testsearchModelPermission() {
    }

    @Test
    public void testsearchUIWidgetPermission() {
    }

    @Test
    public void testsearchBEPermission() {
    }

    @Test
    public void testsearchContract() {
    }

}

