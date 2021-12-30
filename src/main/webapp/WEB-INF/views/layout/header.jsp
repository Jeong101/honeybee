<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%@include file="../manager/editMemberModal.jsp"%>
    <%@include file="../manager/manageMemberModal.jsp"%>
    <%@include file="../manager/uploadVideoModal.jsp"%>
<!DOCTYPE html>
<html>
    <head>
	    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

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
        <link href="/css/registmember.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    </head>

    
    <body>
    
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="emptySpace px-4 px-lg-5">
   
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item-home"><a class="nav-link active" aria-current="page" href="/">HOME</a></li>
                    <%-- 로그인 한 회원이 관리자일 경우에만 관리메뉴 표시 --%>
                    <!--<li class="nav-item"><input type="button" value="동호회 생성" id="btn-modal"/></li>-->
                    
                    
                        <c:choose>
                            <c:when test="${sessionScope.userEntity != null}">  
                                <%-- 관리자한테만 표시 --%>
                                <c:choose>
                                    <c:when test="${sessionScope.userEntity.member==2}">
                                        <li class="nav-item-hover"><a class="nav-link active" aria-current="page" id="btn-modal1" href="javascript:openModal('modal1');">회원관리</a></li>
                                    </c:when>
                                </c:choose>
                                <li class="nav-item-hover"><a class="nav-link active" aria-current="page" id="btn-modal" href="javascript:openModal('modal');">내 정보</a></li>
                                <c:choose>
                                    <c:when test="${sessionScope.userEntity.member!=0}">
                                        <li class="nav-item-hover"><a class="nav-link active" aria-current="page" id="btn-modal2" href="javascript:openModal('modal2');">글쓰기</a></li>
                                    </c:when>
                                </c:choose>
                               
                                <div id="name">${sessionScope.userEntity.username} 님</div>
                                
                                <li class="nav-item-signOut"><a class="signOut" href="#" onclick="signOut();">Sign out</a></li>
                            </c:when>
                            <c:otherwise>
                                <div id="customBtn-1" class="login-btn">가입하기</div>
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
                    <img class="img-fluid img-profile" src="/assets/honeybee_logo.jpg" onclick="home()" alt="..." />
                </div> <!-- end logoImg-Box-->
                <div class="container px-4 px-lg-5 my-5">
                    <div class="text-center text-black title-Box">
                        <a class="blog-title" href="/"><h1 class="display-4 fw-bolder">HoneyBee 5 Sound</h1></a>
                    </div> <!-- end title-Box-->
                 </div><!-- end px-4-->
            </div> <!--end header-Box -->

        </header>

        <div class = "body-Box">
            <!--LEFT side bar-->
            <nav class="navbar navbar-expand-lg1" id="sideNav">
                
                <%-- <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button> --%>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <div id="member_list">
                        <ul class="navbar-nav">
                           
                            <c:forEach var="users" items="${usersEntity}">
                             <c:choose>
                            <c:when test="${users.member==1}">
                                <form action="/" method="POST">
                                <%-- <li class="user-li"><a class="menu-style" href="#">${users.nickname}</a></li> --%>
                                <li class="user-li"><input name="nickname" class="menu-style" type="submit" value="${users.nickname}"/></li>
                                <input name="userId" type="hidden" value="${users.id}"/>
                                </form>
                                </c:when>
                            </c:choose>
                            </c:forEach>
                            
                        </ul>
                    </div>
                </div>  <!-- end navbar-collapse-->
        </nav> <!-- end navbar-expand-lg1 -->

    <!-- div body-Box 아직 안닫힘 -->