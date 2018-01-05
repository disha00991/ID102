import axios from 'axios';
 
export function fetchData(){
    var myData = axios.get("https://jsonplaceholder.typicode.com/todos");
    console.log("my data is this:"+myData);
    return (dispatch)=>(myData.then(
        (data)=>{dispatch({type:'FETCH_TODO', response:data})}
    ))
}
