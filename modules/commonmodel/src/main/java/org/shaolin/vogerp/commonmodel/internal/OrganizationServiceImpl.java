package org.shaolin.vogerp.commonmodel.internal;

import java.util.ArrayList;
import java.util.List;

import org.shaolin.bmdp.runtime.security.UserContext;
import org.shaolin.bmdp.runtime.spi.IServiceProvider;
import org.shaolin.vogerp.commonmodel.IOrganizationService;
import org.shaolin.vogerp.commonmodel.be.ILegalOrganizationInfo;
import org.shaolin.vogerp.commonmodel.be.IOrganization;
import org.shaolin.vogerp.commonmodel.be.IPersonalInfo;
import org.shaolin.vogerp.commonmodel.be.LegalOrganizationInfoImpl;
import org.shaolin.vogerp.commonmodel.be.OrganizationImpl;
import org.shaolin.vogerp.commonmodel.be.PersonalInfoImpl;
import org.shaolin.vogerp.commonmodel.dao.CommonModel;

public class OrganizationServiceImpl implements IOrganizationService, IServiceProvider {

	public OrganizationServiceImpl() {
	}
	
	public void reload() {
	}
	
	@Override
	public List[] getAllOrganizations(int offset, int count) {
		OrganizationImpl scFlow = new OrganizationImpl();
		scFlow.setEnabled(true);
		scFlow.setParentId(1);
		List<IOrganization> list = CommonModel.INSTANCE.searchSubOrganizationInfo(scFlow, null, offset, count);
		
		List[] result = new List[2];
		List<String> nameList = new ArrayList<String>();
		List<String> nameListDisplay = new ArrayList<String>();
		nameList.add("uimaster");
		nameListDisplay.add("Vogue E-Service");
		for (IOrganization org : list) {
			nameList.add(org.getOrgCode());
			nameListDisplay.add(org.getName());
		}
		result[0] = nameList;
		result[1] = nameListDisplay;
		return result;
	}
	

	@Override
	public long getOrgIdByPartyId(long partyId) {
		PersonalInfoImpl condition = new PersonalInfoImpl();
		condition.setId(partyId);
		List<IPersonalInfo> result = CommonModel.INSTANCE.searchPersonInfo(condition, null, 0, 1);
		return result.get(0).getOrgId();
	}
	
	@Override
	public IOrganization getOrganizationByPartyId(long partyId) {
		PersonalInfoImpl condition = new PersonalInfoImpl();
		condition.setId(partyId);
		List<IPersonalInfo> result = CommonModel.INSTANCE.searchPersonInfo(condition, null, 0, 1);
		
		OrganizationImpl scFlow = new OrganizationImpl();
		scFlow.setId(result.get(0).getOrgId());
		List<IOrganization> list = CommonModel.INSTANCE.searchOrganization(scFlow, null, 0, -1);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public IOrganization getOrganizationInfo() {
		OrganizationImpl scFlow = new OrganizationImpl();
		scFlow.setId(UserContext.getUserContext().getOrgId());
		List<IOrganization> list = CommonModel.INSTANCE.searchOrganization(scFlow, null, 0, -1);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public ILegalOrganizationInfo getLegalInfo() {
		LegalOrganizationInfoImpl scFlow = new LegalOrganizationInfoImpl();
		scFlow.setOrgId(UserContext.getUserContext().getOrgId());
		List<ILegalOrganizationInfo> list = CommonModel.INSTANCE.searchOrgaLegalInfo(scFlow, null, 0, -1);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public ILegalOrganizationInfo getLegalInfo(long orgId) {
		LegalOrganizationInfoImpl scFlow = new LegalOrganizationInfoImpl();
		scFlow.setOrgId(orgId);
		List<ILegalOrganizationInfo> list = CommonModel.INSTANCE.searchOrgaLegalInfo(scFlow, null, 0, -1);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<IOrganization> getSubOrganization(long orgId) {
		OrganizationImpl scFlow = new OrganizationImpl();
		scFlow.setParentId(orgId);
		return CommonModel.INSTANCE.searchSubOrganizationInfo(scFlow, null, 0, -1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IPersonalInfo> getEmployeese(long orgId) {
		PersonalInfoImpl condition = new PersonalInfoImpl();
		condition.setOrgId(orgId);
		List<IPersonalInfo> result = CommonModel.INSTANCE.searchPersonInfo(condition, null, 0, -1);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IPersonalInfo> getEmployeese() {
		Object orgId = UserContext.getUserData(UserContext.CURRENT_USER_ORGID, true);
		PersonalInfoImpl condition = new PersonalInfoImpl();
		condition.setOrgId((Long)orgId);
		List<IPersonalInfo> result = CommonModel.INSTANCE.searchPersonInfo(condition, null, 0, -1);
		return result;
	}
		
	@Override
	public List<String> getOrganizationRoles() {
		return null;
	}

	@Override
	public List<String> getEmployeeseRoles() {
		return null;
	}

	@Override
	public List<String> getEmployeeseByRole() {
		return null;
	}

	@Override
	public Class getServiceInterface() {
		return IOrganizationService.class;
	}

}
