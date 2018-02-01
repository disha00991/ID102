export default function commodities(state=[],action){
    switch(action.type){
        case 'FETCH_COMMODITY':
        return action.response;
        default:
        return state;
    }
}