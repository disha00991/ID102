import axios from 'axios';

export function increement(index){
    return {
        type:'INCREMENT_LIKES',
        index
    }
}

export function fetchData(){
    var request = axios.get('http://jsonplaceholder.typicode.com/posts');
    

    return (dispatch)=>{
        request.then((data)=>{
            dispatch({type:'FETCH_POSTS',response:data})
        })
    }
}

export function addComment(){
    return {
        type:'ADD_COMMENT'      
        }
}

export function removeComment(index){
    return {
        type:'REMOVE_COMMENT',
        index
    }
}