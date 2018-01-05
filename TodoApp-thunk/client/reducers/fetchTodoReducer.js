function reduceTodo(state=[], action){
    switch(action.type){
        case 'FETCH_TODO':{
        console.log("im fetching data: "+state);
            return action.response.data;}
        default:
            console.log("im in default state: "+state);
            return state;
    }
}

export default reduceTodo;