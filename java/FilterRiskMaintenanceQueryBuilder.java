package com.bankofamerica.ptaa.arr.dao.support;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class FilterRiskMaintenanceQueryBuilder {

	private static final Object PARTIAL_MATCH_WILDCARD = "%";
	private String query;
	private List<Object> params;
	/**
	 * Flag to indicate if we are adding multiple where clauses that need to be
	 * joined with "and"
	 */
	private boolean addAnd = false;
	
	public String getQuery() {
        return query;
    }
    
    public List<Object> getParams() {
        return params;
    }
    
    public FilterRiskMaintenanceQueryBuilder(String vertical, String aitNo, String riskStatus, String riskType){
    	buildQuery(vertical, aitNo, riskStatus, riskType);
    }
    
    private void buildQuery(String vertical, String aitNo, String riskStatus, String riskType){
    	params  =  new ArrayList<Object>();
    	
    	StringBuffer queryBuilder =  new StringBuffer();
    	
    	queryBuilder.append("select distinct rm from RiskMaintenance rm ");
    	
    	if(StringUtils.isNotEmpty(vertical) && !StringUtils.equalsIgnoreCase(vertical, "null")){
    		buildQuery(queryBuilder, "rm.vertical.verticalName LIKE :vertical");
    		params.add(String.format("%s%s%s", PARTIAL_MATCH_WILDCARD,
				StringUtils.upperCase(vertical), PARTIAL_MATCH_WILDCARD));
    	}
	
    	if(StringUtils.isNotEmpty(aitNo) && !StringUtils.equalsIgnoreCase(aitNo, "null")){
    		buildQuery(queryBuilder, "rm.aitNo.aitDescription LIKE :aitNo");
    		params.add(String.format("%s%s%s", PARTIAL_MATCH_WILDCARD,
				StringUtils.upperCase(aitNo), PARTIAL_MATCH_WILDCARD));
    	}
    	
    	if(StringUtils.isNotEmpty(riskStatus) && !StringUtils.equalsIgnoreCase(riskStatus, "null")){
    		buildQuery(queryBuilder, "rm.riskStatus LIKE :riskStatus");
    		params.add(String.format("%s%s%s", PARTIAL_MATCH_WILDCARD,
				StringUtils.upperCase(riskStatus), PARTIAL_MATCH_WILDCARD));
    	}
    	
    	
    	if(StringUtils.isNotEmpty(riskType) && !StringUtils.equalsIgnoreCase(riskType, "null")){
    		buildQuery(queryBuilder, "rm.riskTypeDescription.riskTypeDescription LIKE :riskType");
    		params.add(String.format("%s%s%s", PARTIAL_MATCH_WILDCARD,
    				StringUtils.upperCase(riskType), PARTIAL_MATCH_WILDCARD));
    	}
    	
    	query = queryBuilder.toString();
    }

	/**
	 * 
	 * @param queryBuilder
	 * @param addQuery
	 */
	private void buildQuery(StringBuffer queryBuilder, String addQuery) {
		String strAnd = " and ";
		if (addAnd) {
			queryBuilder.append(strAnd);
		} else {
			queryBuilder.append(" where ");
		}
		queryBuilder.append(addQuery);
		addAnd = true;
	}
}
