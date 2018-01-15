export default function posts(state=[],action){

    switch(action.type){
            case 'INCREEMENT_LIKES':
            console.log('Posts Reducer called !');
            return state;  // new Store
            default :
            return state;
    }
    
    return state;
}


