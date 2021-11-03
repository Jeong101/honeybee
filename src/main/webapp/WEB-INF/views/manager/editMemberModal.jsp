<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div id="modal" class="modal-overlay">
  
    <div class="modal-window">
    
      <form action="/doEdit/${sessionScope.userEntity.id}" method="POST" class="joinForm">
  <div class="close-area"><a class="close-btn" href="javascript:modalOff();">X</a></div>                                                                                
        <h2>내 정보</h2>
        
        <div class="info-attribute">이메일</div>
          <div class="textForm">
          
          <input name="email" type="text" class="email" value="${sessionScope.userEntity.email}" readonly="readonly">
        </div>
        <div class="info-attribute">이름</div>
        <div class="textForm">
          
          <input name="username" type="text" class="name" value="${sessionScope.userEntity.username}" readonly="readonly">
        </div>
        <div class="info-attribute">닉네임(수정)</div>
        <div class="textForm">
          
          <input name="nickname" type="text" class="nickname" value="${sessionScope.userEntity.username}">
        </div>
        
        <input type="submit" class="btn" value="E D I T"/>
      </form>
      </div>
  </div>
    
    