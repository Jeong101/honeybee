<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div id="modal" class="modal-overlay">
    <div class="modal-window">
      <form action="/doJoin" method="POST" class="joinForm" onsubmit="setWindow(`createWindow`)">
        <div class="close-area">X</div>                                                                          
        <h2>회원가입</h2>
        <div class="textForm">
          <input name="clubName" type="text" class="email" placeholder="회원명 입력" required>
        </div>
        <div>
          <h4>회원 정보</h4>
        </div>
        
          <div class="textForm">
          <input name="email" type="text" class="email" value="${sessionScope.userEntity.email}" readonly="readonly">
        </div>
        <div class="textForm">
          <input name="nickname" type="text" class="nickname" value="${sessionScope.userEntity.username}" readonly="readonly">
        </div>
        
        <input type="submit" class="btn" value="J O I N"/>
      </form>
      </div>
  </div>
    
    