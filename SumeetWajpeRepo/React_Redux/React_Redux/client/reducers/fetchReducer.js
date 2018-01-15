export default function fetchposts(state=[],action){  
    switch(action.type){
        case 'FETCH_POSTS':
            console.log(action.response.data);
            return action.response.data;        
        default :
            return state;
}   
}