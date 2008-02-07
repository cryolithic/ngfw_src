<%@ include file="/WEB-INF/jsp/include.jsp" %>

{
 'success':${success},
 'msg':'<fmt:message key="${msg}"/>',
 'data': 
	<c:set var="node" value="${data}"/>
	  <%--workaround because NodeContext.node() should be named NodeContext.getNode()--%>
  	  <jsp:useBean id="node"  type="com.untangle.uvm.node.NodeContext" />
	  {'id':'${node.tid.id}','tid':'${node.tid.id}','name':'${node.nodeDesc.name}','displayName':'${node.nodeDesc.displayName}','viewPosition':${node.mackageDesc.viewPosition},
	  'rackType':'${node.mackageDesc.rackType}','isService':${node.mackageDesc.service},'isUtil':${node.mackageDesc.util},'isSecurity':${node.mackageDesc.security},'isCore':${node.mackageDesc.core},
	  'runState':'<%= node.node().getRunState() %>','image':'image?name=${node.mackageDesc.name}',
	  'helpLink':'<uvm:help source="${node.nodeDesc.displayName}"/>',
	  'webContext':'<uvm:web-context node="${node.nodeDesc.name}"/>',
	  'blingers':[{'type':'ActivityBlinger','bars':['ACT 1','ACT 2','ACT 3','ACT 4']},{'type':'SystemBlinger'}]}
}

