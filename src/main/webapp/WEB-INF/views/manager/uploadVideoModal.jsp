<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div id="modal2" class="modal-overlay">
  
    <div class="modal-window manageModal">
    
      <form action="/doEdit/${sessionScope.userEntity.id}" method="POST" class="joinForm manageJoinForm">
  <div class="close-area"><a class="close-btn" href="javascript:modalOff();">X</a></div>                                                                                
        <h2>동영상 업로드</h2>
        
        <div class="info-attribute">이메일</div>
          <div class="textForm">
          
          <input name="email" type="text" class="email" value="${sessionScope.userEntity.email}" readonly="readonly">
        </div>
        <div class="info-attribute">작성자</div>
        <div class="textForm">
          
          <input name="username" type="text" class="name" value="${sessionScope.userEntity.username}" readonly="readonly">
        </div>
        <div class="info-attribute">제목</div>
        <div class="textForm">
          
          <input name="nickname" type="text" class="nickname" value="${sessionScope.userEntity.username}">
        </div>
        
        <input type="submit" class="btn" value="E D I T"/>
      </form>
      </div>
  </div>
    
    