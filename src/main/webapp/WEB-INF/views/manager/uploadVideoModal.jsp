<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div id="modal2" class="modal-overlay">
  
    <div class="modal-window manageModal">
      <form action="/upload" method="POST" class="joinForm manageJoinForm" enctype="multipart/form-data">
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
              <input name="title" type="text" class="nickname" placeholder="동영상 제목을 입력하세요." required="required">
            </div> <!--end textForm -->

          </div> <!--end postInfo-box -->

        <!--video Upload button and preview onchange="setThumbnail(event);"-->
          <div id="videoUpload-box" class="videoUpload-box">
            <input type="file" name="video" id="video" onclick="reloadPreview();" accept="video/*" />
            <div id="image_container" class="preview-box"></div>
          </div> <!-- end videoUpload-box-->

        </div> <!--end upload-box -->

        <input type="submit" class="btn" value="Upload"/>
        <div class="box">
          <div class="loader3"></div>
        </div>
      </form>
    </div>  <!--end modal-widnow -->
  </div> <!--end modal-overlay -->

  <script> 
  function setThumbnail(event) {
    var reader = new FileReader(); 
      reader.onload = function(event) { 
        var img = document.createElement("video"); 
        img.setAttribute("src", event.target.result); 
        document.querySelector("div#image_container").appendChild(img); 
        }; 
      reader.readAsDataURL(event.target.files[0]); 
  } 

  // function fileCheck() {
	// 			//input file 태그.
	// 			// var file = document.getElementById('videoPath').files[0].name;
	// 			// //파일 경로.
	// 			// var filePath = file.value;
  //       // // var filePath = document.getElementById('videoPath').value=document.selection.createRange().text.toString();
	// 			// //전체경로를 \ 나눔.
	// 			// var filePathSplit = file.split('\\'); 
	// 			// //전체경로를 \로 나눈 길이.
	// 			// var filePathLength = filePathSplit.length;
	// 			// //마지막 경로를 .으로 나눔.
	// 			// var fileNameSplit = filePathSplit[filePathLength-1].split('.');
	// 			// //파일명 : .으로 나눈 앞부분
	// 			// var fileName = fileNameSplit[0];
	// 			// //파일 확장자 : .으로 나눈 뒷부분
	// 			// var fileExt = fileNameSplit[1];
	// 			// //파일 크기
	// 			// var fileSize = file.files[0].size;
  //       alert(document.getElementById('videoPath').value()+"파일경로");
	// 			// alert("파일경로일거같은거"+document.getElementById('videoPath').files[0].path);
	// 		}
  </script>

  


    
    