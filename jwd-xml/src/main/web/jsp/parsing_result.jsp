<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%request.setAttribute("dashSign", "——");%>

<c:import url="header.jsp"/>
<main>
    <div class="container-fluid">
        <table align="center" class="table table-light">
            <tr align="center">
                <th>Type</th>
                <th>Id</th>
                <th>Group</th>
                <th>Name</th>
                <th>Company name</th>
                <th>Versions</th>
                <th>Analog names</th>
                <th>Title of original</th>
                <th>Efficiency</th>
            </tr>
            <c:forEach var="medicine" items="${medicineList}">
                <tr align="center">
                    <c:if test="${medicine['class'].simpleName == 'Analog'}">
                        <td>Analog</td>
                    </c:if>
                    <c:if test="${medicine['class'].simpleName == 'OriginalMedicine'}">
                        <td>Original Medicine</td>
                    </c:if>
                    <td>${medicine.id}</td>
                    <td>${medicine.group}</td>
                    <td>${medicine.name}</td>
                    <td>${medicine.pharmaceuticalCompanyName}</td>
                    <td>
                        <c:forEach var="version" items="${medicine.versions}">
                            <table class="table table-light version_table">
                                <tr align="center">
                                    <th>Certificate</th>
                                    <th>Package type</th>
                                    <th>Dosage</th>
                                </tr>
                                <tr>
                                    <td>
                                        <table class="table table-light">
                                            <tr align="center">
                                                <th>Number</th>
                                                <th>Issue date</th>
                                                <th>Expiry date</th>
                                                <th>reg. organization</th>
                                            </tr>
                                            <tr>
                                                <td>${version.certificate.number}</td>
                                                <td>${version.certificate.issueDate}</td>
                                                <td>${version.certificate.expiryDate}</td>
                                                <td>${version.certificate.registrationOrganization}</td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <table class="table table-light">
                                            <tr align="center">
                                                <th>Type</th>
                                                <th>Amount</th>
                                                <th>Price</th>
                                            </tr>
                                            <tr align="center">
                                                <td>${version.packageType.packageType}</td>
                                                <td>${version.packageType.amount}</td>
                                                <td>${version.packageType.price}rub</td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <table class="table table-light">
                                            <tr align="center">
                                                <th>Frequency</th>
                                                <th>Dose</th>
                                            </tr>
                                            <tr>
                                                <td>${version.dosage.medicationFrequency}</td>
                                                <td>${version.dosage.dose}</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </c:forEach>
                    </td>
                    <td>
                        <c:if test="${medicine['class'].simpleName == 'OriginalMedicine'}">
                            <c:forEach var="analog" items="${medicine.analogs}">
                                ${analog}.<br/>
                            </c:forEach>
                        </c:if>
                        <c:if test="${medicine['class'].simpleName == 'Analog'}">
                            ${dashSign}
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${medicine['class'].simpleName == 'Analog'}">
                            ${medicine.titleOfOriginal}
                        </c:if>
                        <c:if test="${medicine['class'].simpleName == 'OriginalMedicine'}">
                            ${dashSign}
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${medicine['class'].simpleName == 'Analog'}">
                            ${medicine.efficiency}%
                        </c:if>
                        <c:if test="${medicine['class'].simpleName == 'OriginalMedicine'}">
                            ${dashSign}
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
</main>
<c:import url="footer.jsp"/>

