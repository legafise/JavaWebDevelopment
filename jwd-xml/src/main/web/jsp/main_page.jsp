<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%request.setAttribute("actionURL", request.getContextPath() + "/controller?command=save_file");%>

<c:import url="header.jsp"/>
    <main>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-4"></div>
                <div class="col-xl-4">
                    <div class="input-window">
                        <div class="card">
                            <h5 align="center" class="card-header">Upload file and chose parsing type</h5>
                            <div class="card-body">
                                <p class="card-text">
                                    <form action="${actionURL}" method="post" enctype="multipart/form-data">
                                        <p>
                                            <div class="mb-3">
                                                <input class="form-control" type="file" name="xmlFile" id="formFile">
                                            </div>
                                        </p>
                                        <p>
                                            <select class="form-select" name="builderNumber">
                                                <option value="1">Dom</option>
                                                <option value="2">Sax</option>
                                                <option value="3">Stax</option>
                                            </select>
                                        </p>
                                        <div class="row">
                                            <div class="col-xl-5"></div>
                                            <div class="col-xl-5">
                                                <input class="btn btn-success" type="submit" value="Select">
                                            </div>
                                        </div>
                                    </form>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-4"></div>
            </div>
        </div>
    </main>
<c:import url="footer.jsp"/>