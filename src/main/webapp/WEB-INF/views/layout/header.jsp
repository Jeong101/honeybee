<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>HoneyBee5Sound</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/honeybee_icon.jpg" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
  
    </head>

    
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
   
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <%-- 로그인 한 회원이 관리자일 경우에만 관리메뉴 표시 --%>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/manageclub">동호회관리</a></li>
                    
                    <%-- 로그인 후 동호회생성 메뉴 표시 --%>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">동호회 생성</a></li>
                    <%-- 로그인 후 동호회가입 메뉴 표시 --%>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">동호회 가입</a></li>
                    
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${sessionScope.userEntity != null}">
                                <div id="name">${sessionScope.userEntity.name} 회원</div>
                                <li class="nav-item-signOut"><a class="signOut" href="#" onclick="signOut();">Sign out</a></li>
                            </c:when>
                            <c:otherwise>
                                <div id="customBtn" class="g-signin2" data-onsuccess="onSignIn"></div>
                                <li class="nav-item-join"><a class="nav-link" href="#!">회원가입</a></li>
                            </c:otherwise>
                        </c:choose>                        
                    </li>    
    
                    
                    
                </ul>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-white py-5">
            <div class="header-Box">
                <div class="logoImg-Box">
                    <img class="img-fluid img-profile" src="/assets/honeybee_logo.jpg" alt="..." />
                </div> <!-- end logoImg-Box-->
                <div class="container px-4 px-lg-5 my-5">
                    <div class="text-center text-black title-Box">
                        <h1 class="display-4 fw-bolder">HoneyBee 5 Sound</h1>
                    </div> <!-- end title-Box-->
                 </div><!-- end px-4-->
            </div> <!--end header-Box -->

            <div class="memberlist-Box">
                <ul>
                    <li>A</li>
                    <li>B</li>
                    <li>C</li>
                    <li>D</li>
                    <li>E</li>
                </ul>
            </div>  <!-- end memberlist-Box-->
        </header>

        <div class = "body-Box">
            <!--LEFT side bar-->
            <nav class="navbar navbar-expand-lg1" id="sideNav">
                <div class="search-Box">
                    <form action="">
                        <input type="text" /><input type="submit" value="🔍">
                    </form>
                </div> <!-- end search-Box-->

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <div>
                        <ul class="navbar-nav">
                            <%-- <li class="nav-item"><a class="menu-style" href="#about">About</a></li>
                            <li class="nav-item"><a class="menu-style" href="#experience">Experience</a></li>
                            <li class="nav-item"><a class="menu-style" href="#education">Education</a></li>
                            <li class="nav-item"><a class="menu-style" href="#skills">Skills</a></li>
                            <li class="nav-item"><a class="menu-style" href="#interests">Interests</a></li>
                            <li class="nav-item"><a class="menu-style" href="#awards">Awards</a></li> --%>
                            <c:forEach var="club" items="${clubsEntity}">
                            <li class="nav-item"><a class="menu-style" href="#awards">${club.clubname}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>  <!-- end navbar-collapse-->
        </nav> <!-- end navbar-expand-lg1 -->

    <!-- div body-Box 아직 안닫힘 -->