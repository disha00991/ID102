export default function counterparties(state=[],action){
    switch(action.type){
        case 'FETCH_COUNTERPARTY':
        return action.response;
        default:
        return state;
    }
}