<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>banque YH</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css" />
</head>
<body>
   <div>
     <f:form modelAttribute="banqueForm" method="post" action="chargerCompte">
      <table>
         <tr>
          <td>Code:</td>
          <td><f:input path="code"/></td>
          <td><f:errors path="code"></f:errors></td>
        </tr>
       <tr> 
        <td><input type="submit" value="ok"></td>
       </tr>
      </table>
     </f:form>
   </div>

  <c:if test="${not empty banqueForm.compte}">
    <div>
     <table>
	       <tr>
	         <td>Solde:</td>
	         <td>${banqueForm.compte.solde}</td>
	       </tr>
	       <tr>
	         <td>Date de création:</td>
	         <td>${banqueForm.compte.dateCreation}</td>
	       </tr>
	       <tr>
	         <td>Type de compte:</td>
	         <td>${banqueForm.typeCompte}</td>
	       </tr>
	      <c:if test="${banqueForm.typeCompte=='CompteCourant'}">
	           <tr>
	         <td>Découvert:</td>
	         <td>${banqueForm.compte.decouvert}</td>
	       </tr>
	      </c:if>
	      <c:if test="${banqueForm.typeCompte=='CompteEpargne'}">
	           <tr>
	         <td>Taux :</td>
	         <td>${banqueForm.compte.taux}</td>
	       </tr>
	      </c:if>
     </table>
    </div>
    <div>
      <table>
         <td>Nom Client</td> <td>${banqueForm.compte.client.nomClient}</td>
      </table>
    </div>
        <div>
      <table>
         <td>Nom Employé</td> <td>${banqueForm.compte.employe.nomEmploye}</td>
      </table>
    </div>
    <div>
      <table class="table1">
         <tr>
            <th>Num</th><th>Type</th><th>Date</th><th>Montant</th>
         </tr>
         <c:forEach items="${banqueForm.operations}" var="op">
             <tr>
             <td>${op.numeroOperation}</td>
             <td>${op}</td>  <!-- toString -->
             <td>${op.dateOperation}</td>
             <td>${op.montant}</td>
             </tr>
         
         </c:forEach>
      </table>
    </div>
    
  </c:if>

 
 <c:if test="${not empty banqueForm.exception}"> <!--  si exception recupérée dans le catch de banqueform  j'affiche le message récupéré ds le runtime paramétré depuis la dao -->
   <div>
   ${banqueForm.exception} 
   
   </div>
 
 </c:if>
</body>
</html>