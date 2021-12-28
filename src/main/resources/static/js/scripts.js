/*!
* Start Bootstrap - Shop Homepage v5.0.3 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
  
  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(async function () {
      console.log('User signed out.');

      location.href="/user/logout";
    
    });   
  }

  var googleUser = {};
  var startApp = function() {
    gapi.load('auth2', function(){
      // Retrieve the singleton for the GoogleAuth library and set up the client.
      auth2 = gapi.auth2.init({
        client_id: '328137351009-2suk9eiklaooe3gh19mh7atbm57mci68.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        // Request scopes in addition to 'profile' and 'email'
        //scope: 'additional_scope'
      });
      attachSignin(document.getElementById('customBtn-1'));
    });
  };

  async function attachSignin(element) {
    auth2.attachClickHandler(element, {},
      async function(googleUser) {
        // document.getElementById('name').innerText = "Signed in: " + googleUser.getBasicProfile().getName();
        var profile = auth2.currentUser.get().getBasicProfile();
        console.log('Full Name: ' + profile.getName());
        console.log('Email: ' + profile.getEmail());
          let user = {
            username : profile.getName(),
            email : profile.getEmail()
          };

          let googleInfo = await fetch("/auth/login", {
            method : 'POST',
            headers:{
               'Content-Type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(user)
          });
          let parseResponse = await googleInfo.text();
          
          

          if(parseResponse === "OK"){
            location.href="/";
          }else{
            alert("ERROR");
          }
        });
    } 

    function home(){
      location.href="/";
    }

  
