<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div id="modal1" class="modal-overlay">
    <div class="modal-window">
      <form action="/doJoin" method="POST" class="joinForm" onsubmit="setWindow(`createWindow`)">
        <div class="close-area"><a class="close-btn" href="javascript:modalOff();">X</a></div>                                                                          
        <h2>회원관리</h2>

        <div class="modal_container">

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">신청 회원</li>
		<li class="tab-link" data-tab="tab-2">회원 관리</li>
	</ul>

	<div id="tab-1" class="tab-content current">
		<section class="ftco-section">
		<div class="container-box">
			<%-- <div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
				</div>
			</div> --%>
			<div class="row-1">
				<div class="col-md-12-1">
					<div class="table-wrap">
						<table class="table table-striped">
						  <thead>
						    <tr>
						      <th>이름</th>
						      <th>이메일</th>
						      
						      <th>닉네임</th>
						      
						      <th>Status</th>
						    </tr>
						  </thead>
						  <tbody>
							<c:forEach var="users" items="${usersEntity}">
							<c:choose>
							  <c:when test = "${users.member==0}">
                                <tr>
						      <th scope="row-1">${users.username}</th>
						      <td>${users.email}</td>
						      <td>${users.nickname}</td>
						      
						      <td><a href="/admitMember/${users.id}" class="btn-1 btn-success">가입</a></td>
						    </tr>
							</c:when>
							  </c:choose>
                            </c:forEach>

						    

						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	</div>
	<div id="tab-2" class="tab-content">
		<section class="ftco-section">
		<div class="container-box">
			<%-- <div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
				</div>
			</div> --%>
			<div class="row-1">
				<div class="col-md-12-1">
					<div class="table-wrap">
						<table class="table table-striped">
						  <thead>
						    <tr>
						      <th>이름</th>
						      <th>이메일</th>
						      
						      <th>닉네임</th>
						      
						      <th>status</th>
						    </tr>
						  </thead>
						  <tbody>
							<c:forEach var="users" items="${usersEntity}">
							<c:choose>
							  <c:when test = "${users.member==1}">
                                <tr>
						      <th scope="row-1">${users.username}</th>
						      <td>${users.email}</td>
						      <td>${users.nickname}</td>
						      
						      <td><a href="#" class="btn-1 btn-success">탈퇴</a></td>
						    </tr>
							</c:when>
							  </c:choose>
                            </c:forEach>

						    

						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	</div>
	

</div>
        
          
        
        
        <%-- <input type="submit" class="btn" value="J O I N"/> --%>
      </form>
      </div>
  </div>
    
    