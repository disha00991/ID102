function MakeAPromise(){
    return  new Promise(function(resolve,reject){      

      var requestObj = new XMLHttpRequest();/// async

      requestObj.onreadystatechange = function(){
        if(requestObj.readyState == 4 && requestObj.status == 200){
            // success
            resolve(requestObj.responseText);
      }
      else if(requestObj.readyState == 4 && requestObj.status !=200){
           // error !
           reject(requestObj.statusText);
      }   
    }// eof ready state change
    requestObj.open('GET','https://jsonplaceholder.typicode.com/posts')
    requestObj.send(); // make ajax request !
      
    });
}