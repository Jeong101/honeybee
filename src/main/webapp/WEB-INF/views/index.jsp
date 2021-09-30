<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="./layout/header.jsp"%>
    <!-- div body-Box 안-->
    <!-- Section-->
    <section class="py-5">
        <div class="px-4 px-lg-5 mt-5">
            <%-- <div class="posts-Box"> --%>
            <%-- row-cols-md-3 row-cols-xl-4 --%>
            <div class="row gx-4 gx-lg-5 row-cols-5 justify-content-center"> 
                <c:forEach var="i" begin="0" end="8">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image width:400 height:250-->
                            <iframe width="400" height="250" src="https://www.youtube.com/embed/D38noXazUDE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            <%-- <img class="card-img-top" src="assets/honeybee_logo.jpg" alt="..." /> --%>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5>영상제목</h5>
                                    <!-- Product reviews-->
                                    <%-- <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div> --%>
                                    <!-- Product price-->
                                    <h5>작성자</h5>
                                    <h5>날짜</h5>
                                </div>
                            </div> <!-- end card-body -->
                            <!-- Product actions-->
                            
                        </div> <!-- end card -->
                    </div> <!-- end mb-5 -->          
                </c:forEach>
            </div> <!-- end gx-4 -->
            
            <%-- </div> --%>
        </div> <!-- end px-4-->
    </section>
        
<%@include file="./layout/footer.jsp"%>
