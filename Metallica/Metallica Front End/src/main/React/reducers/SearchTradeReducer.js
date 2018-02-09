export default function trades(state=[],action){
    switch(action.type){
        case 'FETCH_SEARCH_TRADE':
        return action.response;
        default:
        return state;
    }
}