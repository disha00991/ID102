export default function comments(state=[],action){
    

    switch(action.type){
        case 'ADD_COMMENT':
        console.log('Comments Reducer called !');
        return state;
        default:
        return state;
    }
}


