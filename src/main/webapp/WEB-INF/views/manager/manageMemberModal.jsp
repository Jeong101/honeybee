<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div id="modal1" class="modal-overlay">
    <div class="modal-window">
      <form action="/doJoin" method="POST" class="joinForm" onsubmit="setWindow(`createWindow`)">
        <div class="close-area"><a class="close-btn" href="javascript:modalOff();">X</a></div>                                                                          
        <h2>회원관리</h2>

        <div class="modal_container">

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">신청회원</li>
		<li class="tab-link" data-tab="tab-2">회원관리</li>

	</ul>

	<div id="tab-1" class="tab-content current">
	
	</div>
	<div id="tab-2" class="tab-content">
---- ---- ★------ ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ★-- ---- ---- ------★ ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- ---- ★------ ---- ---- ---- ----
	</div>

</div>
        
          
        
        
        <input type="submit" class="btn" value="J O I N"/>
      </form>
      </div>
  </div>
    
    