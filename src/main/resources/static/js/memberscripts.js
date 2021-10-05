//let modal = document.getElementById("modal")

//const modal = null;

function setWindow(id){
     let modal = document.getElementById("modal")
     modal = document.getElementById(id);
 }

function modalOn(id) {
    
    modal = id;
    
    modal.style.display = "flex"
}

function isModalOn() {
    return modal.style.display === "flex"
}

function modalOff() {
    modal.style.display = "none"
}

function setId(id){

    const btnModal = document.getElementById(id)
    
    btnModal.addEventListener("click", e => {
        modalOn(id)
    })
    
}

// const btnModal = document.getElementById("btn-modal")




const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modalOff()
})

modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modalOff()
    }
})

window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})

//waiting
