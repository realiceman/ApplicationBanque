<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>banque YH</title>
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
     </table>
   </div>
   
</body>
</html>