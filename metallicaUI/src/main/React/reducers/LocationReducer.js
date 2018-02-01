export default function locations(state=[],action){
    switch(action.type){
        case 'FETCH_LOCATION':
        return action.response;
        default:
        return state;
    }
}