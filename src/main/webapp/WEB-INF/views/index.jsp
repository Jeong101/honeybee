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
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
   
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <%-- 로그인 한 회원이 관리자일 경우에만 관리메뉴 표시 --%>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">동호회관리</a></li>
                    <%-- 로그인 후 동호회생성 메뉴 표시 --%>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">동호회 생성</a></li>
                    <%-- 로그인 후 동호회가입 메뉴 표시 --%>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">동호회 가입</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">회원가입</a></li>
                    </ul>
                </div>
        </nav>
        <!-- Header-->
        <header class="bg-white py-5">
        <div class="header-Box">
        <div class="logoImg-Box">
        <img class="img-fluid img-profile" src="/assets/honeybee_logo.jpg" alt="..." />
        </div>
        <div class="container px-4 px-lg-5 my-5">
            
                <div class="text-center text-black title-Box">
                    <h1 class="display-4 fw-bolder">HoneyBee 5 Sound</h1>
                    
                </div>
        </div>

</div>

        <div class="memberlist-Box">
        <ul>
        <li>A</li>
        <li>B</li>
        <li>C</li>
        <li>D</li>
        <li>E</li>
        </ul>
        </div>
        </header>
        <div class = "body-Box">
        <!--LEFT side bar-->
        <nav class="navbar navbar-expand-lg1" id="sideNav">
        <div class="search-Box">
            <form action="">
            <input type="text" /><input type="submit" value="🔍">
            </form>
            </div>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
            <div>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="menu-style" href="#about">About</a></li>
                    <li class="nav-item"><a class="menu-style" href="#experience">Experience</a></li>
                    <li class="nav-item"><a class="menu-style" href="#education">Education</a></li>
                    <li class="nav-item"><a class="menu-style" href="#skills">Skills</a></li>
                    <li class="nav-item"><a class="menu-style" href="#interests">Interests</a></li>
                    <li class="nav-item"><a class="menu-style" href="#awards">Awards</a></li>
                </ul>
            </div>
            </div>
        </nav>
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
                                    <h5 class="fw-bolder">영상제목</h5>
                                    <!-- Product reviews-->
                                    <%-- <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div> --%>
                                    <!-- Product price-->
                                    
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center">작성자</div>
                                <div class="text-center">날짜</div>
                            </div>
                        </div>
                    </div>           
                    </c:forEach>
                </div>
            
            <%-- </div> --%>
            </div>
        </section>
        </div>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
