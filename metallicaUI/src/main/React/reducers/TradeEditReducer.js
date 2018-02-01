export default function editTrade(state=[],action){
    switch(action.type){
        case 'TRADE_EDIT':
        return state.push({
        	updated: action.updated
        })
        default:
        return state;
    }
}