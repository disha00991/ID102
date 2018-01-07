export default function comments(state=[],action){
   
    switch(action.type){
        case 'ADD_COMMENT':
         console.log('Within comments reducer !');
        // But change the current state to a new state and return
         console.log(action);
         return state;
        case 'REMOVE_COMMENT':
            console.log('Within comments reducer !');
            // But change the current state to a new state and return
            console.log(action);
            return state;
        default:
            return state;
        }      

}