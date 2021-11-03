

function openModal(btnModal){
    switch(btnModal){
        case "modal1":   
            modal = document.getElementById("modal1");
            modal.style.display = "flex";
            break;
        case "modal":
            modal = document.getElementById("modal");
            modal.style.display = "flex";
            break;
    }

    // if(btnModal == 'modal1'){
    //     const modal = document.getElementById("modal1");
    //     modal.style.display = "flex"
    // }else if(btnModal == 'modal'){
    //     const modal = document.getElementById("modal");
    //     modal.style.display = "flex"
    // }
    

}

// openModal.addEventListener("click", e => {  
//     modalName(openModal);
// })


// function modalOn() {
//     const modal = document.getElementById("modal");
//     modal.style.display = "flex"
// }

function isModalOn() {
    return modal.style.display === "flex"
}
function modalOff() {
    modal.style.display = "none"
}

// const btnModal = document.getElementById("btn-modal")
// btnModal.addEventListener("click", e => {
//     modalOn()
// })

// const closeBtn = modal.querySelector(".close-area")
// closeBtn.addEventListener("click", e => {
//     modal.style.display = "none"
// })

// 모달 범위 밖 클릭 시 닫힘
// modal.addEventListener("click", e => {
//     const evTarget = e.target
//     if(evTarget.classList.contains("modal-overlay")) {
//         modalOff()
//     }
// })


window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})

//manageMemberModal.js
$(document).ready(function(){
	
	$('ul.tabs li').click(function(){
        
		var tab_id = $(this).attr('data-tab');
        
		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');

        // if(tab_id === "tab-2"){
        //     $('#tab-2').load(location.href + ' #tab-2');
        // }
	})

})


async function deleteMember(id){
    event.preventDefault();
    let response = await fetch("/deleteMember/"+id, {
        method: "delete"
    });
    
    let parseResponse = await response.text();
    
    if(parseResponse === "ok"){
        //location.reload();
        let deleteEL = document.querySelector("#member-"+id);
        deleteEL.remove();
        console.log(deleteEL);
        $('#member_list').load(location.href + ' #member_list');
    }
}

async function admitMember(id){
    event.preventDefault();
    let response = await fetch("/admitMember/"+id, {
        method: "get"
    });
    
    let parseResponse = await response.text();
    
    if(parseResponse === "ok"){
        //location.reload();
        let admitEl = document.querySelector("#admit-"+id);
        $('#member_list').load(location.href + ' #member_list');
        admitEl.remove();
        console.log(deleteEL);
        
    }
}

// $('#admit-btn').on('click',async function(){
//     let response = await fetch("/admitMember/"+id, {
//         method: "get"
//     });
    
//     let form = document.modalForm;
//     let variable = form.admit-btn.value;
//     alert(variable);
    
//     let parseResponse = await response.text();
    
//     if(parseResponse === "ok"){
//         //location.reload();
//         let admitEl = document.querySelector("#admit-"+id);
//         admitEl.remove();
//         console.log(deleteEL);
//         $('#member_list').load(location.href + ' #member_list');
//     }
// })

$('#manage-tab').on('click', function(){
    //                                # 앞에 띄어쓰기 안하면 전체 새로고침 됨
    $('#list-table').load(location.href + ' #list-table');
})