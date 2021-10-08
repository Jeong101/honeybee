

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
