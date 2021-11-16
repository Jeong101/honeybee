<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div id="modal2" class="modal-overlay">
  
    <div class="modal-window manageModal">
    
      <form action="/doEdit/${sessionScope.userEntity.id}" method="POST" class="joinForm manageJoinForm">
        <div class="close-area" onclick="reloadPreviewName();"><a class="close-btn" href="javascript:modalOff();">X</a></div>                                                                                
        <h2>동영상 업로드</h2>
        <div class="upload-box">
          <div class="postInfo-box">
            <div class="info-attribute">이메일</div>
            <div class="textForm">
          
            <input name="email" type="text" class="email" value="${sessionScope.userEntity.email}" readonly="readonly">
            </div> <!--end textForm -->
            <div class="info-attribute">작성자</div>

            <div class="textForm">
              <input name="username" type="text" class="name" value="${sessionScope.userEntity.username}" readonly="readonly">
            </div> <!--end textForm -->

            <div class="info-attribute">제목</div>
            <div class="textForm">
              <input name="nickname" type="text" class="nickname" value="${sessionScope.userEntity.username}">
            </div> <!--end textForm -->

          </div> <!--end postInfo-box -->

        <!--video Upload button and preview -->
          <div id="videoUpload-box" class="videoUpload-box">
            <input type="file" id="image" onclick="reloadPreview();" accept="video/*" onchange="setThumbnail(event);"/>
            <div id="image_container" class="preview-box"></div>
          </div> <!-- end videoUpload-box-->

        </div> <!--end upload-box -->

        <input type="submit" class="btn" value="E D I T"/>
      </form>
    </div>  <!--end modal-widnow -->
  </div> <!--end modal-overlay -->

  <script> 
  function setThumbnail(event) {
    var reader = new FileReader(); reader.onload = function(event) { 
      var img = document.createElement("video"); 
      img.setAttribute("src", event.target.result); 
      document.querySelector("div#image_container").appendChild(img); }; 
      reader.readAsDataURL(event.target.files[0]); 
  } 
  </script>


    
    